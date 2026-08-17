package tech.jxson.services;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tech.jxson.attributes.RequiresNone;
import tech.jxson.endpoints.friends.GetNumberOfFriendsForUser.GetNumberOfFriendsForUserData;
import tech.jxson.endpoints.friends.GetUserFriendsForUser.GetUserFriendsForUserData;

public interface Friends {
  /*** Note that Roblox only returns "id", "name" (as null), and "displayName" (as null) */
  @RequiresNone @GET("/v1/users/{userId}/friends")
  Call<GetUserFriendsForUserData> getUserFriendsForUser(@Path("userId") Long userId) throws IOException, IllegalStateException;

  @RequiresNone @GET("/v1/users/{userId}/friends/count")
  Call<GetNumberOfFriendsForUserData> getNumberOfFriendsForUser(@Path("userId") Long userId) throws IOException, IllegalStateException;
}
