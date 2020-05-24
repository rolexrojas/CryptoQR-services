package com.mono40.types;

public class Producto {
    private int idProducto;
    private String descPlan;
    private int Slob;

    public Producto() {
    }

    public Producto(int idProducto, String descPlan, int slob) {
        this.idProducto = idProducto;
        this.descPlan = descPlan;
        Slob = slob;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescPlan() {
        return descPlan;
    }

    public void setDescPlan(String descPlan) {
        this.descPlan = descPlan;
    }

    public int getSlob() {
        return Slob;
    }

    public void setSlob(int slob) {
        Slob = slob;
    }
}
