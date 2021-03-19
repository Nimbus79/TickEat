package beans;

import javax.ejb.Local;


@Local
public interface UtilizadorBeanLocal {

	/**
     * @param emailUtilizador
     * @param password
     */
    boolean autenticar(String emailUtilizador, String password);



    /**
     * @param emailUtilizador
     * @param password
     */
    boolean definirPassword(String emailUtilizador, String password);
}