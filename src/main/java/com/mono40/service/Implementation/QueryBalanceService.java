package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IPayableAccountTypeService;
import com.mono40.service.IQueryBalanceService;
import com.mono40.types.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yinfante on 10/24/16.
 */
@Service
public class QueryBalanceService implements IQueryBalanceService {

    private Logger logger = LogManager.getLogger(QueryBalanceService.class);


    @Override
    public Account[] loadAccounts(Long msisdn) {

        RestTemplate restTemplate = new RestTemplate();

       // Account[] accounts = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/query-balance/accounts/" + msisdn.toString(), Account[].class);
        BankDTO bankDTO = new BankDTO();
        bankDTO.setActive(true);
        bankDTO.setBankPartnerId("102");
        bankDTO.setBankPartnerCode(BigDecimal.valueOf(5));
        bankDTO.setBankLogoURI("");
        bankDTO.setBankPartnerName("Banco Popular");

        Account account = new Account();
        account.setPayable(true);
        account.setAccountAlias("");
        account.setAccountNumber("");
        account.setAccountType("LOAN");
        account.setAltPanKey("");
        account.setBank(bankDTO);
        account.setCurrency("DOP");
        account.setDefaultAccount(true);
        account.setPriority(0);
        account.setQueryFee(BigDecimal.valueOf(0.00));
        Account[] accounts = new Account[]{account};

        return accounts;
    }

    @Override
    public CreditCard[] loadCreditCards(Long msisdn) {

        RestTemplate restTemplate = new RestTemplate();
        BankDTO bankDTO = new BankDTO();
        bankDTO.setActive(true);
        bankDTO.setBankPartnerId("102");
        bankDTO.setBankPartnerCode(BigDecimal.valueOf(5));
        bankDTO.setBankLogoURI("");
        bankDTO.setBankPartnerName("Banco Popular");
      //  CreditCard[] creditCards = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/query-balance/credit-cards/" + msisdn.toString(), CreditCard[].class);
        CreditCard creditCard = new CreditCard();
        creditCard.setImageUrl("");
        creditCard.setPayable(false);
        creditCard.setAccountAlias("");
        creditCard.setAccountNumber("");
        creditCard.setAccountType("CC");
        creditCard.setAltPanKey("");
        creditCard.setBank(bankDTO);
        creditCard.setCurrency("");
        creditCard.setDefaultAccount(false);
        creditCard.setPriority(0);
        creditCard.setQueryFee(new BigDecimal(0.00));

        CreditCard[] creditCards = new CreditCard[]{ creditCard };
        return creditCards;
    }

    @Override
    public Loan[] loadLoan(Long msisdn) {

        RestTemplate restTemplate = new RestTemplate();

       // Loan[] loans = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/query-balance/loans/" + msisdn.toString(), Loan[].class);
        BankDTO bankDTO = new BankDTO();
        bankDTO.setActive(true);
        bankDTO.setBankPartnerId("102");
        bankDTO.setBankPartnerCode(BigDecimal.valueOf(5));
        bankDTO.setBankLogoURI("");
        bankDTO.setBankPartnerName("Banco Popular");


        Loan loan = new Loan();
        loan.setPayable(false);
        loan.setAccountAlias("LOAN");
        loan.setAccountNumber("");
        loan.setAccountType("LOAN");
        loan.setAltPanKey("");
        loan.setBank(bankDTO);
        loan.setCurrency("");
        loan.setDefaultAccount(false);
        loan.setPriority(0);
        loan.setQueryFee(BigDecimal.valueOf(0.00));
        Loan[] loans = new Loan[]{ loan };
        return loans;
    }

/*
    @Override
    public QueryBalanceResponse accountBalance(QueryBalance queryBalance) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/query-balance/accounts";
        QueryBalanceResponse queryBalanceResponse = rt.postForObject(uri, queryBalance, QueryBalanceResponse.class);

        return queryBalanceResponse;

    }

    @Override
    public QueryBalanceResponse creditCardBalance(QueryBalance queryBalance) {

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/query-balance/credit-cards";
        QueryBalanceResponse queryBalanceResponse = rt.postForObject(uri, queryBalance, QueryBalanceResponse.class);

        return queryBalanceResponse;

    }

    @Override
    public LoanBalanceResponse loanBalance(QueryBalance queryBalance) {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = applicationProperties.getTransaxionAddress() + "/query-balance/loans";
        LoanBalanceResponse loanBalanceResponse = rt.postForObject(uri, queryBalance, LoanBalanceResponse.class);

        return loanBalanceResponse;
    }


    private <E extends QueryDTO> E[] validatePayableValue(E[] e) {

        List<String> accountTypes = payableAccountTypeService.getAccountTypes();
        logger.info(accountTypes);

        for (QueryDTO dto : e) {
            dto.setPayable(accountTypes.contains(dto.getAccountType()));
        }

        return e;
    }*/
}
