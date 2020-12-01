package com.bodywithbrain.awsbackend.controller;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.bodywithbrain.awsbackend.handler.RequestHandler;
import com.bodywithbrain.awsbackend.model.BwbBlog;
import com.bodywithbrain.awsbackend.services.BlogService;
import com.bodywithbrain.awsbackend.services.LambdaHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateBlogRoute extends RequestHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    BlogService blogService;

    ObjectMapper mapper;

    @Inject
    public CreateBlogRoute(BlogService blogService,ObjectMapper mapper) {
        super(HttpMethod.POST, "/blog");
        this.blogService = blogService;
        this.mapper = mapper;
    }


    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayV2ProxyRequestEvent request) {

            BwbBlog bwbBlog = mapper.readValue(request.getBody(),BwbBlog.class);
            return LambdaHelper.getResponseEvent(HttpStatus.SC_CREATED, blogService.saveBlog(bwbBlog));
    }

}
