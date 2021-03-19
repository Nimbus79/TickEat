package beans;

import main.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Blob;
import java.util.List;
import java.util.Map;


public class FacadeBeans {

    private static AdministradorBeanLocal administradorBean = lookupAdministradorBeanLocal();
    private static ConsumidorBeanLocal consumidorBean = lookupConsumidorBeanLocal();
    private static CozinheiroBeanLocal cozinheiroBean = lookupCozinheiroBeanLocal();
    private static ListarBeanLocal listarBean = lookupListarBeanLocal();
    private static RefeicaoBeanLocal refeicaoBean = lookupRefeicaoBeanLocal();
    private static UtilizadorBeanLocal utilizadorBean = lookupUtilizadorBeanLocal();

    /**
     * @param pedidoId
     * @param valida
     */
    public static boolean validarContaConsumidor(int pedidoId, boolean valida) {
        return administradorBean.validarContaConsumidor(pedidoId, valida);
    }

    /**
     * @param nome
     * @param localizacao
     * @param descricao
     * @param refeicoesInfo
     * @param tiposRefeicao
     */
    public static boolean definirCantina(String nome, String localizacao, String descricao, List<RefeicaoInfo> refeicoesInfo, List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao) {
        return administradorBean.definirCantina(nome, localizacao, descricao, refeicoesInfo, tiposRefeicao);
    }

    public static Map<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> analiseDiaria() {
        return administradorBean.analiseDiaria();
    }

    /**
     * @param emailConsumidor
     * @param tipoConsumidorId
     */
    public static boolean registar(String emailConsumidor, String nome, int tipoConsumidorId) {
        return consumidorBean.registar(emailConsumidor, nome, tipoConsumidorId);
    }

    /**
     * @param emailConsumidor
     * @param valor
     * @param metodo
     */
    public static int carregarSaldo(String emailConsumidor, float valor, String metodo) {
        return consumidorBean.carregarSaldo(emailConsumidor, valor, metodo);
    }

    /**
     * @param emailConsumidor
     */
    public static Par<Float, Float> consultarSaldos(String emailConsumidor) {
        return consumidorBean.consultarSaldos(emailConsumidor);
    }

    /**
     * @param emailConsumidor
     */
    public static List<Par<Cantina, Movimento>> consultarMovimentos(String emailConsumidor) {
        return consumidorBean.consultarMovimentos(emailConsumidor);
    }

    /**
     * @param emailConsumidor
     */
    public static Par<Consumidor, List<CantinaVisivel>> consultarPerfil(String emailConsumidor) {
        return consumidorBean.consultarPerfil(emailConsumidor);
    }

    /**
     * @param emailConsumidor
     */
    public static List<Notificacao> consultarNotificacoes(String emailConsumidor) {
        return consumidorBean.consultarNotificacoes(emailConsumidor);
    }

    /**
     * @param notificacaoId
     */
    public static boolean notificacaoVista(int notificacaoId) {
        return consumidorBean.notificacaoVista(notificacaoId);
    }

    /**
     * @param emailConsumidor
     * @param nome
     * @param atualPassword
     * @param novaPassword
     * @param contribuinte
     * @param cantinasVisiveis
     */
    public static boolean editarPerfil(String emailConsumidor, String nome, String atualPassword, String novaPassword, int contribuinte, List<Par<Integer,Par<Integer, Boolean>>> cantinasVisiveis) {
        return consumidorBean.editarPerfil(emailConsumidor, nome, atualPassword, novaPassword, contribuinte, cantinasVisiveis);
    }

    /**
     * @param emailConsumidor
     */
    public static List<Par<Cantina, Refeicao>> consultarPrevisoesConsumidor(String emailConsumidor) {
        return consumidorBean.consultarPrevisoes(emailConsumidor);
    }

    /**
     * @param emailConsumidor
     * @param fotografia
     */
    public static boolean alterarFotografia(String emailConsumidor, Blob fotografia) {
        return consumidorBean.alterarFotografia(emailConsumidor, fotografia);
    }

    /**
     * @param emailCozinheiro
     */
    public static Par<Cantina, Refeicao> consultarEstadoFilaCozinheiro(String emailCozinheiro) {
        return cozinheiroBean.consultarEstadoFila(emailCozinheiro);
    }

    /**
     * @param emailCozinheiro
     */
    public static Map<Componente,List<Ementa>> consultarEmenta(String emailCozinheiro) {
        return cozinheiroBean.consultarEmenta(emailCozinheiro);
    }

    /**
     * @param refeicaoId
     */
    public static boolean iniciarRefeicao(int refeicaoId) {
        return cozinheiroBean.iniciarRefeicao(refeicaoId);
    }

    public static List<TipoConsumidor> listarTiposConsumidor() {
        return listarBean.listarTiposConsumidor();
    }

    public static List<Pedido> listarPedidos() {
        return listarBean.listarPedidos();
    }

    public static List<Comentario> listarComentarios() {
        return listarBean.listarComentarios();
    }

    public static List<String> listarMetodosPagamento() {
        return listarBean.listarMetodosPagamento();
    }

    /**
     * @param emailConsumidor
     */
    public static List<CantinaVisivel> listarCantinasVisiveis(String emailConsumidor) {
        return listarBean.listarCantinasVisiveis(emailConsumidor);
    }

    public static List<Cantina> listarCantinasAtivas() {
        return listarBean.listarCantinasAtivas();
    }

    public static List<Componente> listarComponentes() {
        return listarBean.listarComponentes();
    }

    public static List<Cantina> listarCantinas() {
        return listarBean.listarCantinas();
    }

    /**
     * @param emailConsumidor
     */
    public static Map<CantinaVisivel, List<Par<String,Refeicao>>> consultarCalendario(String emailConsumidor) {
        return refeicaoBean.consultarCalendario(emailConsumidor);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     */
    public static boolean isRefeicaoReservada(String emailConsumidor, int refeicaoId) {
        return refeicaoBean.isRefeicaoReservada(emailConsumidor, refeicaoId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param cantinaId
     */
    public static Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Par<Boolean, Par<Float, Par<Map<Componente, Ementa>, Map<Componente, List<Ementa>>>>>>>>> consultarRefeicaoReservada(String emailConsumidor, int refeicaoId, int cantinaId) {
        return refeicaoBean.consultarRefeicaoReservada(emailConsumidor, refeicaoId, cantinaId);
    }

    /**
     * @param refeicaoId
     * @param cantinaId
     */
    public static Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Map<Componente, List<Ementa>>>>>> consultarRefeicaoNaoReservada(int refeicaoId, int cantinaId) {
        return refeicaoBean.consultarRefeicaoNaoReservada(refeicaoId, cantinaId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param cantinaId
     */
    public static Par<String, Par<Refeicao, Par<String, Map<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>>>>> getMenuRefeicao(String emailConsumidor, int refeicaoId, int cantinaId) {
        return refeicaoBean.getMenuRefeicao(emailConsumidor, refeicaoId, cantinaId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param tipoRefeicaoId
     * @param ementasId
     */
    public static boolean reservarRefeicao(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId) {
        return refeicaoBean.reservarRefeicao(emailConsumidor, refeicaoId, tipoRefeicaoId, preco, ementasId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     */
    public static boolean cancelarReserva(String emailConsumidor, int refeicaoId) {
        return refeicaoBean.cancelarReserva(emailConsumidor, refeicaoId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param tipoRefeicaoId
     * @param ementasId
     */
    public static boolean editarReserva(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId) {
        return refeicaoBean.editarReserva(emailConsumidor, refeicaoId, tipoRefeicaoId, preco, ementasId);
    }

    /**
     * @param qrCode
     * @param ferramentaId
     */
    public static boolean validarReserva(String qrCode, int ferramentaId) {
        return refeicaoBean.validarReserva(qrCode, ferramentaId);
    }

    /**
     * @param ferramentaId
     */
    public static boolean registarEntradaConsumidor(int ferramentaId) {
        return refeicaoBean.registarEntradaConsumidor(ferramentaId);
    }

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param pontuacao
     * @param comentariosId
     */
    public static boolean avaliarRefeicao(String emailConsumidor, int refeicaoId, int pontuacao, List<Integer> comentariosId) {
        return refeicaoBean.avaliarRefeicao(emailConsumidor, refeicaoId, pontuacao, comentariosId);
    }

    /**
     * @param emailUtilizador
     * @param password
     */
    public static boolean autenticar(String emailUtilizador, String password) {
        return utilizadorBean.autenticar(emailUtilizador, password);
    }

    /**
     * @param emailUtilizador
     * @param password
     */
    public static boolean definirPassword(String emailUtilizador, String password) {
        return utilizadorBean.definirPassword(emailUtilizador, password);
    }

    private static AdministradorBeanLocal lookupAdministradorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (AdministradorBeanLocal) c.lookup("java:global/tickeat_war_exploded/AdministradorBean!beans.AdministradorBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static ConsumidorBeanLocal lookupConsumidorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (ConsumidorBeanLocal) c.lookup("java:global/tickeat_war_exploded/ConsumidorBean!beans.ConsumidorBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static CozinheiroBeanLocal lookupCozinheiroBeanLocal() {
        try {
            Context c = new InitialContext();
            return (CozinheiroBeanLocal) c.lookup("java:global/tickeat_war_exploded/CozinheiroBean!beans.CozinheiroBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static ListarBeanLocal lookupListarBeanLocal() {
        try {
            Context c = new InitialContext();
            return (ListarBeanLocal) c.lookup("java:global/tickeat_war_exploded/ListarBean!beans.ListarBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static RefeicaoBeanLocal lookupRefeicaoBeanLocal() {
        try {
            Context c = new InitialContext();
            return (RefeicaoBeanLocal) c.lookup("java:global/tickeat_war_exploded/RefeicaoBean!beans.RefeicaoBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static UtilizadorBeanLocal lookupUtilizadorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (UtilizadorBeanLocal) c.lookup("java:global/tickeat_war_exploded/UtilizadorBean!beans.UtilizadorBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }
}