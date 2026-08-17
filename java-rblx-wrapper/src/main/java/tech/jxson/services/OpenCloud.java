package tech.jxson.services;

import java.io.IOException;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tech.jxson.attributes.RequiresAPIKey;
import tech.jxson.endpoints.*;
import tech.jxson.endpoints.cloud.groups.GetGroupsUserCanManage.GetGroupsUserCanManageData;
import tech.jxson.endpoints.cloud.groups.GetGroupsUserRequestedToJoin.GetGroupsUserRequestedToJoinData;
import tech.jxson.endpoints.cloud.restriction.GetUserRestriction.GetUserRestrictionData;
import tech.jxson.endpoints.cloud.restriction.ListUserRestrictions.ListUserRestrictionsData;
import tech.jxson.endpoints.cloud.restriction.UpdateUserRestriction.UpdateUserRestrictionBody;
import tech.jxson.endpoints.cloud.restriction.UpdateUserRestriction.UpdateUserRestrictionData;

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
  @RequiresAPIKey
  @GET("/cloud/v2/users/{user_id}")
  retrofit2.Call<UserResponse> getUser(@Path("user_id") long userId) throws IllegalStateException, IOException;


  /* Restriction */
  /**
   * @throws IllegalStateException
   * @param universeId - The universe id
   * @param maxPageSize - Max page size to return of user restrictions (max 100)
   * @param pageToken - The pagination token received from a previous call
   * @return {@link retrofit2.OkHttpCall}
   */
  @RequiresAPIKey
  @GET("/cloud/v2/universes/{universe_id}/user-restrictions")
  retrofit2.Call<ListUserRestrictionsData> listUserRestrictions(@Path("universe_id") Long universeId, @Query("maxPageSize") Integer maxPageSize, @Query("pageToken") String pageToken) throws IllegalStateException, IOException;
  /**
   * @param universeId - The universe id
   * @param userRestrictionId - The id for the specific user restriction
   * @return {@link retrofit2.OkHttpCall}
   * @throws IllegalStateException
   */
  @RequiresAPIKey
  @GET("/cloud/v2/universes/{universe_id}/user-restrictions/{user_restriction_id}")
  retrofit2.Call<GetUserRestrictionData> getUserRestriction(@Path("universe_id") Long universeId, @Path("user_restriction_id") Long userRestrictionId) throws IllegalStateException, IOException;
  
  @RequiresAPIKey
  @PATCH("/cloud/v2/universes/{universe_id}/user-restrictions/{user_restriction_id}")
  retrofit2.Call<UpdateUserRestrictionData> updateUserRestriction(@Body UpdateUserRestrictionBody request,
      @Path("universe_id") Long universe_id, @Path("user_restriction_id") Long user_restriction_id,
      @Query("updateMask") String updateMask, @Query("idempotencyKey") String idempotencyKey,
      @Query("idemptoencyKey.firstSent") String idemptoencyKeyFirstSent) throws IllegalStateException, IOException;

  /* Groups */
  /***
   * <strong>Warning:</strong> The information from this endpoint will derive itself from the owner of the API key. Use this with user-owned API keys.
   * @return {@link retrofit2.OkHttpCall}
   * @throws IllegalStateException
   * @throws IOException
   */
  @RequiresAPIKey @GET("/legacy-develop/v1/users/groups/canmanage")
  retrofit2.Call<GetGroupsUserCanManageData> getGroupsUserCanManage() throws IllegalStateException, IOException;

  /**
   * <strong>Warning:</strong> The information from this endpoint will derive itself from the owner of the API key. Use this with user-owned API keys.
   * @return {@link retrofit2.OkHttpCall}
   * @throws IllegalStateException
   * @throws IOException
   */
  @RequiresAPIKey @GET("/legacy-groups/v1/user/groups/pending")
  retrofit2.Call<GetGroupsUserRequestedToJoinData> getGroupsUserRequestedToJoin() throws IllegalStateException, IOException;
}