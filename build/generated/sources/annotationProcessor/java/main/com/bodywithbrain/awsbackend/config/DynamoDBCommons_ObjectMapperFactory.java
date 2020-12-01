package com.bodywithbrain.awsbackend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DynamoDBCommons_ObjectMapperFactory implements Factory<ObjectMapper> {
  private final DynamoDBCommons module;

  public DynamoDBCommons_ObjectMapperFactory(DynamoDBCommons module) {
    this.module = module;
  }

  @Override
  public ObjectMapper get() {
    return provideInstance(module);
  }

  public static ObjectMapper provideInstance(DynamoDBCommons module) {
    return proxyObjectMapper(module);
  }

  public static DynamoDBCommons_ObjectMapperFactory create(DynamoDBCommons module) {
    return new DynamoDBCommons_ObjectMapperFactory(module);
  }

  public static ObjectMapper proxyObjectMapper(DynamoDBCommons instance) {
    return Preconditions.checkNotNull(
        instance.objectMapper(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
