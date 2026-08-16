package tech.jxson.users.GetUsersByIds;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetUsersByIdsData {
  @SerializedName("data") //szname reads for JSON keys, List<UserData> is the shit inside of data: []
  public List<UserData> data;

  public static class UserData {
    public String requestedUsername;
    public boolean hasVerifiedBadge;
    public long id;
    public String name;
    public String displayName;
  }
}
