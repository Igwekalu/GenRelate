package com.example.igweigwe_kalu.genrelate;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igweigwe-kalu on 4/28/16.
 */
public class GenreSound {
    private static final String TAG = "GenreSound";
    public static final String soundFolder= "genre_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public GenreSound(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    public void loadSounds(){
        String [] soundNames;
        try{
            soundNames = mAssets.list(soundFolder);
        }
        catch (IOException ioe){
            Log.e(TAG, "Nope");
            return;
        }

        for (String filename : soundNames){
            String assetPath = soundFolder + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }

    }
    public List getSounds(){
        return mSounds;
    }
}