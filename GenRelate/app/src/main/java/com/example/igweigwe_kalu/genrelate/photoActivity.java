package com.example.igweigwe_kalu.genrelate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by igweigwe-kalu on 4/24/16.
 */
public class photoActivity extends ScrollingActivity {
    public Fragment createFragment(){
        return photoFragment.newInstance();
    }

   public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, photoActivity.class);
        return i;
    }

}
