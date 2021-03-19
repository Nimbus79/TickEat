package web;

import beans.FacadeBeans;
import io.jsonwebtoken.Claims;
import main.*;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import static jwt.CookieProvider.getClaimsFromCookies;


@WebServlet(name = "EditarPerfilServlet", urlPatterns = "/EditarPerfil")
public class EditarPerfilServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        Cookie[] cookies = request.getCookies();
        Claims claims = null;

        if(cookies!=null) {
            claims = getClaimsFromCookies(cookies);
        }

        if (claims == null) {
            mensagem.put("success", false);
        }
        else {
            String emailConsumidor = claims.getSubject();
            Date expir = claims.getExpiration();
            Date now = new Date();
            String type = claims.get("type").toString();

            if (emailConsumidor != null && expir.after(now) && type.equals("Consumidor")) {
                String nome = (String) parameters.get("nome");
                String atualPassword = (String) parameters.get("atualPassword");
                String novaPassword = (String) parameters.get("novaPassword");
                int contribuinte = Integer.parseInt((String) parameters.get("contribuinte"));
                List<Par<Integer, Par<Integer, Boolean>>> cantinasVisiveis = Util.parseCantinasVisiveisArray(parameters.getJSONArray("cantinasVisiveis"));
                if (!novaPassword.equals("")) {
                    novaPassword = Util.hash(novaPassword);
                    atualPassword = Util.hash(atualPassword);
                }

                boolean result = FacadeBeans.editarPerfil(emailConsumidor, nome, atualPassword, novaPassword, contribuinte, cantinasVisiveis);

                mensagem.put("success", result);
            }
            else {
                mensagem.put("success", false);
            }
        }
        out.print(mensagem);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();

        Cookie[] cookies = request.getCookies();
        Claims claims = null;

        if(cookies!=null) {
            claims = getClaimsFromCookies(cookies);
        }

        if (claims == null) {
            mensagem.put("success", false);
        }
        else {
            String emailConsumidor = claims.getSubject();
            Date expir = claims.getExpiration();
            Date now = new Date();
            String type = claims.get("type").toString();

            if (emailConsumidor != null && expir.after(now) && type.equals("Consumidor")) {

                List<CantinaVisivel> cantinasVisiveis = FacadeBeans.listarCantinasVisiveis(emailConsumidor);

                // Erro nos beans
                if (cantinasVisiveis == null) {
                    mensagem.put("success", false);
                }
                else {
                    mensagem.put("success", true);
                    mensagem.put("cantinasVisiveis", Util.parseCantinasVisiveisList(cantinasVisiveis, "editar"));
                }
            }
            else {
                mensagem.put("success", false);
            }
        }
        out.print(mensagem);
        out.flush();
    }
}