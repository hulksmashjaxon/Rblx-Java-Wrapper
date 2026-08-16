package tech.jxson;

import java.io.IOException;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.jxson.services.OpenCloud;
import tech.jxson.services.UserService;
import tech.jxson.users.UserResponse;
import tech.jxson.util.SLF4J;
import tech.jxson.util.SLF4J.logModes;

/**
 * Main
 */
public class Client {
  public static void main(String[] args) {
    Dotenv env = Dotenv.load();
    Client client = new Client();
    client.setApiKey(env.get("API_KEY"));
    // try {
    //   Response<UserResponse> res = client.openCloud().getUser(1).execute();
    //   if (res.isSuccessful()) {
    //     UserResponse user = res.body();
    //     if (user == null) { System.out.println("Null"); }
    //     System.out.println(user.about + " | " + user.id);
    //   }
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
  }
  private final UserService userService;
  private final HttpInterceptor httpInterceptor;
  private final OpenCloud openCloud;

  public Client() {
    this.userService = null;
    this.httpInterceptor = new HttpInterceptor();
    OkHttpClient httpClient = new OkHttpClient().newBuilder().addInterceptor(httpInterceptor).build();

    Retrofit cloudApi = new Retrofit.Builder().baseUrl("https://apis.roblox.com").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
    this.openCloud = cloudApi.create(OpenCloud.class);
  }

  public void setApiKey(String apiKey) {
    this.httpInterceptor.setApiKey(apiKey);
    SLF4J.Log("Set Open Cloud API key successfully", logModes.INFO);
  }

  public void setCookie(String cookie) {
    this.httpInterceptor.setCookie(cookie);
    SLF4J.Log("Set cookie successfully", logModes.INFO);
  }

  public UserService users() { return this.userService; }
  public OpenCloud openCloud() { return this.openCloud; }


  /**
  * Test call, donotuse
  */
  // public static void Test() {
  //   Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
  //   TestService userSrvc = retrofit.create(TestService.class);
  //   try {
  //     Response<Test> res = userSrvc.getUserById(1).execute();
  //     if (res.isSuccessful() && res.body() != null) {
  //       Test user = res.body();
  //       System.out.println(user.name);
  //       System.out.println(user.email);
  //     } else {
  //       System.out.println("server response: " + res.code());
  //     }
  //   } catch (Exception e) {
  //     System.out.println("net req fail");
  //     e.printStackTrace();
  //   }
  // }
}
