package Planificador;

import Recursos.Pedido;
import java.util.ArrayList;

public class MLQ
{
    public final static MLQ MLQ = new MLQ();

    private  HRRNQueue pedidosDeFarmacia = new HRRNQueue();
    private  HRRNQueue nuevosClientes = new HRRNQueue();
    private  HRRNQueue clientesHabituales = new HRRNQueue();
    private  HRRNQueue pedidosProgramados = new HRRNQueue();
    public  ArrayList<HRRNQueue> queues = new ArrayList<>();

    public MLQ()
    {
        queues.add(pedidosDeFarmacia);
        queues.add(nuevosClientes);
        queues.add(clientesHabituales);
        queues.add(pedidosProgramados);
    }

    public boolean isEmpty() throws InterruptedException {
        return pedidosDeFarmacia.isEmpty() && nuevosClientes.isEmpty() && clientesHabituales.isEmpty() && pedidosProgramados.isEmpty();
    }

    public void insertar(Pedido pedido) throws InterruptedException {
        switch (pedido.getTipo()) {
            case "farmacia":
                this.pedidosDeFarmacia.push(pedido);
                break;
            case "nuevo":
                this.nuevosClientes.push(pedido);
                break;
            case "habitual":
                this.clientesHabituales.push(pedido);
                break;
            case "programado":
                this.pedidosProgramados.push(pedido);
                break;
        }
    }

    public Pedido proximaSolicitud() throws InterruptedException{
        for (HRRNQueue queue : queues) {
            Pedido pedido = queue.pop();
            if (pedido != null) {
                return pedido;
            }
        }
        return null;
    }
}
