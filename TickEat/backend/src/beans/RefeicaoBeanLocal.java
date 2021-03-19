package beans;

import main.*;
import javax.ejb.Local;
import java.util.List;
import java.util.Map;


@Local
public interface RefeicaoBeanLocal {

    /**
     * @param emailConsumidor
     */
    Map<CantinaVisivel, List<Par<String,Refeicao>>> consultarCalendario(String emailConsumidor);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     */
    boolean isRefeicaoReservada(String emailConsumidor, int refeicaoId);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param cantinaId
     */
    Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Par<Boolean, Par<Float, Par<Map<Componente,Ementa>,Map<Componente,List<Ementa>>>>>>>>> consultarRefeicaoReservada(String emailConsumidor, int refeicaoId, int cantinaId);

    /**
     * @param refeicaoId
     * @param cantinaId
     */
    Par<Cantina, Par<Refeicao, Par<String, Par<Boolean,Map<Componente,List<Ementa>>>>>> consultarRefeicaoNaoReservada(int refeicaoId, int cantinaId);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param cantinaId
     */
    Par<String, Par<Refeicao, Par<String, Map<TipoRefeicao, Par<Float, Map<Componente,List<Ementa>>>>>>> getMenuRefeicao(String emailConsumidor, int refeicaoId, int cantinaId);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param tipoRefeicaoId
     * @param ementasId
     */
    boolean reservarRefeicao(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     */
    boolean cancelarReserva(String emailConsumidor, int refeicaoId);

    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param tipoRefeicaoId
     * @param ementasId
     */
    boolean editarReserva(String emailConsumidor, int refeicaoId, int tipoRefeicaoId, float preco, List<Integer> ementasId);

    /**
     * @param qrCode
     * @param ferramentaId
     */
    boolean validarReserva(String qrCode, int ferramentaId);

    /**
     * @param ferramentaId
     */
    boolean registarEntradaConsumidor(int ferramentaId);


    // TODO: CONSULTAR AFLUÊNCIA


    /**
     * @param emailConsumidor
     * @param refeicaoId
     * @param pontuacao
     * @param comentariosId
     */
    boolean avaliarRefeicao(String emailConsumidor, int refeicaoId, int pontuacao, List<Integer> comentariosId);
}