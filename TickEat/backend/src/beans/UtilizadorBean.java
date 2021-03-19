package beans;

import main.*;
import org.orm.PersistentException;
import javax.ejb.Local;
import javax.ejb.Stateless;


@Local(UtilizadorBeanLocal.class)
@Stateless(name = "UtilizadorBean")
public class UtilizadorBean implements UtilizadorBeanLocal {

    public UtilizadorBean() {
    }

    @Override
    public boolean autenticar(String emailUtilizador, String password){
        boolean result = false;

        Utilizador utilizador = null;
        try {
            utilizador = FacadeDAOs.getUtilizador(emailUtilizador);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if (utilizador != null) {
        	if (utilizador.getAtivo() && utilizador.getPassword().equals(password)) {
            	result = true;
        	}
        }
        return result;
    }

    @Override
    public boolean definirPassword(String emailUtilizador, String password) {
        boolean result = false;

        try {
            Utilizador utilizador = FacadeDAOs.getUtilizador(emailUtilizador);
            if (utilizador.getPassword() == null && utilizador.getAtivo()) {
                utilizador.setPassword(password);
                result = FacadeDAOs.saveUtilizador(utilizador);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return result;
    }
}