package main;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.mchange.io.FileUtils;
import org.apache.commons.io.IOUtils;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;


public class Fatura {

    public static final String BASEURI = "../../TickEat/backend/img/";

    public static String createHTML(String nome, int nif, String data, float valor) {
        String contribuinte = "";
        if (nif != 0) {
            contribuinte = Integer.toString(nif);
        }
        String html =
                "<html>"+
                        "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">"+
                        "<style>"+
                        ".table tr:first-child th {\n" +
                        "background-color: #dddddd;\n" +
                        "}"+
                        "</style>"+
                        "<body>"+
                        "<img src=\"logo_tijolo.png\" style=\"width:30%;height:30%;margin-left:20px\">"+
                        "<div class=\"w3-container\" style=\"width:97.5%;\">"+
                        "<div class=\"w3-container\" style=\"width:40%;height:105px;float:left;font-size:12px;color:grey\">"+
                        "<p><span style=\"font-weight:bold\">Largo do Paço</span></p>"+
                        "<p><span style=\"font-weight:bold\">4704-553 Braga</span></p>"+
                        "<br>"+
                        "<span style=\"font-weight:bold\">E-mail: tickeat@hotmail.com</span>"+
                        "<p><span style=\"font-weight:bold\">NIF: 123456789</span></p>"+
                        "</div>"+
                        "<div class=\"w3-container\" style=\"width:49%;height:100px;float:right;\"></div>"+
                        "<div class=\"w3-container\" style=\"width:49%;height:30px;float:right;line-height:19px;text-align:right;\">"+
                        "<p style=\"margin-right:0px;\"><span style=\"font-weight:bold\">RECIBO</span></p>"+
                        "</div>"+
                        "</div>"+
                        "<br>"+
                        "<div class=\"w3-container\" style=\"width:43%;margin-left:350px;background-color: #dddddd;\">"+
                        "<p><span style=\"font-weight:bold\">NOME: </span>"+nome+"</p>"+
                        "<p><span style=\"font-weight:bold\">NIF: </span>"+contribuinte+"</p>"+
                        "</div>"+
                        "<br>"+
                        "<hr style=\"margin-left: 1.1em;margin-right: 1.1em;border-width: 1px;border-color: black;\">"+
                        "<div class=\"w3-container\">"+
                        "<table class=\"table w3-table w3-border w3-white\" style=\"border-color:black;\">"+
                        "<tr>"+
                        "<th style=\"width:16%\">Data</th>"+
                        "<th>Descrição</th>"+
                        "<th style=\"width:16%\">Montante</th>"+
                        "</tr>"+
                        "<tr>"+
                        "<td style=\"width:16%\">"+data+"</th>"+
                        "<td>Carregamento</th>"+
                        "<td style=\"width:16%\">"+valor+"</th>"+
                        "</tr>"+
                        "</table>"+
                        "</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"+
                        "<hr style=\"margin-left: 1.1em;margin-right: 1.1em;border-width: 1px;border-color: black;\">"+
                        "<div class=\"w3-container\" style=\"font-size:12px\">"+
                        "<div class=\"w3-container w3-border\" style=\"width:55%;height:108px;float:left;border-color:black;\">"+
                        "<p><span style=\"font-weight:bold\">Observações:</span></p>"+
                        //"<p></p>"+
                        "</div>"+
                        "<div class=\"w3-container w3-border\" style=\"width:34%;height:25px;float:right;border-color:black;text-align:right;line-height:5px;background-color: #dddddd;\">"+
                        "<p><span style=\"font-weight:bold\">EURO</span></p>"+
                        "<br>"+
                        "</div>"+
                        "<div class=\"w3-container w3-border-right w3-border-bottom w3-border-left\" style=\"width:34%;height:40px;float:right;border-color:black;line-height:19px;\">"+
                        "<p><span style=\"font-weight:bold\">VALOR PAGO</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span>"+valor+"</span></p>"+
                        "</div>"+
                        "<div class=\"w3-container w3-border-right w3-border-bottom w3-border-left\" style=\"width:34%;height:40px;float:right;border-color:black;line-height:19px;\">"+
                        "<p><span style=\"font-weight:bold\">TOTAL RECIBO</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span>"+valor+"</span></p>"+
                        "</div>"+
                        "</div>"+
                        "</body>"+
                        "</html>";
        return html;
    }

    public static Blob createFatura(String nome, int nif, String data, float valor, String filePath) {
        String html = createHTML(nome, nif, data, valor);
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(BASEURI);
        Blob pdf = null;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            HtmlConverter.convertToPdf(html, fos, properties);
            fos.close();
            File file = new File(filePath);
            pdf = new SerialBlob(FileUtils.getBytes(file));
            file.delete();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return pdf;
    }

    public static File blobToFile(Blob blob, String filePath) {
        File outputFile = new File(filePath);

        try {
            FileOutputStream fout = new FileOutputStream(outputFile);
            IOUtils.copy(blob.getBinaryStream(), fout);
            fout.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }
}