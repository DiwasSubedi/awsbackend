package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.bodywithbrain.awsbackend.controller.CreateBlogRoute;
import com.bodywithbrain.awsbackend.controller.GetBlogRoute;
import com.bodywithbrain.awsbackend.controller.RequestRouter;
import com.bodywithbrain.awsbackend.services.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;


@Module
public class BlogModule {

    @Provides
    BlogService provideBlogService(@Named("Blog_Table") Table blogTable, DynamoDBMapper dynamoDBMapper){
        return new BlogService(blogTable,dynamoDBMapper);
    }

    @Provides
    CreateBlogRoute provideCreateBlogRoute(BlogService blogService, ObjectMapper objectMapper){
        return new CreateBlogRoute(blogService,objectMapper);
    }

    @Provides
    RequestRouter partnerRequestRouter(CreateBlogRoute createBlogRoute, GetBlogRoute getBlogRoute){
        RequestRouter partnerRequestRouter = new RequestRouter();
        partnerRequestRouter.register(createBlogRoute);
        partnerRequestRouter.register(getBlogRoute);
        return partnerRequestRouter;
    }
}
