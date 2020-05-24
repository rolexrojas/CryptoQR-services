package com.mono40.repository;

import com.mono40.domain.Account;
import org.springframework.data.repository.CrudRepository;


public interface IAccountRepository extends CrudRepository<Account, Long> {

    Account findByUserNameIgnoreCase(String userName);

    Account findByEmail(String email);
}
