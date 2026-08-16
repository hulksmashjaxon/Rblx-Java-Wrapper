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
      if (!apiKey.isEmpty()) { builder.header("x-api-key", apiKey); } 
    } else { 
      if (cookie == null || cookie.trim().isEmpty()) {
        throw new IllegalStateException("A cookie is required for non Open Cloud requests");
      }
      if (cookie.startsWith("_|WARNING:-DO-NOT-SHARE-THIS.") && !apiKey.isEmpty()) { builder.header("Cookie", cookie); }
     }
    builder.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
    Request newReq = builder.build();
    return chain.proceed(newReq);
  }
}
