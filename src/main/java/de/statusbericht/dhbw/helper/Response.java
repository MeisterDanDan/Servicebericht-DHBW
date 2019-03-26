/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.helper;

import de.statusbericht.dhbw.enums.ResponseStatus;
import java.util.List;

/**
 *
 * @author Dominik Kunzmann
 */
public class Response<E> {

    private List<E> responseList;

    private E response;

    private String message;

    private ResponseStatus status;

    private String exception;
    
    private StackTraceElement[] stackTrace;

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    public List<E> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<E> responseList) {
        this.responseList = responseList;
    }

    public E getResponse() {
        return response;
    }

    public void setResponse(E response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
