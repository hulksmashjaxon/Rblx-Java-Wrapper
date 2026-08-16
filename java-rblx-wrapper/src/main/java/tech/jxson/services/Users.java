package tech.jxson.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tech.jxson.users.GetUsersByUsernames.GetUsersByUsernameData;
import tech.jxson.users.GetUsersByUsernames.GetUsersByUsernameBody;

public interface Users {
  @POST("/v1/usernames/users")
  Call<GetUsersByUsernameData> getUsersByUsernames(@Body GetUsersByUsernameBody request);
}