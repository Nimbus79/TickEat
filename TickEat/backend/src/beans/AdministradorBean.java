package beans;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import main.*;
import org.orm.PersistentException;
import javax.crypto.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.net.URLEncoder;
import java.security.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Local(AdministradorBeanLocal.class)
@Stateless(name = "AdministradorBean")
public class AdministradorBean implements AdministradorBeanLocal {

    public AdministradorBean() {
    }

    @Override
    public boolean validarContaConsumidor(int pedidoId, boolean valida) {
        boolean result = false;
        Consumidor consumidor;
        String emailConsumidor = "";
        String nomeConsumidor = "";
        try {
            Pedido pedido = FacadeDAOs.getPedido(pedidoId);
            consumidor = pedido.getConsumidor();
            emailConsumidor = consumidor.getEmail();
            nomeConsumidor = consumidor.getNome();
            // Delete consumer's registration request
            FacadeDAOs.deletePedido(pedido);
            if (!valida) {
                // Delete user if admin doesn't validate account
                Utilizador utilizador = FacadeDAOs.getUtilizador(consumidor.getEmail());
                result = FacadeDAOs.deleteUtilizador(utilizador);
            }
            else {
                criarCantinasVisiveisConsumidor(consumidor);
                // Create consumer's ID
                result = criarIdentificador(consumidor);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Send an email to the consumer with the response
        enviarEmail(emailConsumidor, nomeConsumidor, valida);
        return result;
    }

    @Override
    public boolean definirCantina(String nome, String localizacao, String descricao, List<RefeicaoInfo> refeicoesInfo, List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao) {
        boolean result = false;
        try {
            Cantina cantina = FacadeDAOs.createCantina();
            cantina.setNome(nome);
            cantina.setLocalizacao(localizacao);
            cantina.setDescricao(descricao);
            cantina.setAtivo(true);
            for (RefeicaoInfo refeicaoInfo : refeicoesInfo) {
                cantina.refeicoesInfo.add(refeicaoInfo);
            }
            definirTiposRefeicaoCantina(cantina, tiposRefeicao);
            result = FacadeDAOs.saveCantina(cantina);
            for (RefeicaoInfo refeicaoInfo : refeicoesInfo) {
                FacadeDAOs.saveRefeicaoInfo(refeicaoInfo);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> analiseDiaria() {
        Map<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> analise = new TreeMap<>(
                Comparator.comparingInt(Cantina::getId)
        );
        try {
            List<Cantina> cantinas = FacadeDAOs.listCantinas("Ativo=1", "id");
            for (Cantina cantina : cantinas) {
                Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>> refeicoes = getRefeicoesHojeCantina(cantina.getId());
                analise.put(cantina, refeicoes);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return analise;
    }

    // AUXILIAR: validarContaConsumidor()
    public void criarCantinasVisiveisConsumidor(Consumidor consumidor) {
        int posicao = 1;
        try {
            List<Cantina> cantinas = FacadeDAOs.listCantinas("Ativo=1","id");
            if (!cantinas.isEmpty()) {
                for (Cantina cantina : cantinas) {
                    CantinaVisivel cantinaVisivel = FacadeDAOs.createCantinaVisivel();
                    cantinaVisivel.setCantina(cantina);
                    cantinaVisivel.setConsumidor(consumidor);
                    cantinaVisivel.setPosicao(posicao);
                    cantinaVisivel.setVisivel(true);
                    FacadeDAOs.saveCantinaVisivel(cantinaVisivel);
                    posicao++;
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    /* CENAS PARA O QR CODE:
       https://www.callicoder.com/generate-qr-code-in-java-using-zxing/
       http://tutorials.jenkov.com/java-cryptography/keystore.html
    */
    // AUXILIAR: validarContaConsumidor()
    public boolean criarIdentificador(Consumidor consumidor) {
        boolean result = false;
        // Get secret key
        KeyStore keyStore = Crypto.loadKeyStore("tickeat-pei-1920", "../../TickEat/backend/data/keystore.ks");
        SecretKey secretKey = Crypto.getSecretKey("62798789106115117129", keyStore, "MNBJFBFK");

        // Encrypt consumer email
        String encryptedText = Crypto.encrypt(secretKey, consumidor.getEmail());

        try {
            // Create QR Code
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(encryptedText, BarcodeFormat.QR_CODE, 500, 500);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();
            Blob identificador = new SerialBlob(pngData);

            // Save QR Code to filesystem
            //Path path = FileSystems.getDefault().getPath("../../TickEat/backend/qrcode.png");
            //MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

            consumidor.setAtivo(true);
            consumidor.setIdentificador(identificador);
            result = FacadeDAOs.saveConsumidor(consumidor);
        } catch (WriterException | IOException | SQLException | PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }

    // TODO: ENCRIPTAR PARTE DO LINK PARA SEGURANÇA?
    // AUXILIAR: validarContaConsumidor()
    public void enviarEmail(String emailConsumidor, String nomeConsumidor, boolean valida) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", "smtp.live.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tickeat@hotmail.com", "pei.1920");
            }
        };

        Session session = Session.getInstance(prop, auth);
        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress("tickeat@hotmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailConsumidor));
            msg.setSubject("[TICKEAT] REGISTO/REGISTRATION");

            String emailText;
            if (valida) {
                emailText = getEmailValidacao(emailConsumidor, nomeConsumidor);
            }
            else {
                emailText = getEmailInvalidacao(nomeConsumidor);
            }

            msg.setContent(emailText, "text/html; charset=UTF-8");
            msg.setSentDate(new Date());

            Transport.send(msg);

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getEmailValidacao(String emailConsumidor, String nomeConsumidor) throws UnsupportedEncodingException {
        String email = "<p>Caro(a) " + nomeConsumidor + ",</p>"+
                "<p>O seu pedido de registo na TickEat foi aceite com sucesso."+
                "&nbsp Para concluir este processo clique no seguinte <a href='http://localhost:3000/password?email=" + URLEncoder.encode(emailConsumidor, "UTF-8") +"'>endereço</a>.</p><br><hr><br>"+
                "<p>Dear " + nomeConsumidor + ",</p>"+
                "<p>Your registration request for TickEat was accepted."+
                "&nbsp To complete this process click on the following <a href='http://localhost:3000/password?email=" + URLEncoder.encode(emailConsumidor, "UTF-8") +"'>link</a>.</p><br><br>"+
                "<p>TickEat</p>";
        return email;
    }

    public String getEmailInvalidacao(String nomeConsumidor) {
        String email = "<p>Caro(a) " + nomeConsumidor + ",</p>"+
                "<p>O seu pedido de registo na TickEat foi recusado por incoerência nos dados fornecidos."+
                "&nbsp Para mais informações contactar: tickeat@hotmail.com</p><br><hr><br>"+
                "<p>Dear " + nomeConsumidor + ",</p>"+
                "<p>Your registration request for TickEat was denied due to inconsistency on the data provided."+
                "&nbsp For more information contact: tickeat@hotmail.com</p><br><br>"+
                "<p>TickEat</p>";
        return email;
    }

    // AUXILIAR: definirCantina()
    public void definirTiposRefeicaoCantina(Cantina cantina, List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao) {
        try {
            for (Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>> par : tiposRefeicao) {
                TipoRefeicao tipoRefeicao = par.getFst();
                for (Componente componente : par.getSnd().getFst()) {
                    tipoRefeicao.componentes.add(componente);
                }
                FacadeDAOs.saveTipoRefeicao(tipoRefeicao);
                definirPrecosTipoRefeicao(tipoRefeicao, par.getSnd().getSnd());
                cantina.tiposRefeicao.add(tipoRefeicao);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    // AUXILIAR: definirTiposRefeicaoCantina()
    public void definirPrecosTipoRefeicao(TipoRefeicao tipoRefeicao, List<Par<TipoConsumidor, Float>> precos) {
        try {
            for (Par<TipoConsumidor, Float> parPreco : precos) {
                Preco preco = FacadeDAOs.createPreco();
                preco.setTipoConsumidor(parPreco.getFst());
                preco.setTipoRefeicao(tipoRefeicao);
                preco.setValor(parPreco.getSnd());
                FacadeDAOs.savePreco(preco);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>> getRefeicoesHojeCantina(int cantinaId) {
        //String data = getData();
        String data = "2020-02-04";
        List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>> refeicoesDia = new ArrayList<>();

        try {
            List<Componente> componentes = FacadeDAOs.listComponentes(null, "id");
            List<Refeicao> refeicoes = FacadeDAOs.listRefeicoes("CantinaId='"+cantinaId+"' AND Data='"+data+"'", null);
            if (!refeicoes.isEmpty()) {
                for (Refeicao refeicao : refeicoes) {
                    if (getEstadoRefeicao(refeicao.getData(), refeicao.getRefeicaoInfo().getHoraInicio(), refeicao.getRefeicaoInfo().getHoraFim()).equals("japassou")) {
                        float lucro = getLucroRefeicao(refeicao.getId());
                        List<Avaliacao> avaliacoes = getAvaliacoesRefeicao(refeicao.getId());
                        int totalAvaliacoes = avaliacoes.size();
                        Map<Comentario, Integer> comentarios = getComentariosRefeicao(avaliacoes);
                        Par<Float, Map<Integer, Integer>> pontuacoes = getPontuacoesRefeicao(avaliacoes);
                        Map<Componente, List<Ementa>> ementas = getEmenta(refeicao, componentes);
                        refeicoesDia.add(new Par(refeicao, new Par(lucro, new Par(totalAvaliacoes, new Par(pontuacoes.getFst(), new Par(comentarios, new Par(pontuacoes.getSnd(), ementas)))))));
                    }
                }
            }

        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return new Par(data, refeicoesDia);
    }



    // AUXILIAR:
    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public String getEstadoRefeicao(String dateRefeicao, String horaInicio, String horaFim) {
        String result;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterHour= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatterHour.format(date).split(" ")[0];
        String horaAtual = formatterHour.format(date).split(" ")[1];
        Date dataAtual = null;
        Date dataRefeicao = null;
        try {
            dataAtual = formatter.parse(data);
            dataRefeicao = formatter.parse(dateRefeicao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dataRefeicao.before(dataAtual))
            result = "japassou";
        else if (dataRefeicao.equals(dataAtual))
            result = compareTime(horaAtual, horaInicio, horaFim);
        else
            result = "naopassou";
        return result;
    }

    // AUXILIAR: getEstadoRefeicao()
    public String compareTime(String horaAtual, String horaInicio, String horaFim) {
        String result;
        String[] parts = horaAtual.split(":");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaInicio.split(":");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal2.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        parts = horaFim.split(":");
        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
        cal3.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
        cal3.set(Calendar.SECOND, Integer.parseInt(parts[2]));

        if (cal1.equals(cal3) || cal1.after(cal3)) {
            result = "japassou";
        }
        else if (cal1.before(cal2)) {
            result = "naopassou";
        }
        else {
            result = "adecorrer";
        }
        return result;
    }

    public float getLucroRefeicao(int refeicaoId) {
        float lucro = 0;
        try {
            List<Despesa> despesas = FacadeDAOs.listDespesas("RefeicaoId='"+refeicaoId+"'", null);
            if (!despesas.isEmpty()) {
                for (Despesa despesa : despesas) {
                    lucro += despesa.getValor();
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return lucro;
    }

    public List<Avaliacao> getAvaliacoesRefeicao(int refeicaoId) {
        List<Avaliacao> avaliacoes = null;
        try {
            avaliacoes = FacadeDAOs.listAvaliacoes("RefeicaoId='"+refeicaoId+"'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return avaliacoes;
    }

    public Map<Comentario, Integer> getComentariosRefeicao(List<Avaliacao> avaliacoes) {
        Map<Comentario, Integer> comentarios = new HashMap<>();

        if (!avaliacoes.isEmpty()) {
            for (Avaliacao avaliacao : avaliacoes) {
                if (!avaliacao.comentarios.isEmpty()) {
                    for (Comentario comentario : avaliacao.comentarios.toArray("id")) {
                        if (comentarios.containsKey(comentario)) {
                            comentarios.put(comentario, comentarios.get(comentario)+1);
                        }
                        else {
                            comentarios.put(comentario, 1);
                        }
                    }
                }
            }
        }

        return comentarios;
    }

    public Par<Float, Map<Integer, Integer>> getPontuacoesRefeicao(List<Avaliacao> avaliacoes) {
        Map<Integer, Integer> pontuacoes = new HashMap<>();
        float pontuacaoMedia = 0;

        if (!avaliacoes.isEmpty()) {
            for (Avaliacao avaliacao : avaliacoes) {
                int pontuacao = avaliacao.getPontuacao();
                if (pontuacoes.containsKey(pontuacao)) {
                    pontuacoes.put(pontuacao, pontuacoes.get(pontuacao) + 1);
                }
                else {
                    pontuacoes.put(pontuacao, 1);
                }
                pontuacaoMedia += pontuacao;
            }
            pontuacaoMedia = pontuacaoMedia/avaliacoes.size();
        }

        return new Par(pontuacaoMedia, pontuacoes);
    }

    public Map<Componente,List<Ementa>> getEmenta(Refeicao refeicao, List<Componente> componentes) {
        Map<Componente, List<Ementa>> componenteEmentas = new TreeMap<>(
                Comparator.comparingInt(Componente::getId)
        );

        Ementa[] ementas = refeicao.ementas.toArray("id");

        for (Componente componente : componentes) {
            List<Ementa> ementasComponenteRefeicao = new ArrayList<>();
            if (!componente.ementas.isEmpty()) {
                List<Ementa> ementasComponente = Arrays.asList(componente.ementas.toArray("id"));
                for (Ementa ementa : ementas) {
                    if (ementasComponente.contains(ementa)) {
                        ementasComponenteRefeicao.add(ementa);
                    }
                }
            }
            componenteEmentas.put(componente, ementasComponenteRefeicao);
        }
        return componenteEmentas;
    }
}