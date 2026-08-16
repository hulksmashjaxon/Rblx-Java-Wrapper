package tech.jxson.services;

import org.jspecify.annotations.Nullable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tech.jxson.users.GetUsersByUsernames.GetUsersByUsernameData;
import tech.jxson.users.SearchForUsersByKeyword.SearchForUsersByKeywordData;
import tech.jxson.users.GetUsersByUsernames.GetUsersByUsernameBody;

public interface Users {
  /*** 
   * @param request - {@link tech.jxson.users.GetUsersByUsernames.GetUsersByUsernameBody}
   * 
   * @return {@link retrofit2.OkHttpCall}
   */
  @POST("/v1/usernames/users")
  Call<GetUsersByUsernameData> getUsersByUsernames(@Body GetUsersByUsernameBody request);
  /***
   * @param keyword - The search keyword
   * @param sessionId - The sessionId for the request
   * @param limit - The number of results per request (10, 25, 50, 100)
   * @param cursor - The paging cursor for the previous or next page
   * @return {@link retrofit2.OkHttpCall}
  */
  @GET("/v1/users/search")
  Call<SearchForUsersByKeywordData> getUsersByKeyword(@Query("keyword") String keyword, @Query("sessionId") @Nullable String sessionId, @Query("limit") @Nullable Integer limit, @Query("cursor") @Nullable String cursor);
} 