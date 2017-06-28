package by.instinctools.megamag.common.api.pojo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class PageResponse {

    @SerializedName("id")
    public String id;
    @SerializedName("js")
    public JsonObject js;
    @SerializedName("text")
    public String text;
}
