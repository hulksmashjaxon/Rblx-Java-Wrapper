package tech.jxson.endpoints.friends.GetUserFriendsForUser;

import java.util.List;

public class GetUserFriendsForUserData {
  public List<InnerGetUserFriendsForUserData> data;

  public class InnerGetUserFriendsForUserData {
    public Boolean isOnline;
    public Integer prescenceType;
    public Boolean isDeleted;
    public Integer friendFrequentScore;
    public Integer friendFrequentRank;
    public Boolean hasVerifiedBadge;
    public String description;
    public String created;
    public Boolean isBanned;
    public String externalAppDisplayName;
    public Long id;
    public String name;
    public String displayName;
  }
}