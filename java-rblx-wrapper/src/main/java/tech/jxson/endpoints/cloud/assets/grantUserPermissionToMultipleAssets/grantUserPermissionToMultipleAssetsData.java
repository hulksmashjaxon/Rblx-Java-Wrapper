package tech.jxson.endpoints.cloud.assets.grantUserPermissionToMultipleAssets;

import java.util.List;

public class grantUserPermissionToMultipleAssetsData {
  public List<Long> successAssetIds;
  public List<errors> errors;

  public static class errors {
    public String code;
    public Long assetId;
  }
}
