package web;

import beans.FacadeBeans;
import io.jsonwebtoken.Claims;
import main.Cantina;
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


@WebServlet(name = "ConsultarCantinasServlet", urlPatterns = "/Cantinas")
public class ConsultarCantinasServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
            String emailAdministrador = claims.getSubject();
            Date expir = claims.getExpiration();
            Date now = new Date();
            String type = claims.get("type").toString();

            if (emailAdministrador != null && expir.after(now) && type.equals("Administrador")) {

                List<Cantina> cantinas = FacadeBeans.listarCantinas();

                // Erro nos beans
                if (cantinas == null) {
                    mensagem.put("success", false);
                }
                else {
                    mensagem.put("success", true);
                    mensagem.put("cantinas", Util.parseCantinasList(cantinas));
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
