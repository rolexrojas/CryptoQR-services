package com.mono40.controller;

import com.mono40.types.BankDTO;
import org.apache.log4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by yarielinfante on 11/4/16.
 */
@RestController
@RequestMapping("/banks")
public class PartnerBankResource {

    private Logger logger = Logger.getLogger(PartnerBankResource.class);

    //@Autowired
    //private IPartnerBankService partnerBankService;

    //@Autowired
    //private ImageAttacherManager imageAttacherManager;

    @GetMapping
    public ResponseEntity banks() {

        logger.debug("getting banks available");


        List<BankDTO> banks = new ArrayList<>();

        BankDTO bank = new BankDTO();
        bank.setBankPartnerName("BanReservas");
        bank.setBankLogoURI("http://localhost:8091/images/235/40/40/dinamic.png");
        bank.setBankPartnerCode(new BigDecimal(3));
        bank.setBankPartnerId("40");
        bank.setActive(true);

        banks.add(bank);
        logger.debug("banks found : " + banks.size());

        //imageAttacherManager.attachBankLogo(bankDTOs);
        //Link link = Link.valueOf("dsfd");
        Link link = linkTo(methodOn(PartnerBankResource.class).banks()).withSelfRel();
        logger.debug("Links found : " + link);
        //link.getHref().replace("cryptoqr", "neo");


        Resources resources = new Resources(banks, link);


        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
   public ResponseEntity banks(@PathVariable int id) {

        BankDTO bank = new BankDTO();
        bank.setActive(true);
        bank.setBankPartnerId("40");
        bank.setBankPartnerCode(BigDecimal.valueOf(3));
        bank.setBankLogoURI("http://172.20.67.113:8091/images/235/40/40/dinamic.png");
        bank.setBankPartnerName("Banco Popular");

        return ResponseEntity.ok(bank);
    }


}
