package beans;

import main.*;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;


@Local
public interface AdministradorBeanLocal {

    /**
     * @param pedidoId
     * @param valida
     */
    boolean validarContaConsumidor(int pedidoId, boolean valida);


    // TODO: REGISTAR ADMINISTRADOR
    /**
     * @param emailAdministrador
     */
    //boolean registarAdministrador(String emailAdministrador);


    // TODO: REGISTAR COZINHEIRO
    /**
     * @param emailCozinheiro
     */
    //boolean registarCozinheiro(String emailCozinheiro);


    // TODO: REGISTAR EMENTA

    /**
     * @param nome
     * @param localizacao
     * @param descricao
     * @param refeicoesInfo
     * @param tiposRefeicao
     */
    boolean definirCantina(String nome, String localizacao, String descricao, List<RefeicaoInfo> refeicoesInfo, List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao);


    // TODO: ADICIONAR FERRAMENTA VALIDAÇÃO (LISTAR TIPOS DE REFEIÇÃO E CANTINAS)
    /**
     * @param cantinaId
     * @param tipoRefeicaoId
     */
    //boolean adicionarFerramentaValidacao(int cantinaId, int tipoRefeicaoId);


    // TODO: ADICIONAR FERRAMENTA CONTAGEM (LISTAR CANTINAS)
    /**
     * @param cantinaId
     */
    //boolean adicionarFerramentaContagem(int cantinaId);


    // TODO: DEFINIR TIPOS DE CONSUMIDOR
    /**
     * @param tiposConsumidor
     */
    //boolean definirTiposConsumidor(List<String> tiposConsumidor);


    // TODO: INATIVAR UTILIZADOR (LISTAR ADMINISTRADORES, COZINHEIROS E CONSUMIDORES)
    /**
     * @param emailUtilizador
     */
    //boolean inativarUtilizador(String emailUtilizador);


    // TODO: INATIVAR CANTINA (LISTAR CANTINAS)
    /**
     * @param cantinaId
     */
    //boolean inativarCantina(int cantinaId);


    // TODO: INATIVAR FERRAMENTA (LISTAR FERRAMENTAS)
    /**
     * @param ferramentaId
     */
    //boolean inativarFerramenta(int ferramentaId);


    // TODO: EDITAR EMENTA

    // TODO: EDITAR CANTINA

    /**
     * @param
     */
    Map<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> analiseDiaria();



    /* EXTRAS
    * TODO: LISTAR AVALIAÇÕES
    * TODO: DESCARREGAR RELATÓRIO DIÁRIO
    */

}