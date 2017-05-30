package com.example.android.simplypodcast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;
import static com.example.android.simplypodcast.R.id.manage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView podcast1 = (TextView) findViewById(R.id.podcast1);
        podcast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent podcast1Intent = new Intent(MainActivity.this, Episode1Activity.class);
                startActivity(podcast1Intent);
            }
        });

        TextView podcast2 = (TextView) findViewById(R.id.podcast2);
        podcast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent podcast2Intent = new Intent(MainActivity.this, Episode2Activity.class);
                startActivity(podcast2Intent);
            }
        });

        TextView podcast3 = (TextView) findViewById(R.id.podcast3);
        podcast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent podcast3Intent = new Intent(MainActivity.this, Episode3Activity.class);
                startActivity(podcast3Intent);
            }
        });

        Button manage = (Button) findViewById(R.id.manage);
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent manageIntent = new Intent(MainActivity.this, ManageActivity.class);
                startActivity(manageIntent);
            }
        });

        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Download new episodes of all podcasts.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
