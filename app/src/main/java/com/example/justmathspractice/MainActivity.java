package com.example.justmathspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnplay,btnstar,btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplay = (ImageButton) findViewById(R.id.btnplay);
        btnstar = (ImageButton) findViewById(R.id.btnstar);
        btnshare = (ImageButton) findViewById(R.id.btnshare);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, GameActivity.class);

                startActivity(i);

            }
        });


        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Just Maths - Fun  way to learn Maths. http/www.play.google.com");
                startActivity(intent);
            }
        });

        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You can open your Google Play landing page",Toast.LENGTH_LONG).show();
            }
        });










    }

}
