package com.bodywithbrain.awsbackend.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BlogService_Factory implements Factory<BlogService> {
  private final Provider<Table> blogTableProvider;

  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public BlogService_Factory(
      Provider<Table> blogTableProvider, Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.blogTableProvider = blogTableProvider;
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public BlogService get() {
    return provideInstance(blogTableProvider, dynamoDBMapperProvider);
  }

  public static BlogService provideInstance(
      Provider<Table> blogTableProvider, Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new BlogService(blogTableProvider.get(), dynamoDBMapperProvider.get());
  }

  public static BlogService_Factory create(
      Provider<Table> blogTableProvider, Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new BlogService_Factory(blogTableProvider, dynamoDBMapperProvider);
  }

  public static BlogService newBlogService(Table blogTable, DynamoDBMapper dynamoDBMapper) {
    return new BlogService(blogTable, dynamoDBMapper);
  }
}
