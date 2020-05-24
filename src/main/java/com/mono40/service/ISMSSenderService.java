package com.mono40.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yinfante on 2/21/18.
 */
public interface ISMSSenderService {
    @Async
    void sendSMS(Long msisdn, String message);

    @Async
    @Transactional
    void sendActivationCodeSMS(Long msisdn);
}
