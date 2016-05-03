package com.example.igweigwe_kalu.genrelate;

/**
 * Created by igweigwe-kalu on 4/28/16.
 */
public class Sound {
    private String mAssetPath;
    private String mName;


    public Sound(String assetPath){

        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length-1];
        mName = filename.replace("wav", "");
    }

    public String getmAssetPath() {
        return mAssetPath;
    }

    public void setmAssetPath(String mAssetPath) {
        this.mAssetPath = mAssetPath;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
