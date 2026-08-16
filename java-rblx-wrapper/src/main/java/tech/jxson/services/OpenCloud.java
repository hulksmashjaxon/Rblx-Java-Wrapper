package tech.jxson.services;

import retrofit2.http.GET;
import retrofit2.http.Path;
import tech.jxson.users.*;

/**
 * All endpoints that use <code>apis.roblox.com</code>
 */
public interface OpenCloud {
  /* Users */
  /**
   * Returns information about the given user.
   * <p><strong>Warning:</strong> An API key must be called or it will throw an exception</p>
   * @param userId - The userId for the given user
   * @return A {@link UserResponse}
   * @throws IllegalStateException If an API key is not specified using Client.setApiKey
   */
  @GET("/cloud/v2/users/{user_id}")
  retrofit2.Call<UserResponse> getUser(@Path("user_id") long userId);
}