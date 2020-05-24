package com.mono40.repository;

import com.mono40.domain.Account;
import com.mono40.domain.AccountPublicKey;
import org.springframework.data.repository.CrudRepository;

public interface IAccountPublicKeyRepository extends CrudRepository<AccountPublicKey, Long> {

    AccountPublicKey findByAccount(Account account);
}
