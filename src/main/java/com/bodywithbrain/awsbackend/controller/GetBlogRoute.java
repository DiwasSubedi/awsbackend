package com.bodywithbrain.awsbackend.controller;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.bodywithbrain.awsbackend.handler.RequestHandler;
import com.bodywithbrain.awsbackend.services.BlogService;
import com.bodywithbrain.awsbackend.services.LambdaHelper;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetBlogRoute extends RequestHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    BlogService blogService;

    @Inject
    public GetBlogRoute(BlogService blogService) {
        super(HttpMethod.GET, "/blog");
        this.blogService = blogService;
    }


    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayV2ProxyRequestEvent request) {
             String user = request.getQueryStringParameters().get("user");
             return LambdaHelper.getResponseEvent(HttpStatus.SC_OK, blogService.getBlogs(user));
    }
}
