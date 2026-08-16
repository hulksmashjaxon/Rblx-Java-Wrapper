package tech.jxson.users.cloud.ListUserRestrictions;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListUserRestrictionsData {
  @SerializedName("userRestrictions")
  public List<UserRestriction> restrictions;
  public String nextPageToken;

  public class UserRestriction {
    public String path;
    public String updateTime;
    public String user;
    @SerializedName("gameJoinRestriction")
    public List<gameJoinRestriction> joinRestrictions;

    public class gameJoinRestriction {
      public Boolean active;
      public String startTime;
      public String duration;
      public String privateReason;
      public String displayReason;
      public Boolean excludeAltAccounts;
      public Boolean inherited;
    }
  }
}
