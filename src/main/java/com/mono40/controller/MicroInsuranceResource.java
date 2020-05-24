package com.mono40.controller;

//import com.mono40.service.IMicroInsuranceService;
import com.mono40.types.*;
import com.mono40.util.JwtManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/micro-insurance")
public class MicroInsuranceResource {

    private Logger logger = Logger.getLogger(MicroInsuranceResource.class);


   // @Autowired
    //private IMicroInsuranceService microInsuranceUniversalService;

    @Autowired
    private JwtManager jwtManager;

    @GetMapping("/partners")
    public ResponseEntity partners(@RequestHeader("Authorization") String token) {

        logger.debug("getting partners ");

        TokenModel tokenModel = jwtManager.parseTokenToModel(token);

        List<Partners> partnerList = new ArrayList<>();

        Partners partners = new Partners();
        partners.setActive(true);
        partners.setCategory("VEHICULOS");
        partners.setDescription("Entidad vendora de automobiles");
        List<Links> links = new ArrayList<>();
        Links link = new Links();
        link.setHref("http://localhost:8086/partnerhub/UNI/products");
        link.setRel("cars");
        links.add(link);
        partners.setLinks(links);
        partners.setName("MGHEADQUARTERS");
        partners.setPartnerId("01");
        partnerList.add(partners);
        logger.debug("partners found : " + partnerList.size());

        return ResponseEntity.ok(partnerList);
    }
}
