package com.example.android.footballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private int scoreA;
    private int scoreB;

    // Score for a Point After Touchdown (PAT)
    private static final int SCORE_PAT = 1;
    // Score for a Point After Touchdown (PAT) or Safety
    private static final int SCORE_PAT_SAFETY = 2;
    // Score for a Field Goal or a Fair Catch Kick (FCK)
    private static final int SCORE_FG_FCK = 3;
    // Score for a Touchdown (TD)
    private static final int SCORE_TD = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Display score for Team A and B.
     */
    private void display() {
        TextView scoreView = (TextView) findViewById(R.id.scoreA);
        scoreView.setText(String.valueOf(this.scoreA));
        scoreView = (TextView) findViewById(R.id.scoreB);
        scoreView.setText(String.valueOf(this.scoreB));
    }

    /**
     * Add points to the team's score.
     *
     * @param v view
     */
    public void addPoints(View v) {
        switch (v.getId()) {
            case R.id.add1A:
                this.scoreA += this.SCORE_PAT;
                break;
            case R.id.add1B:
                this.scoreB += this.SCORE_PAT;
                break;
            case R.id.add2A:
                this.scoreA += this.SCORE_PAT_SAFETY;
                break;
            case R.id.add2B:
                this.scoreB += this.SCORE_PAT_SAFETY;
                break;
            case R.id.add3A:
                this.scoreA += this.SCORE_FG_FCK;
                break;
            case R.id.add3B:
                this.scoreB += this.SCORE_FG_FCK;
                break;
            case R.id.add6A:
                this.scoreA += this.SCORE_TD;
                break;
            case R.id.add6B:
                this.scoreB += this.SCORE_TD;
                break;
        }
        display();
    }

    /**
     * Reset score.
     *
     * @param v View
     */
    public void reset(View v) {
        this.scoreA = this.scoreB = 0;
        display();
    }
}