package com.example.justmathspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtViewQuestion;
    TextView txtResult;
    TextView txtTime;
    TextView txtScore;
    ImageButton btnCorrect;
    ImageButton btnInCorrect;
    boolean isResultCorrect;
    int seconds = 59;
    private int score = 0;
    private  boolean stopTimer = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtViewQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnCorrect = (ImageButton) findViewById(R.id.btnCorrect);
        btnInCorrect = (ImageButton) findViewById(R.id.btnInCorrect);
        timer();
        btnInCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(false);
            }
        });


        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer(true);
            }
        });

        generateQuestion();

    }

private  void generateQuestion() {

      isResultCorrect = true;
    Random random = new Random();
    int a = random.nextInt(100);
    int b = random.nextInt(100);
    int result = a + b;
    float f = random.nextFloat();
    if (f < 0.5f) {
        result = random.nextInt(100);
        isResultCorrect = false;
    }
      txtViewQuestion.setText(a + "+" + b);
      txtResult.setText("=" + result);

}

public  void verifyAnswer(boolean answer) {
    if (answer == isResultCorrect) {
        score += 5;
        txtScore.setText("SCORE:" + score);

    } else {
        Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
   generateQuestion();

}

private  void  timer() {
   final Handler handler = new Handler();
   handler.post(new Runnable() {
       @Override
       public void run() {
         txtTime.setText("TIME :" + seconds);
         seconds--;
    if (seconds < 0){
        Intent i = new Intent(GameActivity.this, ScoreActivity.class);
         i.putExtra("score", score);
         startActivity(i);
         stopTimer = true;
}
      if(stopTimer== false){
          handler.postDelayed(this,1000);
      }
       }
   });

}
@Override
protected void onPause(){
     super.onPause();
     stopTimer = false;
     finish();
}


}
