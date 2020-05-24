package com.mono40.exception;

/**
 * Created by yinfante on 6/26/17.
 */
public class AccountUserInactiveException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }
}
