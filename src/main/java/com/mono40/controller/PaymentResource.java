package com.mono40.controller;

//import com.mono40.exception.InvalidPinException;
//import com.mono40.exception.NeoAPIException;
import com.mono40.service.IPaymentService;
import com.mono40.types.*;
//import com.mono40.util.ImageAttacherManager;
import com.mono40.util.JwtManager;

import com.mono40.util.SessionManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by yarielinfante on 10/31/16.
 */
@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private Logger logger = Logger.getLogger(PaymentResource.class);

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private SessionManager sessionManager;

    //@Autowired
    //private ImageAttacherManager imageAttacherManager;

    //@Autowired
    //private PinManager pinManager;

    @PostMapping("/validate-pin")
    @Deprecated
    public ResponseEntity validatePin(@RequestHeader("Authorization") String token, @RequestBody AuthPin authPin) {

        logger.debug("validating pin ");

        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        //authPin.setMsisdn(msisdn);

        logger.info("This implementation the this method always return true, because validate pin is intern validation in core tpago");

        return ResponseEntity.ok(true);

    }

   /* @PostMapping("/change-default-account")
    public ResponseEntity changeDefaultAccount(@RequestBody ChangeAccountDTO account, @RequestHeader("Authorization") String token) throws NeoAPIException {
        try {




            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

            account.setMsisdn(msisdn);

            logger.debug("change default account to : " + account);

            paymentService.changeDefaultAccount(account);

            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            throw new NeoAPIException(e, account);
        }

    }
    */

    @RequestMapping(value = "/partners", method = RequestMethod.GET)
    public ResponseEntity partners() {

        logger.debug("getting partners");

        List<PartnerDTO> partners = new ArrayList<>();
        PartnerDTO aPartner = new PartnerDTO();
        aPartner.setPartnerId("40");
        aPartner.setPartnerCode(BigDecimal.valueOf(40));
        aPartner.setPartnerName("Partner");
        aPartner.setPartnerType("Bank");
        aPartner.setImageUrl("localhost:8091/images/235/49/40/image.png");

        partners.add(aPartner);
        logger.debug("partners found :" + partners.size());

        //imageAttacherManager.attachPartnerLogo(partners);

        Link link = linkTo(methodOn(PaymentResource.class).partners()).withSelfRel();

        Resources resources = new Resources(partners, link);

        return ResponseEntity.ok(resources);

    }


    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public ResponseEntity getInvoices(@RequestHeader("Authorization") String token) {

        logger.debug("getting invoices");



        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        List<CustomerInvoice> invoices = paymentService.getBills(msisdn);

        logger.debug("invoices found : " + invoices.size());

        List<PartnerDTO> partners = new ArrayList<>();

        for (CustomerInvoice invoice : invoices) {
            partners.add(invoice.getPartner());
        }

       // imageAttacherManager.attachPartnerLogo(partners);

        Link link = linkTo(methodOn(PaymentResource.class).getInvoices(token)).withSelfRel();

//        Resources resources = new Resources(partners, link);

        return ResponseEntity.ok(invoices);

    }
/*
    @RequestMapping(value = "/invoices/contract/client", method = RequestMethod.POST)
    public ResponseEntity getClientInvoices(@RequestBody ClientInvoiceRequest clientInvoiceRequest, @RequestHeader("Authorization") String token) {
        logger.info("Entering getClientInvoices...");
        logger.info("clientInvoiceRequest : "+clientInvoiceRequest);

        Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

        clientInvoiceRequest.setMsisdn(msisdn);
        clientInvoiceRequest.setSessionId(sessionManager.createSessionId());

        logger.info("call getClientInvoices of service...");
        ClientInvoiceResponse response = paymentService.getClientInvoices(clientInvoiceRequest);
        logger.info("call getClientInvoices of service...END Call.");

        return ResponseEntity.ok(response);
    }


    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public ResponseEntity addInvoice(@RequestBody InvoiceDTO invoiceDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {

            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();

            invoiceDTO.setMsisdn(msisdn);
            invoiceDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("adding invoice : " + invoiceDTO);

            paymentService.addInvoice(invoiceDTO);

            return ResponseEntity.noContent().build();

        } catch (Throwable e) {
            throw new NeoAPIException(e, invoiceDTO);
        }

    }

    @RequestMapping(value = "/remove-invoice", method = RequestMethod.POST)
    public ResponseEntity removeInvoice(@RequestBody InvoiceDTO invoiceDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {

            Long msisdn = jwtManager.parseTokenToModel(token).getAccountId();
            AuthPin authPin = new AuthPin(msisdn, invoiceDTO.getPin());

            if (!pinManager.verifyPin(authPin))
                throw new InvalidPinException(invoiceDTO);

            invoiceDTO.setMsisdn(msisdn);
            invoiceDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("removing invoice : " + invoiceDTO);

            paymentService.removeInvoice(invoiceDTO);

            return ResponseEntity.noContent().build();

        } catch (Throwable e) {
            throw new NeoAPIException(e, invoiceDTO);
        }

    }


    @RequestMapping(value = "/invoices/balance", method = RequestMethod.POST)
    public ResponseEntity getBalance(@RequestBody InvoiceDTO invoiceDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {



            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            invoiceDTO.setMsisdn(msisdn);
            invoiceDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("invoice balance for : " + invoiceDTO);

            InvoiceDetail balance = paymentService.getBalance(invoiceDTO);

            logger.debug("invoice balance for : " + invoiceDTO + " ------> " + balance);
            return ResponseEntity.ok(balance);

        } catch (Throwable e) {
            throw new NeoAPIException(e, invoiceDTO);
        }

    }


    @RequestMapping(value = "/invoices/pay")
    public ResponseEntity payInvoice(@RequestBody PaymentInvoiceDTO paymentInvoiceDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {




            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            paymentInvoiceDTO.setMsisdn(msisdn);
            paymentInvoiceDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("invoice payment : " + paymentInvoiceDTO);

            TransactionResponseDTO paymentResponse = paymentService.invoicePayment(paymentInvoiceDTO);

            logger.debug("invoice payment response : " + paymentResponse);

            return ResponseEntity.ok(paymentResponse);

        } catch (Throwable e) {
            throw new NeoAPIException(e, paymentInvoiceDTO);
        }

    }

    @RequestMapping(value = "/credit-cards/balance", method = RequestMethod.POST)
    public ResponseEntity getCreditCardBalance(@RequestBody CreditCard creditCard, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {



            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            CreditCardBalance creditCardBalance = new CreditCardBalance();
            creditCardBalance.setCreditCard(creditCard);
            creditCardBalance.setMsisdn(msisdn);
            creditCardBalance.setSessionId(sessionManager.createSessionId());

            logger.debug("credit card balance : " + creditCardBalance);

            CreditCardBalanceResponse creditCardBalanceResponse = paymentService.getCreditCardBalance(creditCardBalance);

            logger.debug("credit card balance response : " + creditCardBalanceResponse);

            return ResponseEntity.ok(creditCardBalanceResponse);

        } catch (Throwable e) {
            throw new NeoAPIException(e, creditCard);
        }

    }

    @RequestMapping(value = "/credit-cards/pay")
    public ResponseEntity payCreditCard(@RequestBody CreditCardPaymentDTO creditCardPaymentDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {



            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            creditCardPaymentDTO.setMsisdn(msisdn);
            creditCardPaymentDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("credit card payment : " + creditCardPaymentDTO);

            TransactionResponseDTO paymentResponse = paymentService.creditCardPayment(creditCardPaymentDTO);

            logger.debug("credit card payment response: " + paymentResponse);

            return ResponseEntity.ok(paymentResponse);

        } catch (Throwable e) {
            throw new NeoAPIException(e, creditCardPaymentDTO);
        }

    }


    @RequestMapping(value = "/loans/balance", method = RequestMethod.POST)
    public ResponseEntity getCreditCardBalance(@RequestBody Loan loan, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {



            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            LoanBalance loanBalance = new LoanBalance();
            loanBalance.setLoan(loan);
            loanBalance.setMsisdn(msisdn);
            loanBalance.setSessionId(sessionManager.createSessionId());

            logger.debug("loan balance : " + loanBalance);

            LoanBalanceResponse loanBalanceResponse = paymentService.getLoanBalance(loanBalance);

            logger.debug("loan balance response : " + loanBalanceResponse);

            return ResponseEntity.ok(loanBalanceResponse);

        } catch (Throwable e) {
            throw new NeoAPIException(e, loan);
        }

    }

    @RequestMapping(value = "/loans/pay")
    public ResponseEntity payLoan(@RequestBody LoanPaymentDTO loanPaymentDTO, @RequestHeader("Authorization") String token) throws NeoAPIException {

        try {

            Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

            loanPaymentDTO.setMsisdn(msisdn);
            loanPaymentDTO.setSessionId(sessionManager.createSessionId());

            logger.debug("loan payment : " + loanPaymentDTO);
            TransactionResponseDTO paymentResponse = paymentService.loanPayment(loanPaymentDTO);

            logger.debug("loan payment response : " + paymentResponse);

            return ResponseEntity.ok(paymentResponse);

        } catch (Throwable e) {
            throw new NeoAPIException(e, loanPaymentDTO);
        }

    }

    @PostMapping(value = "/pay/without-nfc")
    public ResponseEntity paymentShoppingMode(@RequestBody PaymentShoppingModeRequest paymentShoppingModeRequest, @RequestHeader("Authorization") String token) throws NeoAPIException {

        logger.info("Entering in paymentShoppingMode");
        logger.info("paymentShoppingModeRequest : "+ paymentShoppingModeRequest);

        Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();

        paymentShoppingModeRequest.setMsisdn(msisdn);
        paymentShoppingModeRequest.setSessionId(sessionManager.createSessionId());

        String mensaje = paymentService.paymentShoppingMode(paymentShoppingModeRequest);

        logger.info("Exiting in paymentShoppingMode...");

        return ResponseEntity.ok(mensaje);

    }

    @PostMapping(value = "/merchants/{merchant}/pay")
    public ResponseEntity paymentMerchants(@PathVariable("merchant") long merchant, @RequestBody MerchantPaymentRequest merchantPaymentRequest, @RequestHeader("Authorization") String token) throws NeoAPIException {
        logger.info("Entering in paymentMerchants");
        logger.info("MerchantPaymentRequest : "+ merchantPaymentRequest);
        logger.info("Merchant: "+ merchant);
        try{
        Long msisdn = jwtManager.parseTokenToModel(token).getMsisdn();
        merchantPaymentRequest.setMsisdn(msisdn);
        merchantPaymentRequest.setSessionId(sessionManager.createSessionId());
        TransactionResponseDTO txnResponse = paymentService.paymentMerchantsPay(merchantPaymentRequest, merchant);
        logger.info("Exiting in paymentMerchants...");
        return ResponseEntity.ok(txnResponse);
        } catch (Throwable e) {
            throw new NeoAPIException(e, merchantPaymentRequest);
        }
    }

    */
}
