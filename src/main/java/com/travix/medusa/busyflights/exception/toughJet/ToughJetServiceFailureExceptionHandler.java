package com.travix.medusa.busyflights.exception.toughJet;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@Slf4j
public class ToughJetServiceFailureExceptionHandler {

    private String version;

    @Autowired
    public ToughJetServiceFailureExceptionHandler(@Value("${application.version}") final String version) {
        this.version = version;
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final ToughJetFailureException exception) {
        log.error("ToughJetFailureException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_SERVICE_FAILURE);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final ToughJetNotFoundException exception) {
        log.error("ToughJetNotFoundException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_NOT_FOUND);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final IllegalArgumentException exception) {
        log.error("IllegalArgumentException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_BAD_REQUEST);
    }

    @ResponseStatus(OK)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final ToughJetException exception) {
        log.error("ToughJetException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_EXCEPTION);
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final Exception exception) {
        log.error("Exception: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.UNEXPECTED_ERROR);
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final ToughJetUnauthorizedException exception) {
        log.error("MotorPolicyUnauthorisedException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_UNAUTHORISED_FORBIDDEN);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    protected ToughJetResponse handle(final InvalidRequestException exception) {
        log.error("InvalidRequestException: {}", exception.getMessage(), exception);
        return buildServiceError(ToughJetError.TOUGH_JET_BAD_REQUEST);
    }

    private ToughJetResponse buildServiceError(final ToughJetError motorPolicyError) {
        return new ToughJetResponse();
              
    }
}
