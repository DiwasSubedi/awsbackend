package com.bodywithbrain.awsbackend.controller;

import com.bodywithbrain.awsbackend.services.BlogService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetBlogRoute_Factory implements Factory<GetBlogRoute> {
  private final Provider<BlogService> blogServiceProvider;

  public GetBlogRoute_Factory(Provider<BlogService> blogServiceProvider) {
    this.blogServiceProvider = blogServiceProvider;
  }

  @Override
  public GetBlogRoute get() {
    return provideInstance(blogServiceProvider);
  }

  public static GetBlogRoute provideInstance(Provider<BlogService> blogServiceProvider) {
    return new GetBlogRoute(blogServiceProvider.get());
  }

  public static GetBlogRoute_Factory create(Provider<BlogService> blogServiceProvider) {
    return new GetBlogRoute_Factory(blogServiceProvider);
  }

  public static GetBlogRoute newGetBlogRoute(BlogService blogService) {
    return new GetBlogRoute(blogService);
  }
}
