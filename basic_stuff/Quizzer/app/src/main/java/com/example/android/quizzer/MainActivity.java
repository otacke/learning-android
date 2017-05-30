package com.example.android.quizzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Constant here, but now it could easily be replaced in a dynamic setting.
    private static final int QUESTION_MAX = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Check the questions and show results.
     *
     * @param view View that click came from.
     */
    public void check(View view) {
        int score;

        /*
         * This is not elegant, but functional.
         */

        // Question 1
        boolean q1o2 = ((RadioButton) findViewById(R.id.Question1_Option2)).isChecked();
        /*
         * We could have set score to 0 before ans used score++ as with the following questions,
         * but the rubric demands we use an if/else statement.
         */
        if (q1o2) {
            score = 1;
        } else {
            score = 0;
        }

        // Question 2
        /*
         * I guess there's a way to create dynamic layouts, e.g. by creating them in your code
         * instead of an XML file, right? Something like setting up the Document Object Model
         * framework in HTML/CSS but changing it dynamically in JavaScript? Arrays or something a
         * little more sophisticated would be much cooler for those options, but it didn't seem
         * to work in the XML file.
         */
        boolean q2o1 = ((CheckBox) findViewById(R.id.Question2_Option1)).isChecked();
        boolean q2o2 = ((CheckBox) findViewById(R.id.Question2_Option2)).isChecked();
        boolean q2o3 = ((CheckBox) findViewById(R.id.Question2_Option3)).isChecked();
        boolean q2o4 = ((CheckBox) findViewById(R.id.Question2_Option4)).isChecked();
        if (!q2o1 & q2o2 & q2o3 & q2o4) {
            score++;
        }

        // Question 3
        String q3o1 = ((EditText) findViewById(R.id.Question3_Option1)).getText().toString();
        if (q3o1.equals("Quizzer")) {
            score++;
        }

        // Question 4
        boolean q4o2 = ((RadioButton) findViewById(R.id.Question4_Option2)).isChecked();
        if (q4o2) {
            score++;
        }

        // output results
        ((TextView) findViewById(R.id.Results)).setText("Your score is " + score + "/" + QUESTION_MAX);
    }
}
