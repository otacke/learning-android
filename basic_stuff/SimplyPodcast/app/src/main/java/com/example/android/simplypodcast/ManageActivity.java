package com.example.android.simplypodcast;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.android.simplypodcast.R.id.manage;

public class ManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        Button deletePodcast1 = (Button) findViewById(R.id.delete_podcast1);
        deletePodcast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delete this podcast.", Toast.LENGTH_SHORT).show();
            }
        });

        Button deletePodcast2 = (Button) findViewById(R.id.delete_podcast2);
        deletePodcast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delete this podcast.", Toast.LENGTH_SHORT).show();
            }
        });

        Button add = (Button) findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(ManageActivity.this, AddActivity.class);
                startActivity(addIntent);
            }
        });
    }
}
