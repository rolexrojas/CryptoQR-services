package com.mono40.types.exception;

public class AttributeValueNotAllowException extends Exception {

    private static final int CODIGO = 0031;
    private static final String MESSAGE = "Datos con valores no permitidos";

    public AttributeValueNotAllowException() {
        super(MESSAGE +" "+CODIGO);
    }

    public AttributeValueNotAllowException(String message) {
        super(message);
    }

    public AttributeValueNotAllowException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributeValueNotAllowException(Throwable cause) {
        super(cause);
    }

    protected AttributeValueNotAllowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
