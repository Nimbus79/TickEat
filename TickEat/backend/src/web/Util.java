package web;

import main.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.orm.PersistentException;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.sql.Blob;
import java.sql.Ref;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Util {

    public static String hash(String original) {
        String res = original;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(original.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            res = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static JSONObject parseBody (BufferedReader reader) {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject(jb.toString());
    }

    public static JSONArray parseCalendario(Map<CantinaVisivel, List<Par<String, Refeicao>>> calendario) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<CantinaVisivel, List<Par<String, Refeicao>>> entry : calendario.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("nome", entry.getKey().getCantina().getNome());
            obj.put("refeicoes", parseRefeicoesList(entry.getValue(), entry.getKey().getCantina().getId()));
            arr.put(obj);
        }
        return arr;
    }

    public static JSONArray parseRefeicoesList(List<Par<String,Refeicao>> refeicoes, int cantinaId) {
        JSONArray arr = new JSONArray();

        if (refeicoes != null) {
            for (Par<String,Refeicao> parRefeicao : refeicoes) {
                Refeicao refeicao = parRefeicao.getSnd();
                JSONObject obj = new JSONObject();
                obj.put("cantinaId", cantinaId);
                obj.put("id", refeicao.getId());
                obj.put("start", refeicao.getData());
                obj.put("end", refeicao.getData());
                obj.put("title", refeicao.getRefeicaoInfo().getNome());
                obj.put("class", parRefeicao.getFst());
                arr.put(obj);
            }
        }

        return arr;
    }

    public static JSONArray parsePedidosList(List<Pedido> pedidos) {
        JSONArray arr = new JSONArray();

        for (Pedido pedido : pedidos) {
            JSONObject obj = new JSONObject();
            obj.put("id", pedido.getId());
            obj.put("consumidorEmail", pedido.getConsumidor().getEmail());
            obj.put("tipoConsumidor", pedido.getConsumidor().getTipoConsumidor().getNome());
            arr.put(obj);
        }
        return arr;
    }

    public static JSONObject parseRefeicaoReservada(Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Par<Boolean, Par<Float, Par<Map<Componente, Ementa>, Map<Componente, List<Ementa>>>>>>>>> refeicaoReservada) {
        Cantina cantina = refeicaoReservada.getFst();
        Refeicao refeicao = refeicaoReservada.getSnd().getFst();
        String diaDaSemana = refeicaoReservada.getSnd().getSnd().getFst();
        boolean passou = refeicaoReservada.getSnd().getSnd().getSnd().getFst();
        boolean avaliada = refeicaoReservada.getSnd().getSnd().getSnd().getSnd().getFst();
        float preco = refeicaoReservada.getSnd().getSnd().getSnd().getSnd().getSnd().getFst();
        Map<Componente,Ementa> ementaSelecionada = refeicaoReservada.getSnd().getSnd().getSnd().getSnd().getSnd().getSnd().getFst();
        Map<Componente,List<Ementa>> ementa = refeicaoReservada.getSnd().getSnd().getSnd().getSnd().getSnd().getSnd().getSnd();

        JSONObject obj = new JSONObject();

        obj.put("reservada", true);
        obj.put("passou", passou);
        obj.put("avaliada", avaliada);
        obj.put("cantinaId", cantina.getId());
        obj.put("cantinaNome", cantina.getNome());
        obj.put("refeicaoId", refeicao.getId());
        obj.put("refeicaoNome", refeicao.getRefeicaoInfo().getNome());
        obj.put("diaDaSemana", diaDaSemana);
        obj.put("data", refeicao.getData());
        obj.put("contagemValidados", refeicao.getContagemValidados());
        obj.put("previsaoGeral", refeicao.getPrevisaoGeral());
        obj.put("preco", preco);
        obj.put("aDecorrer", refeicao.getaDecorrer());
        obj.put("ementaSelecionada", parseEmentaSelecionada(ementaSelecionada));
        obj.put("ementa", parseEmenta(ementa));

        return obj;
    }

    public static JSONArray parseEmentaSelecionada(Map<Componente,Ementa> ementaSelecionada) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Componente,Ementa> entry : ementaSelecionada.entrySet()) {
            Componente componente = entry.getKey();
            Ementa ementa = entry.getValue();
            JSONObject obj = new JSONObject();
            obj.put("componenteId", componente.getId());
            obj.put("componenteNome", componente.getNome());
            obj.put("ementaId", ementa.getId());
            obj.put("ementaTipo", ementa.getTipo());
            obj.put("comida", ementa.getComida());
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseEmenta(Map<Componente,List<Ementa>> ementa) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Componente,List<Ementa>> entry : ementa.entrySet()) {
            Componente componente = entry.getKey();
            JSONObject obj = new JSONObject();
            obj.put("componenteId", componente.getId());
            obj.put("componenteNome", componente.getNome());
            obj.put("ementas", parseEmentasList(entry.getValue()));
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseEmentasList(List<Ementa> ementas) {
        JSONArray arr = new JSONArray();

        if (ementas != null) {
            for (Ementa ementa : ementas) {
                TabelaNutricional tabelaNutricional = ementa.getTabelaNutricional();
                JSONObject obj = new JSONObject();
                obj.put("ementaId", ementa.getId());
                obj.put("ementaTipo", ementa.getTipo());
                obj.put("comida", ementa.getComida());
                if (tabelaNutricional != null) {
                    obj.put("energia", tabelaNutricional.getEnergia());
                    obj.put("lipidos", tabelaNutricional.getLipidos());
                    obj.put("saturados", tabelaNutricional.getSaturados());
                    obj.put("hidratos", tabelaNutricional.getHidratos());
                    obj.put("acucar", tabelaNutricional.getAcucar());
                    obj.put("fibra", tabelaNutricional.getFibra());
                    obj.put("proteinas", tabelaNutricional.getProteinas());
                    obj.put("sal", tabelaNutricional.getSal());
                }
                arr.put(obj);
            }
        }

        return arr;
    }

    public static JSONObject parseRefeicaoNaoReservada(Par<Cantina, Par<Refeicao, Par<String, Par<Boolean, Map<Componente, List<Ementa>>>>>> refeicaoNaoReservada) {
        Cantina cantina = refeicaoNaoReservada.getFst();
        Refeicao refeicao = refeicaoNaoReservada.getSnd().getFst();
        String diaDaSemana = refeicaoNaoReservada.getSnd().getSnd().getFst();
        boolean passou = refeicaoNaoReservada.getSnd().getSnd().getSnd().getFst();
        Map<Componente,List<Ementa>> ementa = refeicaoNaoReservada.getSnd().getSnd().getSnd().getSnd();

        JSONObject obj = new JSONObject();

        obj.put("reservada", false);
        obj.put("passou", passou);
        obj.put("cantinaId", cantina.getId());
        obj.put("cantinaNome", cantina.getNome());
        obj.put("refeicaoId", refeicao.getId());
        obj.put("refeicaoNome", refeicao.getRefeicaoInfo().getNome());
        obj.put("diaDaSemana", diaDaSemana);
        obj.put("data", refeicao.getData());
        obj.put("contagemValidados", refeicao.getContagemValidados());
        obj.put("previsaoGeral", refeicao.getPrevisaoGeral());
        obj.put("aDecorrer", refeicao.getaDecorrer());
        obj.put("ementa", parseEmenta(ementa));

        return obj;
    }

    public static JSONObject parseMenuRefeicao(Par<String, Par<Refeicao, Par<String, Map<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>>>>> menuRefeicao) {
        JSONObject obj = new JSONObject();

        obj.put("cantinaNome", menuRefeicao.getFst());
        obj.put("refeicaoNome", menuRefeicao.getSnd().getFst().getRefeicaoInfo().getNome());
        obj.put("diaDaSemana", menuRefeicao.getSnd().getSnd().getFst());
        obj.put("data", menuRefeicao.getSnd().getFst().getData());
        obj.put("tiposRefeicao", parseTiposRefeicao(menuRefeicao.getSnd().getSnd().getSnd()));

        return obj;
    }

    public static JSONArray parseTiposRefeicao(Map<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>> tiposRefeicao) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<TipoRefeicao, Par<Float, Map<Componente, List<Ementa>>>> tipoRefeicao : tiposRefeicao.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("tipoRefeicaoId", tipoRefeicao.getKey().getId());
            obj.put("tipoRefeicaoNome", tipoRefeicao.getKey().getNome());
            obj.put("preco", tipoRefeicao.getValue().getFst());
            obj.put("ementa", parseEmenta(tipoRefeicao.getValue().getSnd()));
            arr.put(obj);
        }

        return arr;
    }

    public static List<Integer> parseEmentasArray(JSONArray ementas) {
        List<Integer> ementasId = new ArrayList<>();

        for (int i = 0; i < ementas.length(); i++) {
            ementasId.add((Integer) ementas.get(i));
        }

        return ementasId;
    }

    public static List<Integer> parseComentariosArray(JSONArray comentarios) {
        List<Integer> comentariosId = new ArrayList<>();

        for (int i = 0; i < comentarios.length(); i++) {
            comentariosId.add((Integer) comentarios.get(i));
        }

        return comentariosId;
    }

    public static JSONObject parseCarteira(Par<Float, Float> saldos, List<Par<Cantina, Movimento>> movimentos) {
        float saldoContabilistico = saldos.getFst();
        float saldoDisponivel = saldos.getSnd();

        JSONObject obj = new JSONObject();

        obj.put("saldoContabilistico", saldoContabilistico);
        obj.put("saldoDisponivel", saldoDisponivel);
        obj.put("movimentos", parseMovimentosList(movimentos));

        return obj;
    }

    public static JSONArray parseMovimentosList(List<Par<Cantina, Movimento>> movimentos) {
        JSONArray arr = new JSONArray();

        if (movimentos != null) {
            for (Par<Cantina, Movimento> par : movimentos) {
                Cantina cantina = par.getFst();
                Movimento movimento = par.getSnd();
                JSONObject obj = new JSONObject();

                obj.put("id", movimento.getId());
                obj.put("valor", movimento.getValor());
                obj.put("timestamp", movimento.getTimestamp());
                obj.put("efetuado", movimento.getEfetuado());
                obj.put("nome", movimento.getNome());
                obj.put("saldoResultante", movimento.getSaldoResultante());
                obj.put("evento", parseMovimento(cantina, movimento));

                arr.put(obj);
            }
        }

        return arr;
    }

    public static JSONObject parseMovimento(Cantina cantina, Movimento movimento) {
        JSONObject obj = null;

        try {
            if (cantina != null) {
                Despesa despesa = FacadeDAOs.getDespesa(movimento.getId());
                obj = parseDespesa(cantina, despesa);
            }
            else {
                Carregamento carregamento = FacadeDAOs.getCarregamento(movimento.getId());
                obj = parseCarregamento(carregamento);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static JSONObject parseCarregamento(Carregamento carregamento) {
        JSONObject obj = new JSONObject();

        obj.put("referencia", carregamento.getReferencia());
        obj.put("entidade", carregamento.getEntidade());
        obj.put("validade", carregamento.getValidade());
        Blob blob = carregamento.getFatura();
        try {
            if (blob != null) {
                File file = Fatura.blobToFile(blob, "../../TickEat/backend/faturas/fatura" + carregamento.getId() + ".pdf");
                byte[] bytes = Files.readAllBytes(file.toPath());
                obj.put("fatura", DatatypeConverter.printBase64Binary(bytes));
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        obj.put("metodo", carregamento.getMetodo());

        return obj;
    }

    public static JSONObject parseDespesa(Cantina cantina, Despesa despesa) {
        JSONObject obj = new JSONObject();
        Refeicao refeicao = despesa.getRefeicao();

        obj.put("descricao", despesa.getDescricao());

        JSONObject object = new JSONObject();
        object.put("refeicaoId", refeicao.getId());
        object.put("refeicaoNome", refeicao.getRefeicaoInfo().getNome());
        object.put("cantinaId", cantina.getId());
        object.put("cantinaNome", cantina.getNome());
        object.put("data", refeicao.getData());

        obj.put("refeicao", object);

        return obj;
    }

    public static JSONObject parseNotificacoesList(List<Notificacao> notificacoes) {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        int naoVistas = 0;

        for (Notificacao notificacao : notificacoes) {
            if (!notificacao.getVista()) {
                naoVistas++;
            }
            arr.put(parseNotificacao(notificacao));
        }
        obj.put("naoVistas", naoVistas);
        obj.put("notificacoesList", arr);

        return obj;
    }

    public static JSONObject parseNotificacao(Notificacao notificacao) {
        JSONObject obj = new JSONObject();

        obj.put("id", notificacao.getId());
        obj.put("nome", notificacao.getNome());
        obj.put("descricao", notificacao.getDescricao());
        obj.put("timestamp", notificacao.getTimestamp());
        obj.put("vista", notificacao.getVista());

        return obj;
    }

    public static JSONObject parsePerfil(Par<Consumidor, List<CantinaVisivel>> perfil) {
        Consumidor consumidor = perfil.getFst();
        List<CantinaVisivel> cantinasVisiveis = perfil.getSnd();

        JSONObject obj = new JSONObject();

        obj.put("email", consumidor.getEmail());
        obj.put("nome", consumidor.getNome());
        obj.put("contribuinte", consumidor.getContribuinte());
        obj.put("tipoConsumidor", consumidor.getTipoConsumidor().getNome());
        Blob blob = consumidor.getFotografia();
        if (blob != null) {
            obj.put("fotografia", blobToImage(blob));
        }
        blob = consumidor.getIdentificador();
        if (blob != null) {
            obj.put("identificador", blobToImage(blob));
        }
        obj.put("cantinasVisiveis", parseCantinasVisiveisList(cantinasVisiveis, "consultar"));

        return obj;
    }

    public static String blobToImage(Blob blob) {
        String imageByteArrayInString = "";
        try {
            ByteArrayInputStream imageInputStream = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()));
            ByteArrayOutputStream byteArrayImageOutputStream = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(imageInputStream), "png", byteArrayImageOutputStream);
            byteArrayImageOutputStream.flush();
            imageByteArrayInString = DatatypeConverter.printBase64Binary(byteArrayImageOutputStream.toByteArray());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return imageByteArrayInString;
    }

    public static Blob stringToBlob(String image) {
        byte[] decodedByte = Base64.getDecoder().decode(image);
        Blob blob = null;
        try {
            blob = new SerialBlob(decodedByte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blob;
    }

    public static JSONArray parseCantinasVisiveisList(List<CantinaVisivel> cantinasVisiveis, String tipo) {
        JSONArray arr = new JSONArray();

        if (cantinasVisiveis != null) {
            for (CantinaVisivel cantinaVisivel : cantinasVisiveis) {
                JSONObject obj = new JSONObject();

                obj.put("cantinaNome", cantinaVisivel.getCantina().getNome());
                obj.put("posicao", cantinaVisivel.getPosicao());

                if (tipo.equals("editar")) {
                    obj.put("cantinaVisivelId", cantinaVisivel.getId());
                    obj.put("visivel", cantinaVisivel.getVisivel());
                }

                arr.put(obj);
            }
        }

        return arr;
    }

    public static List<Par<Integer,Par<Integer, Boolean>>> parseCantinasVisiveisArray(JSONArray cantinasVisiveisArray) {
        List<Par<Integer,Par<Integer, Boolean>>> cantinasVisiveis = new ArrayList<>();

        for (int i = 0; i < cantinasVisiveisArray.length(); i++) {
            JSONObject obj = cantinasVisiveisArray.getJSONObject(i);

            int cantinaVisivelId = (Integer) obj.get("cantinaVisivelId");
            int posicao = (Integer) obj.get("posicao");
            boolean visivel = (Boolean) obj.get("visivel");

            cantinasVisiveis.add(new Par(cantinaVisivelId, new Par(posicao, visivel)));
        }
        return cantinasVisiveis;
    }

    public static JSONArray parsePaginaInicialConsumidor(List<Par<Cantina, Refeicao>> previsoes) {
        JSONArray arr = new JSONArray();

        for (Par<Cantina, Refeicao> previsao : previsoes) {
            Refeicao refeicao = previsao.getSnd();
            JSONObject obj = new JSONObject();

            obj.put("cantinaNome", previsao.getFst().getNome());

            if (refeicao != null) {
                obj.put("refeicaoNome", refeicao.getRefeicaoInfo().getNome());
                obj.put("data", refeicao.getData());
                obj.put("aDecorrer", refeicao.getaDecorrer());
                obj.put("previsaoGeral", refeicao.getPrevisaoGeral());
                obj.put("contagemValidados", refeicao.getContagemValidados());
                if (refeicao.getaDecorrer()) {
                    obj.put("estadoFila", refeicao.getContagemEntrada()-refeicao.getContagemValidados());
                }
            }
            arr.put(obj);
        }

        return arr;
    }

    public static JSONObject parsePaginaInicialCozinheiro(Par<Cantina, Refeicao> estadoFila, Map<Componente,List<Ementa>> ementas) {
        Refeicao refeicao = estadoFila.getSnd();

        JSONObject obj = new JSONObject();

        obj.put("cantinaNome", estadoFila.getFst().getNome());

        if (refeicao != null) {
            RefeicaoInfo refeicaoInfo = refeicao.getRefeicaoInfo();
            obj.put("refeicaoId", refeicao.getId());
            obj.put("refeicaoNome", refeicaoInfo.getNome());
            obj.put("horaInicio", refeicaoInfo.getHoraInicio());
            obj.put("horaFim", refeicaoInfo.getHoraFim());
            obj.put("data", refeicao.getData());
            obj.put("aDecorrer", refeicao.getaDecorrer());
            if (refeicao.getaDecorrer()) {
                obj.put("estadoFila", refeicao.getContagemEntrada()-refeicao.getContagemValidados());
            }
            obj.put("ementa", parseEmentasPrevisoes(ementas));
        }

        return obj;
    }

    public static JSONArray parseEmentasPrevisoes(Map<Componente,List<Ementa>> ementas) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Componente,List<Ementa>> entry : ementas.entrySet()) {
            Componente componente = entry.getKey();
            JSONObject obj = new JSONObject();
            obj.put("componenteId", componente.getId());
            obj.put("componenteNome", componente.getNome());
            obj.put("ementas", parseEmentasPrevisoesList(entry.getValue()));
            arr.put(obj);
        }
        return arr;
    }

    public static JSONArray parseEmentasPrevisoesList(List<Ementa> ementas) {
        JSONArray arr = new JSONArray();

        if (ementas != null) {
            for (Ementa ementa : ementas) {
                JSONObject obj = new JSONObject();
                obj.put("ementaId", ementa.getId());
                obj.put("ementaTipo", ementa.getTipo());
                obj.put("comida", ementa.getComida());
                obj.put("previsao", ementa.getPrevisao());
                obj.put("contagemValidados", ementa.getContagemValidados());
                arr.put(obj);
            }
        }

        return arr;
    }

    public static JSONArray parseCantinasAtivasList(List<Cantina> cantinas) {
        JSONArray arr = new JSONArray();

        for (Cantina cantina : cantinas) {
            JSONObject obj = new JSONObject();
            obj.put("cantinaNome", cantina.getNome());
            obj.put("localizacao", cantina.getLocalizacao());
            obj.put("descricao", cantina.getDescricao());
            obj.put("refeicoesInfo", parseRefeicoesInfoList(cantina));
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseRefeicoesInfoList(Cantina cantina) {
        JSONArray arr = new JSONArray();

        if (!cantina.refeicoesInfo.isEmpty()) {
            RefeicaoInfo[] refeicoesInfo = cantina.refeicoesInfo.toArray("id");
            for (RefeicaoInfo refeicaoInfo : refeicoesInfo) {
                if (refeicaoInfo.getAtivo()) {
                    JSONObject obj = new JSONObject();
                    obj.put("refeicaoNome", refeicaoInfo.getNome());
                    obj.put("horaInicio", refeicaoInfo.getHoraInicio());
                    obj.put("horaFim", refeicaoInfo.getHoraFim());
                    obj.put("horaLimite", refeicaoInfo.getHoraLimite());
                    obj.put("desconto", refeicaoInfo.getDesconto());
                    obj.put("taxaCancelamento", refeicaoInfo.getTaxaCancelamento());
                    obj.put("segunda", refeicaoInfo.getSegunda());
                    obj.put("terca", refeicaoInfo.getTerca());
                    obj.put("quarta", refeicaoInfo.getQuarta());
                    obj.put("quinta", refeicaoInfo.getQuinta());
                    obj.put("sexta", refeicaoInfo.getSexta());
                    obj.put("sabado", refeicaoInfo.getSabado());
                    obj.put("domingo", refeicaoInfo.getDomingo());
                    arr.put(obj);
                }
            }
        }

        return arr;
    }

    public static List<RefeicaoInfo> parseRefeicoesInfoArray(JSONArray refeicoesInfoArray) {
        List<RefeicaoInfo> refeicoesInfo = new ArrayList<>();

        for (int i = 0; i < refeicoesInfoArray.length(); i++) {
            JSONObject obj = refeicoesInfoArray.getJSONObject(i);
            RefeicaoInfo refeicaoInfo = FacadeDAOs.createRefeicaoInfo();
            refeicaoInfo.setNome((String) obj.get("nome"));
            refeicaoInfo.setHoraInicio(obj.get("horaInicio") + ":00");
            refeicaoInfo.setHoraFim(obj.get("horaFim") + ":00");
            refeicaoInfo.setHoraLimite(obj.get("horaLimite") + ":00");
            refeicaoInfo.setDesconto(Float.parseFloat((String) obj.get("desconto")));
            refeicaoInfo.setTaxaCancelamento(Float.parseFloat((String) obj.get("taxaCancelamento")));
            refeicaoInfo.setAtivo(true);
            refeicaoInfo.setSegunda((Boolean) obj.get("segunda"));
            refeicaoInfo.setTerca((Boolean) obj.get("terca"));
            refeicaoInfo.setQuarta((Boolean) obj.get("quarta"));
            refeicaoInfo.setQuinta((Boolean) obj.get("quinta"));
            refeicaoInfo.setSexta((Boolean) obj.get("sexta"));
            refeicaoInfo.setSabado((Boolean) obj.get("sabado"));
            refeicaoInfo.setDomingo((Boolean) obj.get("domingo"));
            refeicoesInfo.add(refeicaoInfo);
        }

        return refeicoesInfo;
    }

    public static List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> parseTiposRefeicaoArray(JSONArray tiposRefeicaoArray, List<TipoConsumidor> tiposConsumidor) {
        List<Par<TipoRefeicao, Par<List<Componente>, List<Par<TipoConsumidor, Float>>>>> tiposRefeicao = new ArrayList<>();

        for (int i = 0; i < tiposRefeicaoArray.length(); i++) {
            JSONObject obj = tiposRefeicaoArray.getJSONObject(i);
            TipoRefeicao tipoRefeicao = FacadeDAOs.createTipoRefeicao();
            tipoRefeicao.setAtivo(true);
            tipoRefeicao.setNome((String) obj.get("nome"));
            List<Componente> componentes = parseComponentesArray(obj.getJSONArray("componentes"));
            List<Par<TipoConsumidor, Float>> precos = parsePrecosArray(obj.getJSONArray("precos"), tiposConsumidor);
            tiposRefeicao.add(new Par(tipoRefeicao, new Par(componentes, precos)));
        }

        return tiposRefeicao;
    }

    public static List<Componente> parseComponentesArray(JSONArray componentesArray) {
        List<Componente> componentes = new ArrayList<>();

        for (int i = 0; i < componentesArray.length(); i++) {
            try {
                Componente componente = FacadeDAOs.getComponente((Integer) componentesArray.get(i));
                componentes.add(componente);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }

        return componentes;
    }

    public static List<Par<TipoConsumidor, Float>> parsePrecosArray(JSONArray precosArray, List<TipoConsumidor> tiposConsumidor) {
        List<Par<TipoConsumidor, Float>> precos = new ArrayList<>();

        if (precosArray.length() > 0) {
            for (TipoConsumidor tipoConsumidor : tiposConsumidor) {
                precos.add(new Par(tipoConsumidor, Float.parseFloat((String) precosArray.get(tipoConsumidor.getId()))));
            }
        }

        return precos;
    }

    public static JSONObject parseInfo(List<Componente> componentes, List<TipoConsumidor> tiposConsumidor) {
        JSONObject obj = new JSONObject();

        obj.put("componentes", parseComponentesList(componentes));
        obj.put("tiposConsumidor", parseTiposConsumidorList(tiposConsumidor));

        return obj;
    }

    public static JSONArray parseComponentesList(List<Componente> componentes) {
        JSONArray arr = new JSONArray();

        for (Componente componente : componentes) {
            JSONObject obj = new JSONObject();

            obj.put("componenteId", componente.getId());
            obj.put("componenteNome", componente.getNome());

            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseTiposConsumidorList(List<TipoConsumidor> tiposConsumidor) {
        JSONArray arr = new JSONArray();

        for (TipoConsumidor tipoConsumidor : tiposConsumidor) {
            JSONObject obj = new JSONObject();

            obj.put("tipoConsumidorId", tipoConsumidor.getId());
            obj.put("tipoConsumidorNome", tipoConsumidor.getNome());

            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseCantinasList(List<Cantina> cantinas) {
        JSONArray arr = new JSONArray();

        for (Cantina cantina : cantinas) {
            JSONObject obj = new JSONObject();
            obj.put("id", cantina.getId());
            obj.put("nome", cantina.getNome());
            obj.put("localizacao", cantina.getLocalizacao());
            obj.put("descricao", cantina.getDescricao());
            obj.put("ativo", cantina.getAtivo());
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseAnaliseDiaria(Map<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> analise) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Cantina, Par<String, List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>>>> entry : analise.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("id", entry.getKey().getId());
            obj.put("nome", entry.getKey().getNome());
            obj.put("data", entry.getValue().getFst());
            obj.put("refeicoes", parseAnaliseRefeicoesList(entry.getValue().getSnd()));
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseAnaliseRefeicoesList(List<Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>>> refeicoes) {
        JSONArray arr = new JSONArray();

        for (Par<Refeicao, Par<Float, Par<Integer, Par<Float, Par<Map<Comentario, Integer>, Par<Map<Integer, Integer>, Map<Componente, List<Ementa>>>>>>>> par : refeicoes) {
            Refeicao refeicao = par.getFst();
            JSONObject obj = new JSONObject();
            obj.put("id", refeicao.getId());
            obj.put("nome", refeicao.getRefeicaoInfo().getNome());
            obj.put("previsaoGeral", refeicao.getPrevisaoGeral());
            obj.put("contagemValidados", refeicao.getContagemValidados());
            obj.put("lucro", par.getSnd().getFst());
            obj.put("totalAvaliacoes", par.getSnd().getSnd().getFst());
            obj.put("pontuacaoMedia", par.getSnd().getSnd().getSnd().getFst());
            obj.put("comentarios", parseComentariosMap(par.getSnd().getSnd().getSnd().getSnd().getFst()));
            obj.put("pontuacoes", parsePontuacoesMap(par.getSnd().getSnd().getSnd().getSnd().getSnd().getFst()));
            obj.put("ementas", parseEmentasMap(par.getSnd().getSnd().getSnd().getSnd().getSnd().getSnd()));
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseComentariosMap(Map<Comentario, Integer> comentarios) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Comentario, Integer> entry : comentarios.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("comentario", entry.getKey().getDescricao());
            obj.put("total", entry.getValue());
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parsePontuacoesMap(Map<Integer, Integer> pontuacoes) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Integer, Integer> entry : pontuacoes.entrySet()) {
            JSONObject obj = new JSONObject();
            obj.put("pontuacao", entry.getKey());
            obj.put("total", entry.getValue());
            arr.put(obj);
        }

        return arr;
    }

    public static JSONArray parseEmentasMap(Map<Componente, List<Ementa>> ementas) {
        JSONArray arr = new JSONArray();

        for (Map.Entry<Componente, List<Ementa>> entry : ementas.entrySet()) {
            for (Ementa ementa : entry.getValue()) {
                JSONObject obj = new JSONObject();
                obj.put("componenteId", entry.getKey().getId());
                obj.put("componenteNome", entry.getKey().getNome());
                obj.put("tipo", ementa.getTipo());
                obj.put("comida", ementa.getComida());
                obj.put("previsao", ementa.getPrevisao());
                obj.put("contagemValidados", ementa.getContagemValidados());
                arr.put(obj);
            }
        }

        return arr;
    }
}