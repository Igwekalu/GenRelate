package com.example.igweigwe_kalu.genrelate;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igweigwe-kalu on 3/7/16.
 */
public class genreLab {

    private static genreLab sgenreLab;
    private List<Genre> mGenreList;



    public static genreLab get(Context context) {
        if (sgenreLab == null) {
            sgenreLab = new genreLab(context);
        }

        return sgenreLab;

    }

    public genreLab(Context context){
        int i = 0;
        mGenreList = new ArrayList<>(getResults());

        while(i!=15){
        //for (i = 1; i < mGenreList.size(); i++);{
            System.out.println("b: " + mGenreList.size());
            Genre genre = new Genre();
            genre.setmGenreId(i);
            genre.setmGenreName("Genre: " + i);
            if (mGenreList.size() == 0){
                mGenreList.add(genre);
                i++;
            }
            else{
                mGenreList.add(i,genre);
                i++;
            }
        }
    }

    public List<Genre> getResults(){
        if(mGenreList == null){
            mGenreList = new ArrayList<>(100);
        }

        System.out.println("a: " + mGenreList.size());
        return mGenreList;
    }
}
