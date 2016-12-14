package entity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Simar Arora on 27/07/16.
 */
public class ShareInfoEntity {
    @SerializedName("facebook_al")
    @Expose
    private ShareDataEntity facebookAl;
    @SerializedName("twitter")
    @Expose
    private ShareDataEntity twitter;
    @SerializedName("sms")
    @Expose
    private ShareDataEntity sms;
    @SerializedName("linkedin")
    @Expose
    private ShareDataEntity linkedin;
    @SerializedName("general")
    @Expose
    private ShareDataEntity general;
    @SerializedName("facebook")
    @Expose
    private ShareDataEntity facebook;
    @SerializedName("whatsapp")
    @Expose
    private ShareDataEntity whatsapp;
    @SerializedName("email")
    @Expose
    private ShareDataEntity email;


    public ShareDataEntity getFacebookAl() {
        return facebookAl;
    }

    public void setFacebookAl(ShareDataEntity facebookAl) {
        this.facebookAl = facebookAl;
    }

    public ShareDataEntity getTwitter() {
        return twitter;
    }

    public void setTwitter(ShareDataEntity twitter) {
        this.twitter = twitter;
    }

    public ShareDataEntity getSms() {
        return sms;
    }

    public void setSms(ShareDataEntity sms) {
        this.sms = sms;
    }

    public ShareDataEntity getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(ShareDataEntity linkedin) {
        this.linkedin = linkedin;
    }

    public ShareDataEntity getGeneral() {
        return general;
    }

    public void setGeneral(ShareDataEntity general) {
        this.general = general;
    }

    public ShareDataEntity getFacebook() {
        return facebook;
    }

    public void setFacebook(ShareDataEntity facebook) {
        this.facebook = facebook;
    }

    public ShareDataEntity getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(ShareDataEntity whatsapp) {
        this.whatsapp = whatsapp;
    }

    public ShareDataEntity getEmail() {
        return email;
    }

    public void setEmail(ShareDataEntity email) {
        this.email = email;
    }
}
