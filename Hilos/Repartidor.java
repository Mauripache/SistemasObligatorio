package Hilos;

import java.util.concurrent.Semaphore;

import Planificador.MLQ;
import Recursos.Pedido;

public class Repartidor extends Thread {

    public Semaphore semRepartidor = new Semaphore(0);
    int ubicacion;
    String nombre;
    boolean pedidoRecogido = false;
    Pedido pedidoAEntregar = null;

    public Repartidor(int ubicacion, String nombre) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semRepartidor.acquire();

                if (pedidoAEntregar == null) {
                    this.pedidoAEntregar = MLQ.MLQ.proximaSolicitud();
                } else {
                    if (!pedidoRecogido) {
                        if (ubicacion > pedidoAEntregar.getDireccionRetiro()) {
                            ubicacion--;
                        } else if (ubicacion < pedidoAEntregar.getDireccionRetiro()) {
                            ubicacion++;
                        } else {
                            //llegué a dirección de retiro
                            this.pedidoRecogido = true;
                        }
                    } else {
                        if (ubicacion > pedidoAEntregar.getDireccionEntrega()) {
                            ubicacion--;
                        } else if (ubicacion < pedidoAEntregar.getDireccionEntrega()) {
                            ubicacion++;
                        } else {
                            // entregado
                            System.out.println("Entrega pedido " + pedidoAEntregar.getPedido().getFirst().toString() + " en momento " + Clock.getInstance().counter);
                            pedidoRecogido = false;
                            pedidoAEntregar = null;
                        }
                    }
                }

                Clock.getInstance().semClock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}