package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IChangePinService;
//import com.mono40.types.ChangePinRequest;
import com.mono40.util.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *  Created by jedeleon on 8/23/18.
 */
@Service
public class ChangePinService implements IChangePinService {

    private Logger logger = LogManager.getLogger(ChangePinService.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private SessionManager sessionManager;


  /*  @Override
    public String changePin(ChangePinRequest changePinRequest) {

        logger.info("Entered changePin");

        String sessionId = sessionManager.createSessionId();

        changePinRequest.setLangPref("spanish");
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(applicationProperties.getTransaxionAddress() + "/change-pin?sessionId=" + sessionId, changePinRequest, String.class);

    }*/
}
