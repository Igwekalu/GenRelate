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
    private List<Genre> mGenreList;


    public static genreLab get(Context context) {
        if (sgenreLab == null) {
            sgenreLab = new genreLab(context);
        }

        return sgenreLab;

    }

    public genreLab(Context context) {
        mGenreList = new ArrayList<>(getResults());
        for (int i = 0; i < mGenreList.size();i++){
            Genre genre = new Genre();
            genre.setmGenreName(mGenreList.get(i).getGenreName());
        }


        //Testing to populate list
        /*int i = 0;
        mGenreList = new ArrayList<>(getResults());

        while (i != 15) {
            //for (i = 1; i < mGenreList.size(); i++);{
            System.out.println("b: " + mGenreList.size());
            Genre genre = new Genre();
            genre.setmGenreId(i);
            genre.setmGenreName("Genre: " + i);
            if (mGenreList.size() == 0) {
                mGenreList.add(genre);
                i++;
            } else {
                mGenreList.add(i, genre);
                i++;
            }
        }*/
    }

    public List<Genre> getResults() {

        mGenreList = new ArrayList<Genre>();

        final ParseQuery<ParseObject> query = ParseQuery.getQuery("GenreNames");
        query.orderByAscending("GenreName");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (ParseObject genre : objects) {
                        Genre genre2 = new Genre((String) genre.get("GenreName"));
                        mGenreList.add(genre2);
                    }
                } else {
                    Log.d("error", "didn't work" + e.getMessage());
                }
            }
        /*try {
            List<Genre> queryResults = query.find();

            }
        }
        catch (ParseException e){
            Log.d("error", "didn't work" + e.getMessage());
        }
        if(mGenreList == null){
            mGenreList = new ArrayList<>(100);
        }

        System.out.println("a: " + mGenreList.size());*/

        });
        return mGenreList;
    }
}
