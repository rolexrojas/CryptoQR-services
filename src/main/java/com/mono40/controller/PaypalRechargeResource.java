package com.mono40.controller;

import com.mono40.exception.InvalidMsisdnException;
import com.mono40.types.*;
import com.mono40.util.JwtManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbinet on 4/20/2018.
 */
@RestController
@RequestMapping("/paypal/accounts")
public class PaypalRechargeResource {

    private Logger logger = Logger.getLogger(PaypalRechargeResource.class);


    @Autowired
    private JwtManager jwtManager;

    @GetMapping
    ResponseEntity getPaypalAccount(@RequestHeader("Authorization") String token) {

        String msisdn = jwtManager.parseTokenToModel(token).getAccountId().toString();

        PaypalAccount paypalAccount = new PaypalAccount();
        paypalAccount.setId(1);
        paypalAccount.setPaypalEmail("");
        paypalAccount.setAlias("");
        paypalAccount.setDocumentId("");
        paypalAccount.setMsisdn(8492656223L);
        paypalAccount.setPaypalAccountId("");
        paypalAccount.setPreApprovalKey("");
        paypalAccount.setToken("");

        List<PaypalAccount> paypalAccounts = new ArrayList<>();
        paypalAccounts.add(paypalAccount);

        PaypalRechargeAccount paypalRechargeAccount = new PaypalRechargeAccount(paypalAccounts);

        return ResponseEntity.ok(paypalRechargeAccount);

    }

}
