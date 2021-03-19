package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
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


@WebServlet(name = "CarregarSaldoServlet", urlPatterns = "/Carregar")
public class CarregarSaldoServlet extends HttpServlet {

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
                float valor = Float.parseFloat((String) parameters.get("valor"));
                String metodo = (String) parameters.get("metodo");

                int result = FacadeBeans.carregarSaldo(emailConsumidor, valor, metodo);

                if (result == -1) {
                    mensagem.put("success", false);
                }
                else {
                    mensagem.put("success", true);
                    mensagem.put("id", result);
                }
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

                List<String> metodos = FacadeBeans.listarMetodosPagamento();

                // Erro nos beans ou não existem métodos de pagamento
                if (metodos == null) {
                    mensagem.put("success", false);
                }
                else {
                    Gson gson = new Gson();
                    String json = gson.toJson(metodos);
                    mensagem.put("success", true);
                    mensagem.put("metodos", json);
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