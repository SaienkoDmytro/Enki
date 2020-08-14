package enki.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import saenko.enki.R;

public class Logo_activity extends Activity {
    private Animation logoAnim, buttonLogoAnim;
    private Button bAnim;
    private ImageView logoImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActiv();
    }
    private void init(){
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);
        logoImage = findViewById(R.id.logoView);
        bAnim = findViewById(R.id.button);
        logoImage.startAnimation(logoAnim);
        bAnim.startAnimation(buttonLogoAnim);
    }
//start App on START button click
    public void onClickStart(View view) {
        Intent i = new Intent(Logo_activity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    //auto start App after 3sec
    private void startMainActiv(){
     new Thread(new Runnable() {
         @Override
         public void run() {
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             Intent i = new Intent(Logo_activity.this,MainActivity.class);
             startActivity(i);
         }
     }).start();
    }
}
