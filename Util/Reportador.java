package Util;

import java.util.LinkedList;

import Recursos.Pedido;

public class Reportador{

    private static Reportador instance;
    private LinkedList<Pedido> pedidos = new LinkedList<>();
    int tiempoTotal = 0;
    int tiempoTotalDeEntrega = 0;
    int tiempoTotalFarmacia = 0;
    int tiempoTotalNuevos = 0;
    int tiempoTotalHabituales = 0;
    int tiempoTotalProgramados = 0;

    int totalPedidos1a10 = 0;
    int totalTiempoPedidos1a10 = 0;
    int totalPedidos11a20 = 0;
    int totalTiempoPedidos11a20 = 0;
    int totalPedidos21a30 = 0;
    int totalTiempoPedidos21a30 = 0;
    int totalPedidos31a40 = 0;
    int totalTiempoPedidos31a40 = 0;
    int totalPedidos41a50 = 0;
    int totalTiempoPedidos41a50 = 0;
    int totalPedidos51a60 = 0;
    int totalTiempoPedidos51a60 = 0;
    int totalPedidos61a70 = 0;
    int totalTiempoPedidos61a70 = 0;
    int totalPedidos71a80 = 0;
    int totalTiempoPedidos71a80 = 0;
    int totalPedidos81a90 = 0;
    int totalTiempoPedidos81a90 = 0;
    int totalPedidos91a100 = 0;
    int totalTiempoPedidos91a100 = 0;

    
    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public static Reportador getInstance() {
        return instance;
    }

    public Reportador () {
        instance = this;
    }

    private void sumarADistancia (int distanciaLocalEntrega, int tiempoEntregado, int tiempoPedido) {
        if (distanciaLocalEntrega >= 1 && distanciaLocalEntrega <= 10) {
            this.totalPedidos1a10 += 1;
            this.totalTiempoPedidos1a10 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 11 && distanciaLocalEntrega <= 20) {
            this.totalPedidos11a20 += 1;
            this.totalTiempoPedidos11a20 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 21 && distanciaLocalEntrega <= 30) {
            this.totalPedidos21a30 += 1;
            this.totalTiempoPedidos21a30 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 31 && distanciaLocalEntrega <= 40) {
            this.totalPedidos31a40 += 1;
            this.totalTiempoPedidos31a40 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 41 && distanciaLocalEntrega <= 50) {
            this.totalPedidos41a50 += 1;
            this.totalTiempoPedidos41a50 += tiempoEntregado - tiempoPedido;
        } else if (distanciaLocalEntrega >= 51 && distanciaLocalEntrega <= 60) {
            this.totalPedidos51a60 += 1;
            this.totalTiempoPedidos51a60 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 61 && distanciaLocalEntrega <= 70) {
            this.totalPedidos61a70 += 1;
            this.totalTiempoPedidos61a70 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 71 && distanciaLocalEntrega <= 80) {
            this.totalPedidos71a80 += 1;
            this.totalTiempoPedidos71a80 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 81 && distanciaLocalEntrega <= 90) {
            this.totalPedidos81a90 += 1;
            this.totalTiempoPedidos81a90 += tiempoEntregado - tiempoPedido; 
        } else if (distanciaLocalEntrega >= 91 && distanciaLocalEntrega <= 100) {
            this.totalPedidos91a100 += 1;
            this.totalTiempoPedidos91a100 += tiempoEntregado - tiempoPedido; 
        }
    }

    private void resetearDistancias() {
        totalPedidos1a10 = 0;
        totalTiempoPedidos1a10 = 0;
        totalPedidos11a20 = 0;
        totalTiempoPedidos11a20 = 0;
        totalPedidos21a30 = 0;
        totalTiempoPedidos21a30 = 0;
        totalPedidos31a40 = 0;
        totalTiempoPedidos31a40 = 0;
        totalPedidos41a50 = 0;
        totalTiempoPedidos41a50 = 0;
        totalPedidos51a60 = 0;
        totalTiempoPedidos51a60 = 0;
        totalPedidos61a70 = 0;
        totalTiempoPedidos61a70 = 0;
        totalPedidos71a80 = 0;
        totalTiempoPedidos71a80 = 0;
        totalPedidos81a90 = 0;
        totalTiempoPedidos81a90 = 0;
        totalPedidos91a100 = 0;
        totalTiempoPedidos91a100 = 0;
    }

    public void generarLineas(LinkedList<String> lineasAEscribir, String tipo) {
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 1 a la 10 fue: " + this.totalTiempoPedidos1a10/this.totalPedidos1a10);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 11 a la 20 fue: " + this.totalTiempoPedidos11a20/this.totalPedidos11a20);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 21 a la 30 fue: " + this.totalTiempoPedidos21a30/this.totalPedidos21a30);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 31 a la 40 fue: " + this.totalTiempoPedidos31a40/this.totalPedidos31a40);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 41 a la 50 fue: " + this.totalTiempoPedidos41a50/this.totalPedidos41a50);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 51 a la 60 fue: " + this.totalTiempoPedidos51a60/this.totalPedidos51a60);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 61 a la 70 fue: " + this.totalTiempoPedidos61a70/this.totalPedidos61a70);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 71 a la 80 fue: " + this.totalTiempoPedidos71a80/this.totalPedidos71a80);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 81 a la 90 fue: " + this.totalTiempoPedidos81a90/this.totalPedidos81a90);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera de los pedidos de " + tipo + " de la distancia hasta el local 91 a la 100 fue: " + this.totalTiempoPedidos91a100/this.totalPedidos91a100);
        this.resetearDistancias();
    }

    public void generarLineas2(LinkedList<String> lineasAEscribir, String tipo) {
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 1 a la 10 fue: " + this.totalTiempoPedidos1a10/this.totalPedidos1a10);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 11 a la 20 fue: " + this.totalTiempoPedidos11a20/this.totalPedidos11a20);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 21 a la 30 fue: " + this.totalTiempoPedidos21a30/this.totalPedidos21a30);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 31 a la 40 fue: " + this.totalTiempoPedidos31a40/this.totalPedidos31a40);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 41 a la 50 fue: " + this.totalTiempoPedidos41a50/this.totalPedidos41a50);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 51 a la 60 fue: " + this.totalTiempoPedidos51a60/this.totalPedidos51a60);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 61 a la 70 fue: " + this.totalTiempoPedidos61a70/this.totalPedidos61a70);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 71 a la 80 fue: " + this.totalTiempoPedidos71a80/this.totalPedidos71a80);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 81 a la 90 fue: " + this.totalTiempoPedidos81a90/this.totalPedidos81a90);
        lineasAEscribir.add("\t\tEl tiempo promedio de espera desde que la orden esta lista hasta que llega a manos del repartidor de los pedidos de " + tipo + " de la distancia hasta el local 91 a la 100 fue: " + this.totalTiempoPedidos91a100/this.totalPedidos91a100);
        this.resetearDistancias();
    }

    public void generarReportes() {
        LinkedList<Pedido> pedidosProgramados = new LinkedList<>();
        LinkedList<Pedido> pedidosHabituales = new LinkedList<>();
        LinkedList<Pedido> pedidosNuevos = new LinkedList<>();
        LinkedList<Pedido> pedidosFarmacia = new LinkedList<>();

        pedidos.forEach( pedido -> {
            switch (pedido.getTipo()) {
                case "farmacia":
                    pedidosFarmacia.push(pedido);
                    break;
                case "nuevo":
                    pedidosNuevos.push(pedido);
                    break;
                case "habitual":
                    pedidosHabituales.push(pedido);
                    break;
                case "programado":
                    pedidosProgramados.push(pedido);
                    break;
            }

            tiempoTotal += pedido.getTiempoEntregado() - pedido.getTiempoPedido();
            tiempoTotalDeEntrega += pedido.getTiempoRecogido() - pedido.getTiempoListo();
        });
        LinkedList<String> lineasAEscribir = new LinkedList<>();
        
        lineasAEscribir.add("El tiempo promedio de espera de los pedidos fue: " + this.tiempoTotal/this.pedidos.size() + "\n");

        pedidosFarmacia.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoEntregado(), pedido.getTiempoPedido());
            tiempoTotalFarmacia += pedido.getTiempoEntregado() - pedido.getTiempoPedido();
        });

        lineasAEscribir.add("\tEl tiempo promedio de espera de los pedidos de farmacia fue: " + this.tiempoTotalFarmacia/pedidosFarmacia.size());
        this.generarLineas(lineasAEscribir, "farmacia");
        
        pedidosNuevos.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoEntregado(), pedido.getTiempoPedido());
            tiempoTotalNuevos += pedido.getTiempoEntregado() - pedido.getTiempoPedido();
        });
        
        lineasAEscribir.add("\tEl tiempo promedio de espera de los pedidos de clientes nuevos fue: " + this.tiempoTotalNuevos/pedidosNuevos.size());
        this.generarLineas(lineasAEscribir, "clientes nuevos");

        pedidosHabituales.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoEntregado(), pedido.getTiempoPedido());
            tiempoTotalHabituales += pedido.getTiempoEntregado() - pedido.getTiempoPedido();
        });

        lineasAEscribir.add("\tEl tiempo promedio de espera de los pedidos de clientes habituales fue: " + this.tiempoTotalHabituales/pedidosHabituales.size());
        this.generarLineas(lineasAEscribir, "clientes habituales");
        
        pedidosProgramados.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoEntregado(), pedido.getTiempoPedido());
            tiempoTotalProgramados += pedido.getTiempoEntregado() - pedido.getTiempoPedido();
        });

        lineasAEscribir.add("\tEl tiempo promedio de espera de los pedidos de pedidos programados fue: " + this.tiempoTotalProgramados/pedidosProgramados.size());
        this.generarLineas(lineasAEscribir, "pedidos programados");
        
        tiempoTotalFarmacia = 0;
        tiempoTotalNuevos = 0;
        tiempoTotalHabituales = 0;
        tiempoTotalProgramados = 0;

        lineasAEscribir.add("\n" + "El tiempo promedio, desde que la orden esta lista hasta que llega a manos del repartidor, de los pedidos fue: " + this.tiempoTotalDeEntrega/this.pedidos.size() + "\n");

        pedidosFarmacia.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoRecogido(), pedido.getTiempoListo());
            tiempoTotalFarmacia += pedido.getTiempoRecogido() - pedido.getTiempoListo();
        });

        lineasAEscribir.add("\tEl tiempo promedio, desde que la orden esta lista hasta que llega a manos del repartidor, de los pedidos de farmacia fue: " + this.tiempoTotalFarmacia/pedidosFarmacia.size());
        this.generarLineas2(lineasAEscribir, "farmacia");
        
        pedidosNuevos.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoRecogido(), pedido.getTiempoListo());
            tiempoTotalNuevos += pedido.getTiempoRecogido() - pedido.getTiempoListo();
        });
        
        lineasAEscribir.add("\tEl tiempo promedio, desde que la orden esta lista hasta que llega a manos del repartidor, de los pedidos de clientes nuevos fue: " + this.tiempoTotalNuevos/pedidosNuevos.size());
        this.generarLineas2(lineasAEscribir, "clientes nuevos");

        pedidosHabituales.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoRecogido(), pedido.getTiempoListo());
            tiempoTotalHabituales += pedido.getTiempoRecogido() - pedido.getTiempoListo();
        });

        lineasAEscribir.add("\tEl tiempo promedio, desde que la orden esta lista hasta que llega a manos del repartidor, de los pedidos de clientes habituales fue: " + this.tiempoTotalHabituales/pedidosHabituales.size());
        this.generarLineas2(lineasAEscribir, "clientes habituales");
        
        pedidosProgramados.forEach( pedido -> {
            this.sumarADistancia(Math.abs(pedido.getDireccionRetiro() - pedido.getDireccionEntrega()), pedido.getTiempoRecogido(), pedido.getTiempoListo());
            tiempoTotalProgramados += pedido.getTiempoRecogido() - pedido.getTiempoListo();
        });

        lineasAEscribir.add("\tEl tiempo promedio, desde que la orden esta lista hasta que llega a manos del repartidor, de los pedidos de pedidos programados fue: " + this.tiempoTotalProgramados/pedidosProgramados.size());
        this.generarLineas2(lineasAEscribir, "pedidos programados");

        ManejadorArchivos.escribirArchivo("archivos/Salida.txt", lineasAEscribir, false);
    }
}