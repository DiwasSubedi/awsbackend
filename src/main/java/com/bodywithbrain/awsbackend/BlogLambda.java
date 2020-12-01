package com.bodywithbrain.awsbackend;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.bodywithbrain.awsbackend.config.DaggerBlogComponent;
import com.bodywithbrain.awsbackend.controller.RequestRouter;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class BlogLambda implements RequestHandler<APIGatewayV2ProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    RequestRouter router;


    public BlogLambda() {
        DaggerBlogComponent.builder().build().inject(this);
    }

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayV2ProxyRequestEvent request, Context context) {
        return router.getHandler(HttpMethod.valueOf(request.getHttpMethod()), request.getPath())
                .handleRequest(request);

    }


}
