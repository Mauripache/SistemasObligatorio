package Recursos;

import java.util.LinkedList;
import Hilos.Repartidor;
import Util.ManejadorArchivos;

public class Repartidores {
    private static Repartidores instance;
    private LinkedList<Repartidor> repartidores = new LinkedList<>();
    private int distanciaTotal;

    public static Repartidores getInstance() {
        return instance;
    }

    public Repartidores(String pathRepartidores) {
        instance = this;
        cargarRepartidores(pathRepartidores);
    }

    private void cargarRepartidores(String pathRepartidores) {
        LinkedList<String> lineas = ManejadorArchivos.leerArchivo(pathRepartidores, true);
        for (String linea : lineas) {
            String[] lineaSplit = linea.split(",");
            Repartidor repartidor = new Repartidor(Integer.parseInt(lineaSplit[1]), lineaSplit[0]);
            repartidores.add(repartidor);
        }
    }

    public LinkedList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void releaseAll() {
        this.repartidores.forEach( repartidor -> {
            repartidor.semRepartidor.release();
        });
    }

    public int promedioDistancia(Pedido pedido) {
        int totalRepartidores = repartidores.size();
        distanciaTotal = 0;
        repartidores.forEach( repartidor -> {
            distanciaTotal += Math.abs(repartidor.getUbicacion() - pedido.getDireccionRetiro());
        });
        return distanciaTotal/totalRepartidores;
    }
}

