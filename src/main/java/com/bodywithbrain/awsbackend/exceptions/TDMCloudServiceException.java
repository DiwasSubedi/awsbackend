package com.bodywithbrain.awsbackend.exceptions;

public class TDMCloudServiceException  extends  Exception{
    public TDMCloudServiceException(String message) {
        super(message);
    }

    public TDMCloudServiceException(String message, Exception ex) {
        super(message, ex);
    }

}
