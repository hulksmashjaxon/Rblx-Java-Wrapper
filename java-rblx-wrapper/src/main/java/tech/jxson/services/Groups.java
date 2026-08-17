package tech.jxson.services;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tech.jxson.attributes.RequiresCookie;
import tech.jxson.attributes.RequiresNone;
import tech.jxson.endpoints.groups.GetUserPrimaryGroup.GetUserPrimaryGroupData;

public interface Groups {
  @RequiresCookie @DELETE("/v1/groups/{groupId}/users/{userId}")
  Call<Void> removeUserFromGroup(@Path("groupId") Long groupId, @Path("userId") Long userId);

  @RequiresNone @GET("/v1/users/{userId}/groups/primary/role")
  Call<GetUserPrimaryGroupData> getUserPrimaryGroup(@Path("userId") Long userId);
}
