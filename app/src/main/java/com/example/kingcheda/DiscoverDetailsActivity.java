package com.example.kingcheda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DiscoverDetailsActivity extends AppCompatActivity {

    TextView storyTitle, storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_details);

        storyContent = findViewById(R.id.contentOfStory);
        storyTitle = findViewById(R.id.titleOfStory);

        Intent i = getIntent();
        String title = i.getStringExtra("titleOfStory");
        String content = i.getStringExtra("contentOfStory");

       storyTitle.setText(title);

        storyContent.setText(content);
        storyContent.setMovementMethod(new ScrollingMovementMethod());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}