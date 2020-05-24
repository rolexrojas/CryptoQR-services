package com.mono40.repository;

import com.mono40.domain.AttemptPinInvalidMsisdn;
import org.springframework.data.repository.CrudRepository;

public interface IAttemptPinInvalidMsisdnRepository extends CrudRepository<AttemptPinInvalidMsisdn, Long> {

    AttemptPinInvalidMsisdn findByMsisdn(Long msisdn);

}
