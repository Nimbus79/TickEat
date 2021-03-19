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
import java.util.Map;
import static jwt.CookieProvider.getClaimsFromCookies;

@WebServlet(name = "ReservarRefeicaoServlet", urlPatterns = "/Reservar")
public class ReservarRefeicaoServlet extends HttpServlet {

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
                int refeicaoId = Integer.parseInt(request.getParameter("ref"));
                int tipoRefeicaoId = Integer.parseInt((String) parameters.get("tipoRefeicaoId"));
                float preco = Float.parseFloat((String) parameters.get("preco"));
                List<Integer> ementasId = Util.parseEmentasArray(parameters.getJSONArray("ementas"));

                boolean result = FacadeBeans.reservarRefeicao(emailConsumidor, refeicaoId, tipoRefeicaoId, preco, ementasId);

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
                int refeicaoId = Integer.parseInt(request.getParameter("ref"));
                int cantinaId = Integer.parseInt(request.getParameter("cant"));

                Par<String, Par<Refeicao, Par<String, Map<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>>>>> menuRefeicao = FacadeBeans.getMenuRefeicao(emailConsumidor, refeicaoId, cantinaId);

                // Erro nos beans
                if (menuRefeicao == null) {
                    mensagem.put("success", false);
                }
                else {
                    mensagem.put("success", true);
                    mensagem.put("menuRefeicao", Util.parseMenuRefeicao(menuRefeicao));
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