package tech.jxson.users.SearchForUsersByKeyword;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SearchForUsersByKeywordData {
  public String previousPageCursor;
  public String nextPageCursor;
  @SerializedName("data")
  public List<GetUsersByKeywordList> data;

  public static class GetUsersByKeywordList {
    @SerializedName("previousUsernames")
    public List<String> previousUsernames;
    public Boolean hasVerifiedBadge;
    public long id;
    public String name;
    public String displayName;
  }
}
