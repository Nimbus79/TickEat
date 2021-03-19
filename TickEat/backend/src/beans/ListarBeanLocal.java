package beans;

import main.*;
import javax.ejb.Local;
import java.util.List;


@Local
public interface ListarBeanLocal {

    // UTILIZADA NO REGISTAR E NO DEFINIR CANTINA
    List<TipoConsumidor> listarTiposConsumidor();

    // UTILIZADA NO VALIDAR CONTA CONSUMIDOR
    List<Pedido> listarPedidos();

    // UTILIZADA NO AVALIAR REFEIÇÃO
    List<Comentario> listarComentarios();

    // UTILIZADA NO CARREGAR SALDO
    List<String> listarMetodosPagamento();

    // UTILIZADA NO EDITAR PERFIL
    List<CantinaVisivel> listarCantinasVisiveis(String emailConsumidor);

    // UTILIZADA NO CONSULTAR INFORMAÇÕES
    List<Cantina> listarCantinasAtivas();

    // UTILIZADA NO DEFINIR CANTINA
    List<Componente> listarComponentes();

    // UTILIZADA NO CONSULTAR CANTINAS
    List<Cantina> listarCantinas();
}