package com.mono40.types.exception;

/**
 * Created by yinfante on 10/19/17.
 */
public class PinBlockedException extends NeoAPIException {

    public PinBlockedException() {
        super();
    }

    public PinBlockedException(Object requestParams) {
        super(requestParams);
    }

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

}
