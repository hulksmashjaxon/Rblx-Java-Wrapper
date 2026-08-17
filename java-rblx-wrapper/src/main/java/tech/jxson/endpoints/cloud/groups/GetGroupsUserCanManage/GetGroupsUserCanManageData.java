package tech.jxson.endpoints.cloud.groups.GetGroupsUserCanManage;

import java.util.List;

public class GetGroupsUserCanManageData {
  public List<InnerGetGroupsUserCanManageData> data;

  public class InnerGetGroupsUserCanManageData {
    public Long id;
    public String name;
  }
}
