package beans;

import main.*;
import org.orm.PersistentException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Local(CozinheiroBeanLocal.class)
@Stateless(name = "CozinheiroBean")
public class CozinheiroBean implements CozinheiroBeanLocal {
    private List<Refeicao> queueRefeicao;

    public CozinheiroBean() {
    }

    @Override
    public Par<Cantina, Refeicao> consultarEstadoFila(String emailCozinheiro) {
        esvaziarQueueRefeicao();
        Cozinheiro cozinheiro = null;
        try {
            cozinheiro = FacadeDAOs.getCozinheiro(emailCozinheiro);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        Cantina cantina = cozinheiro.getCantina();
        return new Par(cantina, getRefeicao(cantina));
    }

    @Override
    public Map<Componente, List<Ementa>> consultarEmenta(String emailCozinheiro) {
        esvaziarQueueRefeicao();
        Cozinheiro cozinheiro = null;
        List<Componente> componentes = null;
        try {
            cozinheiro = FacadeDAOs.getCozinheiro(emailCozinheiro);
            componentes = FacadeDAOs.listComponentes(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        Refeicao refeicao = getRefeicao(cozinheiro.getCantina());
        if (refeicao != null) {
            return getEmenta(refeicao, componentes);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean iniciarRefeicao(int refeicaoId) {
        boolean result = false;
        try {
            Refeicao refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            if (verificarDataHora(refeicao)) {
                refeicao.setaDecorrer(true);
                result = FacadeDAOs.saveRefeicao(refeicao);
                esvaziarQueueRefeicao();
                TerminarRefeicao terminarRefeicao = new TerminarRefeicao(refeicao, this.queueRefeicao);
                Thread terminar = new Thread(terminarRefeicao);
                terminar.start();
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: consultarEstadoFila()
    public Refeicao getRefeicao(Cantina cantina) {
        String data = getData();
        int limite = 0;
        Refeicao proximaRefeicao = null;
        try {
            List<Refeicao> refeicoes = FacadeDAOs.listRefeicoes("CantinaId='"+cantina.getId()+"' AND Data='"+data+"' AND ADecorrer=1", null);
            if (refeicoes.isEmpty()) {
                while (limite < 7 && proximaRefeicao == null) {
                    refeicoes = FacadeDAOs.listRefeicoes("CantinaId='" + cantina.getId() + "' AND Data='" + data + "'", null);
                    if (!refeicoes.isEmpty()) {
                        for (Refeicao refeicao : refeicoes) {
                            if (limite != 0 || (limite == 0 && !isRefeicaoPassou(refeicao))) {
                                proximaRefeicao = getProximaRefeicao(refeicao, proximaRefeicao);
                            }
                        }
                    }
                    limite++;
                    data = getDataDiaSeguinte(data);
                }
            }
            else {
                proximaRefeicao = refeicoes.get(0);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return proximaRefeicao;
    }

    // AUXILIAR: getRefeicao()
    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    // AUXILIAR: getRefeicao()
    public boolean isRefeicaoPassou(Refeicao refeicao) {
        String horaAtual = getHora();
        String horaFimRefeicao = refeicao.getRefeicaoInfo().getHoraFim();
        return compareTime(horaFimRefeicao, horaAtual);
    }

    // AUXILIAR: isRefeicaoPassou()
    public String getHora() {
        SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String timestamp = formatterHour.format(date);
        return timestamp.split(" ")[1];
    }

    // AUXILIAR: getRefeicao()
    public Refeicao getProximaRefeicao(Refeicao refeicao, Refeicao refeicaoMaisRecente) {
        if (refeicaoMaisRecente == null) {
            return refeicao;
        }
        else {
            boolean result = compareTime(refeicao.getRefeicaoInfo().getHoraInicio(), refeicaoMaisRecente.getRefeicaoInfo().getHoraInicio());
            if (result) {
                return refeicao;
            }
            else {
                return refeicaoMaisRecente;
            }
        }
    }

    // AUXILIAR: getProximaRefeicao()
    public boolean compareTime(String horaRefeicao, String horaMaisRecente) {
        boolean result;
        String[] parts = horaRefeicao.split(":");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaMaisRecente.split(":");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal2.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        result = cal1.before(cal2);
        return result;
    }

    // AUXILIAR: getRefeicao()
    public String getDataDiaSeguinte(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return formatter.format(calendar.getTime());
    }

    // AUXILIAR: consultarEmenta()
    public Map<Componente,List<Ementa>> getEmenta(Refeicao refeicao, List<Componente> componentes) {
        Map<Componente, List<Ementa>> componenteEmentas = new TreeMap<>(
                Comparator.comparingInt(Componente::getId)
        );

        Ementa[] ementas = refeicao.ementas.toArray("id");

        for (Componente componente : componentes) {
            List<Ementa> ementasComponenteRefeicao = new ArrayList<>();
            if (!componente.ementas.isEmpty()) {
                List<Ementa> ementasComponente = Arrays.asList(componente.ementas.toArray("id"));
                for (Ementa ementa : ementas) {
                    if (ementasComponente.contains(ementa)) {
                        ementasComponenteRefeicao.add(ementa);
                    }
                }
            }
            componenteEmentas.put(componente, ementasComponenteRefeicao);
        }
        return componenteEmentas;
    }

    // AUXILIAR: iniciarRefeicao()
    public boolean verificarDataHora(Refeicao refeicao) {
        String dataAtual = getData();
        String horaAtual = getHora();
        String dataRefeicao = refeicao.getData();
        String horaInicio = refeicao.getRefeicaoInfo().getHoraInicio();
        if (dataAtual.equals(dataRefeicao)) {
            return !compareTime(horaAtual, horaInicio);
        }
        return false;
    }

    public void esvaziarQueueRefeicao() {
        if (this.queueRefeicao == null) {
            this.queueRefeicao = new ArrayList<>();
        }
        else {
            for (int i = 0; i < this.queueRefeicao.size(); i++) {
                Refeicao refeicao = this.queueRefeicao.get(i);
                try {
                    FacadeDAOs.saveRefeicao(refeicao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                this.queueRefeicao.remove(refeicao);
                i--;
            }
        }
    }
}