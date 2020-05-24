package com.mono40.component;

import org.springframework.stereotype.Component;

@Component
public class ValidatorComponent {

    public boolean isValidUsername(String username){

        return true;
    }

    public boolean isValidPassword(String password){

        return true;
    }

    public boolean isValidAccountKey(String accountKey){

        return true;
    }

    public boolean isAccountKeyActive(String accountKey){
        return true;
    }
}
