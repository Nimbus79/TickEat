package web;

import beans.FacadeBeans;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "RegistarEntradaConsumidorServlet", urlPatterns = "/Entrada")
public class RegistarEntradaConsumidorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        int ferramentaId = Integer.parseInt((String) parameters.get("ferramentaId"));

        boolean result = FacadeBeans.registarEntradaConsumidor(ferramentaId);

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }
}