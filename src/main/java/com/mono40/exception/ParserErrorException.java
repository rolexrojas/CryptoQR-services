package com.mono40.exception;

public class ParserErrorException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public ParserErrorException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public ParserErrorException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }


    public ParserErrorException(Object requestParams) {
        super(requestParams);
    }
}
