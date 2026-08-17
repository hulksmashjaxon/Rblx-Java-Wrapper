package tech.jxson.endpoints.cloud.restriction.UpdateUserRestriction;

import java.util.List;

public class UpdateUserRestrictionData {
  public String path;
  public String updateTime;
  public String user;
  public List<gameJoinRestriction> gameJoinRestriction;

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
