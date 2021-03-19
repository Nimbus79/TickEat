package web;

import beans.FacadeBeans;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DefinirPasswordServlet", urlPatterns = "/Password")
public class DefinirPasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JSONObject mensagem = new JSONObject();
        JSONObject parameters = Util.parseBody(request.getReader());

        String emailUtilizador = (String) parameters.get("email");
        String password = (String) parameters.get("password");

        boolean result = FacadeBeans.definirPassword(emailUtilizador, Util.hash(password));

        mensagem.put("success", result);

        out.print(mensagem);
        out.flush();
    }
}