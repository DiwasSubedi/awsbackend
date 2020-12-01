package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.bodywithbrain.awsbackend.services.BlogService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BlogModule_ProvideBlogServiceFactory implements Factory<BlogService> {
  private final BlogModule module;

  private final Provider<Table> blogTableProvider;

  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public BlogModule_ProvideBlogServiceFactory(
      BlogModule module,
      Provider<Table> blogTableProvider,
      Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.module = module;
    this.blogTableProvider = blogTableProvider;
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public BlogService get() {
    return provideInstance(module, blogTableProvider, dynamoDBMapperProvider);
  }

  public static BlogService provideInstance(
      BlogModule module,
      Provider<Table> blogTableProvider,
      Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return proxyProvideBlogService(module, blogTableProvider.get(), dynamoDBMapperProvider.get());
  }

  public static BlogModule_ProvideBlogServiceFactory create(
      BlogModule module,
      Provider<Table> blogTableProvider,
      Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new BlogModule_ProvideBlogServiceFactory(
        module, blogTableProvider, dynamoDBMapperProvider);
  }

  public static BlogService proxyProvideBlogService(
      BlogModule instance, Table blogTable, DynamoDBMapper dynamoDBMapper) {
    return Preconditions.checkNotNull(
        instance.provideBlogService(blogTable, dynamoDBMapper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
