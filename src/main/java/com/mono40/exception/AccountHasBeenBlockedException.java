package com.mono40.exception;

/**
 * Created by yinfante on 6/26/17.
 */
public class AccountHasBeenBlockedException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }
}
