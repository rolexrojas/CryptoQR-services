package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class NeoAPIException extends Exception {

    public enum ExceptionLevel {
        FATAL,
        ERROR,
        WARN
    }



    private Object requestParams;
    private ExceptionLevel exceptionLevel = ExceptionLevel.ERROR;


    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public NeoAPIException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NeoAPIException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public NeoAPIException(String message, Throwable cause, Object requestParams) {
        super(message, cause);
        this.requestParams = requestParams;
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public NeoAPIException(Throwable cause, Object requestParams) {
        super(cause);
        this.requestParams = requestParams;
    }


    public NeoAPIException(Throwable cause) {
        super(cause);
    }


    public NeoAPIException(Object requestParams){
        this.requestParams = requestParams;
    }

    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 1.7
     */
    public NeoAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public Object getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(Object requestParams) {
        this.requestParams = requestParams;
    }

    public ExceptionLevel getExceptionLevel() {
        return exceptionLevel;
    }

    public void setExceptionLevel(ExceptionLevel exceptionLevel) {
        this.exceptionLevel = exceptionLevel;
    }
}
