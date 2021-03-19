package web;

import beans.FacadeBeans;
import com.google.gson.Gson;
import main.TipoConsumidor;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "RegistarServlet", urlPatterns = "/Registar")
public class RegistarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String emailConsumidor = (String) parameters.get("utilizadorEmail");
        String nome = (String) parameters.get("nome");
        int tipoConsumidorId = Integer.parseInt((String) parameters.get("tipoConsumidorId"));

        boolean result = FacadeBeans.registar(emailConsumidor, nome, tipoConsumidorId);

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();

        List<TipoConsumidor> tiposConsumidor = FacadeBeans.listarTiposConsumidor();

        // Erro nos beans
        if (tiposConsumidor == null) {
            mensagem.put("success", false);
        }
        else {
            Gson gson= new Gson();
            String json = gson.toJson(tiposConsumidor);
            mensagem.put("success", true);
            mensagem.put("tiposConsumidor", json);
        }
        out.print(mensagem);
        out.flush();
    }
}