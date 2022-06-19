package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ManejadorArchivos {

    public static LinkedList<String> leerArchivo(String path, boolean ignoreHeader) {
        LinkedList<String> lineas = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (ignoreHeader) {
                linea = br.readLine();
            }
            while (linea != null) {
                lineas.add(linea);
                linea = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + path + "\n" + ex);
        }
        return lineas;
    }

    public static void escribirArchivo(String path, LinkedList<String> lines, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (Object lineaActual : lines) {
                bw.write(lineaActual.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + path);
        }
    }

    public static void vaciarArchivo(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + path);
        }
    }
}
