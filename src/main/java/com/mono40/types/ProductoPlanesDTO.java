package com.mono40.types;


public class ProductoPlanesDTO {

    private String PartnerCode;
    private ProductoPlanes productoPlanes;

    public ProductoPlanesDTO() {
    }

    public ProductoPlanesDTO(String partnerCode, ProductoPlanes productoPlanes) {
        PartnerCode = partnerCode;
        this.productoPlanes = productoPlanes;
    }

    public String getPartnerCode() {
        return PartnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        PartnerCode = partnerCode;
    }

    public ProductoPlanes getProductoPlanes() {
        return productoPlanes;
    }

    public void setProductoPlanes(ProductoPlanes productoPlanes) {
        this.productoPlanes = productoPlanes;
    }
}
