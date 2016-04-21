package com.example.igweigwe_kalu.genrelate;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

/**
 * Created by igweigwe-kalu on 3/12/16.
 */
public class genreButtonActivity extends ScrollingActivity {
    protected Fragment createFragment() {
        return new GenreFragment();
    }


}
