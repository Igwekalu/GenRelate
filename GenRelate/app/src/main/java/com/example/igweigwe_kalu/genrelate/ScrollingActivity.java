package com.example.igweigwe_kalu.genrelate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public abstract class ScrollingActivity extends FragmentActivity implements View.OnClickListener {


    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.button_layout);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.button_layout, fragment)
                    .commit();
        }

        //Enabling the use of Parse and initializing the connection
        //between the server and the app
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Genre.class);
        Parse.initialize(this, "QTGRlLMbhjTx5YpoGMx1KmdpO00CLmtWfj1jpgxL",
                "1dFGhppGtI3g20RJprvIjJbmP4F4KXJ5jLK53cEe");

        //Testing and Adding Genre Classes to Parse

        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        /*ParseObject GenreName = new ParseObject("GenreNames");
        GenreName.put("GenreName", "Instrumental");

        GenreName.saveInBackground();*/

        //OnClickListener for all buttons


    }

    @Override
    public void onClick(View v) {
        setContentView(R.layout.selection_menu);
    }
}
