package Hilos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import Recursos.Locales;
import Recursos.Pedido;
import Recursos.Repartidores;

public class Clock extends Thread{
    private static Clock instance;
    private int numeroHilos;
    public Semaphore semClock;
    public int counter;
    private HashMap<Integer, LinkedList<Pedido>> pedidosAInsertar = new HashMap<>();

    public static Clock getInstance() {
        return instance;
    }

    public void run() {
        try {
            while (true) {
                //Espera a que termine un tick de cada hilo
                semClock.acquire(numeroHilos);
                counter++;
                //System.out.println("Hola soy el Cock " + counter);
                
                //Tomar pedidos a insertar en este momento y mandarlo a respectivos  locales
                LinkedList<Pedido> momentoPedidos = pedidosAInsertar.get(counter);
                if (momentoPedidos != null) {
                    momentoPedidos.forEach( pedido -> {
                        Locales.getInstance().insertarPedido(pedido);
                    });
                }

                //Liberar todos los hilos
                Repartidores.getInstance().releaseAll();
                Locales.getInstance().releaseAll();
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