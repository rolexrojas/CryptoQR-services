package com.mono40.controller;

import com.mono40.exception.QueryBalanceException;
import com.mono40.service.IQueryBalanceService;
import com.mono40.types.*;
//import com.mono40.util.ImageAttacherManager;
import com.mono40.util.JwtManager;
import com.mono40.util.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by yinfante on 10/24/16.
 */
@RestController
@RequestMapping("/query")
public class QueryBalanceResource {

    private Logger log = LogManager.getLogger(QueryBalanceResource.class);

    @Autowired
    private IQueryBalanceService queryBalanceService;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private JwtManager jwtManager;

    //@Autowired
    //private ImageAttacherManager imageAttacherManager;


    @RequestMapping(value = "/accounts")
    public ResponseEntity accounts(@RequestHeader("Authorization") String token) {

        log.info("inside getting accounts");

        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        List<Resource> resourceList = new ArrayList<>();

        log.info("getting all  accounts for " + msisdn);
        Account[] accounts = queryBalanceService.loadAccounts(msisdn);
        log.info("done getting accounts, count :" + accounts.length);
        List<BankDTO> banks = new ArrayList<>();

        for (Account curr : accounts) {
//            Link accountLink = linkTo(methodOn(QueryBalanceResource.class).accountBalance(new QueryBalance(), token)).withRel("balance");

            Resource resource = new Resource(curr);

            resourceList.add(resource);
            banks.add(curr.getBank());
        }

        //log.info("attaching bank logos");
        //imageAttacherManager.attachBankLogo(banks);
        //log.info("done attaching bank logos");


        Resources resources = new Resources(resourceList, linkTo(methodOn(QueryBalanceResource.class).accounts(token)).withSelfRel());

        return ResponseEntity.ok(accounts);
    }

  /*  @RequestMapping(value = "/accounts/balance", method = RequestMethod.POST)
    public ResponseEntity accountBalance(@RequestBody QueryBalance queryBalance, @RequestHeader("Authorization") String token) throws QueryBalanceException {
        try {
            log.info("inside account balance");


            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();
            queryBalance.setMsisdn(msisdn);
            queryBalance.setSessionId(sessionManager.createSessionId());

            log.info("getting account balance for " + queryBalance.getAccountAlias());
            QueryBalanceResponse queryBalanceResponse = queryBalanceService.accountBalance(queryBalance);
            log.info("done getting balance for " + queryBalance.getAccountAlias());

            return ResponseEntity.ok(queryBalanceResponse);

        } catch (Exception e) {
            throw new QueryBalanceException(e, queryBalance);
        }
    }
*/
    @RequestMapping("/credit-cards")
    public ResponseEntity creditCards(@RequestHeader("Authorization") String token) {

        log.info("inside getting credit-cards");


        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        List<Resource> resourceList = new ArrayList<>();

        log.info("getting all credit-cards for " + msisdn);
        CreditCard[] creditCards = queryBalanceService.loadCreditCards(msisdn);
        log.info("done getting credit-cards for " + msisdn);

        List<BankDTO> banks = new ArrayList<>();


        for (CreditCard curr : creditCards) {
//            Link creditCardLink = linkTo(methodOn(QueryBalanceResource.class).creditCardBalance(new QueryBalance(), token)).withRel("balance");

            Resource resource = new Resource(curr);

            resourceList.add(resource);
            banks.add(curr.getBank());
        }


        Resources resources = new Resources(resourceList, linkTo(methodOn(QueryBalanceResource.class).creditCards(token)).withSelfRel());

       // log.info("attaching bank logos");
        //imageAttacherManager.attachBankLogo(banks);
       // log.info("done attaching bank logos");

       // log.info("getting credit-cards images for " + msisdn);
       // imageAttacherManager.attachCreditCardImage(creditCards, msisdn);
       // log.info("done getting credit-cards images for " + msisdn);

        return ResponseEntity.ok(creditCards);
    }

    /*@RequestMapping(value = "/credit-cards/balance", method = RequestMethod.POST)
    public ResponseEntity creditCardBalance(@RequestBody QueryBalance queryBalance, @RequestHeader("Authorization") String token) throws QueryBalanceException {

        try {
            log.info("inside credit-card balance");


            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

            queryBalance.setMsisdn(msisdn);
            queryBalance.setSessionId(sessionManager.createSessionId());

            log.info("getting credit-card balance");
            QueryBalanceResponse queryBalanceResponse = queryBalanceService.creditCardBalance(queryBalance);
            log.info("done getting credit-card balance");

            return ResponseEntity.ok(queryBalanceResponse);
        } catch (Exception e) {
            throw new QueryBalanceException(e, queryBalance);
        }
    }
*/
    @RequestMapping("/loans")
    public ResponseEntity loans(@RequestHeader("Authorization") String token) {

        log.info("inside getting all loans");


        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        List<Resource> resourceList = new ArrayList<>();

        log.info("getting all loans");
        Loan[] loans = queryBalanceService.loadLoan(msisdn);
        log.info("done getting all loans");
        List<BankDTO> banks = new ArrayList<>();

        for (Loan curr : loans) {

//            Link creditCardLink = linkTo(methodOn(QueryBalanceResource.class).loanBalance(new QueryBalance(), token)).withRel("balance");

            Resource resource = new Resource(curr);

            resourceList.add(resource);
            banks.add(curr.getBank());
        }

       // log.info("attaching bank logos");
        //imageAttacherManager.attachBankLogo(banks);
       // log.info("done attaching bank logos");

        Resources resources = new Resources(resourceList, linkTo(methodOn(QueryBalanceResource.class).loans(token)).withSelfRel());

        return ResponseEntity.ok(loans);
    }

  /*  @RequestMapping(value = "/loans/balance", method = RequestMethod.POST)
    public ResponseEntity loanBalance(@RequestBody QueryBalance queryBalance, @RequestHeader("Authorization") String token) throws QueryBalanceException {

        try {
            log.info("inside loan balance");


            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

            queryBalance.setMsisdn(msisdn);
            queryBalance.setSessionId(sessionManager.createSessionId());

            log.info("getting loan balance");
            LoanBalanceResponse queryBalanceResponse = queryBalanceService.loanBalance(queryBalance);
            log.info("done getting loan balance");

            return ResponseEntity.ok(queryBalanceResponse);
        } catch (Exception e) {
            throw new QueryBalanceException(e, queryBalance);
        }
    }
*/

}
