package com.mono40.types.exception;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * Created by yarielinfante on 2/6/17.
 */
public class ExpiredSessionException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public ExpiredSessionException(ExpiredJwtException expiredJwtException) {
        super(expiredJwtException);
    }
}
