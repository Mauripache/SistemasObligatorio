package Hilos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import static Planificador.MLQ.MLQ;
import Recursos.Pedido;

public class Local extends Thread {

    public Semaphore semLocal = new Semaphore(0);
    public LinkedList<Pedido> pedidosEnPreparacion = new LinkedList<>();
    private int ubicacion;
    private HashMap<String, Integer> articulosDisponibles = new HashMap<>();
    private int tiempoTotal = 0;

    public Local(int ubicacion, String[] articulos, String[] tiempoPreparacion) {
        this.ubicacion = ubicacion;
        for(int i = 0; i < articulos.length; i++) {
            articulosDisponibles.putIfAbsent(articulos[i], Integer.parseInt(tiempoPreparacion[i]));
        }
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void insertarPedido(Pedido pedido) {
        this.tiempoTotal = 0;
        pedido.getPedido().forEach( articulo -> {
            tiempoTotal += articulosDisponibles.get(articulo);
        });
        pedido.setTiempoPreparacion(tiempoTotal);
        pedidosEnPreparacion.add(pedido);
    }

    public void run() {
        while (Clock.getInstance().tiempoActivo) {
            try {
                semLocal.acquire();
                
                LinkedList<Pedido> pedidosPreparados = new LinkedList<Pedido>();
                pedidosEnPreparacion.forEach( pedido -> {
                    pedido.setTiempoPreparacion(pedido.getTiempoPreparacion() - 1);
                    if (pedido.getTiempoPreparacion() == 0){
                        try {
                            pedido.setDireccionRetiro(ubicacion);
                            pedido.setTiempoListo(Clock.getInstance().counter);
                            MLQ.insertar(pedido);
                            pedidosPreparados.add(pedido);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                pedidosEnPreparacion.removeAll(pedidosPreparados);

                Clock.getInstance().semClock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}