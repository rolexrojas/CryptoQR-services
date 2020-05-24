package com.mono40.repository;

import com.mono40.domain.MsisdnEmailActivationCode;
import org.springframework.data.repository.CrudRepository;


public interface IMsisdnEmailActivationCodeRepository extends CrudRepository<MsisdnEmailActivationCode, Long> {

    MsisdnEmailActivationCode findFirstByMsisdnAndEmailOrderByCreationDateDesc(Long msisdn, String email);

    MsisdnEmailActivationCode findFirstByMsisdnAndEmailAndIsValidIsTrueOrderByVerificationDateDesc(Long msisdn, String email);

}
