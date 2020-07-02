package com.example.test1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private int category;
    private TextView text_content;
    private Typeface face1;
    private int position;
    private int [] array_video = {R.string.text_video, R.string.text_video1, R.string.text_PB, R.string.text_PBD,R.string.text_pros,R.string.text_mech};
    private ImageView imageContent;
    private int [] array_image = {R.drawable.youtube, R.drawable.twitch, R.drawable.twitch, R.drawable.twitch, R.drawable.twitch, R.drawable.twitch};
    private int [] array_pob = {R.string.text_PB, R.string.text_PBD};
    private int [] array_image_pob = {R.drawable.twitch, R.drawable.twitch};
    private int [] array_about = {R.string.text_pros,R.string.text_mech};
    private int [] array_image_about = {R.drawable.youtube, R.drawable.youtube};
    private int [] array_lvl = {R.string.text_lvl1,R.string.text_lvl2, R.string.text_lvl3};
    private int [] array_image_lvl = {R.drawable.youtube, R.drawable.youtube, R.drawable.youtube};
    private int [] array_asc = {R.string.text_asc1,R.string.text_asc2, R.string.text_asc3};
    private int [] array_image_asc = {R.drawable.youtube, R.drawable.youtube, R.drawable.youtube};
    private int [] array_gem = {R.string.text_gem1};
    private int [] array_image_gem = {R.drawable.youtube};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_youtube);
        imageContent = findViewById(R.id.imageContent);
        reciveIntent();
        init();
    }
    private void reciveIntent() {
Intent i = getIntent();
if (i != null){
category = i.getIntExtra("category", 0);
position = i.getIntExtra("position", 0);
}
switch (category){
    case (0):
text_content.setText(array_video[position]);
imageContent.setImageResource(array_image[position]);
        break;
    case (1):
        text_content.setText(array_pob[position]);
        imageContent.setImageResource(array_image_pob[position]);
        break;
    case (2):
        text_content.setText(array_about[position]);
        imageContent.setImageResource(array_image_about[position]);
        break;
    case (3):
        text_content.setText(array_lvl[position]);
        imageContent.setImageResource(array_image_lvl[position]);
        break;
    case (4):
        text_content.setText(array_asc[position]);
        imageContent.setImageResource(array_image_asc[position]);
        break;
    case (5):
        text_content.setText(array_gem[position]);
        imageContent.setImageResource(array_image_gem[position]);
        break;
    case (6):

        break;
    case (7):

        break;
}
    }
    private void init(){
        text_content = findViewById(R.id.text_youtube);
        imageContent = findViewById(R.id.imageContent);
        face1 = Typeface.createFromAsset(this.getAssets(), "fonts/Spartan-Regular.ttf");
        text_content.setTypeface(face1);
    }
}