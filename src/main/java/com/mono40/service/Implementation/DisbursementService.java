package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IDisbursementService;
import com.mono40.types.*;
import com.mono40.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yinfante on 8/3/17.
 */
@Service
public class DisbursementService implements IDisbursementService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private SessionManager sessionManager;

  /*  @Override
    public List<BankDisbursementDTO> getBanks(Long msisdn) {

        RestTemplate restTemplate = new RestTemplate();

        BankDisbursementDTO[] bankDTOs = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/disbursement/banks/" + msisdn, BankDisbursementDTO[].class);

        return Arrays.asList(bankDTOs);
    }

    @Override
    public SAAvailableAmountResponseDTO getAvailableAmount(SAAvailableAmountDTO saAvailableAmountDTO, String transaction) {

        String sessionId = sessionManager.createSessionId();
        saAvailableAmountDTO.setSessionId(sessionId);
        saAvailableAmountDTO.setLangPref("spanish");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/disbursement/available-amount/" + transaction, saAvailableAmountDTO, SAAvailableAmountResponseDTO.class);
    }

    @Override
    public SAAmountOfFeesResponseDTO getAmountFees(SAAmountOfFeesDTO saAmountOfFeesDTO, String transaction) {

        String sessionId = sessionManager.createSessionId();
        saAmountOfFeesDTO.setSessionId(sessionId);
        saAmountOfFeesDTO.setLangPref("spanish");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/disbursement/amount-fees/" + transaction, saAmountOfFeesDTO, SAAmountOfFeesResponseDTO.class);
    }

    @Override
    public SACalculateFeeResponseDTO calculateFee(SACalculateFeeDTO saCalculateFeeDTO, String transaction) {

        String sessionId = sessionManager.createSessionId();
        saCalculateFeeDTO.setSessionId(sessionId);
        saCalculateFeeDTO.setLangPref("spanish");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/disbursement/calculate-fee/" + transaction, saCalculateFeeDTO, SACalculateFeeResponseDTO.class);
    }

    @Override
    public TransactionResponseDTO confirmTransaction(SalaryAdvanceDTO salaryAdvanceDTO, String transaction) {

        String sessionId = sessionManager.createSessionId();
        salaryAdvanceDTO.setSessionId(sessionId);
        salaryAdvanceDTO.setLangPref("spanish");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/disbursement/confirm/" + transaction, salaryAdvanceDTO, TransactionResponseDTO.class);
    }*/


}
