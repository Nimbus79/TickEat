package main;

import org.orm.PersistentException;

import java.util.Arrays;
import java.util.List;

public class FacadeDAOs {

    // ADMINISTRADOR

    public static Administrador createAdministrador() {
        return AdministradorDAO.createAdministrador();
    }

    /**
     * @param administrador
     */
    public static boolean saveAdministrador(Administrador administrador) throws PersistentException {
        return AdministradorDAO.save(administrador);
    }

    /**
     * @param email
     */
    public static Administrador getAdministrador(String email) throws PersistentException {
        return AdministradorDAO.getAdministradorByORMID(email);
    }


    // AVALIACAO

    public static Avaliacao createAvaliacao() {
        return AvaliacaoDAO.createAvaliacao();
    }

    /**
     * @param avaliacao
     */
    public static boolean saveAvaliacao(Avaliacao avaliacao) throws PersistentException {
        return AvaliacaoDAO.save(avaliacao);
    }

    /**
     * @param id
     */
    public static Avaliacao getAvaliacao(int id) throws PersistentException {
        return AvaliacaoDAO.getAvaliacaoByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Avaliacao> listAvaliacoes(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(AvaliacaoDAO.listAvaliacaoByQuery(condition, orderBy));
    }


    // CANTINA

    public static Cantina createCantina() {
        return CantinaDAO.createCantina();
    }

    /**
     * @param cantina
     */
    public static boolean saveCantina(Cantina cantina) throws PersistentException {
        return CantinaDAO.save(cantina);
    }

    /**
     * @param id
     */
    public static Cantina getCantina(int id) throws PersistentException {
        return CantinaDAO.getCantinaByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Cantina> listCantinas(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(CantinaDAO.listCantinaByQuery(condition, orderBy));
    }


    // CANTINAVISIVEL

    public static CantinaVisivel createCantinaVisivel() {
        return CantinaVisivelDAO.createCantinaVisivel();
    }

    /**
     * @param cantinaVisivel
     */
    public static boolean saveCantinaVisivel(CantinaVisivel cantinaVisivel) throws PersistentException {
        return CantinaVisivelDAO.save(cantinaVisivel);
    }

    /**
     * @param id
     */
    public static CantinaVisivel getCantinaVisivel(int id) throws PersistentException {
        return CantinaVisivelDAO.getCantinaVisivelByORMID(id);
    }

    /**
     * @param cantinaVisivel
     */
    public static boolean deleteCantinaVisivel(CantinaVisivel cantinaVisivel) throws PersistentException {
        return CantinaVisivelDAO.delete(cantinaVisivel);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<CantinaVisivel> listCantinasVisiveis(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(CantinaVisivelDAO.listCantinaVisivelByQuery(condition, orderBy));
    }


    // CARREGAMENTO

    public static Carregamento createCarregamento() {
        return CarregamentoDAO.createCarregamento();
    }

    /**
     * @param carregamento
     */
    public static boolean saveCarregamento(Carregamento carregamento) throws PersistentException {
        return CarregamentoDAO.save(carregamento);
    }

    /**
     * @param id
     */
    public static Carregamento getCarregamento(int id) throws PersistentException {
        return CarregamentoDAO.getCarregamentoByORMID(id);
    }

    /**
     * @param carregamento
     */
    public static boolean deleteCarregamento(Carregamento carregamento) throws PersistentException {
        return CarregamentoDAO.delete(carregamento);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Carregamento> listCarregamentos(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(CarregamentoDAO.listCarregamentoByQuery(condition, orderBy));
    }


    // COMENTARIO

    public static Comentario createComentario() {
        return ComentarioDAO.createComentario();
    }

    /**
     * @param comentario
     */
    public static boolean saveComentario(Comentario comentario) throws PersistentException {
        return ComentarioDAO.save(comentario);
    }

    /**
     * @param id
     */
    public static Comentario getComentario(int id) throws PersistentException {
        return ComentarioDAO.getComentarioByORMID(id);
    }

    /**
     * @param comentario
     */
    public static boolean deleteComentario(Comentario comentario) throws PersistentException {
        return ComentarioDAO.delete(comentario);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Comentario> listComentarios(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(ComentarioDAO.listComentarioByQuery(condition, orderBy));
    }


    // COMPONENTE

    /**
     * @param id
     */
    public static Componente getComponente(int id) throws PersistentException {
        return ComponenteDAO.getComponenteByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Componente> listComponentes(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(ComponenteDAO.listComponenteByQuery(condition, orderBy));
    }


    // CONSUMIDOR

    public static Consumidor createConsumidor() {
        return ConsumidorDAO.createConsumidor();
    }

    /**
     * @param consumidor
     */
    public static boolean saveConsumidor(Consumidor consumidor) throws PersistentException {
        return ConsumidorDAO.save(consumidor);
    }

    /**
     * @param email
     */
    public static Consumidor getConsumidor(String email) throws PersistentException {
        return ConsumidorDAO.getConsumidorByORMID(email);
    }

    /**
     * @param consumidor
     */
    public static boolean deleteConsumidor(Consumidor consumidor) throws PersistentException {
        return ConsumidorDAO.delete(consumidor);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Consumidor> listConsumidores(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(ConsumidorDAO.listConsumidorByQuery(condition, orderBy));
    }


    // COZINHEIRO

    public static Cozinheiro createCozinheiro() {
        return CozinheiroDAO.createCozinheiro();
    }

    /**
     * @param cozinheiro
     */
    public static boolean saveCozinheiro(Cozinheiro cozinheiro) throws PersistentException {
        return CozinheiroDAO.save(cozinheiro);
    }

    /**
     * @param email
     */
    public static Cozinheiro getCozinheiro(String email) throws PersistentException {
        return CozinheiroDAO.getCozinheiroByORMID(email);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Cozinheiro> listCozinheiros(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(CozinheiroDAO.listCozinheiroByQuery(condition, orderBy));
    }


    // DESPESA

    public static Despesa createDespesa() {
        return DespesaDAO.createDespesa();
    }

    /**
     * @param despesa
     */
    public static boolean saveDespesa(Despesa despesa) throws PersistentException {
        return DespesaDAO.save(despesa);
    }

    /**
     * @param id
     */
    public static Despesa getDespesa(int id) throws PersistentException {
        return DespesaDAO.getDespesaByORMID(id);
    }

    /**
     * @param despesa
     */
    public static boolean deleteDespesa(Despesa despesa) throws PersistentException {
        return DespesaDAO.delete(despesa);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Despesa> listDespesas(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(DespesaDAO.listDespesaByQuery(condition, orderBy));
    }


    // EMENTA

    public static Ementa createEmenta() {
        return EmentaDAO.createEmenta();
    }

    /**
     * @param ementa
     */
    public static boolean saveEmenta(Ementa ementa) throws PersistentException {
        return EmentaDAO.save(ementa);
    }

    /**
     * @param id
     */
    public static Ementa getEmenta(int id) throws PersistentException {
        return EmentaDAO.getEmentaByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Ementa> listEmentas(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(EmentaDAO.listEmentaByQuery(condition, orderBy));
    }


    // FERRAMENTA

    public static Ferramenta createFerramenta() {
        return FerramentaDAO.createFerramenta();
    }

    /**
     * @param ferramenta
     */
    public static boolean saveFerramenta(Ferramenta ferramenta) throws PersistentException {
        return FerramentaDAO.save(ferramenta);
    }

    /**
     * @param id
     */
    public static Ferramenta getFerramenta(int id) throws PersistentException {
        return FerramentaDAO.getFerramentaByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Ferramenta> listFerramentas(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(FerramentaDAO.listFerramentaByQuery(condition, orderBy));
    }


    // FERRAMENTACONTAGEM

    public static FerramentaContagem createFerramentaContagem() {
        return FerramentaContagemDAO.createFerramentaContagem();
    }

    /**
     * @param ferramentaContagem
     */
    public static boolean saveFerramentaContagem(FerramentaContagem ferramentaContagem) throws PersistentException {
        return FerramentaContagemDAO.save(ferramentaContagem);
    }

    /**
     * @param id
     */
    public static FerramentaContagem getFerramentaContagem(int id) throws PersistentException {
        return FerramentaContagemDAO.getFerramentaContagemByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<FerramentaContagem> listFerramentasContagem(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(FerramentaContagemDAO.listFerramentaContagemByQuery(condition, orderBy));
    }


    // FERRAMENTAVALIDACAO

    public static FerramentaValidacao createFerramentaValidacao() {
        return FerramentaValidacaoDAO.createFerramentaValidacao();
    }

    /**
     * @param ferramentaValidacao
     */
    public static boolean saveFerramentaValidacao(FerramentaValidacao ferramentaValidacao) throws PersistentException {
        return FerramentaValidacaoDAO.save(ferramentaValidacao);
    }

    /**
     * @param id
     */
    public static FerramentaValidacao getFerramentaValidacao(int id) throws PersistentException {
        return FerramentaValidacaoDAO.getFerramentaValidacaoByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<FerramentaValidacao> listFerramentasValidacao(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(FerramentaValidacaoDAO.listFerramentaValidacaoByQuery(condition, orderBy));
    }


    // MOVIMENTO

    public static Movimento createMovimento() {
        return MovimentoDAO.createMovimento();
    }

    /**
     * @param movimento
     */
    public static boolean saveMovimento(Movimento movimento) throws PersistentException {
        return MovimentoDAO.save(movimento);
    }

    /**
     * @param id
     */
    public static Movimento getMovimento(int id) throws PersistentException {
        return MovimentoDAO.getMovimentoByORMID(id);
    }

    /**
     * @param movimento
     */
    public static boolean deleteMovimento(Movimento movimento) throws PersistentException {
        return MovimentoDAO.delete(movimento);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Movimento> listMovimentos(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(MovimentoDAO.listMovimentoByQuery(condition, orderBy));
    }


    // NOTIFICACAO

    public static Notificacao createNotificacao() {
        return NotificacaoDAO.createNotificacao();
    }

    /**
     * @param notificacao
     */
    public static boolean saveNotificacao(Notificacao notificacao) throws PersistentException {
        return NotificacaoDAO.save(notificacao);
    }

    /**
     * @param id
     */
    public static Notificacao getNotificacao(int id) throws PersistentException {
        return NotificacaoDAO.getNotificacaoByORMID(id);
    }

    /**
     * @param notificacao
     */
    public static boolean deleteNotificacao(Notificacao notificacao) throws PersistentException {
        return NotificacaoDAO.delete(notificacao);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Notificacao> listNotificacoes(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(NotificacaoDAO.listNotificacaoByQuery(condition, orderBy));
    }


    // PEDIDO

    public static Pedido createPedido() {
        return PedidoDAO.createPedido();
    }

    /**
     * @param pedido
     */
    public static boolean savePedido(Pedido pedido) throws PersistentException {
        return PedidoDAO.save(pedido);
    }

    /**
     * @param id
     */
    public static Pedido getPedido(int id) throws PersistentException {
        return PedidoDAO.getPedidoByORMID(id);
    }

    /**
     * @param pedido
     */
    public static boolean deletePedido(Pedido pedido) throws PersistentException {
        return PedidoDAO.delete(pedido);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Pedido> listPedidos(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(PedidoDAO.listPedidoByQuery(condition, orderBy));
    }


    // PRECO

    public static Preco createPreco() {
        return PrecoDAO.createPreco();
    }

    /**
     * @param preco
     */
    public static boolean savePreco(Preco preco) throws PersistentException {
        return PrecoDAO.save(preco);
    }

    /**
     * @param id
     */
    public static Preco getPreco(int id) throws PersistentException {
        return PrecoDAO.getPrecoByORMID(id);
    }

    /**
     * @param preco
     */
    public static boolean deletePreco(Preco preco) throws PersistentException {
        return PrecoDAO.delete(preco);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Preco> listPrecos(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(PrecoDAO.listPrecoByQuery(condition, orderBy));
    }


    // REFEICAO

    public static Refeicao createRefeicao() {
        return RefeicaoDAO.createRefeicao();
    }

    /**
     * @param refeicao
     */
    public static boolean saveRefeicao(Refeicao refeicao) throws PersistentException {
        return RefeicaoDAO.save(refeicao);
    }

    /**
     * @param id
     */
    public static Refeicao getRefeicao(int id) throws PersistentException {
        return RefeicaoDAO.getRefeicaoByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Refeicao> listRefeicoes(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(RefeicaoDAO.listRefeicaoByQuery(condition, orderBy));
    }


    // REFEICAOINFO

    public static RefeicaoInfo createRefeicaoInfo() {
        return RefeicaoInfoDAO.createRefeicaoInfo();
    }

    /**
     * @param refeicaoInfo
     */
    public static boolean saveRefeicaoInfo(RefeicaoInfo refeicaoInfo) throws PersistentException {
        return RefeicaoInfoDAO.save(refeicaoInfo);
    }

    /**
     * @param id
     */
    public static RefeicaoInfo getRefeicaoInfo(int id) throws PersistentException {
        return RefeicaoInfoDAO.getRefeicaoInfoByORMID(id);
    }

    /**
     * @param refeicaoInfo
     */
    public static boolean deleteRefeicaoInfo(RefeicaoInfo refeicaoInfo) throws PersistentException {
        return RefeicaoInfoDAO.delete(refeicaoInfo);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<RefeicaoInfo> listRefeicoesInfo(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(RefeicaoInfoDAO.listRefeicaoInfoByQuery(condition, orderBy));
    }


    // RESERVA

    public static Reserva createReserva() {
        return ReservaDAO.createReserva();
    }

    /**
     * @param reserva
     */
    public static boolean saveReserva(Reserva reserva) throws PersistentException {
        return ReservaDAO.save(reserva);
    }

    /**
     * @param id
     */
    public static Reserva getReserva(int id) throws PersistentException {
        return ReservaDAO.getReservaByORMID(id);
    }

    /**
     * @param reserva
     */
    public static boolean deleteReserva(Reserva reserva) throws PersistentException {
        return ReservaDAO.delete(reserva);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Reserva> listReservas(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(ReservaDAO.listReservaByQuery(condition, orderBy));
    }


    // TABELANUTRICIONAL

    public static TabelaNutricional createTabelaNutricional() {
        return TabelaNutricionalDAO.createTabelaNutricional();
    }

    /**
     * @param tabelaNutricional
     */
    public static boolean saveTabelaNutricional(TabelaNutricional tabelaNutricional) throws PersistentException {
        return TabelaNutricionalDAO.save(tabelaNutricional);
    }

    /**
     * @param id
     */
    public static TabelaNutricional getTabelaNutricional(int id) throws PersistentException {
        return TabelaNutricionalDAO.getTabelaNutricionalByORMID(id);
    }

    /**
     * @param tabelaNutricional
     */
    public static boolean deleteTabelaNutricional(TabelaNutricional tabelaNutricional) throws PersistentException {
        return TabelaNutricionalDAO.delete(tabelaNutricional);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<TabelaNutricional> listTabelasNutricionais(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(TabelaNutricionalDAO.listTabelaNutricionalByQuery(condition, orderBy));
    }


    // TIPOCONSUMIDOR

    public static TipoConsumidor createTipoConsumidor() {
        return TipoConsumidorDAO.createTipoConsumidor();
    }

    /**
     * @param tipoConsumidor
     */
    public static boolean saveTipoConsumidor(TipoConsumidor tipoConsumidor) throws PersistentException {
        return TipoConsumidorDAO.save(tipoConsumidor);
    }

    /**
     * @param id
     */
    public static TipoConsumidor getTipoConsumidor(int id) throws PersistentException {
        return TipoConsumidorDAO.getTipoConsumidorByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<TipoConsumidor> listTiposConsumidor(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(TipoConsumidorDAO.listTipoConsumidorByQuery(condition, orderBy));
    }


    // TIPOREFEICAO

    public static TipoRefeicao createTipoRefeicao() {
        return TipoRefeicaoDAO.createTipoRefeicao();
    }

    /**
     * @param tipoRefeicao
     */
    public static boolean saveTipoRefeicao(TipoRefeicao tipoRefeicao) throws PersistentException {
        return TipoRefeicaoDAO.save(tipoRefeicao);
    }

    /**
     * @param id
     */
    public static TipoRefeicao getTipoRefeicao(int id) throws PersistentException {
        return TipoRefeicaoDAO.getTipoRefeicaoByORMID(id);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<TipoRefeicao> listTiposRefeicao(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(TipoRefeicaoDAO.listTipoRefeicaoByQuery(condition, orderBy));
    }


    // UTILIZADOR

    public static Utilizador createUtilizador() {
        return UtilizadorDAO.createUtilizador();
    }

    /**
     * @param utilizador
     */
    public static boolean saveUtilizador(Utilizador utilizador) throws PersistentException {
        return UtilizadorDAO.save(utilizador);
    }

    /**
     * @param email
     */
    public static Utilizador getUtilizador(String email) throws PersistentException {
        return UtilizadorDAO.getUtilizadorByORMID(email);
    }

    /**
     * @param utilizador
     */
    public static boolean deleteUtilizador(Utilizador utilizador) throws PersistentException {
        return UtilizadorDAO.delete(utilizador);
    }

    /**
     * @param condition
     * @param orderBy
     */
    public static List<Utilizador> listUtilizadores(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(UtilizadorDAO.listUtilizadorByQuery(condition, orderBy));
    }
}
