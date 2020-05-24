package com.mono40.repository;

import com.mono40.domain.MsisdnActivationCode;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


public interface IMsisdnActivationCodeRepository extends CrudRepository<MsisdnActivationCode, Long> {

    @Transactional
    void deleteByMsisdn(Long msisdn);
    MsisdnActivationCode findByMsisdn(Long msisdn);
    MsisdnActivationCode findByMsisdnAndOtpValid(Long msisdn, boolean isOtpvalid);

}
