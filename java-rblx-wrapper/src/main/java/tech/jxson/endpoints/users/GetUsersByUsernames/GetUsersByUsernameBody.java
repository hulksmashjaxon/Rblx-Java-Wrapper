package tech.jxson.endpoints.users.GetUsersByUsernames;

import java.util.List;

public class GetUsersByUsernameBody {
  private List<String> usernames;
  private boolean excludeBannedUsers;
  public GetUsersByUsernameBody(List<String> usernames, boolean excludeBannedUsers) {
    this.usernames = usernames;
    this.excludeBannedUsers = excludeBannedUsers;
  }
  public GetUsersByUsernameBody() {  }

  public List<String> getUsernames() { return usernames; }
  public void setUsernames(List<String> usernames) { this.usernames = usernames; }
  public boolean isBannedUsersExcluded() { return excludeBannedUsers; }
  public void setBannedUsersExcluded(boolean value) { this.excludeBannedUsers = value; }

}
