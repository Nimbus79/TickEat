package beans;

import main.*;
import javax.ejb.Local;
import java.sql.Blob;
import java.util.List;


@Local
public interface ConsumidorBeanLocal {

    /**
     * @param emailConsumidor
     * @param nome
     * @param tipoConsumidorId
     */
    boolean registar(String emailConsumidor, String nome, int tipoConsumidorId);

    /**
     * @param emailConsumidor
     */
    List<Par<Cantina, Refeicao>> consultarPrevisoes(String emailConsumidor);

    /**
     * @param emailConsumidor
     * @param valor
     * @param metodo
     */
    int carregarSaldo(String emailConsumidor, float valor, String metodo);

    /**
     * @param emailConsumidor
     */
    Par<Float, Float> consultarSaldos(String emailConsumidor);

    /**
     * @param emailConsumidor
     */
    List<Par<Cantina, Movimento>> consultarMovimentos(String emailConsumidor);

    /**
     * @param emailConsumidor
     */
    Par<Consumidor, List<CantinaVisivel>> consultarPerfil(String emailConsumidor);

    /**
     * @param emailConsumidor
     * @param nome
     * @param atualPassword
     * @param novaPassword
     * @param contribuinte
     * @param cantinasVisiveis
     */
    boolean editarPerfil(String emailConsumidor, String nome, String atualPassword, String novaPassword, int contribuinte, List<Par<Integer,Par<Integer, Boolean>>> cantinasVisiveis);

    /**
     * @param emailConsumidor
     * @param fotografia
     */
    boolean alterarFotografia(String emailConsumidor, Blob fotografia);

    /**
     * @param emailConsumidor
     */
    List<Notificacao> consultarNotificacoes(String emailConsumidor);

    /**
     * @param notificacaoId
     */
    boolean notificacaoVista(int notificacaoId);
}