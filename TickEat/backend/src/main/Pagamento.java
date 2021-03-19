package main;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class Pagamento implements Runnable {
    private Consumidor consumidor;
    private Carregamento carregamento;
    private long time;
    private List<Consumidor> queueConsumidor;
    private List<Par<String, Carregamento>> queueCarregamento;

    public Pagamento(Consumidor consumidor, Carregamento carregamento, long time, List<Consumidor> queueConsumidor, List<Par<String, Carregamento>> queueCarregamento) {
        this.consumidor = consumidor;
        this.carregamento = carregamento;
        this.time = time;
        this.queueConsumidor = queueConsumidor;
        this.queueCarregamento = queueCarregamento;
    }

    @Override
    public void run() {
        while (System.currentTimeMillis() < time + 10000) { // TODO: 30*60*1000 -> 30 min.
            // Check if consumer made the payment
        }
        Random r = new Random();
        int pagou = r.nextInt(2);
        if (pagou == 0) {
            eliminarCarregamento();
        }
        else {
            efetuarCarregamento();
        }
    }

    public void eliminarCarregamento() {
        consumidor.movimentos.remove(carregamento);
        queueConsumidor.add(consumidor);
        queueCarregamento.add(new Par("delete", carregamento));
        /*try {
            FacadeDAOs.saveConsumidor(consumidor);
            FacadeDAOs.deleteCarregamento(carregamento);
        } catch (PersistentException e) {
            e.printStackTrace();
        }*/
    }

    public void efetuarCarregamento() {
        float valor = carregamento.getValor();
        float saldoContabilistico = consumidor.getSaldoContabilistico()+valor;
        consumidor.setSaldoContabilistico(saldoContabilistico);
        consumidor.setSaldoDisponivel(consumidor.getSaldoDisponivel()+valor);
        carregamento.setTimestamp(getTimestamp());
        carregamento.setSaldoResultante(saldoContabilistico);
        carregamento.setEfetuado(true);
        Blob fatura = Fatura.createFatura(consumidor.getNome(), consumidor.getContribuinte(), getData(), valor, "../../TickEat/backend/faturas/"+consumidor.getEmail()+"_"+carregamento.getId()+".pdf");
        carregamento.setFatura(fatura);
        queueConsumidor.add(consumidor);
        queueCarregamento.add(new Par("save", carregamento));
        /*try {
            FacadeDAOs.saveCarregamento(carregamento);
            FacadeDAOs.saveConsumidor(consumidor);
        } catch (PersistentException e) {
            e.printStackTrace();
        }*/
    }

    public String getTimestamp() {
        SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String timestamp = formatterHour.format(date);
        return timestamp;
    }

    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String data = formatter.format(date);
        return data;
    }
}
