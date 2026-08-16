package tech.jxson.users.cloud.GetUserRestriction;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetUserRestrictionData {
  public String path;
  public String updateTime;
  public String user;
  @SerializedName("gameJoinRestriction")
  public List<gameJoinRestriction> restriction;

  public static class gameJoinRestriction {
    public Boolean active;
    public String startTime;
    public String duration;
    public String privateReason;
    public String displayReason;
    public Boolean excludeAltAccounts;
    public Boolean inherited;
  }
}
