package tech.jxson.endpoints.users.GetUsersByIds;

import java.util.List;

public class GetUsersByIdsBody {
  private List<Long> ids;
  private boolean excludeBannedUsers;
  public GetUsersByIdsBody(List<Long> ids, boolean excludeBannedUsers) {
    this.ids = ids;
    this.excludeBannedUsers = excludeBannedUsers;
  }
  public GetUsersByIdsBody() {  }

  public List<Long> getUsernames() { return ids; }
  public void setUsernames(List<Long> ids) { this.ids = ids; }
  public boolean isBannedUsersExcluded() { return excludeBannedUsers; }
  public void setBannedUsersExcluded(boolean value) { this.excludeBannedUsers = value; }

}
