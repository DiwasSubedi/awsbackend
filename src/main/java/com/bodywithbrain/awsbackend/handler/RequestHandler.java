package com.bodywithbrain.awsbackend.handler;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.bodywithbrain.awsbackend.exceptions.TDMNotFoundException;


/**
 * Provides properties used by the RequestRouter.
 */
public abstract class RequestHandler {
    private final String resource;
    private final HttpMethod method;

    public RequestHandler(HttpMethod method, String resource) {
        this.resource = resource;
        this.method = method;
    }

    public abstract APIGatewayProxyResponseEvent handleRequest(APIGatewayV2ProxyRequestEvent request)
            throws TDMNotFoundException;

    public String getResource() {
        return resource;
    }

    public HttpMethod getMethod() {
        return method;
    }
}
