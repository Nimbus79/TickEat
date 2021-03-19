package beans;

import main.*;
import org.orm.PersistentException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.*;


@Local(ListarBeanLocal.class)
@Stateless(name = "ListarBean")
public class ListarBean implements ListarBeanLocal {

    public ListarBean() {
    }

    @Override
    public List<TipoConsumidor> listarTiposConsumidor() {
        List<TipoConsumidor> tiposConsumidor = null;
        try {
            tiposConsumidor = FacadeDAOs.listTiposConsumidor("Ativo=1", "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return tiposConsumidor;
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = null;
        try {
            pedidos = FacadeDAOs.listPedidos(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public List<Comentario> listarComentarios() {
        List<Comentario> comentarios = null;
        try {
            comentarios = FacadeDAOs.listComentarios("Ativo=1", "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return comentarios;
    }

    @Override
    public List<String> listarMetodosPagamento() {
        List<String> metodos = new ArrayList<>();
        metodos.add("Multibanco");
        metodos.add("MBWay");
        metodos.add("Paypal");
        metodos.add("Revolut");
        return metodos;
    }

    @Override
    public List<CantinaVisivel> listarCantinasVisiveis(String emailConsumidor) {
        List<CantinaVisivel> cantinasVisiveis = null;
        try {
            cantinasVisiveis = FacadeDAOs.listCantinasVisiveis("ConsumidorUtilizadorEmail='"+emailConsumidor+"'", "posicao");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return cantinasVisiveis;
    }

    @Override
    public List<Cantina> listarCantinasAtivas() {
        List<Cantina> cantinas = null;
        try {
            cantinas = FacadeDAOs.listCantinas("Ativo=1", "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return cantinas;
    }

    @Override
    public List<Componente> listarComponentes() {
        List<Componente> componentes = null;
        try {
            componentes = FacadeDAOs.listComponentes(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return componentes;
    }

    @Override
    public List<Cantina> listarCantinas() {
        List<Cantina> cantinas = null;
        try {
            cantinas = FacadeDAOs.listCantinas(null, "id");
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return cantinas;
    }
}