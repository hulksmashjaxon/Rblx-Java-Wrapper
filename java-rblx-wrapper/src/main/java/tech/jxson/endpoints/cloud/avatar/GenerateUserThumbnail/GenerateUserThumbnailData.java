package tech.jxson.endpoints.cloud.avatar.GenerateUserThumbnail;

import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class GenerateUserThumbnailData {
  public String path;
  public Metadata metadata;
  public Boolean done;
  public Response response;

  public class Metadata {
    @SerializedName("@type")
    public String type;
    public JsonObject additionalProp1; //json {}
  }
  public class Error {
    public Long code;
    public String message;
    public List<Details> details;
  }
  public class Details {
    @SerializedName("@type")
    public String type;
    public JsonObject additionalProp1;
  }
  public class Response {
    @SerializedName("@type")
    public String type;
    public JsonObject additionalProp1;
  }

  public enum Format {
    FORMAT_UNSPECIFIED,
    PNG,
    JPEG
  }

  public enum Shape {
    SHAPE_UNSPECIFIED,
    ROUND,
    SQUARE
  }
}