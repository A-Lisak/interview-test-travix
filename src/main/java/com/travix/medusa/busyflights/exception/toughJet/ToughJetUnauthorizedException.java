package com.travix.medusa.busyflights.exception.toughJet;

import lombok.Getter;

@Getter
public class ToughJetUnauthorizedException extends RuntimeException {

    public ToughJetUnauthorizedException(final String message) {
        super(message);
    }
}
