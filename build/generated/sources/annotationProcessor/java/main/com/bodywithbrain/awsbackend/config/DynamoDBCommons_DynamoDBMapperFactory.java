package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DynamoDBCommons_DynamoDBMapperFactory implements Factory<DynamoDBMapper> {
  private final DynamoDBCommons module;

  private final Provider<AmazonDynamoDB> amazonDynamoDBProvider;

  public DynamoDBCommons_DynamoDBMapperFactory(
      DynamoDBCommons module, Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    this.module = module;
    this.amazonDynamoDBProvider = amazonDynamoDBProvider;
  }

  @Override
  public DynamoDBMapper get() {
    return provideInstance(module, amazonDynamoDBProvider);
  }

  public static DynamoDBMapper provideInstance(
      DynamoDBCommons module, Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    return proxyDynamoDBMapper(module, amazonDynamoDBProvider.get());
  }

  public static DynamoDBCommons_DynamoDBMapperFactory create(
      DynamoDBCommons module, Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    return new DynamoDBCommons_DynamoDBMapperFactory(module, amazonDynamoDBProvider);
  }

  public static DynamoDBMapper proxyDynamoDBMapper(
      DynamoDBCommons instance, AmazonDynamoDB amazonDynamoDB) {
    return Preconditions.checkNotNull(
        instance.dynamoDBMapper(amazonDynamoDB),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
