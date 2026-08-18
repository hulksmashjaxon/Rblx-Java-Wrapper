# Rblx-Java-Wrapper
[![](https://jitpack.io/v/hulksmashjaxon/Rblx-Java-Wrapper.svg)](https://jitpack.io/#hulksmashjaxon/Rblx-Java-Wrapper)
![](https://github.com/hulksmashjaxon/Rblx-Java-Wrapper/actions/workflows/gradle.yml/badge.svg)

**An API wrapper library for Roblox**, made in and for Java. 

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

## Installation with JitPack.io
This library has not yet been made available on Maven Central, however for now you can use JitPack.

### Step 1:
Head over to [JitPack.io](https://jitpack.io/), and enter `hulksmashjaxon/Rblx-Java-Wrapper` into the "Git repo url" field.

### Step 2:
Find the latest version, and press "Get it". Select your build file type, and follow the directions there.
*Note:* If the dependency implementation has :Tag at the end of it, replace :Tag with the latest version (e.g., v1.0.3-alpha)
