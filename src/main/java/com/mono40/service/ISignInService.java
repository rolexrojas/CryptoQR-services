package com.mono40.service;

import com.mono40.domain.Account;
import com.mono40.types.SignInDTO;
import com.mono40.types.SignUpDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yinfante on 2/21/18.
 */
public interface ISignInService {
    @Transactional
    void updateInvalidUserAuthentication(Account account) throws Exception;

    @Transactional
    @Async
    void updateValidUserAuthentication(Account account);

    @Transactional
    SignUpDTO createSignUpDTO(Account account);

}
