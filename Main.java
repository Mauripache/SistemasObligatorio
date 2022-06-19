import java.util.HashMap;
import java.util.LinkedList;

import Hilos.Clock;
import Recursos.Locales;
import Recursos.Pedido;
import Recursos.Repartidores;
import Util.ManejadorArchivos;

public class Main
{
    public static void main (String [] args)
    {
        //Carga de archivos
        Locales locales = new Locales("archivos/Locales.csv");
        int cantidadLocales = locales.getLocalesDisponibles().size();
        Repartidores repartidores = new Repartidores("archivos/Repartidores.csv");
        int cantidadRepartidores = repartidores.getRepartidores().size();
        
        HashMap<Integer, LinkedList<Pedido>> pedidosAInsertar = new HashMap<>();
        LinkedList<String> lineasPedidos = ManejadorArchivos.leerArchivo("archivos/Pedidos.csv", true);
        lineasPedidos.forEach( linea -> {
            String[] lineaSplit = linea.split(",");
            LinkedList<String> listaArticulos = new LinkedList<>();
            String[] listaArticulosString = lineaSplit[1].split(";");
            for (String articulo : listaArticulosString) {
                listaArticulos.add(articulo);
            }
            Pedido pedido = new Pedido(Integer.parseInt(lineaSplit[2]), lineaSplit[0], listaArticulos, lineaSplit[4]);
            LinkedList<Pedido> momento = pedidosAInsertar.get(Integer.parseInt(lineaSplit[3]));
            if (momento == null) {
                pedidosAInsertar.put(Integer.parseInt(lineaSplit[3]), new LinkedList<Pedido>());
                pedidosAInsertar.get(Integer.parseInt(lineaSplit[3])).add(pedido);
            } else {
                pedidosAInsertar.get(Integer.parseInt(lineaSplit[3])).add(pedido);
            }
        });

        locales.getLocalesDisponibles().values().forEach( local -> {
            local.start();
        });
        repartidores.getRepartidores().forEach( repartidor -> {
            repartidor.start();
        });
       
        new Clock(cantidadLocales + cantidadRepartidores, pedidosAInsertar);
        
        Clock.getInstance().start();
    }
}
