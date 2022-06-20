package Recursos;

import java.util.HashMap;
import java.util.LinkedList;
import Hilos.Local;
import Util.ManejadorArchivos;

public class Locales {
    private static Locales instance;
    private final HashMap<String, Local> localesDisponibles = new HashMap<>();

    public static Locales getInstance() {
        return instance;
    }

    public Locales(String pathLocales) {
        instance = this;
        cargarLocales(pathLocales);
    }

    private void cargarLocales(String pathLocales) {
        LinkedList<String> lineas = ManejadorArchivos.leerArchivo(pathLocales, true);
        for (String linea : lineas) {
            String[] lineaSplit = linea.split(",");
            String[] articulos = lineaSplit[0].split(";");
            String[] tiempos = lineaSplit[1].split(";");
            Local local = new Local(Integer.parseInt(lineaSplit[3]), articulos, tiempos);
            localesDisponibles.putIfAbsent(lineaSplit[2], local);
        }
    }

    public HashMap<String, Local> getLocalesDisponibles() {
        return localesDisponibles;
    }

    public void releaseAll() {
        this.localesDisponibles.values().forEach( local -> {
            local.semLocal.release();
        });
    }

    public void insertarPedido(Pedido pedido) {
        this.localesDisponibles.get(pedido.getLocal()).insertarPedido(pedido);
    }

    public boolean localesTrabajando() {
        return !this.localesDisponibles.values().stream().allMatch(local -> local.pedidosEnPreparacion.isEmpty());
    }
}
