package com.example.igweigwe_kalu.genrelate;

/**
 * Created by igweigwe-kalu on 4/24/16.
 */
public class GalleryItem {

    private String mId;
    private String mCaption;
    private String mURL;

    @Override
    public String toString() {
        return mCaption;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCaption() {
        return mCaption;
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }
}
