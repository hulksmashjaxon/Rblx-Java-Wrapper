package tech.jxson.endpoints.groups.GetUserPrimaryGroup;

import java.util.List;

import org.jspecify.annotations.Nullable;

public class GetUserPrimaryGroupData {
  public InnerGetUserPrimaryGroupData group;
  public RoleData role;
  @Nullable public Boolean isPrimaryGroup;
  @Nullable public List<NotificationPreferenceData> notificationPreferences;

  public static class InnerGetUserPrimaryGroupData {
    public Long id;
    public String name;
    public String description;
    public OwnerData owner;
    @Nullable public ShoutData shout;
    public Long memberCount;
    public Boolean isBuildersClubOnly;
    public Boolean publicEntryAllowed;
    public Boolean isLocked;
    public Boolean hasVerifiedBadge;
    public Boolean hasSocialModules;
    @Nullable public CommunityTier communityTier; // JSON objects are represent as their classes... not List<CommunityTier>... shit
  }

  public static class OwnerData {
    @Nullable public Integer buildersClubMembershipType;
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

  public static class RoleData {
    public Long id;
    public String name;
    public String description;
    public Integer rank;
    public Long memberCount;
    public Boolean isBase;
    public Integer color;
  }
  
  public static class NotificationPreferenceData {
    public Integer type;
    public Boolean enabled;
    public String name;
    public String description;
  }
}
