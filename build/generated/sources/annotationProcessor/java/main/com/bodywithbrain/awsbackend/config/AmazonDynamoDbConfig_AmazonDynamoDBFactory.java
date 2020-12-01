package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AmazonDynamoDbConfig_AmazonDynamoDBFactory implements Factory<AmazonDynamoDB> {
  private final AmazonDynamoDbConfig module;

  public AmazonDynamoDbConfig_AmazonDynamoDBFactory(AmazonDynamoDbConfig module) {
    this.module = module;
  }

  @Override
  public AmazonDynamoDB get() {
    return provideInstance(module);
  }

  public static AmazonDynamoDB provideInstance(AmazonDynamoDbConfig module) {
    return proxyAmazonDynamoDB(module);
  }

  public static AmazonDynamoDbConfig_AmazonDynamoDBFactory create(AmazonDynamoDbConfig module) {
    return new AmazonDynamoDbConfig_AmazonDynamoDBFactory(module);
  }

  public static AmazonDynamoDB proxyAmazonDynamoDB(AmazonDynamoDbConfig instance) {
    return Preconditions.checkNotNull(
        instance.amazonDynamoDB(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
