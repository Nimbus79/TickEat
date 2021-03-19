package beans;

import main.*;
import javax.ejb.Local;
import java.util.List;
import java.util.Map;


@Local
public interface CozinheiroBeanLocal {

    /**
     * @param emailCozinheiro
     */
    Par<Cantina, Refeicao> consultarEstadoFila(String emailCozinheiro);

    /**
     * @param emailCozinheiro
     */
    Map<Componente,List<Ementa>> consultarEmenta(String emailCozinheiro);

    /**
     * @param refeicaoId
     */
    boolean iniciarRefeicao(int refeicaoId);
}