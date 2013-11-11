package com.fbratu.relevant.ws.iface;

/**
 * Author: Florin
 */
public class LookupException extends Exception {
    public LookupException() {
        super();
    }

    public LookupException(String message) {
        super(message);
    }

    public LookupException(Throwable cause) {
        super(cause);
    }

    public LookupException(String message, Throwable cause) {
        super(message, cause);
    }
}
