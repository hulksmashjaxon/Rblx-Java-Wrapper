# Rblx-Java-Wrapper
**An API wrapper for Roblox**, made in and support for Java. 

## Why?
I made this because I could not find any Roblox API wrapper for Java- the only one was deprecated six years ago.

## How to
Basic initalization:
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