package com.bodywithbrain.awsbackend.config;
import com.bodywithbrain.awsbackend.BlogLambda;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AmazonDynamoDbConfig.class, DynamoDBCommons.class, BlogModule.class})
public interface BlogComponent {
    void inject(BlogLambda blogLambda);
}
