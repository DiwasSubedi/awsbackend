package com.bodywithbrain.awsbackend.controller;


import com.amazonaws.HttpMethod;

import com.bodywithbrain.awsbackend.exceptions.TDMNotFoundException;
import com.bodywithbrain.awsbackend.handler.RequestHandler;
import org.apache.http.MethodNotSupportedException;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles route resolution.
 */
public class RequestRouter {


    private final Map<String, Map<HttpMethod, RequestHandler>> handlers = new HashMap<>();
    public Map<String, Map<HttpMethod, RequestHandler>> getHandlers() {
        return handlers;
    }

    /**
     * Registers a handler for a given route.
     *
     * @param handler the handler for the route.
     */
    public void register(RequestHandler handler) {

       // Map<HttpMethod, RequestHandler> supportedMethods = new HashMap<HttpMethod, RequestHandler>();
        if (!hasResource(handler)) {
            getHandlers().put(handler.getResource(), new HttpMethodRequestHandlerHashMap(handler));
           // supportedMethods.put(handler.getMethod(), handler);
        } else {
            if (getHandlers().get(handler.getResource()).keySet().contains(handler.getMethod())) {
                throw new IllegalStateException("Handler already registered for "
                        + handler.getMethod() + " " + handler.getResource());
            } else {
                getHandlers().get(handler.getResource()).put(handler.getMethod(), handler);
            }
        }
    }

    private boolean hasResource(RequestHandler handler) {
        return getHandlers().containsKey(handler.getResource());
    }

    /**
     * Resolves the handler for a given route.
     *
     * @param method   the method used.
     * @param resource the API Gateway resource (route path).
     * @return the handler for the specified route.
     * @throws MethodNotSupportedException thrown for unregistered methods.
     * @throws TDMNotFoundException           thrown for unregistered routes.
     */
    public RequestHandler getHandler(HttpMethod method, String resource)
            throws TDMNotFoundException {
        Map<HttpMethod, RequestHandler> supportedMethods = handlers.get(resource);

        if (supportedMethods == null) {
            throw new TDMNotFoundException("Resource not found");
        }

        if (!supportedMethods.containsKey(method)) {
            throw new TDMNotFoundException("Http Method Not Supported.");
        }

        return supportedMethods.get(method);
    }

    private static class HttpMethodRequestHandlerHashMap extends HashMap<HttpMethod, RequestHandler> {
        private static final long serialVersionUID = 1;
        public HttpMethodRequestHandlerHashMap(RequestHandler handler) {
            put(handler.getMethod(), handler);
        }
    }
}
