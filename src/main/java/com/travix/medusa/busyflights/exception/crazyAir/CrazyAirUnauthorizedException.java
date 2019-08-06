package com.travix.medusa.busyflights.exception.crazyAir;

import lombok.Getter;

@Getter
public class CrazyAirUnauthorizedException extends RuntimeException {

    public CrazyAirUnauthorizedException(final String message) {
        super(message);
    }
}
