package com.mono40.repository;

import com.mono40.domain.AccountEventInsurance;
import org.springframework.data.repository.CrudRepository;

public interface IAccountEventRepository extends CrudRepository<AccountEventInsurance, Long> {

}
