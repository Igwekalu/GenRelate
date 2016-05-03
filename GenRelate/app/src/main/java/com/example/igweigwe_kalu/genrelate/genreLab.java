package com.example.igweigwe_kalu.genrelate;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igweigwe-kalu on 3/7/16.
 */
public class genreLab {

    private static genreLab sgenreLab;
    public List<Genre> mGenreList;


    public static genreLab get(Context context) {
        if (sgenreLab == null) {
            sgenreLab = new genreLab(context);
        }

        return sgenreLab;

    }

    public genreLab(Context context) {

        mGenreList = new ArrayList<>(getResults());


    }

    public List<Genre> getResults() {
        //int i =1;
        mGenreList = new ArrayList<Genre>();

        ParseQuery query = new ParseQuery("GenreNames");
        query.orderByAscending("GenreName");
        try{
              List<Genre> queryResult = query.find();
            for (ParseObject newGenre : queryResult){
                mGenreList.add(new Genre(newGenre.getString("GenreName")));
            }
        }
        catch (ParseException e){
            Log.d("error", "didn't work" + e.getMessage());
        }


        for (int i = 0; i < mGenreList.size();i++){
            Genre genre = new Genre();
            genre.setmGenreName(mGenreList.get(i).getGenreName());
            genre.setGenreId(i);
            System.out.println("GenreId " + genre.getGenreId());
        }
   return mGenreList;

    }
}
