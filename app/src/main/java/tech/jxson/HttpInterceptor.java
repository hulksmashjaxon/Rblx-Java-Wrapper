package tech.jxson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpInterceptor implements Interceptor {
  private String apiKey = "";
  private String cookie = "";

  public void setApiKey(String apiKey) { this.apiKey = apiKey; };
  public void setCookie(String cookie) { this.cookie = cookie; };
  
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request originalReq = chain.request();
    Request.Builder builder = originalReq.newBuilder();
    if (originalReq.url().host().equals("apis.roblox.com")) {
      if (apiKey == null || apiKey.trim().isEmpty()) {
        throw new IllegalStateException("API key is not specified- specify one using Client.setApiKey()");
      }
    }
    if (!apiKey.isEmpty()) { builder.header("x-api-key", apiKey); }
    if (cookie.startsWith(".ROBLOSECURITY=") && !apiKey.isEmpty()) { builder.header("Cookie", cookie); }

    Request newReq = builder.build();
    return chain.proceed(newReq);
  }
}
