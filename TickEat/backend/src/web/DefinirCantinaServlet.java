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


@WebServlet(name = "DefinirCantinaServlet", urlPatterns = "/DefinirCantina")
public class DefinirCantinaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        Cookie[] cookies = request.getCookies();
        Claims claims = null;

        if (cookies != null) {
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
                String nome = (String) parameters.get("nome");
                String localizacao = (String) parameters.get("localizacao");
                String descricao = (String) parameters.get("descricao");
                List<RefeicaoInfo> refeicoesInfo = Util.parseRefeicoesInfoArray(parameters.getJSONArray("refeicoesInfo"));
                List<TipoConsumidor> tiposConsumidor = FacadeBeans.listarTiposConsumidor();
                List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao = Util.parseTiposRefeicaoArray(parameters.getJSONArray("tiposRefeicao"), tiposConsumidor);

                boolean result = FacadeBeans.definirCantina(nome, localizacao, descricao, refeicoesInfo, tiposRefeicao);

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

        if (cookies != null) {
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

                List<Componente> componentes = FacadeBeans.listarComponentes();
                List<TipoConsumidor> tiposConsumidor = FacadeBeans.listarTiposConsumidor();

                // Erro nos beans
                if (componentes == null || tiposConsumidor == null) {
                    mensagem.put("success", false);
                }
                else {
                    mensagem.put("success", true);
                    mensagem.put("info", Util.parseInfo(componentes, tiposConsumidor));
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