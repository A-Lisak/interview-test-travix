package com.travix.medusa.busyflights.exception.crazyAir;


public class CrazyAirFailureException extends RuntimeException {

    public CrazyAirFailureException(final String message) {
        super(message);
    }

    public CrazyAirFailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
