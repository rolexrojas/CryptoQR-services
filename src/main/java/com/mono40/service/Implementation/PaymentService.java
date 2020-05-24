package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
//import com.mono40.domain.Device;
//import com.mono40.repository.IDeviceRepository;
import com.mono40.service.IMailSenderService;
import com.mono40.service.IPaymentService;
import com.mono40.types.*;
//import com.mono40.types.PaymentShoppingModeRequest;
import com.mono40.util.NeoUtil;
//import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yarielinfante on 12/1/16.
 */
@Service
public class PaymentService implements IPaymentService {


  /*  @Override
    public boolean changeDefaultAccount(ChangeAccountDTO accountDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/change-default-account";

        rt.postForObject(uri, accountDTO, Object.class);

        return true;
    }*/


    @Override
    public List<PartnerDTO> partners() {


        RestTemplate restTemplate = new RestTemplate();


        //PartnerDTO[] partnerDTOs = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/payments/partners", PartnerDTO[].class);

        PartnerDTO partner = new PartnerDTO();
        partner.setPartnerId("01");
        partner.setPartnerCode(BigDecimal.valueOf(01));
        partner.setImageUrl("");
        partner.setPartnerName("MAGNA_MOTORS");
        partner.setPartnerType("01");
        List<PartnerDTO> listado = new ArrayList<>();
        listado.add(partner);
        //PartnerDTO[] partnerDTOs = partner;

        return listado;

    }

    @Override
    public List<CustomerInvoice> getBills(Long msisdn) {


        PartnerDTO partner = new PartnerDTO();
        partner.setPartnerId("01");
        partner.setPartnerCode(BigDecimal.valueOf(01));
        partner.setImageUrl("");
        partner.setPartnerName("MAGNA_MOTORS");
        partner.setPartnerType("01");
        List<PartnerDTO> listado = new ArrayList<>();
        listado.add(partner);
        RestTemplate restTemplate = new RestTemplate();


        //CustomerInvoice[] partnerDTOs = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/payments/invoices/" + msisdn, CustomerInvoice[].class);

        CustomerInvoice invoice = new CustomerInvoice();
        invoice.setPartner(partner);
        invoice.setContract("00");
        CustomerInvoice[] partnerDTOs = new CustomerInvoice[]{ invoice };
        return Arrays.asList(partnerDTOs);

    }


   /* @Override
    public void addInvoice(InvoiceDTO invoiceDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/invoices";

        rt.postForObject(uri, invoiceDTO, Object.class);

    }

    @Override
    public ClientInvoiceResponse getClientInvoices(ClientInvoiceRequest clientInvoiceRequest) {
        RestTemplate rt = new RestTemplate();
        String uri = applicationProperties.getTransaxionAddress() + "/payments/invoices/contract/client";
        return rt.postForObject(uri, clientInvoiceRequest, ClientInvoiceResponse.class);
    }

    @Override
    public void removeInvoice(InvoiceDTO invoiceDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/remove-invoice";

        rt.postForObject(uri, invoiceDTO, Object.class);

    }

    @Override
    public InvoiceDetail getBalance(InvoiceDTO invoiceDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/invoices/balance";

        return rt.postForObject(uri, invoiceDTO, InvoiceDetail.class);

    }


    @Override
    public TransactionResponseDTO invoicePayment(PaymentInvoiceDTO paymentInvoiceDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/invoices/pay";

        return rt.postForObject(uri, paymentInvoiceDTO, TransactionResponseDTO.class);
    }

    @Override
    public CustomerDetail getCustomerDetail(Long msisdn) {

        try {

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/payments/customer/" + msisdn, CustomerDetail.class);

        } catch (Throwable e) {

            logger.error("Request param: " + msisdn, e);

            return null;
        }
    }

    @Override
    public CreditCardResponseDTO getCreditCardBin(CreditCardInfoDTO creditCardInfoDTO) {

        try {

            RestTemplate rt = new RestTemplate();
            rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());

            String uri = applicationProperties.getNeoBridgeAddress() + "/credit-card/info";

            return rt.postForObject(uri, creditCardInfoDTO, CreditCardResponseDTO.class);

        } catch (Throwable e) {

            logger.error("Request param: " + creditCardInfoDTO, e);

            return null;
        }
    }

    @Override
    public CreditCardBalanceResponse getCreditCardBalance(CreditCardBalance creditCardBalance) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/credit-cards/balance";

        return rt.postForObject(uri, creditCardBalance, CreditCardBalanceResponse.class);

    }


    @Override
    public TransactionResponseDTO creditCardPayment(CreditCardPaymentDTO creditCardPaymentDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/credit-cards/pay";

        return rt.postForObject(uri, creditCardPaymentDTO, TransactionResponseDTO.class);
    }

    @Override
    public LoanBalanceResponse getLoanBalance(LoanBalance loanBalance) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/loans/balance";

        return rt.postForObject(uri, loanBalance, LoanBalanceResponse.class);
    }

    @Override
    public TransactionResponseDTO loanPayment(LoanPaymentDTO loanPaymentDTO) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/payments/loans/pay";

        return rt.postForObject(uri, loanPaymentDTO, TransactionResponseDTO.class);

    }

    @Override
    public String paymentShoppingMode(PaymentShoppingModeRequest paymentShoppingModeRequest) {

        logger.info("Entering in paymentShoppingMode...");
        logger.info("paymentShoppingModeRequest : "+ paymentShoppingModeRequest);

        RestTemplate rt = new RestTemplate();
        String uri = applicationProperties.getTransaxionAddress() + "/payments/pay/without-nfc/";

        String message = rt.postForObject(uri, paymentShoppingModeRequest, String.class);


        logger.info("returning message "+ message);

        return message;

    }

    @Override
    public TransactionResponseDTO paymentMerchantsPay(MerchantPaymentRequest merchantPaymentRequest, long merchantId) throws IOException, TemplateException {
        logger.info("Entering in paymentMerchantsPay...");
        logger.info("merchantPaymentRequest : "+ merchantPaymentRequest);
        logger.info("merchantId : "+ merchantId);

        logger.info("search name and email by msisdn ");
        Device activeDevice = deviceRepository.findFirstByMsisdnAndActiveIsTrueOrderByIdDesc(merchantPaymentRequest.getMsisdn());
        logger.info("finish search name and email by msisdn ");

        //prepared call to Core
        logger.info("begin prepared body for paymentShoppingMode");
        PaymentShoppingModeRequest request = new PaymentShoppingModeRequest();
        request.setSessionId(merchantPaymentRequest.getSessionId());
        request.setPin(merchantPaymentRequest.getPin());
        request.setMsisdn(merchantPaymentRequest.getMsisdn());
        request.setFundingAccount(merchantPaymentRequest.getFundingAccount());
        //disable Push for merchants pay / activate buy in merchants
        logger.info("send param "+request);
        logger.info("call paymentShoppingMode");
        String responseCore = paymentShoppingMode(request);
        logger.info("paymentShoppingMode response : "+responseCore);

        //prepared call to TPagoNet
        logger.info("begin prepared body for TPagoNet tPagoNetpaymentRequest");
        TPagoNetMerchantPaymentRequest requestTpagoNet = new TPagoNetMerchantPaymentRequest();
        requestTpagoNet.setMsisdn(merchantPaymentRequest.getMsisdn().toString());
        requestTpagoNet.setApiVersion(applicationProperties.getTpagoNetApiVersion());
        requestTpagoNet.setAmount(merchantPaymentRequest.getAmount());
        requestTpagoNet.setCurrency(applicationProperties.getTpagoNetApiCurrency());
        requestTpagoNet.setInvoice(NeoUtil.generateTimeUnixFormat().toString());
        requestTpagoNet.setSessionKey(NeoUtil.generateTimeUnixFormat().toString());

        Date transactionDate = new Date();

        requestTpagoNet.setTransactionDate(NeoUtil.formatDateToString(transactionDate, "yyyy-MM-dd'T'HH:mm:ss"));
        requestTpagoNet.setCustomerName(activeDevice.getAccount().getName());
        requestTpagoNet.setCustomerEmail(activeDevice.getAccount().getEmail());
        logger.info("send param "+requestTpagoNet);
        logger.info("call tPagoNetpaymentRequest");
        TPagoNetMerchantPaymentResponse response = tPagoNetService.tPagoNetPaymentRequest(requestTpagoNet, merchantId);
        logger.info("tPagoNetPaymentRequest response : "+response);

        logger.info("call tPagoNetPaymentQuery for check status");
        logger.info("param transactionId : "+response.getTransactionId() );
        logger.info("param merchantId : "+ merchantId);

        //prepared call to TPagoNet for transaction status verification

        TPagoNetPaymentQueryResponse queryResponse = tPagoNetService.tPagoNetPaymentQuery(response.getTransactionId(), merchantId);
        logger.info("response tPagoNetPaymentQuery for check status : "+ queryResponse);

        if(!"0000".equals(queryResponse.getResponseCode())){
            logger.info("transaction status failed ");
            logger.info("response error code "+ queryResponse.getResponseCode());
            throw new IOException();
        }
        logger.info("transaction status successfully ");
        logger.info("send email notification");

        String parsedSessionId = merchantPaymentRequest.getSessionId().replace("NEO","");
        String formatedTransactionDate = NeoUtil.formatDateToString(transactionDate, "dd/M/yyyy hh:mm a");

        mailSenderService.sendPaymentNotification(
                activeDevice.getAccount().getName(),
                activeDevice.getAccount().getLastName(),
                requestTpagoNet.getAmount(),
                requestTpagoNet.getCurrency(),
                merchantPaymentRequest.getFundingAccount().getAccountNumber(),
                merchantPaymentRequest.getMerchantDescription(),
                formatedTransactionDate,
                parsedSessionId,
                activeDevice.getAccount().getEmail()
        );

        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setTransactionId(response.getTransactionId());
        responseDTO.setTransactionMessage("Pago Realizado Exitosamente! "+ response.getTransactionId());
        logger.info("returning response: "+responseDTO);
        return responseDTO;
    }*/
}
