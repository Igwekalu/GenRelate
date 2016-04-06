package com.example.igweigwe_kalu.genrelate;

import android.widget.Button;

import java.util.UUID;

/**
 * Created by igweigwe-kalu on 4/3/16.
 */
public class Genre {

    private UUID mId;
    private String mGenreName;
    private int mGenreId;
    private Button mGenreButton;

    public Genre(){
        mGenreName = getGenreName();
    }

    public Genre(String id){
        mId = UUID.randomUUID();
    }


    public int getGenreId(){return mGenreId;}

    public void setmGenreId(int genreId){
        mGenreId = genreId;
    }

    public String getGenreName(){return mGenreName;}

    public void setmGenreName(String nameId){
        mGenreName = nameId;
    }


}
