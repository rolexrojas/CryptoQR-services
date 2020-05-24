package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.ICashAdvanceService;
import com.mono40.types.TransactionResponseDTO;
//import com.mono40.types.TransferGcsToOwnAccount;
import com.mono40.util.SessionManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yinfante on 5/29/17.
 */
@Service
public class CashAdvanceService implements ICashAdvanceService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private SessionManager sessionManager;

    private Logger logger = Logger.getLogger(CashAdvanceService.class);

  /*  @Override
    public TransactionResponseDTO postCashAdvance(TransferGcsToOwnAccount request) {
        logger.info("sending call transaxion cash advance ");
        String sessionId = sessionManager.createSessionId();
        request.setSessionId(sessionId);
        request.setLangPref("spanish");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/cash-advance", request, TransactionResponseDTO.class);
    }*/
}
