# Rblx-Java-Wrapper
**An API wrapper library for Roblox**, made in and support for Java. 

## Why?
I made this because I could not find any Roblox API wrapper for Java- the only one was deprecated six years ago.

## How to
Basic Initialization:
```java
Client client = new Client();
Dotenv env = Dotenv.load();
client.setApiKey(env.get("API_KEY")); // alternatively, store in plain text but NOT recommended- .env.example and the env package comes with this package
client.setCookie(env.get("COOKIE")); // add a cookie for legacy endpoints
try { // example method!
  Response<UserResponse> res = client.openCloud().getUser(1).execute();
  if (res.isSuccessful()) {
    UserResponse user = res.body();
    if (user == null) { System.out.println("Null"); }
    System.out.println(user.about + " | " + user.id);
  }
} catch (IOException e) {
  e.printStackTrace();
}
```
## SLF4J Logging
A custom library for handling SLF4J logging comes with Rblx-Java-Wrapper. You can use it as so:
```java
import tech.jxson.util.SLF4J;
import tech.jxson.util.SLF4J.logModes; // or alternatively, import tech.jxson.util.SLF4J.*

public class Main {
  public static void main(String[] args) {
    SLF4J.Log("Hello, world!" logModes.INFO);
  }
}
```

## Storing private information
You should not store information in plaintext. Anyone would be able to get the files from a source-control site and steal your cookie/API key. Instead, create a .env file in `main/resources` and put your sensitive information in there.
```env
API_KEY="12345"
COOKIE="12345"
```

## Installation
This library is not yet published to Maven Central or GitHub. Please wait until I am a tad finished!
