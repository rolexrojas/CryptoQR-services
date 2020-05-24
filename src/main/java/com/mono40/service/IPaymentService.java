package com.mono40.service;

import com.mono40.types.*;
//import com.mono40.types.PaymentShoppingModeRequest;
//import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;

/**
 * Created by yinfante on 2/21/18.
 */
public interface IPaymentService {
    List<CustomerInvoice> getBills(Long msisdn);
    List<PartnerDTO> partners();
    /*
    boolean changeDefaultAccount(ChangeAccountDTO accountDTO);





    void addInvoice(InvoiceDTO invoiceDTO);

    ClientInvoiceResponse getClientInvoices(ClientInvoiceRequest clientInvoiceRequest);

    void removeInvoice(InvoiceDTO invoiceDTO);

    InvoiceDetail getBalance(InvoiceDTO invoiceDTO);

    TransactionResponseDTO invoicePayment(PaymentInvoiceDTO paymentInvoiceDTO);

    CustomerDetail getCustomerDetail(Long msisdn);

    CreditCardResponseDTO getCreditCardBin(CreditCardInfoDTO creditCardInfoDTO);

    CreditCardBalanceResponse getCreditCardBalance(CreditCardBalance creditCardBalance);

    TransactionResponseDTO creditCardPayment(CreditCardPaymentDTO creditCardPaymentDTO);

    LoanBalanceResponse getLoanBalance(LoanBalance loanBalance);

    TransactionResponseDTO loanPayment(LoanPaymentDTO loanPaymentDTO);

    String paymentShoppingMode(PaymentShoppingModeRequest paymentShoppingModeRequest);

    TransactionResponseDTO paymentMerchantsPay(MerchantPaymentRequest merchantPaymentRequest, long merchantId) throws IOException, TemplateException;


     */
}
