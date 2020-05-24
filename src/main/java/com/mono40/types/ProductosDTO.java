package com.mono40.types;

public class ProductosDTO {

    private String PartnerCode;
    private Productos productos;

    public ProductosDTO() {
    }

    public ProductosDTO(String partnerCode, Productos productos) {
        PartnerCode = partnerCode;
        this.productos = productos;
    }

    public String getPartnerCode() {
        return PartnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        PartnerCode = partnerCode;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
