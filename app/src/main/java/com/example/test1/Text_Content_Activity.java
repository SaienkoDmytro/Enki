package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private int category;
    private TextView text_content;
    private int position;
    private int [] array_video = {R.string.text_video, R.string.text_video1};
    private ImageView imageContent;
    private int [] array_image = {R.drawable.youtube, R.drawable.twitch};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_youtube);
        imageContent = findViewById(R.id.imageContent);
        reciveIntent();
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

        break;
    case (2):

        break;
    case (3):

        break;
    case (4):

        break;
    case (5):

        break;
    case (6):

        break;
    case (7):

        break;
}
    }
}
