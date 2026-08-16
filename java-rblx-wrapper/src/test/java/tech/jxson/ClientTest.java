package tech.jxson;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.Response;
import tech.jxson.users.UserResponse;

public class ClientTest {
  Dotenv env = Dotenv.load();
  @Test
  public void TestEndpoints() {
    Client client = new Client();
    client.setApiKey(env.get("API_KEY"));
    try {
      retrofit2.Response<UserResponse> res = client.openCloud().getUser(1).execute();
      if (res.isSuccessful()) {
        System.out.println(res.body().displayName);
      } else {
        System.out.println(res.body());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
