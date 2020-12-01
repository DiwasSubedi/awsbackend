package com.bodywithbrain.awsbackend;

import com.bodywithbrain.awsbackend.controller.RequestRouter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BlogLambda_MembersInjector implements MembersInjector<BlogLambda> {
  private final Provider<RequestRouter> routerProvider;

  public BlogLambda_MembersInjector(Provider<RequestRouter> routerProvider) {
    this.routerProvider = routerProvider;
  }

  public static MembersInjector<BlogLambda> create(Provider<RequestRouter> routerProvider) {
    return new BlogLambda_MembersInjector(routerProvider);
  }

  @Override
  public void injectMembers(BlogLambda instance) {
    injectRouter(instance, routerProvider.get());
  }

  public static void injectRouter(BlogLambda instance, RequestRouter router) {
    instance.router = router;
  }
}
