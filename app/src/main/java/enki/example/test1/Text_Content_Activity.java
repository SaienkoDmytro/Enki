package enki.example.test1;

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

import saenko.enki.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Text_Content_Activity extends AppCompatActivity {
    private int category;
    private AdView mAdView;
    private SharedPreferences def_pref;
    private ActionBar actionBar;
    private TextView text_content, text_content1;
    private Typeface face1;
    private int position;
    //using one Activity for all information, so made this with arrays. Big, strange, but dont know better option for now.
    private int [] array_video = {R.string.text_video, R.string.text_video1};
    private int [] array_image = {R.string.youb, R.string.tw};
    private int [] array_pob = {R.string.text_PB, R.string.text_PBD};
    private int [] array_pob1 = {R.string.poba, R.string.pobd};
    private int [] array_about = {R.string.text_pros,R.string.text_mech, R.string.text_thanks};
    private int [] array_about1 = {R.string.pros, R.string.main, R.string.about};
    private int [] array_lvl = {R.string.text_lvl1,R.string.text_lvl2, R.string.text_lvl3};
    private int [] array_lvl1 = {R.string.before, R.string.fulllvl, R.string.lvl};
    private int [] array_asc = {R.string.text_asc1,R.string.text_asc2, R.string.text_asc3};
    private int [] array_asc1 = {R.string.pass, R.string.asce, R.string.pant};
    private int [] array_gem = {R.string.text_gem1};
    private int [] array_gem1 = {R.string.allgem};
    private int [] array_gear = {R.string.text_gear1, R.string.text_gear2, R.string.text_gear3, R.string.text_gear4, R.string.text_gear5};
    private int [] array_gear1 = {R.string.gearlist, R.string.Jewel, R.string.Clust, R.string.Flask, R.string.upgrade};
    private int [] array_map = {R.string.text_mapping, R.string.text_mapmods,R.string.text_boss};
    private int [] array_map1 = {R.string.Mapping, R.string.Mapmods, R.string.Bossfights};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //fill first content on open
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_youtube);
        text_content1 = findViewById(R.id.array_name);
        text_content.setMovementMethod(LinkMovementMethod.getInstance());
        text_content1.setMovementMethod(LinkMovementMethod.getInstance());
        reciveIntent();
        init();
        //this AdMob dont want to work another way WTF
        MobileAds.initialize(this, "ca-app-pub-5317923605482922~1688114550");
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
        //made category and position for fullfill arrays
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
        //lets change text and size here
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
