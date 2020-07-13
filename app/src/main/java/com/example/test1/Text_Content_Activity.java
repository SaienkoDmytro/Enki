package com.example.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Text_Content_Activity extends AppCompatActivity {
    private int category;
    private AdView mAdView;
    private SharedPreferences def_pref;
    private ActionBar actionBar;
    private TextView text_content, text_content1;
    private Typeface face1;
    private int position;
    private int [] array_video = {R.string.text_video, R.string.text_video1};
    private String [] array_image = {"Youtube", "Twitch"};
    private int [] array_pob = {R.string.text_PB, R.string.text_PBD};
    private String [] array_pob1 = {"Pastebin and Browser Version", "POB download"};
    private int [] array_about = {R.string.text_pros,R.string.text_mech, R.string.text_thanks};
    private String [] array_about1 = {"Pros/Cons", "Main Mechanics in this Build", "About this Build, App and Thanks"};
    private int [] array_lvl = {R.string.text_lvl1,R.string.text_lvl2, R.string.text_lvl3};
    private String [] array_lvl1 = {"Before you start", "Full Leveling Section", "Leveling Section"};
    private int [] array_asc = {R.string.text_asc1,R.string.text_asc2, R.string.text_asc3};
    private String [] array_asc1 = {"Passives", "Ascendancy", "Pantheon"};
    private int [] array_gem = {R.string.text_gem1};
    private String [] array_gem1 = {"Main"};
    private int [] array_gear = {R.string.text_gear1, R.string.text_gear2, R.string.text_gear3, R.string.text_gear4, R.string.text_gear5};
    private String [] array_gear1 = {"Gear", "Jewels", "Cluster Jewels", "Flasks", "Upgrade Order"};
    private int [] array_map = {R.string.text_mapping, R.string.text_mapmods,R.string.text_boss};
    private String [] array_map1 = {"Mapping", "Mapmods", "Bossfights"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_youtube);
        text_content1 = findViewById(R.id.array_name);
        text_content.setMovementMethod(LinkMovementMethod.getInstance());
        text_content1.setMovementMethod(LinkMovementMethod.getInstance());
        reciveIntent();
        init();
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
    private void reciveIntent() {
Intent i = getIntent();
if (i != null){
category = i.getIntExtra("category", 0);
position = i.getIntExtra("position", 0);
}
switch (category){
    case (0):
text_content.setText(array_about[position]);
text_content1.setText(array_about1[position]);
        break;
    case (1):
        text_content.setText(array_pob[position]);
        text_content1.setText(array_pob1[position]);
        break;
    case (2):
        text_content.setText(array_video[position]);
        text_content1.setText(array_image[position]);
        break;
    case (3):
        text_content.setText(array_lvl[position]);
        text_content1.setText(array_lvl1[position]);
        break;
    case (4):
        text_content.setText(array_asc[position]);
        text_content1.setText(array_asc1[position]);
        break;
    case (5):
        text_content.setText(array_gem[position]);
        text_content1.setText(array_gem1[position]);
        break;
    case (6):
        text_content.setText(array_gear[position]);
        text_content1.setText(array_gear1[position]);
        break;
    case (7):
        text_content.setText(array_map[position]);
        text_content1.setText(array_map1[position]);
        break;
}
    }
    private void init(){
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        text_content = findViewById(R.id.text_youtube);
        text_content1 = findViewById(R.id.array_name);
        face1 = Typeface.createFromAsset(this.getAssets(), "fonts/Spartan-Regular.ttf");
        text_content.setTypeface(face1);
        if(getSupportActionBar() !=null) {
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String text = def_pref.getString("main_text_size", "Regular");
        if(text != null) {
            switch (text) {
                case "Big":
                    text_content.setTextSize(24);
                    break;
                case "Regular":
                    text_content.setTextSize(18);
                    break;
                case "Small":
                    text_content.setTextSize(14);
                    break;
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}
