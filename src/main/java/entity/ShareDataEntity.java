package entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Simar Arora on 27/07/16.
 */
public class ShareDataEntity {
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("text")
    @Expose
    private String shareText;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText;
    }
}
