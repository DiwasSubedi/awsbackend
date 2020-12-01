package com.bodywithbrain.awsbackend.exceptions;

public class TDMNotFoundException extends  Exception{
    public TDMNotFoundException(String message) {
        super(message);
    }

    public TDMNotFoundException(String message, Exception ex) {
        super(message, ex);
    }

}