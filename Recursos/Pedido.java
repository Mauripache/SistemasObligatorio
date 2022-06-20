package Recursos;

import java.util.LinkedList;

public class Pedido {
    private int direccionEntrega;
    private String id;
    private String local;
    private LinkedList<String> pedido;
    private int tiempoPreparacion;
    private String tipo;
    private int direccionRetiro;
    private Integer distanciaDeRepartidores;

    private int tiempoListo;
    private int tiempoRecogido;
    private int tiempoPedido;
    private int tiempoEntregado;

    public Pedido(int entrega, String local, LinkedList<String> pedido, String tipo, String id, int tiempoPedido) {
        this.direccionEntrega = entrega;
        this.local = local;
        this.pedido = pedido;
        this.tipo = tipo;
        this.id = id;
        this.tiempoPedido = tiempoPedido;
    }

    public int getDireccionEntrega()
    {
        return direccionEntrega;
    }

    public String getId()
    {
        return id;
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

    public int getTiempoListo()
    {
        return this.tiempoListo;
    }

    public int getTiempoRecogido()
    {
        return this.tiempoRecogido;
    }

    public int getTiempoEntregado()
    {
        return this.tiempoEntregado;
    }

    public int getTiempoPedido()
    {
        return this.tiempoPedido;
    }

    public void setDireccion(int direccion)
    {
        this.direccionEntrega = direccion;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public void setTiempoListo(int tiempoListo)
    {
        this.tiempoListo = tiempoListo;
    }

    public void setTiempoRecogido(int tiempoRecogido)
    {
        this.tiempoRecogido = tiempoRecogido;
    }

    public void setTiempoEntregado(int tiempoEntregado)
    {
        this.tiempoEntregado = tiempoEntregado;
    }
}