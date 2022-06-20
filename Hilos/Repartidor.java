package Hilos;

import java.util.concurrent.Semaphore;

import Planificador.MLQ;
import Recursos.Pedido;
import Util.Reportador;

public class Repartidor extends Thread {

    public Semaphore semRepartidor = new Semaphore(0);
    int ubicacion;
    String nombre;
    boolean pedidoRecogido = false;
    public Pedido pedidoAEntregar = null;

    public Repartidor(int ubicacion, String nombre) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        while (Clock.getInstance().tiempoActivo) {
            try {
                semRepartidor.acquire();

                if (pedidoAEntregar == null) {
                    this.pedidoAEntregar = MLQ.MLQ.proximaSolicitud();
                    if (this.pedidoAEntregar != null) {
                        //Habia pedido para recoger
                        this.pedidoAEntregar.setTiempoRecogido(Clock.getInstance().counter);
                    }
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
                            this.pedidoAEntregar.setTiempoEntregado(Clock.getInstance().counter);
                            System.out.println("Entrega pedido " + pedidoAEntregar.getId() +" " + this.nombre + " en momento " + Clock.getInstance().counter);
                            Reportador.getInstance().getPedidos().add(pedidoAEntregar);
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