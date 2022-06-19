package Recursos;

import java.util.LinkedList;

public class Pedido {
    private int direccionEntrega;
    private String local;
    private LinkedList<String> pedido;
    private int tiempoPreparacion;
    private String tipo;
    private int direccionRetiro;
    private Integer distanciaDeRepartidores;

    public Pedido(int entrega, String local, LinkedList<String> pedido, String tipo) {
        this.direccionEntrega = entrega;
        this.local = local;
        this.pedido = pedido;
        this.tipo = tipo;
    }

    public int getDireccionEntrega()
    {
        return direccionEntrega;
    }

    public String getLocal()
    {
        return local;
    }

    public LinkedList<String> getPedido()
    {
        return pedido;
    }

    public int getTiempoPreparacion()
    {
        return this.tiempoPreparacion;
    }

    public String getTipo()
    {
        return this.tipo;
    }

    public int getDireccionRetiro()
    {
        return this.direccionRetiro;
    }

    public Integer getDistanciaDeRepartidores()
    {
        return this.distanciaDeRepartidores;
    }

    public void setDireccion(int direccion)
    {
        this.direccionEntrega = direccion;
    }

    public void setLocal(String local)
    {
        this.local = local;
    }

    public void setPedido(LinkedList<String> pedido)
    {
        this.pedido = pedido;
    }

    public void setTiempoPreparacion(int tiempoPreparacion)
    {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public void setDireccionRetiro(int direccionRetiro)
    {
        this.direccionRetiro = direccionRetiro;
    }

    public void setDistanciaDeRepartidores(Integer distanciaDeRepartidores)
    {
        this.distanciaDeRepartidores = distanciaDeRepartidores;
    }
}