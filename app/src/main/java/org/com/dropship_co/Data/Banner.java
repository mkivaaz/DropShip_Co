package org.com.dropship_co.Data;

public class Banner {

    String bannerTitle;
    String bannerUrl;
    String bannerImgUrl;

    public Banner(String bannerTitle, String bannerUrl, String bannerImgUrl) {
        this.bannerTitle = bannerTitle;
        this.bannerUrl = bannerUrl;
        this.bannerImgUrl = bannerImgUrl;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerImgUrl() {
        return bannerImgUrl;
    }

    public void setBannerImgUrl(String bannerImgUrl) {
        this.bannerImgUrl = bannerImgUrl;
    }
}
