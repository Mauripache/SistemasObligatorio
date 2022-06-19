package Planificador;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

import Recursos.Pedido;
import Recursos.Repartidores;

public class HRRNQueue {

    private final PriorityQueue<Pedido> queue = new PriorityQueue<>((c1, c2) -> (c1.getDistanciaDeRepartidores()).compareTo(c2.getDistanciaDeRepartidores()));
    private final Semaphore mutex = new Semaphore(1);

    public void push(Pedido pedido) throws InterruptedException 
    {
        mutex.acquire();
        //ver en que posicion de la lista lo pongo
        pedido.setDistanciaDeRepartidores(Repartidores.getInstance().promedioDistancia(pedido));
        queue.add(pedido);
        mutex.release();
    }

    public Pedido pop() throws InterruptedException 
    {
        mutex.acquire();
        Pedido pedido = queue.poll();
        mutex.release();
        return pedido;
    }

    public boolean isEmpty() throws InterruptedException 
    {
        mutex.acquire();
        boolean isEmpty = queue.isEmpty();
        mutex.release();
        return isEmpty;
    }


}
