package tech.jxson.endpoints.cloud.restriction.UpdateUserRestriction;

import java.util.List;

public class UpdateUserRestrictionBody {
  private String path;
  private List<gameJoinRestriction> gameJoinRestriction;

  public static class gameJoinRestriction {
    public Boolean active;
    public String duration;
    public String privateReason;
    public String displayReason;
    public Boolean excludeAltAccounts;
  }
  public UpdateUserRestrictionBody(String path, List<gameJoinRestriction> restriction) {
    this.path = path;
    this.gameJoinRestriction = restriction;
  }
  public UpdateUserRestrictionBody() {  }
  public List<gameJoinRestriction> getJoinRestriction() { return gameJoinRestriction; }
  public void setJoinRestriction(List<gameJoinRestriction> restriction) { this.gameJoinRestriction = restriction; }
  public String getPath() { return path; }
  public void setPath(String newPath) { this.path = newPath; }
}
