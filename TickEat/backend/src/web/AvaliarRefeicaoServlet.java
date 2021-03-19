package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
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


@WebServlet(name = "AvaliarRefeicaoServlet", urlPatterns = "/Avaliar")
public class AvaliarRefeicaoServlet extends HttpServlet {

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
                int pontuacao = Integer.parseInt((String) parameters.get("pontuacao"));
                List<Integer> comentariosId = Util.parseComentariosArray(parameters.getJSONArray("comentarios"));

                boolean result = FacadeBeans.avaliarRefeicao(emailConsumidor, refeicaoId, pontuacao, comentariosId);

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

                List<Comentario> comentarios = FacadeBeans.listarComentarios();

                // Erro nos beans ou não existem comentários
                if (comentarios == null) {
                    mensagem.put("success", false);
                }
                else {
                    Gson gson = new Gson();
                    String json = gson.toJson(comentarios);
                    mensagem.put("success", true);
                    mensagem.put("comentarios", json);
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