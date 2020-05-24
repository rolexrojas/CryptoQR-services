package com.mono40.types.exception;

public class AttributeRequiredNoProvidedException extends  Exception{

    private static final int CODIGO = 0030;
    private static final String MESSAGE = "Dato Requerido No Proporcionado.";


    public AttributeRequiredNoProvidedException() {
        super(MESSAGE +" "+CODIGO);
    }

    private AttributeRequiredNoProvidedException(String message) {
        super(message);
    }

    public AttributeRequiredNoProvidedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributeRequiredNoProvidedException(Throwable cause) {
        super(cause);
    }

    protected AttributeRequiredNoProvidedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
