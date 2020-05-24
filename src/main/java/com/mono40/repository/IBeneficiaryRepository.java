package com.mono40.repository;

import com.mono40.domain.Account;
import com.mono40.domain.Beneficiary;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface IBeneficiaryRepository extends CrudRepository<Beneficiary, Long>{

    Set<Beneficiary> findByAccountOrderById(Account account);
    Beneficiary findByAccountAndDetail(Account account, String detail);

}
