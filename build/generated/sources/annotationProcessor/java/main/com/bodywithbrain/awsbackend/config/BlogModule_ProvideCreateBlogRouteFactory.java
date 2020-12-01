package com.bodywithbrain.awsbackend.config;

import com.bodywithbrain.awsbackend.controller.CreateBlogRoute;
import com.bodywithbrain.awsbackend.services.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BlogModule_ProvideCreateBlogRouteFactory implements Factory<CreateBlogRoute> {
  private final BlogModule module;

  private final Provider<BlogService> blogServiceProvider;

  private final Provider<ObjectMapper> objectMapperProvider;

  public BlogModule_ProvideCreateBlogRouteFactory(
      BlogModule module,
      Provider<BlogService> blogServiceProvider,
      Provider<ObjectMapper> objectMapperProvider) {
    this.module = module;
    this.blogServiceProvider = blogServiceProvider;
    this.objectMapperProvider = objectMapperProvider;
  }

  @Override
  public CreateBlogRoute get() {
    return provideInstance(module, blogServiceProvider, objectMapperProvider);
  }

  public static CreateBlogRoute provideInstance(
      BlogModule module,
      Provider<BlogService> blogServiceProvider,
      Provider<ObjectMapper> objectMapperProvider) {
    return proxyProvideCreateBlogRoute(
        module, blogServiceProvider.get(), objectMapperProvider.get());
  }

  public static BlogModule_ProvideCreateBlogRouteFactory create(
      BlogModule module,
      Provider<BlogService> blogServiceProvider,
      Provider<ObjectMapper> objectMapperProvider) {
    return new BlogModule_ProvideCreateBlogRouteFactory(
        module, blogServiceProvider, objectMapperProvider);
  }

  public static CreateBlogRoute proxyProvideCreateBlogRoute(
      BlogModule instance, BlogService blogService, ObjectMapper objectMapper) {
    return Preconditions.checkNotNull(
        instance.provideCreateBlogRoute(blogService, objectMapper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
