package com.bodywithbrain.awsbackend.config;

import com.bodywithbrain.awsbackend.controller.CreateBlogRoute;
import com.bodywithbrain.awsbackend.controller.GetBlogRoute;
import com.bodywithbrain.awsbackend.controller.RequestRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BlogModule_PartnerRequestRouterFactory implements Factory<RequestRouter> {
  private final BlogModule module;

  private final Provider<CreateBlogRoute> createBlogRouteProvider;

  private final Provider<GetBlogRoute> getBlogRouteProvider;

  public BlogModule_PartnerRequestRouterFactory(
      BlogModule module,
      Provider<CreateBlogRoute> createBlogRouteProvider,
      Provider<GetBlogRoute> getBlogRouteProvider) {
    this.module = module;
    this.createBlogRouteProvider = createBlogRouteProvider;
    this.getBlogRouteProvider = getBlogRouteProvider;
  }

  @Override
  public RequestRouter get() {
    return provideInstance(module, createBlogRouteProvider, getBlogRouteProvider);
  }

  public static RequestRouter provideInstance(
      BlogModule module,
      Provider<CreateBlogRoute> createBlogRouteProvider,
      Provider<GetBlogRoute> getBlogRouteProvider) {
    return proxyPartnerRequestRouter(
        module, createBlogRouteProvider.get(), getBlogRouteProvider.get());
  }

  public static BlogModule_PartnerRequestRouterFactory create(
      BlogModule module,
      Provider<CreateBlogRoute> createBlogRouteProvider,
      Provider<GetBlogRoute> getBlogRouteProvider) {
    return new BlogModule_PartnerRequestRouterFactory(
        module, createBlogRouteProvider, getBlogRouteProvider);
  }

  public static RequestRouter proxyPartnerRequestRouter(
      BlogModule instance, CreateBlogRoute createBlogRoute, GetBlogRoute getBlogRoute) {
    return Preconditions.checkNotNull(
        instance.partnerRequestRouter(createBlogRoute, getBlogRoute),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
