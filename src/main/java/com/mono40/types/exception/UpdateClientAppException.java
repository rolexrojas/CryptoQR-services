package com.mono40.types.exception;

public class UpdateClientAppException extends NeoAPIException {

    public UpdateClientAppException() {
        super();
    }

    public UpdateClientAppException(Object requestParams) {
        super(requestParams);
    }

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }
}
