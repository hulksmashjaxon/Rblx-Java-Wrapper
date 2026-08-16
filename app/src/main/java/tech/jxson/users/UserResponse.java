package tech.jxson.users;

import java.util.Date;

public class UserResponse {
  public String path;
  public Date createTime;
  public String id;
  public String name;
  public String displayName;
  public String about;
  public String locale;
  public boolean premium;
  public boolean idVerified;
  
  public SocialProfiles socialNetworkProfiles;

  public static class SocialProfiles {
    public String facebook;
    public String twitter;
    public String youtube;
    public String twitch;
    public String guilded;
    public String visibility;
  }
}
