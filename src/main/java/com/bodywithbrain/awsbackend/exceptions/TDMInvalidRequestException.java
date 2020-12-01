package com.bodywithbrain.awsbackend.exceptions;

public class TDMInvalidRequestException extends  Exception{
    public TDMInvalidRequestException(String message) {
        super(message);
    }

    public TDMInvalidRequestException(String message, Exception ex) {
        super(message, ex);
    }
}
