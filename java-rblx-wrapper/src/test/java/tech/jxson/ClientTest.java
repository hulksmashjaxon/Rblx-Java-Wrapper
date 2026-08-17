package tech.jxson;

import org.junit.jupiter.api.Test;

import io.github.cdimascio.dotenv.Dotenv;

public class ClientTest {
  Dotenv env = Dotenv.load();
  @Test
  public void TestEndpoints() {
    Client client = new Client();
    client.setApiKey(env.get("API_KEY"));
    client.setCookie(env.get("COOKIE"));
  }
}
