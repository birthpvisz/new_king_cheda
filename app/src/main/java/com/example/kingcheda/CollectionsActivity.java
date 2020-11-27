package com.example.kingcheda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kingcheda.Admin.AdminCategoryActivity;

public class CollectionsActivity extends AppCompatActivity
{
    private Button collectionsBTN, discoverBTN, communityBTN;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);


        collectionsBTN = (Button) findViewById(R.id.collections_btn);
        discoverBTN = (Button) findViewById(R.id.discover_btn);
        communityBTN = (Button) findViewById(R.id.community_btn);

        collectionsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(CollectionsActivity.this, "Welcome to our wonderful collections", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CollectionsActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        discoverBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(CollectionsActivity.this, "Join our Daily Feeds of Daily Discovery", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CollectionsActivity.this, DiscoverActivity.class);
                startActivity(intent);
            }
        });

        communityBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(CollectionsActivity.this, "Meet Awesome People of Like Minds, Sharing Moments, Excitement & Adventures", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CollectionsActivity.this, CommunityActivity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    }
