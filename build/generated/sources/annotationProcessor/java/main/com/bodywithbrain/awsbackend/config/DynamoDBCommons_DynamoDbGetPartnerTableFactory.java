package com.bodywithbrain.awsbackend.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DynamoDBCommons_DynamoDbGetPartnerTableFactory implements Factory<Table> {
  private final DynamoDBCommons module;

  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  private final Provider<AmazonDynamoDB> amazonDynamoDBProvider;

  public DynamoDBCommons_DynamoDbGetPartnerTableFactory(
      DynamoDBCommons module,
      Provider<DynamoDBMapper> dynamoDBMapperProvider,
      Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    this.module = module;
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
    this.amazonDynamoDBProvider = amazonDynamoDBProvider;
  }

  @Override
  public Table get() {
    return provideInstance(module, dynamoDBMapperProvider, amazonDynamoDBProvider);
  }

  public static Table provideInstance(
      DynamoDBCommons module,
      Provider<DynamoDBMapper> dynamoDBMapperProvider,
      Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    return proxyDynamoDbGetPartnerTable(
        module, dynamoDBMapperProvider.get(), amazonDynamoDBProvider.get());
  }

  public static DynamoDBCommons_DynamoDbGetPartnerTableFactory create(
      DynamoDBCommons module,
      Provider<DynamoDBMapper> dynamoDBMapperProvider,
      Provider<AmazonDynamoDB> amazonDynamoDBProvider) {
    return new DynamoDBCommons_DynamoDbGetPartnerTableFactory(
        module, dynamoDBMapperProvider, amazonDynamoDBProvider);
  }

  public static Table proxyDynamoDbGetPartnerTable(
      DynamoDBCommons instance, DynamoDBMapper dynamoDBMapper, AmazonDynamoDB amazonDynamoDB) {
    return Preconditions.checkNotNull(
        instance.dynamoDbGetPartnerTable(dynamoDBMapper, amazonDynamoDB),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
