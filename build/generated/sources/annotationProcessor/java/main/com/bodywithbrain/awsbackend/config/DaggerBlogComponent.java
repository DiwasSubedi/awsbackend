package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.bodywithbrain.awsbackend.BlogLambda;
import com.bodywithbrain.awsbackend.BlogLambda_MembersInjector;
import com.bodywithbrain.awsbackend.controller.CreateBlogRoute;
import com.bodywithbrain.awsbackend.controller.GetBlogRoute;
import com.bodywithbrain.awsbackend.controller.RequestRouter;
import com.bodywithbrain.awsbackend.services.BlogService;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBlogComponent implements BlogComponent {
  private BlogModule blogModule;

  private DynamoDBCommons dynamoDBCommons;

  private Provider<AmazonDynamoDB> amazonDynamoDBProvider;

  private Provider<DynamoDBMapper> dynamoDBMapperProvider;

  private DaggerBlogComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static BlogComponent create() {
    return new Builder().build();
  }

  private Table getNamedTable() {
    return DynamoDBCommons_DynamoDbGetPartnerTableFactory.proxyDynamoDbGetPartnerTable(
        dynamoDBCommons, dynamoDBMapperProvider.get(), amazonDynamoDBProvider.get());
  }

  private BlogService getBlogService() {
    return BlogModule_ProvideBlogServiceFactory.proxyProvideBlogService(
        blogModule, getNamedTable(), dynamoDBMapperProvider.get());
  }

  private CreateBlogRoute getCreateBlogRoute() {
    return BlogModule_ProvideCreateBlogRouteFactory.proxyProvideCreateBlogRoute(
        blogModule,
        getBlogService(),
        DynamoDBCommons_ObjectMapperFactory.proxyObjectMapper(dynamoDBCommons));
  }

  private GetBlogRoute getGetBlogRoute() {
    return new GetBlogRoute(getBlogService());
  }

  private RequestRouter getRequestRouter() {
    return BlogModule_PartnerRequestRouterFactory.proxyPartnerRequestRouter(
        blogModule, getCreateBlogRoute(), getGetBlogRoute());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.blogModule = builder.blogModule;
    this.dynamoDBCommons = builder.dynamoDBCommons;
    this.amazonDynamoDBProvider =
        DoubleCheck.provider(
            AmazonDynamoDbConfig_AmazonDynamoDBFactory.create(builder.amazonDynamoDbConfig));
    this.dynamoDBMapperProvider =
        DoubleCheck.provider(
            DynamoDBCommons_DynamoDBMapperFactory.create(
                builder.dynamoDBCommons, amazonDynamoDBProvider));
  }

  @Override
  public void inject(BlogLambda blogLambda) {
    injectBlogLambda(blogLambda);
  }

  private BlogLambda injectBlogLambda(BlogLambda instance) {
    BlogLambda_MembersInjector.injectRouter(instance, getRequestRouter());
    return instance;
  }

  public static final class Builder {
    private AmazonDynamoDbConfig amazonDynamoDbConfig;

    private DynamoDBCommons dynamoDBCommons;

    private BlogModule blogModule;

    private Builder() {}

    public BlogComponent build() {
      if (amazonDynamoDbConfig == null) {
        this.amazonDynamoDbConfig = new AmazonDynamoDbConfig();
      }
      if (dynamoDBCommons == null) {
        this.dynamoDBCommons = new DynamoDBCommons();
      }
      if (blogModule == null) {
        this.blogModule = new BlogModule();
      }
      return new DaggerBlogComponent(this);
    }

    public Builder amazonDynamoDbConfig(AmazonDynamoDbConfig amazonDynamoDbConfig) {
      this.amazonDynamoDbConfig = Preconditions.checkNotNull(amazonDynamoDbConfig);
      return this;
    }

    public Builder dynamoDBCommons(DynamoDBCommons dynamoDBCommons) {
      this.dynamoDBCommons = Preconditions.checkNotNull(dynamoDBCommons);
      return this;
    }

    public Builder blogModule(BlogModule blogModule) {
      this.blogModule = Preconditions.checkNotNull(blogModule);
      return this;
    }
  }
}
