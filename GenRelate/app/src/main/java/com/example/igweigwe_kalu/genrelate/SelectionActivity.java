package com.example.igweigwe_kalu.genrelate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by igweigwe-kalu on 4/18/16.
 */
public class SelectionActivity extends Activity{
    public Button mHistoryButton;
    public Button mNotesButton;
    public Button mInstrumentButton;
    public String currentGenre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("thisGenre");
            currentGenre = value;
        }
        setContentView(R.layout.selection_menu);


        mHistoryButton = (Button)findViewById(R.id.history_button);
        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.history_view);
            }

            });
                mNotesButton = (Button) findViewById(R.id.note_button);
                mNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = SoundActivity.newIntent(SelectionActivity.this);
                i.putExtra("thisGenre", currentGenre);
                startActivity(i);
            }

        });
                mInstrumentButton = (Button) findViewById(R.id.instrument_button);
                mInstrumentButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = photoActivity.newIntent(SelectionActivity.this);
                        i.putExtra("thisGenre", currentGenre);
                        startActivity(i);
                    }

                });

            }


            public static Intent newIntent(Context packageContext) {
                Intent i = new Intent(packageContext, SelectionActivity.class);
                return i;
            }
        }
