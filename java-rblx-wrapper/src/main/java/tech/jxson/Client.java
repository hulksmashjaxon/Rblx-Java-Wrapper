package tech.jxson;

import java.time.Duration;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.jxson.services.Friends;
import tech.jxson.services.Groups;
import tech.jxson.services.OpenCloud;
import tech.jxson.services.Users;
import tech.jxson.util.SLF4JUtil;
import tech.jxson.util.SLF4JUtil.logModes;

/**
 * Main
 */
public class Client {
  public static void main(String[] args) {
    Dotenv env = Dotenv.load();
    Client client = new Client();
    client.setApiKey(env.get("API_KEY"));
    client.setCookie(env.get("COOKIE"));
  }
  private final HttpInterceptor httpInterceptor;
  private final OpenCloud openCloud;
  private final Users users;
  private final Friends friends;
  private final Groups groups;

  public Client() {
    this.httpInterceptor = new HttpInterceptor();
    OkHttpClient httpClient = new OkHttpClient().newBuilder().addInterceptor(httpInterceptor).connectTimeout(Duration.ofSeconds(10)).readTimeout(Duration.ofSeconds(10)).writeTimeout(Duration.ofSeconds(10)).build();

    Retrofit cloudApi = new Retrofit.Builder().baseUrl("https://apis.roblox.com").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
    this.openCloud = cloudApi.create(OpenCloud.class);
    Retrofit usersApi = new Retrofit.Builder().baseUrl("https://users.roblox.com").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
    this.users = usersApi.create(Users.class);
    Retrofit friendsApi = new Retrofit.Builder().baseUrl("https://friends.roblox.com").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
    this.friends = friendsApi.create(Friends.class);
    Retrofit groupsApi = new Retrofit.Builder().baseUrl("https://groups.roblox.com").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
    this.groups = groupsApi.create(Groups.class);
  }

  public void setApiKey(String apiKey) {
    this.httpInterceptor.setApiKey(apiKey);
    SLF4JUtil.Log("Set Open Cloud API key successfully", logModes.INFO);
  }

  public void setCookie(String cookie) {
    this.httpInterceptor.setCookie(cookie);
    SLF4JUtil.Log("Set cookie successfully", logModes.INFO);
  }

  /*** This uses the OLD users endpoint (<code>users.roblox.com</code>) */
  public Users users() { return this.users; }
  public OpenCloud openCloud() { return this.openCloud; }
  /*** This uses the OLD friends endpoint (<code>friends.roblox.com</code>) */
  public Friends friends() { return this.friends; }
  /*** This uses the OLD groups endpoint (<code>groups.roblox.com</code>) */
  public Groups groups() { return this.groups; }
}
