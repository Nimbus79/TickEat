package web;

import beans.FacadeBeans;
import jwt.CookieProvider;
import jwt.TokenProvider;
import main.*;
import org.json.JSONObject;
import org.orm.PersistentException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AutenticarServlet", urlPatterns = "/")
public class AutenticarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String emailUtilizador = (String) parameters.get("email");
        String password = (String) parameters.get("password");
        boolean sessao = Boolean.parseBoolean((String) parameters.get("sessao"));
        
        boolean result = FacadeBeans.autenticar(emailUtilizador, Util.hash(password));

        if (result) {
            try {
                Utilizador utilizador = FacadeDAOs.getUtilizador(emailUtilizador);
                String nome = utilizador.getNome();
                String tipo = utilizador.getTipo();
                String token = TokenProvider.createToken(emailUtilizador, nome, tipo, sessao);
                Cookie cookie = CookieProvider.createCookie(token, sessao);
                response.addCookie(cookie);
                mensagem.put("tipo", tipo);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }
}