package Hilos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import static Planificador.MLQ.MLQ;
import Recursos.Locales;
import Recursos.Pedido;
import Recursos.Repartidores;
import Util.Reportador;

public class Clock extends Thread{
    private static Clock instance;
    private int numeroHilos;
    public Semaphore semClock;
    public boolean tiempoActivo = true;
    

    public int counter;
    private HashMap<Integer, LinkedList<Pedido>> pedidosAInsertar = new HashMap<>();

    public static Clock getInstance() {
        return instance;
    }

    
    public void run() {
        try {
            //Espera a que termine un tick de cada hilo
            semClock.acquire(numeroHilos);
            while (tiempoActivo) {
                counter++;
                //Agregar envejecimiento a HRRN
                MLQ.queues.forEach( queue -> {
                    queue.queue.forEach( pedido -> 
                        pedido.setDistanciaDeRepartidores(pedido.getDistanciaDeRepartidores() + 1)
                    );
                });
                
                //Tomar pedidos a insertar en este momento y mandarlo a respectivos  locales
                LinkedList<Pedido> momentoPedidos = pedidosAInsertar.get(counter);
                if (momentoPedidos != null) {
                    momentoPedidos.forEach( pedido -> {
                        Locales.getInstance().insertarPedido(pedido);
                    });
                }
                pedidosAInsertar.remove(counter);

                //Liberar todos los hilos
                Repartidores.getInstance().releaseAll();
                Locales.getInstance().releaseAll();

                //Espera a que termine un tick de cada hilo
                semClock.acquire(numeroHilos);

                tiempoActivo = !pedidosAInsertar.isEmpty() || Locales.getInstance().localesTrabajando() || !MLQ.isEmpty() || Repartidores.getInstance().repartidoresTrabajando();
                if (!tiempoActivo) {
                    Reportador.getInstance().generarReportes();
                    System.exit(0);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Clock(int numeroHilos, HashMap<Integer, LinkedList<Pedido>> pedidosAInsertar) {
        instance = this;
        this.pedidosAInsertar = pedidosAInsertar;
        this.numeroHilos = numeroHilos;
        this.semClock = new Semaphore(numeroHilos);
    }
}