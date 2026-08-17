package tech.jxson.endpoints.cloud.groups.GetGroupsUserRequestedToJoin;

import java.util.List;

public class GetGroupsUserRequestedToJoinData {
  public List<InnerGetGroupsUserRequestedToJoinData> data;

  public static class InnerGetGroupsUserRequestedToJoinData {
    public Long id;
    public String name;
    public String description;
    public OwnerData owner;
    public ShoutData shout;
    public Long memberCount;
    public Boolean isBuildersClubOnly;
    public Boolean publicEntryAllowed;
    public Boolean isLocked;
    public Boolean hasVerifiedBadge;
    public Boolean hasSocialModules;
    public CommunityTier communityTier;
  }

  public static class OwnerData {
    public Integer buildersClubMembershipType;
    public Boolean hasVerifiedBadge;
    public Long userId;
    public String username;
    public String displayName;
  }

  public static class ShoutData {
    public String body;
    public OwnerData poster;
    public String created;
    public String updated;
  }

  public static class CommunityTier {
    public Long groupId;
    public Integer currentTier;
    public Integer previousTier;
    public String tierUpdatedTime;
    public String lastEvaluatedTime;
    public Requirements requirements;
  }

  public static class Requirements {
    public Long key;
    public Boolean satisfied;
  }
}
