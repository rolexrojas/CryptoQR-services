package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Productos {

    @JsonProperty("Products")
    private List<Producto> productos;
    private String outdescresultadoOutField;
    private String outcodresultadoOutField;

    public Productos() {
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getOutdescresultadoOutField() {
        return outdescresultadoOutField;
    }

    public void setOutdescresultadoOutField(String outdescresultadoOutField) {
        this.outdescresultadoOutField = outdescresultadoOutField;
    }

    public String getOutcodresultadoOutField() {
        return outcodresultadoOutField;
    }

    public void setOutcodresultadoOutField(String outcodresultadoOutField) {
        this.outcodresultadoOutField = outcodresultadoOutField;
    }
}
