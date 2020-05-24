package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;


public class GenerateRequestMIDTO {

    private Long msisdn;
    @XmlElement(name = "session-id")
    @JsonProperty("session-id")
    private String sessionId;
    private Partners partner;
    private ProductoPlan productoPlan;
    private String codformapago;
    private String partnerCode;


}
