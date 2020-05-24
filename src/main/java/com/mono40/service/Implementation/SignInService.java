package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.exception.AccountBlockException;
import com.mono40.exception.AccountHasBeenBlockedException;
import com.mono40.exception.InvalidUserException;
import com.mono40.domain.Account;
//import com.mono40.domain.Device;
import com.mono40.types.DeviceInformationType;
import com.mono40.types.SignUpDTO;
import com.mono40.repository.IAccountRepository;
//import com.mono40.repository.IDeviceRepository;
import com.mono40.service.IMailSenderService;
import com.mono40.service.ISignInService;
import com.mono40.util.PasswordGenerator;
import com.mono40.util.PasswordStorage;
//import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yinfante on 10/19/17.
 */
@Service
public class SignInService implements ISignInService {


    @Autowired
    private PasswordStorage passwordStorage;

    @Autowired
    private IAccountRepository accountRepository;



    @Override
    @Transactional
    public void updateInvalidUserAuthentication(Account account) throws AccountBlockException, PasswordStorage.CannotPerformOperationException, IOException, AccountHasBeenBlockedException, InvalidUserException {


        if (account.isBlocked())
            throw new AccountBlockException();

        account.setLoginFailAttempts(account.getLoginFailAttempts() + 1);

        GregorianCalendar lastLoginFail = (GregorianCalendar) Calendar.getInstance();
        GregorianCalendar currentTime = (GregorianCalendar) Calendar.getInstance();

        if (account.getLastLoginFailAttemptTime() != null)
            lastLoginFail.setTime(account.getLastLoginFailAttemptTime());
        else
            lastLoginFail.setTime(new Date());


        if (lastLoginFail.get(Calendar.MONTH) == currentTime.get(Calendar.MONTH)
                && lastLoginFail.get(Calendar.DAY_OF_MONTH) == currentTime.get(Calendar.DAY_OF_MONTH)
                && lastLoginFail.get(Calendar.HOUR) == currentTime.get(Calendar.HOUR)) {


            GregorianCalendar minusRageNumSeconds = (GregorianCalendar) currentTime.clone();
            minusRageNumSeconds.add(Calendar.SECOND, -Integer.valueOf(10));

            if (account.getLoginFailAttempts() >= Integer.valueOf(10)
                    && lastLoginFail.compareTo(minusRageNumSeconds) >= 0
                    && lastLoginFail.compareTo(currentTime) <= 0) {

                account.setBlocked(true);
                account.setPasswordChange(true);
                account.setLastLoginFailAttemptTime(currentTime.getTime());

                String otp = PasswordGenerator.randomPassword();
                String hash = passwordStorage.createHash(otp);

                account.setPassword(hash);

                accountRepository.save(account);

                //mailSenderService.sendBlockUserEmail(account, otp);

                throw new AccountHasBeenBlockedException();
            }

        }
        account.setLastLoginFailAttemptTime(currentTime.getTime());

        accountRepository.save(account);

        throw new InvalidUserException();
    }

    @Override
    @Transactional
    @Async
    public void updateValidUserAuthentication(Account account) {

        account.setLoginFailAttempts(0);
        account.setLastLoginDate(new Date());
        account.setBlocked(false);
        // device.setPinFailAttempts(0);

        accountRepository.save(account);

    }

    @Override
    public SignUpDTO createSignUpDTO(Account account) {

        SignUpDTO signUpDTO = new SignUpDTO();
        signUpDTO.setId(account.getId());
        signUpDTO.setUsername(account.getUserName());
        signUpDTO.setName(account.getName());
        signUpDTO.setLastName(account.getLastName());
        signUpDTO.setPassword("*************************");
        signUpDTO.setEmail(account.getEmail());
        signUpDTO.setMsisdn(8492656223L);
        signUpDTO.setPin("****");
        signUpDTO.setProfilePicUrl(account.getProfilePicUrl());
        signUpDTO.setEmailVerified(account.isEmailVerified());
        signUpDTO.setPasswordChange(account.isPasswordChange());

        return signUpDTO;
    }
}
