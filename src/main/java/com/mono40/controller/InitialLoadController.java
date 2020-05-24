package com.mono40.controller;

import com.mono40.domain.Beneficiary;
//import com.mono40.exception.NeoAPIException;
import com.mono40.types.InitialGeneral;
import com.mono40.types.InitialQuery;
import com.mono40.types.PaymentQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by yinfante on 10/19/16.
 */
@RestController
@RequestMapping("/initial-load")
public class InitialLoadController {

    private Logger logger = LogManager.getLogger(InitialLoadController.class);

    @Autowired
    private QueryBalanceResource queryBalanceResource;

    @Autowired
    private PaymentResource paymentResource;

    //@Autowired
   // private BeneficiaryController beneficiaryController;


    @GetMapping(produces = "application/json")
    public ResponseEntity general(@RequestHeader("Authorization") String authorization) throws Exception {

        logger.info("start of loading query");
        ResponseEntity accounts = queryBalanceResource.accounts(authorization);

        ResponseEntity creditCards = queryBalanceResource.creditCards(authorization);
        ResponseEntity loans = queryBalanceResource.loans(authorization);
        logger.info("done loading query");

        InitialQuery initialQuery = new InitialQuery();
        initialQuery.setAccounts(accounts.getBody());
        initialQuery.setCreditCards(creditCards.getBody());
        initialQuery.setLoans(loans.getBody());

        logger.info("getting invoices");
        ResponseEntity invoices = paymentResource.getInvoices(authorization);
        logger.info("done getting invoices");
/*
        logger.info("getting beneficiaries");
        ResponseEntity beneficiaries = beneficiaryController.getBeneficiaries(authorization);
        logger.info("done getting beneficiaries");
*/
        PaymentQuery paymentQuery = new PaymentQuery();
        paymentQuery.setInvoices(invoices.getBody());

        InitialGeneral generalLoad = new InitialGeneral();

        generalLoad.setQuery(initialQuery);
        generalLoad.setPayment(paymentQuery);
        generalLoad.setBeneficiaries(new Beneficiary());

//        generalLoad.add(linkTo(methodOn(InitialLoadController.class).general(authorization)).withSelfRel());

//        Resource resource =
//                new Resource(generalLoad, linkTo(methodOn(InitialLoadController.class).general(authorization)).withSelfRel());


        return ResponseEntity.ok(generalLoad);
    }


}
/*
* {
              "query": {
                "accounts": [
                  {
                    "account-alias": "yas 3631",
                    "account-number": "*****3631",
                    "bank": {
                      "bank-id": "102",
                      "bank-code": 5,
                      "bank-logo-uri": "",
                      "bank-name": "Banco Popular",
                      "active": true
                    },
                    "query-fee": 5,
                    "account-type": "SAV",
                    "currency": "DOP",
                    "payable": true,
                    "priority": 1,
                    "default-account": true
                  }
                ],
                "creditCards": [
                  {
                    "account-alias": "yas 3631",
                    "account-number": "*****3631",
                    "bank": {
                      "bank-id": "102",
                      "bank-code": 5,
                      "bank-logo-uri": "",
                      "bank-name": "Banco Popular",
                      "active": true
                    },
                    "query-fee": 5,
                    "account-type": "SAV",
                    "currency": "DOP",
                    "payable": true,
                    "priority": 1,
                    "default-account": true
                  }
                ],
                "loans": [
                  {
                    "account-alias": "yas 3631",
                    "account-number": "*****3631",
                    "bank": {
                      "bank-id": "102",
                      "bank-code": 5,
                      "bank-logo-uri": "",
                      "bank-name": "Banco Popular",
                      "active": true
                    },
                    "query-fee": 5,
                    "account-type": "SAV",
                    "currency": "DOP",
                    "payable": true,
                    "priority": 1,
                    "default-account": true
                  }
                ],
                "_links": {
                  "accounts": {
                    "href": "http://172.19.1.103:8081/api/neo/query/accounts/8097147283"
                  },
                  "creditCards": {
                    "href": "http://172.19.1.103:8081/api/neo/query/credit-cards/8097147283"
                  },
                  "loans": {
                    "href": "http://172.19.1.103:8081/api/neo/query/loans/8097147283"
                  }
                }
              },
              "payment": {
            "invoices": [
                  {
                    "contract": "1234567",
                    "partner": {
                      "partner-code": 23,
                      "partner-id": "ESL",
                      "partner-name": "EDESUR",
                      "image-url":""
                    }
                 }
                ]
              },
                  "beneficiaries": [
                    {
                        "name": "Yariel Infante",
                        "detail": "8294407970",
                        "entity": null,
                        "phone-number": true
                    }
                ],
              "_links": {
                "self": {
                  "href": "http://172.19.1.103:8081/api/neo/initial-load"
                }
              }
            }
*
* */