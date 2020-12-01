package com.bodywithbrain.awsbackend.services;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LambdaHelper {

    public static ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());


    private static final Logger LOGGER = LogManager.getLogger();



    public static APIGatewayProxyResponseEvent getResponseEvent(Integer status, Object result) throws JsonProcessingException {
        if(result instanceof String){
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(Integer.valueOf(status)).withBody(result.toString());
        }else{
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            LOGGER.info(mapper.writeValueAsString(result));
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(Integer.valueOf(status)).withBody(mapper.writeValueAsString(result));
        }
    }

}
