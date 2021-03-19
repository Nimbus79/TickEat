package main;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TerminarRefeicao implements Runnable {
    private Refeicao refeicao;
    private List<Refeicao> queueRefeicao;

    public TerminarRefeicao(Refeicao refeicao, List<Refeicao> queueRefeicao) {
        this.refeicao = refeicao;
        this.queueRefeicao = queueRefeicao;
    }

    @Override
    public void run() {
        long fim = getHoraFim();
        while (System.currentTimeMillis() < fim);
        refeicao.setaDecorrer(false);
        queueRefeicao.add(refeicao);
        /*try {
            FacadeDAOs.saveRefeicao(refeicao);
        } catch (PersistentException e) {
            e.printStackTrace();
        }*/
    }

    public long getHoraFim() {
        String dataHora = refeicao.getData() + " " + refeicao.getRefeicaoInfo().getHoraFim() + ".000";
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(dataHora);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return timestamp.getTime();
    }
}