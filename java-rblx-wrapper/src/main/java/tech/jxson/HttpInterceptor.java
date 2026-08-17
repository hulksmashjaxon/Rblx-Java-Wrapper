package tech.jxson;

import java.io.IOException;
import java.lang.reflect.Method;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Invocation;
import tech.jxson.attributes.RequiresAPIKey;
import tech.jxson.attributes.RequiresCookie;
import tech.jxson.attributes.RequiresNone;

public class HttpInterceptor implements Interceptor {
  private String apiKey = "";
  private String cookie = "";

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  };

  public void setCookie(String cookie) {
    this.cookie = cookie;
  };

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request originalReq = chain.request();
    Request.Builder builder = originalReq.newBuilder();
    Invocation invocation = originalReq.tag(Invocation.class);
    boolean requiresApiKey = false;
    boolean requiresCookie = false;
    boolean requiresNone = false;

    if (invocation != null) {
      Method method = invocation.method();
      if (method.isAnnotationPresent(RequiresAPIKey.class)) {
        RequiresAPIKey annotation = method.getAnnotation(RequiresAPIKey.class);
        requiresApiKey = annotation.value();
      } else if (method.isAnnotationPresent(RequiresCookie.class)) {
        RequiresCookie annotation = method.getAnnotation(RequiresCookie.class);
        requiresCookie = annotation.value();
      } else if (method.isAnnotationPresent(RequiresNone.class)) {
        RequiresNone annotation = method.getAnnotation(RequiresNone.class);
        requiresNone = annotation.value();
      }
    }

    if (!requiresNone) {
      if ((requiresApiKey && !requiresCookie) || originalReq.url().host().equals("apis.roblox.com")) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
          throw new IllegalStateException("API key is not specified- specify one using Client.setApiKey()");
        }
        if (!apiKey.isEmpty()) {
          builder.header("x-api-key", apiKey);
        }
      } else if ((requiresCookie && !requiresApiKey) || !originalReq.url().host().equals("apis.roblox.com")) {
        if (cookie == null || cookie.trim().isEmpty()) {
          throw new IllegalStateException("A cookie is required for non Open Cloud requests");
        }
        if (cookie.startsWith("_|WARNING:-DO-NOT-SHARE-THIS.") && !apiKey.isEmpty()) {
          builder.header("Cookie", cookie);
        }
      }
    }
    builder.header("User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
    Request newReq = builder.build();
    return chain.proceed(newReq);
  }
}
