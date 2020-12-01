package com.bodywithbrain.awsbackend.config;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.bodywithbrain.awsbackend.model.BwbBlog;
import com.bodywithbrain.awsbackend.services.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;


@Module
public class DynamoDBCommons {

    @Provides
    @Singleton
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Provides
    @Named("Blog_Table")
    public Table dynamoDbGetPartnerTable(DynamoDBMapper dynamoDBMapper,AmazonDynamoDB amazonDynamoDB)  {
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(BwbBlog.class);
        ProvisionedThroughput pt = new ProvisionedThroughput(10l, 10l);
        tableRequest.getGlobalSecondaryIndexes().get(0).setProvisionedThroughput(pt);
        tableRequest.setProvisionedThroughput(pt);
        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        try{
            Table blogTable = dynamoDB.createTable(tableRequest);
            blogTable.waitForActive();
            return blogTable;
        }catch(ResourceInUseException exception) {
            System.out.println("Table Exists!!");
            return dynamoDB.getTable("Blog_Table");
        }catch (InterruptedException ex){
            return null;
        }
    }


    @Provides
    public ObjectMapper objectMapper(){
         ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
        return mapper;
    }

}
