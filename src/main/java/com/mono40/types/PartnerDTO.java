package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


import java.math.BigDecimal;


@JsonRootName("partner")
public class PartnerDTO {

    @JsonProperty("partner-code")
    private BigDecimal partnerCode;

    @JsonProperty("partner-id")
    private String partnerId;

    @JsonProperty("partner-name")
    private String partnerName;

    @JsonProperty("image-url")
    private String imageUrl;

    @JsonProperty("partner-type")
    private String partnerType;

    public BigDecimal getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(BigDecimal partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerId(BigDecimal bigDecimal) {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }
}
