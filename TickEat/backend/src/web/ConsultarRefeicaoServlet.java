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


@WebServlet(name = "ConsultarRefeicaoServlet", urlPatterns = "/Refeicao")
public class ConsultarRefeicaoServlet extends HttpServlet {

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

                boolean reservada = FacadeBeans.isRefeicaoReservada(emailConsumidor, refeicaoId);

                if (reservada) {
                    Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Par<Boolean, Par<Float, Par<Map<Componente, Ementa>, Map<Componente, List<Ementa>>>>>>>>> refeicaoReservada = FacadeBeans.consultarRefeicaoReservada(emailConsumidor, refeicaoId, cantinaId);

                    // Erro nos beans
                    if (refeicaoReservada == null) {
                        mensagem.put("success", false);
                    }
                    else {
                        mensagem.put("success", true);
                        mensagem.put("refeicao", Util.parseRefeicaoReservada(refeicaoReservada));
                    }
                }
                else {
                    Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Map<Componente, List<Ementa>>>>>> refeicaoNaoReservada = FacadeBeans.consultarRefeicaoNaoReservada(refeicaoId, cantinaId);

                    // Erro nos beans
                    if (refeicaoNaoReservada == null) {
                        mensagem.put("success", false);
                    }
                    else {
                        mensagem.put("success", true);
                        mensagem.put("refeicao", Util.parseRefeicaoNaoReservada(refeicaoNaoReservada));
                    }
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