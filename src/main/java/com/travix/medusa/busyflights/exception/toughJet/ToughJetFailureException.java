package com.travix.medusa.busyflights.exception.toughJet;


public class ToughJetFailureException extends RuntimeException {

    public ToughJetFailureException(final String message) {
        super(message);
    }

    public ToughJetFailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
