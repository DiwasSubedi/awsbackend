package com.bodywithbrain.awsbackend.controller;

import com.bodywithbrain.awsbackend.services.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateBlogRoute_Factory implements Factory<CreateBlogRoute> {
  private final Provider<BlogService> blogServiceProvider;

  private final Provider<ObjectMapper> mapperProvider;

  public CreateBlogRoute_Factory(
      Provider<BlogService> blogServiceProvider, Provider<ObjectMapper> mapperProvider) {
    this.blogServiceProvider = blogServiceProvider;
    this.mapperProvider = mapperProvider;
  }

  @Override
  public CreateBlogRoute get() {
    return provideInstance(blogServiceProvider, mapperProvider);
  }

  public static CreateBlogRoute provideInstance(
      Provider<BlogService> blogServiceProvider, Provider<ObjectMapper> mapperProvider) {
    return new CreateBlogRoute(blogServiceProvider.get(), mapperProvider.get());
  }

  public static CreateBlogRoute_Factory create(
      Provider<BlogService> blogServiceProvider, Provider<ObjectMapper> mapperProvider) {
    return new CreateBlogRoute_Factory(blogServiceProvider, mapperProvider);
  }

  public static CreateBlogRoute newCreateBlogRoute(BlogService blogService, ObjectMapper mapper) {
    return new CreateBlogRoute(blogService, mapper);
  }
}
