package com.mono40.util;

import com.mono40.domain.Account;
import com.mono40.exception.InvalidEmailException;
import com.mono40.exception.InvalidImeiException;
import com.mono40.exception.InvalidMsisdnException;
import com.mono40.exception.PasswordDoesNotMeetTheRequirementsException;
import com.mono40.types.SignUpDTO;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mono40.util.ConstantsUtil.*;

public class SignUpUtil {

    private SignUpUtil(){

    }

    public static void setEntitiesProfile(SignUpDTO informationSignUp, Account account){


        account.setName(informationSignUp.getName());
        account.setLastName(informationSignUp.getLastName());
        account.setEmail(informationSignUp.getEmail());
        account.setUserName(informationSignUp.getUsername());
        account.setCreationDate(new Date());

    }

    public static boolean patternCorrect(String text, final String regex) {

        if(EMAIL_REGEX.equalsIgnoreCase(regex)){
            text = text.toLowerCase();
        }
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
