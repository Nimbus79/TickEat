package web;

import beans.FacadeBeans;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ValidarReservaServlet", urlPatterns = "/Validar")
public class ValidarReservaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String qrCode = (String) parameters.get("qrCode");
        int ferramentaId = Integer.parseInt((String) parameters.get("ferramentaId"));

        boolean result = FacadeBeans.validarReserva(qrCode, ferramentaId);

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }
}