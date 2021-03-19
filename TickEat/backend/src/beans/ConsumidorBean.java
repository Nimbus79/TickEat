package beans;

import main.*;
import org.orm.PersistentException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Local(ConsumidorBeanLocal.class)
@Stateless(name = "ConsumidorBean")
public class ConsumidorBean implements ConsumidorBeanLocal {
    private List<Consumidor> queueConsumidor;
    private List<Par<String, Carregamento>> queueCarregameto;

    public ConsumidorBean() {

    }

    @Override
    public boolean registar(String emailConsumidor, String nome, int tipoConsumidorId) {
        esvaziarQueues();
        try {
            Utilizador utilizador = FacadeDAOs.getUtilizador(emailConsumidor);
            TipoConsumidor tipoConsumidor = FacadeDAOs.getTipoConsumidor(tipoConsumidorId);
            if (utilizador != null) {
                return false;
            }
            Consumidor consumidor = criarConsumidor(emailConsumidor, nome, tipoConsumidor);
            Pedido pedido = criarPedido(consumidor);
            FacadeDAOs.saveConsumidor(consumidor);
            FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Par<Cantina, Refeicao>> consultarPrevisoes(String emailConsumidor) {
        esvaziarQueues();
        List<Par<Cantina, Refeicao>> previsoes = new ArrayList<>();
        try {
            List<CantinaVisivel> cantinasVisiveis = FacadeDAOs.listCantinasVisiveis("ConsumidorUtilizadorEmail='"+emailConsumidor+"' AND Visivel=1", "posicao");
            if (!cantinasVisiveis.isEmpty()) {
                for (CantinaVisivel cantinaVisivel : cantinasVisiveis) {
                    Par<Cantina, Refeicao> previsaoCantina = getPrevisaoCantina(cantinaVisivel.getCantina());
                    previsoes.add(previsaoCantina);
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return previsoes;
    }

    @Override
    public int carregarSaldo(String emailConsumidor, float valor, String metodo) {
        int result = -1;
        String timestamp = getTimestamp();
        long currentTime = System.currentTimeMillis();
        try {
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            Carregamento carregamento = criarCarregamento(metodo, valor, consumidor.getSaldoContabilistico(), timestamp);
            consumidor.movimentos.add(carregamento);
            FacadeDAOs.saveCarregamento(carregamento);
            FacadeDAOs.saveConsumidor(consumidor);
            List<Movimento> movimentos = FacadeDAOs.listMovimentos("ConsumidorUtilizadorEmail='"+emailConsumidor+"'","id DESC");
            result = movimentos.get(0).getId();
            esvaziarQueues();
            Pagamento pagamento = new Pagamento(consumidor, carregamento, currentTime, this.queueConsumidor, this.queueCarregameto);
            Thread t = new Thread(pagamento);
            t.start();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Par<Float, Float> consultarSaldos(String emailConsumidor) {
        esvaziarQueues();
        Consumidor consumidor = null;
        try {
            consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return new Par(consumidor.getSaldoContabilistico(), consumidor.getSaldoDisponivel());
    }

    @Override
    public List<Par<Cantina, Movimento>> consultarMovimentos(String emailConsumidor) {
        esvaziarQueues();
        List<Par<Cantina, Movimento>> movimentos = new ArrayList<>();

        try {
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            if (!consumidor.movimentos.isEmpty()) {
                Movimento[] movimentosConsumidor = consumidor.movimentos.toArray("timestamp", false);
                List<Cantina> cantinas = FacadeDAOs.listCantinas(null, null);
                for (Movimento movimento : movimentosConsumidor) {
                    Despesa despesa = FacadeDAOs.getDespesa(movimento.getId());
                    Par<Cantina, Movimento> par = new Par(null, movimento);
                    if (despesa != null) {
                        for (Cantina cantina : cantinas) {
                            if (cantina.refeicoes.contains(despesa.getRefeicao())) {
                                par.setFst(cantina);
                            }
                        }
                    }
                    movimentos.add(par);
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return movimentos;
    }

    @Override
    public Par<Consumidor, List<CantinaVisivel>> consultarPerfil(String emailConsumidor) {
        esvaziarQueues();
        Par<Consumidor, List<CantinaVisivel>> perfil = null;
        try {
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            List<CantinaVisivel> cantinasVisiveis = FacadeDAOs.listCantinasVisiveis("ConsumidorUtilizadorEmail='"+emailConsumidor+"' AND Visivel=1", "posicao");
            perfil = new Par(consumidor, cantinasVisiveis);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return perfil;
    }

    @Override
    public boolean editarPerfil(String emailConsumidor, String nome, String atualPassword, String novaPassword, int contribuinte, List<Par<Integer, Par<Integer, Boolean>>> cantinasVisiveis) {
        esvaziarQueues();
        boolean result = false;
        try {
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            if (novaPassword.equals("") || atualPassword.equals(consumidor.getPassword())) {
                if (!nome.equals("")) {
                    consumidor.setNome(nome);
                }
                if (!novaPassword.equals("") && atualPassword.equals(consumidor.getPassword())) {
                    consumidor.setPassword(novaPassword);
                }
                if (contribuinte != 0) {
                    consumidor.setContribuinte(contribuinte);
                }
                if (cantinasVisiveis != null) {
                    for (Par<Integer, Par<Integer, Boolean>> par : cantinasVisiveis) {
                        CantinaVisivel cantinaVisivel = FacadeDAOs.getCantinaVisivel(par.getFst());
                        cantinaVisivel.setPosicao(par.getSnd().getFst());
                        cantinaVisivel.setVisivel(par.getSnd().getSnd());
                        FacadeDAOs.saveCantinaVisivel(cantinaVisivel);
                    }
                }
                result = FacadeDAOs.saveConsumidor(consumidor);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean alterarFotografia(String emailConsumidor, Blob fotografia) {
        boolean result = false;
        try {
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            consumidor.setFotografia(fotografia);
            result = FacadeDAOs.saveConsumidor(consumidor);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Notificacao> consultarNotificacoes(String emailConsumidor) {
        esvaziarQueues();
        List<Notificacao> notificacoes = null;
        try {
            notificacoes = FacadeDAOs.listNotificacoes("ConsumidorUtilizadorEmail='"+emailConsumidor+"'", "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return notificacoes;
    }

    @Override
    public boolean notificacaoVista(int notificacaoId) {
        esvaziarQueues();
        boolean result = false;
        try {
            Notificacao notificacao = FacadeDAOs.getNotificacao(notificacaoId);
            notificacao.setVista(true);
            result = FacadeDAOs.saveNotificacao(notificacao);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: registar()
    public Consumidor criarConsumidor(String email, String nome, TipoConsumidor tipoConsumidor) {
        Consumidor consumidor = FacadeDAOs.createConsumidor();
        consumidor.setEmail(email);
        consumidor.setNome(nome);
        consumidor.setTipoConsumidor(tipoConsumidor);
        consumidor.setTipo("Consumidor");
        consumidor.setAtivo(false);
        consumidor.setSaldoContabilistico(0);
        consumidor.setSaldoDisponivel(0);
        return consumidor;
    }

    // AUXILIAR: registar()
    public Pedido criarPedido(Consumidor consumidor) {
        Pedido pedido = FacadeDAOs.createPedido();
        pedido.setConsumidor(consumidor);
        return pedido;
    }

    // AUXILIAR: carregarSaldo()
    public String getTimestamp() {
        SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatterHour.format(date);
    }

    // AUXILIAR: carregarSaldo()
    public Carregamento criarCarregamento(String metodo, float valor, float saldoResultante, String timestamp) {
        Carregamento carregamento = FacadeDAOs.createCarregamento();
        carregamento.setEntidade(12345);
        carregamento.setReferencia(geraReferencia());
        carregamento.setMetodo(metodo);
        carregamento.setEfetuado(false);
        carregamento.setNome("Carregamento");
        carregamento.setSaldoResultante(saldoResultante);
        carregamento.setTimestamp(timestamp);
        carregamento.setValor(valor);
        carregamento.setValidade(getValidade());
        return carregamento;
    }

    // AUXILIAR: criarCarregamento()
    public int geraReferencia() {
        int max = 999999999;
        int min = 100000000;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    // AUXILIAR: criarCarregamento()
    public String getValidade() {
        SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis()+30*60*1000);
        return formatterHour.format(date);
    }

    // AUXILIAR: consultarPrevisoes()
    public Par<Cantina, Refeicao> getPrevisaoCantina(Cantina cantina) {
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
        return new Par(cantina, proximaRefeicao);
    }

    // AUXILIAR: getPrevisaoCantina()
    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    // AUXILIAR: getPrevisaoCantina()
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

    // AUXILIAR: getPrevisaoCantina()
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

    // AUXILIAR: getPrevisaoCantina()
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

    public void esvaziarQueues() {
        try {
            esvaziarQueueConsumidor();
            esvaziarQueueCarregamento();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public void esvaziarQueueConsumidor() throws PersistentException {
        if (this.queueConsumidor == null) {
            this.queueConsumidor = new ArrayList<>();
        }
        else {
            for (int i = 0; i < this.queueConsumidor.size(); i++) {
                Consumidor consumidor = this.queueConsumidor.get(i);
                FacadeDAOs.saveConsumidor(consumidor);
                this.queueConsumidor.remove(consumidor);
                i--;
            }
            /*for (Consumidor consumidor : this.queueConsumidor) {
                FacadeDAOs.saveConsumidor(consumidor);
                this.queueConsumidor.remove(consumidor);
            }*/
        }
    }

    public void esvaziarQueueCarregamento() throws PersistentException {
        if (this.queueCarregameto == null) {
            this.queueCarregameto = new ArrayList<>();
        }
        else {
            for (int i = 0; i < this.queueCarregameto.size(); i++) {
                Par<String, Carregamento> par = this.queueCarregameto.get(i);
                Carregamento carregamento = par.getSnd();
                if (par.getFst().equals("save")) {
                    FacadeDAOs.saveCarregamento(carregamento);
                }
                else {
                    FacadeDAOs.deleteCarregamento(carregamento);
                }
                this.queueCarregameto.remove(par);
                i--;
            }
            /*for (Par<String, Carregamento> par : this.queueCarregameto) {
                if (par.getFst().equals("save")) {
                    FacadeDAOs.saveCarregamento(par.getSnd());
                }
                else {
                    FacadeDAOs.deleteCarregamento(par.getSnd());
                }
                this.queueCarregameto.remove(par);
            }*/
        }
    }
}