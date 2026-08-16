package tech.jxson.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tech.jxson.example.Test;

public interface TestService {
  @GET("users/{id}")
  Call<Test> getUserById(@Path("id") int userId);
}