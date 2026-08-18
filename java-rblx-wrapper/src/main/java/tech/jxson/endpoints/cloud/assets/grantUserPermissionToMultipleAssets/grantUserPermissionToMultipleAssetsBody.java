package tech.jxson.endpoints.cloud.assets.grantUserPermissionToMultipleAssets;

import java.util.List;

public class grantUserPermissionToMultipleAssetsBody {
  public String subjectType;
  public String subjectId;
  public String action;
  public List<Requests> requests;
  public Boolean enableDeepAccessCheck;

  public class Requests {
    public Long assetId;
    public Boolean grantToDependencies;
    public Long parentVersionNumber;
  }
}
