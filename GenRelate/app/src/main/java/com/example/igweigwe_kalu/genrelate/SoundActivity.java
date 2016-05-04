package com.example.igweigwe_kalu.genrelate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by igweigwe-kalu on 5/3/16.
 */
public class SoundActivity extends Activity {
    private SoundPool mGenreSound;
    private int maxVolume = 5;
    private String currentSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("thisGenre");
            currentSound = value;
        }
        setContentView(R.layout.notes_view);
        super.onCreate(savedInstanceState);
        mGenreSound = new SoundPool(maxVolume, AudioManager.STREAM_MUSIC,0);
        loadSound();
    }

    public void loadSound() {

        ParseQuery query = new ParseQuery("GenreNames");
        query.whereEqualTo("Sound", currentSound);
        query.findInBackground();
        Toast.makeText(this, currentSound,
                Toast.LENGTH_LONG).show();

    }

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, SoundActivity.class);
        return i;
    }
}
