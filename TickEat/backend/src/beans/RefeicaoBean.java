package beans;

import main.*;
import org.orm.PersistentException;
import javax.crypto.SecretKey;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.security.KeyStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Local(RefeicaoBeanLocal.class)
@Stateless(name = "RefeicaoBean")
public class RefeicaoBean implements RefeicaoBeanLocal {

    public RefeicaoBean() {
    }

    @Override
    public Map<CantinaVisivel, List<Par<String,Refeicao>>> consultarCalendario(String emailConsumidor) {
        Map<CantinaVisivel, List<Par<String,Refeicao>>> calendario = new TreeMap<>(
                Comparator.comparingInt(CantinaVisivel::getPosicao)
        );

        List<CantinaVisivel> cantinasVisiveis = getCantinasVisiveisConsumidor(emailConsumidor);

        if (cantinasVisiveis != null) {
            for (CantinaVisivel cantinaVisivel : cantinasVisiveis) {
                List<Par<String,Refeicao>> cantinaRefeicoes = new ArrayList<>();
                if (!cantinaVisivel.getCantina().refeicoes.isEmpty()) {
                    Refeicao[] refeicoes = cantinaVisivel.getCantina().refeicoes.toArray("data");
                    for (Refeicao refeicao : refeicoes) {
                        String estado = getEstadoRefeicaoConsumidor(emailConsumidor, refeicao);
                        cantinaRefeicoes.add(new Par(estado, refeicao));
                    }
                }
                calendario.put(cantinaVisivel, cantinaRefeicoes);
            }
        }

        return calendario;
    }

    @Override
    public boolean isRefeicaoReservada(String emailConsumidor, int refeicaoId) {
        boolean reservada = false;
        List<Reserva> reservas = null;
        try {
            reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicaoId + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (reservas != null) {
            if (!reservas.isEmpty()) {
                reservada = true;
            }
        }
        return reservada;
    }

    @Override
    public Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Par<Boolean, Par<Float, Par<Map<Componente, Ementa>, Map<Componente, List<Ementa>>>>>>>>> consultarRefeicaoReservada(String emailConsumidor, int refeicaoId, int cantinaId) {
        Cantina cantina = null;
        List<Componente> componentes = null;
        Reserva reserva = null;
        boolean passou = false;
        boolean avaliada = false;

        try {
            cantina = FacadeDAOs.getCantina(cantinaId);
            List<Reserva> reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicaoId + "'", null);
            reserva = reservas.get(0);
            componentes = FacadeDAOs.listComponentes(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        Refeicao refeicao = reserva.getRefeicao();
        String diaDaSemana = getDiaDaSemana(refeicao.getData());
        String result = getEstadoRefeicao(refeicao.getData(), refeicao.getRefeicaoInfo().getHoraInicio(), refeicao.getRefeicaoInfo().getHoraFim());
        if (result.equals("japassou")) {
            passou = true;
            avaliada = existeAvaliacao(emailConsumidor, refeicaoId);
        }
        float preco = getDespesa(reserva.getId()).getValor();
        Map<Componente,Ementa> ementaSelecionada = getEmentaSelecionada(reserva);
        Map<Componente,List<Ementa>> ementa = getEmenta(refeicao, componentes);

        return new Par(cantina, new Par(refeicao, new Par(diaDaSemana, new Par(passou, new Par(avaliada, new Par(preco, new Par(ementaSelecionada, ementa)))))));
    }

    @Override
    public Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Map<Componente, List<Ementa>>>>>> consultarRefeicaoNaoReservada(int refeicaoId, int cantinaId) {
        Cantina cantina = null;
        Refeicao refeicao = null;
        List<Componente> componentes = null;
        try {
            cantina = FacadeDAOs.getCantina(cantinaId);
            refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            componentes = FacadeDAOs.listComponentes(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        String diaDaSemana = getDiaDaSemana(refeicao.getData());
        String result = getEstadoRefeicao(refeicao.getData(), refeicao.getRefeicaoInfo().getHoraInicio(), refeicao.getRefeicaoInfo().getHoraFim());
        boolean passou = false;
        if (result.equals("japassou")) {
            passou = true;
        }
        Map<Componente,List<Ementa>> ementa = getEmenta(refeicao, componentes);

        return new Par(cantina, new Par(refeicao, new Par(diaDaSemana, new Par(passou, ementa))));
    }

    @Override
    public Par<String, Par<Refeicao, Par<String, Map<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>>>>> getMenuRefeicao(String emailConsumidor, int refeicaoId, int cantinaId) {
        Consumidor consumidor = null;
        Cantina cantina = null;
        Refeicao refeicao = null;
        List<TipoRefeicao> tiposRefeicaoAtivos = new ArrayList<>();
        try {
            consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            cantina = FacadeDAOs.getCantina(cantinaId);
            refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            if (!cantina.tiposRefeicao.isEmpty()) {
                TipoRefeicao[] tiposRefeicao = cantina.tiposRefeicao.toArray("id");
                for (TipoRefeicao tipoRefeicao : tiposRefeicao) {
                    if (tipoRefeicao.getAtivo()) {
                        tiposRefeicaoAtivos.add(tipoRefeicao);
                    }
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        Map<TipoRefeicao, Par<Float, Map<Componente,List<Ementa>>>> menuRefeicao = getMenu(tiposRefeicaoAtivos, refeicao, consumidor.getTipoConsumidor().getId());
        String diaDaSemana = getDiaDaSemana(refeicao.getData());

        return new Par(cantina.getNome(), new Par(refeicao, new Par(diaDaSemana, menuRefeicao)));
    }

    @Override
    public boolean reservarRefeicao(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId) {
        boolean result;
        Consumidor consumidor = null;
        Refeicao refeicao = null;
        TipoRefeicao tipoRefeicao = null;
        List<Ementa> ementas = new ArrayList<>();
        try {
            consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            tipoRefeicao = FacadeDAOs.getTipoRefeicao(tipoRefeicaoId);
            for (Integer ementaId : ementasId) {
                Ementa ementa = FacadeDAOs.getEmenta(ementaId);
                ementas.add(ementa);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (consumidor.getSaldoDisponivel() >= preco) {
            result = efetuarReserva(consumidor, refeicao, tipoRefeicao, ementas, preco);
        }
        else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean cancelarReserva(String emailConsumidor, int refeicaoId) {
        boolean result;
        Consumidor consumidor = null;
        Refeicao refeicao = null;
        Reserva reserva = null;
        Despesa despesa = null;
        try {
            consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            List<Reserva> reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicaoId + "'", null);
            reserva = reservas.get(0);
            despesa = getDespesa(reserva.getId());
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (verificarDataReserva(refeicao)) {
            result = efetuarCancelamentoComTaxa(consumidor, refeicao, reserva, despesa);
        }
        else {
            result = efetuarCancelamentoSemTaxa(consumidor, refeicao, reserva, despesa);
        }
        return result;
    }

    @Override
    public boolean editarReserva(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId) {
        boolean result;
        Consumidor consumidor = null;
        TipoRefeicao tipoRefeicao = null;
        List<Ementa> ementas = new ArrayList<>();
        Reserva reserva = null;
        Despesa despesa = null;
        try {
            consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            tipoRefeicao = FacadeDAOs.getTipoRefeicao(tipoRefeicaoId);
            for (Integer ementaId : ementasId) {
                Ementa ementa = FacadeDAOs.getEmenta(ementaId);
                ementas.add(ementa);
            }
            List<Reserva> reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicaoId + "'", null);
            reserva = reservas.get(0);
            despesa = getDespesa(reserva.getId());
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        result = efetuarEdicaoReserva(consumidor, tipoRefeicao, ementas, preco, reserva, despesa);

        return result;
    }

    @Override
    public boolean validarReserva(String qrCode, int ferramentaId) {
        boolean valida = false;

        try {
            FerramentaValidacao ferramentaValidacao = FacadeDAOs.getFerramentaValidacao(ferramentaId);
            String emailConsumidor = decryptQrCode(qrCode);
            Reserva reserva = getReserva(emailConsumidor, ferramentaValidacao.getCantina().getId(), ferramentaValidacao.getTipoRefeicao().getId());
            if (reserva != null) {
                valida = true;
                Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
                Refeicao refeicao = reserva.getRefeicao();
                Despesa despesa = getDespesa(reserva.getId());
                efetuarValidacaoReserva(consumidor, refeicao, reserva, despesa);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return valida;
    }

    @Override
    public boolean registarEntradaConsumidor(int ferramentaId) {
        boolean regista = false;

        try {
            FerramentaContagem ferramentaContagem = FacadeDAOs.getFerramentaContagem(ferramentaId);
            Cantina cantina = ferramentaContagem.getCantina();
            List<Refeicao> refeicoes = FacadeDAOs.listRefeicoes("CantinaId='"+cantina.getId()+"' AND ADecorrer=1",null);
            if (!refeicoes.isEmpty()) {
                Refeicao refeicao = refeicoes.get(0);
                refeicao.setContagemEntrada(refeicao.getContagemEntrada()+1);
                regista = FacadeDAOs.saveRefeicao(refeicao);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return regista;
    }

    @Override
    public boolean avaliarRefeicao(String emailConsumidor, int refeicaoId, int pontuacao, List<Integer> comentariosId) {
        boolean result = false;

        try {
            Avaliacao avaliacao = FacadeDAOs.createAvaliacao();
            Consumidor consumidor = FacadeDAOs.getConsumidor(emailConsumidor);
            Refeicao refeicao = FacadeDAOs.getRefeicao(refeicaoId);
            if (comentariosId != null) {
                for (Integer comentarioId : comentariosId) {
                    Comentario comentario = FacadeDAOs.getComentario(comentarioId);
                    avaliacao.comentarios.add(comentario);
                }
            }
            avaliacao.setConsumidor(consumidor);
            avaliacao.setRefeicao(refeicao);
            avaliacao.setPontuacao(pontuacao);
            result = FacadeDAOs.saveAvaliacao(avaliacao);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: consultarCalendario()
    public List<CantinaVisivel> getCantinasVisiveisConsumidor(String emailConsumidor) {
        List<CantinaVisivel> cantinasVisiveis = null;
        try {
            cantinasVisiveis = FacadeDAOs.listCantinasVisiveis("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND Visivel=1", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return cantinasVisiveis;
    }

    // AUXILIAR: consultarCalendario()
    public String getEstadoRefeicaoConsumidor(String emailConsumidor, Refeicao refeicao) {
        List<Reserva> reservas = null;
        String estado = "";
        try {
            reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicao.getId() + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (reservas != null && !reservas.isEmpty()) {
            estado += "reservada";
        }
        else {
            estado += "naoreservada";
        }
        String dataCompare = getEstadoRefeicao(refeicao.getData(), refeicao.getRefeicaoInfo().getHoraInicio(), refeicao.getRefeicaoInfo().getHoraFim());
        if (dataCompare.equals("japassou")) {
            estado += " japassou";
        }
        return estado;
    }

    // AUXILIAR: getEstadoRefeicaoConsumidor(), consultarRefeicaoReservada() e consultarRefeicaoNaoReservada()
    public String getEstadoRefeicao(String dateRefeicao, String horaInicio, String horaFim) {
        String result;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterHour= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatterHour.format(date).split(" ")[0];
        String horaAtual = formatterHour.format(date).split(" ")[1];
        Date dataAtual = null;
        Date dataRefeicao = null;
        try {
            dataAtual = formatter.parse(data);
            dataRefeicao = formatter.parse(dateRefeicao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dataRefeicao.before(dataAtual))
            result = "japassou";
        else if (dataRefeicao.equals(dataAtual))
            result = compareTime(horaAtual, horaInicio, horaFim);
        else
            result = "naopassou";
        return result;
    }

    // AUXILIAR: getEstadoRefeicao()
    public String compareTime(String horaAtual, String horaInicio, String horaFim) {
        String result;
        String[] parts = horaAtual.split(":");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaInicio.split(":");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal2.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaFim.split(":");
        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal3.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal3.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        if (cal1.equals(cal3) || cal1.after(cal3)) {
            result = "japassou";
        }
        else if (cal1.before(cal2)) {
            result = "naopassou";
        }
        else {
            result = "adecorrer";
        }
        return result;
    }

    // AUXILIAR: consultarRefeicaoReservada(), consultarRefeicaoNaoReservada() e getMenuRefeicao()
    public String getDiaDaSemana(String data) {
        String diaDaSemana = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                diaDaSemana = "Domingo";
                break;
            case 2:
                diaDaSemana = "Segunda-feira";
                break;
            case 3:
                diaDaSemana = "Terça-feira";
                break;
            case 4:
                diaDaSemana = "Quarta-feira";
                break;
            case 5:
                diaDaSemana = "Quinta-feira";
                break;
            case 6:
                diaDaSemana = "Sexta-feira";
                break;
            case 7:
                diaDaSemana = "Sábado";
                break;
            default:
                break;
        }
        return diaDaSemana;
    }

    // AUXILIAR: consultarRefeicaoReservada()
    public boolean existeAvaliacao(String emailConsumidor, int refeicaoId) {
        boolean existe = false;
        List<Avaliacao> avaliacoes = null;
        try {
            avaliacoes = FacadeDAOs.listAvaliacoes("ConsumidorUtilizadorEmail='" + emailConsumidor + "' AND RefeicaoId='" + refeicaoId + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (avaliacoes != null) {
            if (!avaliacoes.isEmpty()) {
                existe = true;
            }
        }
        return existe;
    }

    // AUXILIAR: consultarRefeicaoReservada()
    public Despesa getDespesa(int reservaId) {
        List<Despesa> despesas = null;
        try {
            despesas = FacadeDAOs.listDespesas("ReservaId='" + reservaId + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return despesas.get(0);
    }

    // AUXILIAR: consultarRefeicaoReservada()
    public Map<Componente,Ementa> getEmentaSelecionada(Reserva reserva) {
        Map<Componente, Ementa> componenteEmenta = new TreeMap<>(
                Comparator.comparingInt(Componente::getId)
        );

        TipoRefeicao tipoRefeicao = reserva.getTipoRefeicao();

        Ementa[] ementas = reserva.ementas.toArray("id");
        Componente[] componentes = tipoRefeicao.componentes.toArray("id");

        for (Componente componente : componentes) {
            if (!componente.ementas.isEmpty()) {
                List<Ementa> ementasComponente = Arrays.asList(componente.ementas.toArray("id"));
                for (Ementa ementa : ementas) {
                    if (ementasComponente.contains(ementa)) {
                        componenteEmenta.put(componente, ementa);
                    }
                }
            }
        }
        return componenteEmenta;
    }

    // AUXILIAR: consultarRefeicaoReservada(), consultarRefeicaoNaoReservada() e getMenu()
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

    // AUXILIAR: getMenuRefeicao()
    public Map<TipoRefeicao, Par<Float, Map<Componente,List<Ementa>>>> getMenu(List<TipoRefeicao> tiposRefeicao, Refeicao refeicao, int tipoConsumidorId) {
        Map<TipoRefeicao, Par<Float, Map<Componente,List<Ementa>>>> menuRefeicao = new TreeMap<>(
                Comparator.comparingInt(TipoRefeicao::getId)
        );

        if (tiposRefeicao != null) {
            for (TipoRefeicao tipoRefeicao : tiposRefeicao) {
                List<Componente> componentes = Arrays.asList(tipoRefeicao.componentes.toArray("id"));
                Map<Componente, List<Ementa>> componenteEmentas = getEmenta(refeicao, componentes);
                float preco = getPrecoRefeicao(refeicao, tipoRefeicao.getId(), tipoConsumidorId);
                menuRefeicao.put(tipoRefeicao, new Par(preco, componenteEmentas));
            }
        }
        return menuRefeicao;
    }

    // AUXILIAR: getMenu()
    public float getPrecoRefeicao(Refeicao refeicao, int tipoRefeicaoId, int tipoConsumidorId) {
        List<Preco> precos = null;
        float preco;
        try {
            precos = FacadeDAOs.listPrecos("TipoConsumidorId='" + tipoConsumidorId + "' AND TipoRefeicaoId='" + tipoRefeicaoId + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        preco = precos.get(0).getValor();

        if (!verificarDataReserva(refeicao)) {
            preco -= refeicao.getRefeicaoInfo().getDesconto();
        }

        return preco;
    }

    // AUXILIAR: cancelarReserva() e getPrecoRefeicao()
    public boolean verificarDataReserva(Refeicao refeicao) {
        boolean passaHoraLimite;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterHour= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatterHour.format(date).split(" ")[0];
        String hora = formatterHour.format(date).split(" ")[1];
        Date dataAtual = null;
        Date dataRefeicao = null;
        try {
            dataAtual = formatter.parse(data);
            dataRefeicao = formatter.parse(refeicao.getData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dataAtual.equals(dataRefeicao)) {
            passaHoraLimite = verificarHoraReserva(hora, refeicao.getRefeicaoInfo().getHoraLimite());
        }
        else {
            passaHoraLimite = false;
        }
        return passaHoraLimite;
    }

    // AUXILIAR: verificarDataReserva()
    public boolean verificarHoraReserva(String hora, String horaLimite) {
        boolean passaHoraLimite;
        String[] parts = hora.split(":");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaLimite.split(":");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal2.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        passaHoraLimite = cal1.after(cal2);
        return passaHoraLimite;
    }

    // AUXILIAR: reservarRefeicao()
    public boolean efetuarReserva(Consumidor consumidor, Refeicao refeicao, TipoRefeicao tipoRefeicao, List<Ementa> ementas, float preco) {
        boolean result = true;
        String timestamp = getTimestamp();
        Reserva reserva = criarReserva(refeicao, timestamp, tipoRefeicao, ementas);
        consumidor.reservas.add(reserva);
        Despesa despesa = criarDespesa(preco, "Reserva", timestamp, reserva, "Reserva", consumidor.getSaldoContabilistico());
        consumidor.movimentos.add(despesa);
        consumidor.setSaldoDisponivel(consumidor.getSaldoDisponivel()-preco);
        refeicao.setPrevisaoGeral(refeicao.getPrevisaoGeral()+1);
        try {
            for (Ementa ementa : ementas) {
                ementa.setPrevisao(ementa.getPrevisao()+1);
                FacadeDAOs.saveEmenta(ementa);
            }
            FacadeDAOs.saveRefeicao(refeicao);
            FacadeDAOs.saveReserva(reserva);
            FacadeDAOs.saveDespesa(despesa);
            FacadeDAOs.saveConsumidor(consumidor);
        } catch (PersistentException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: efetuarReserva()
    public Reserva criarReserva(Refeicao refeicao, String timestamp, TipoRefeicao tipoRefeicao, List<Ementa> ementas) {
        Reserva reserva = FacadeDAOs.createReserva();
        reserva.setRefeicao(refeicao);
        reserva.setTimestamp(timestamp);
        reserva.setTipoRefeicao(tipoRefeicao);
        reserva.setValidada(false);
        for (Ementa ementa : ementas) {
            reserva.ementas.add(ementa);
        }
        return reserva;
    }

    // AUXILIAR: efetuarReserva()
    public Despesa criarDespesa(float preco, String nome, String timestamp, Reserva reserva, String descricao, float saldoResultante) {
        Despesa despesa = FacadeDAOs.createDespesa();
        despesa.setValor(preco);
        despesa.setNome(nome);
        despesa.setEfetuado(false);
        despesa.setTimestamp(timestamp);
        despesa.setReserva(reserva);
        despesa.setDescricao(descricao);
        despesa.setRefeicao(reserva.getRefeicao());
        despesa.setSaldoResultante(saldoResultante);
        return despesa;
    }

    // AUXILIAR: cancelarReserva()
    public boolean efetuarCancelamentoComTaxa(Consumidor consumidor, Refeicao refeicao, Reserva reserva, Despesa despesa) {
        boolean result = true;
        float taxa = refeicao.getRefeicaoInfo().getTaxaCancelamento();
        float saldoContabilistico = consumidor.getSaldoContabilistico()-taxa;
        consumidor.setSaldoDisponivel(consumidor.getSaldoDisponivel()+despesa.getValor()-taxa);
        consumidor.setSaldoContabilistico(saldoContabilistico);
        consumidor.reservas.remove(reserva);
        refeicao.setPrevisaoGeral(refeicao.getPrevisaoGeral()-1);
        Ementa[] ementas = reserva.ementas.toArray("id");
        atualizarDespesa(despesa, "Reserva cancelada fora da hora limite", null, true, "Cancelamento", taxa, saldoContabilistico);
        try {
            FacadeDAOs.saveRefeicao(refeicao);
            for (Ementa ementa : ementas) {
                ementa.setPrevisao(ementa.getPrevisao()-1);
                FacadeDAOs.saveEmenta(ementa);
            }
            FacadeDAOs.saveConsumidor(consumidor);
            FacadeDAOs.saveDespesa(despesa);
            FacadeDAOs.deleteReserva(reserva);
        } catch (PersistentException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: efetuarCancelamentoComTaxa() e efetuarEdicaoReserva()
    public void atualizarDespesa(Despesa despesa, String descricao, Reserva reserva, boolean efetuado, String nome, float valor, float saldoResultante) {
        String timestamp = getTimestamp();
        despesa.setDescricao(descricao);
        despesa.setReserva(reserva);
        despesa.setEfetuado(efetuado);
        despesa.setNome(nome);
        despesa.setTimestamp(timestamp);
        despesa.setValor(valor);
        despesa.setSaldoResultante(saldoResultante);
    }

    // AUXILIAR: cancelarReserva()
    public boolean efetuarCancelamentoSemTaxa(Consumidor consumidor, Refeicao refeicao, Reserva reserva, Despesa despesa) {
        boolean result = true;
        consumidor.setSaldoDisponivel(consumidor.getSaldoDisponivel()+despesa.getValor());
        consumidor.reservas.remove(reserva);
        consumidor.movimentos.remove(despesa);
        refeicao.setPrevisaoGeral(refeicao.getPrevisaoGeral()-1);
        Ementa[] ementas = reserva.ementas.toArray("id");
        try {
            FacadeDAOs.saveRefeicao(refeicao);
            for (Ementa ementa : ementas) {
                ementa.setPrevisao(ementa.getPrevisao()-1);
                FacadeDAOs.saveEmenta(ementa);
            }
            FacadeDAOs.saveConsumidor(consumidor);
            FacadeDAOs.deleteDespesa(despesa);
            FacadeDAOs.deleteReserva(reserva);
        } catch (PersistentException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    // AUXILIAR: editarReserva()
    public boolean efetuarEdicaoReserva(Consumidor consumidor, TipoRefeicao tipoRefeicao, List<Ementa> ementas, float preco, Reserva reserva, Despesa despesa) {
        boolean result;
        if (consumidor.getSaldoDisponivel()+despesa.getValor() >= preco) {
            consumidor.setSaldoDisponivel(consumidor.getSaldoDisponivel()+despesa.getValor()-preco);
            atualizarReserva(reserva, tipoRefeicao, ementas);
            atualizarDespesa(despesa, "Reserva", reserva, false, "Reserva", preco, consumidor.getSaldoContabilistico());
            try {
                FacadeDAOs.saveReserva(reserva);
                FacadeDAOs.saveDespesa(despesa);
                FacadeDAOs.saveConsumidor(consumidor);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    // AUXILIAR: efetuarEdicaoReserva()
    public void atualizarReserva(Reserva reserva, TipoRefeicao tipoRefeicao, List<Ementa> ementas) {
        String timestamp = getTimestamp();
        Ementa[] ementasAnteriores = reserva.ementas.toArray("id");
        try {
            for (Ementa ementa : ementasAnteriores) {
                ementa.setPrevisao(ementa.getPrevisao()-1);
                reserva.ementas.remove(ementa);
                FacadeDAOs.saveEmenta(ementa);
            }
            for (Ementa ementa : ementas) {
                ementa.setPrevisao(ementa.getPrevisao()+1);
                reserva.ementas.add(ementa);
                FacadeDAOs.saveEmenta(ementa);
            }
            reserva.setTipoRefeicao(tipoRefeicao);
            reserva.setTimestamp(timestamp);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    // AUXILIAR: validarReserva()
    public String decryptQrCode(String qrCode) {
        // Get secret key
        KeyStore keyStore = Crypto.loadKeyStore("tickeat-pei-1920", "../../TickEat/backend/data/keystore.ks");
        SecretKey secretKey = Crypto.getSecretKey("62798789106115117129", keyStore, "MNBJFBFK");

        // Decrypt QR Code
        return Crypto.decrypt(secretKey, qrCode);
    }

    // AUXILIAR: validarReserva()
    public Reserva getReserva(String emailConsumidor, int cantinaId, int tipoRefeicaoId) {
        Reserva reserva = null;
        List<Reserva> reservas = null;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String dataAtual = formatter.format(date);
        try {
            List<Refeicao> refeicoes = FacadeDAOs.listRefeicoes("CantinaId='"+cantinaId+"' AND Data='"+dataAtual+"' AND ADecorrer=1", null);
            if (!refeicoes.isEmpty()) {
                reservas = FacadeDAOs.listReservas("ConsumidorUtilizadorEmail='"+emailConsumidor+"' AND RefeicaoId='"+refeicoes.get(0).getId()+"' AND TipoRefeicaoId='"+tipoRefeicaoId+"' AND Validada=0", null);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (reservas != null && !reservas.isEmpty()) {
            reserva = reservas.get(0);
        }
        return reserva;
    }

    // AUXILIAR: validarReserva()
    public void efetuarValidacaoReserva(Consumidor consumidor, Refeicao refeicao, Reserva reserva, Despesa despesa) {
        try {
            String timestamp = getTimestamp();
            float saldoContabilistico = consumidor.getSaldoContabilistico()-despesa.getValor();
            refeicao.setContagemValidados(refeicao.getContagemValidados()+1);
            reserva.setTimestamp(timestamp);
            reserva.setValidada(true);
            Ementa[] ementas = reserva.ementas.toArray("id");
            for (Ementa ementa : ementas) {
                ementa.setContagemValidados(ementa.getContagemValidados()+1);
                FacadeDAOs.saveEmenta(ementa);
            }
            despesa.setDescricao("Reserva validada");
            despesa.setTimestamp(timestamp);
            despesa.setEfetuado(true);
            despesa.setSaldoResultante(saldoContabilistico);
            consumidor.setSaldoContabilistico(saldoContabilistico);
            FacadeDAOs.saveRefeicao(refeicao);
            FacadeDAOs.saveReserva(reserva);
            FacadeDAOs.saveDespesa(despesa);
            FacadeDAOs.saveConsumidor(consumidor);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public String getTimestamp() {
        SimpleDateFormat formatterHour= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatterHour.format(date);
    }
}