package tech.jxson.services;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tech.jxson.users.*;
import tech.jxson.users.cloud.GetUserRestriction.GetUserRestrictionData;
import tech.jxson.users.cloud.ListUserRestrictions.ListUserRestrictionsData;
import tech.jxson.users.cloud.UpdateUserRestriction.UpdateUserRestrictionBody;
import tech.jxson.users.cloud.UpdateUserRestriction.UpdateUserRestrictionData;

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


  /* Universes/Games */
  /**
   * @throws IllegalStateException
   * @param universeId - The universe id
   * @param maxPageSize - Max page size to return of user restrictions (max 100)
   * @param pageToken - The pagination token received from a previous call
   * @return {@link retrofit2.OkHttpCall}
   */
  @GET("/cloud/v2/universes/{universe_id}/user-restrictions")
  retrofit2.Call<ListUserRestrictionsData> listUserRestrictions(@Path("universe_id") Long universeId, @Query("maxPageSize") Integer maxPageSize, @Query("pageToken") String pageToken);
  /**
   * @param universeId - The universe id
   * @param userRestrictionId - The id for the specific user restriction
   * @return {@link retrofit2.OkHttpCall}
   * @throws IllegalStateException
   */
  @GET("/cloud/v2/universes/{universe_id}/user-restrictions/{user_restriction_id}")
  retrofit2.Call<GetUserRestrictionData> getUserRestriction(@Path("universe_id") Long universeId, @Path("user_restriction_id") Long userRestrictionId);

  @PATCH("/cloud/v2/universes/{universe_id}/user-restrictions/{user_restriction_id}")
  retrofit2.Call<UpdateUserRestrictionData> updateUserRestriction(@Body UpdateUserRestrictionBody request,
      @Path("universe_id") Long universe_id, @Path("user_restriction_id") Long user_restriction_id,
      @Query("updateMask") String updateMask, @Query("idempotencyKey") String idempotencyKey,
      @Query("idemptoencyKey.firstSent") String idemptoencyKeyFirstSent);
}