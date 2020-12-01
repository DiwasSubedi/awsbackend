package com.bodywithbrain.awsbackend.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;


@Module
public class AmazonDynamoDbConfig {


    public AmazonDynamoDB amazonDynamoDBCloud() {
        return AmazonDynamoDBClient.builder().withRegion(Regions.US_WEST_2).build();
    }

    @Provides
    @Singleton
    public AmazonDynamoDB amazonDynamoDB() {
            return amazonDynamoDBCloud();
    }
}
