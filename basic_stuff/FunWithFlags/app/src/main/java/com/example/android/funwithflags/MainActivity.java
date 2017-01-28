package com.example.android.funwithflags;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.android.funwithflags.R.id.score;

public class MainActivity extends AppCompatActivity {

    // number of quiz questions
    public static final int DEFAULT_SIZE = 5;

    /*
     * This is a little awkward, and I will have to find out if it is possible to create
     * dynamic layouts where IDs for views can be arrays.
     */
    public static int[] FLAG_VIEWS = {R.id.flag1, R.id.flag2, R.id.flag3, R.id.flag4, R.id.flag5};
    public static int[] NAME_VIEWS = {R.id.name1, R.id.name2, R.id.name3, R.id.name4, R.id.name5};

    // countries to choose from
    private List<Country> countries = new ArrayList<>();
    private List<Country> quizCountries = new ArrayList<>();

    /**
     * get all countries
     *
     * @return all countries
     */
    private List<Country> getCountries() {
        return this.countries;
    }

    /**
     * set all countries available
     *
     * @param countries the countries to choose from
     */
    private void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     * get quiz countries
     *
     * @return quiz countries
     */
    private List<Country> getQuizCountries() {
        return this.quizCountries;
    }

    /**
     * set quiz countries
     *
     * @param countries the countries for the quiz
     */
    private void setQuizCountries(List<Country> countries) {
        this.quizCountries = countries;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetQuiz();
    }

    /**
     * reset quiz
     *
     * @param view calling view
     */
    public void resetQuiz(View view) {
        resetQuiz();
    }

    /**
     * reset quiz
     */
    public void resetQuiz() {
        // reset answers
        for (int i = 0; i < MainActivity.NAME_VIEWS.length; i++) {
            ((TextView) findViewById(MainActivity.NAME_VIEWS[i])).setText("");
        }

        // reset score display
        ((TextView) findViewById(R.id.scoreTitle)).setText("");
        ((TextView) findViewById(score)).setText("");

        // shuffle countries
        if (getCountries().isEmpty()) {
            setCountries(getCountryData());
        }
        setQuizCountries(selectQuizCountries(getCountries(), -1));
        showCountries(getQuizCountries());
    }

    /**
     * compute the current score
     *
     * @return score
     */
    private int computeScore() {
        int score = 0;
        for (int i = 0; i < MainActivity.DEFAULT_SIZE; i++) {
            TextView answerView = (TextView) findViewById(MainActivity.NAME_VIEWS[i]);
            String answer = answerView.getText().toString();
            String solution = getQuizCountries().get(i).getName();
            if (answer.equals(solution)) {
                score++;
            }
        }
        return score;
    }

    /**
     * check answers and show score
     *
     * @param view calling view
     */
    public void checkQuiz(View view) {
        int score = computeScore();
        ((TextView) findViewById(R.id.scoreTitle)).setText(R.string.score_title);
        ((TextView) findViewById(R.id.score)).setText(score + "/" + getQuizCountries().size());
    }

    /**
     * get a certain number of random countries from all countries
     *
     * @param countries countries to choose from
     * @param number    number of countries to choose
     * @return random countries
     */
    private List<Country> selectQuizCountries(List<Country> countries, int number) {
        // sanitize input
        if (number < 0) {
            number = MainActivity.DEFAULT_SIZE;
        }
        // extreme values
        if (countries.isEmpty()) {
            return null;
        }
        if (number >= countries.size()) {
            return countries;
        }
        Collections.shuffle(countries);
        return countries.subList(0, number);
    }

    private void showCountries(List<Country> countries) {
        // counter
        int i = 0;

        for (Country country : countries) {
            ImageView flagView = (ImageView) findViewById(MainActivity.FLAG_VIEWS[i]);
            flagView.setImageResource(country.getFlagImage());
            i++;
        }
    }

    /**
     * get country data
     *
     * @return country data for the quiz
     */
    private List<Country> getCountryData() {
        List<Country> countries = new ArrayList<>();

        /*
         * Of course, it would be possible to load these files from a separate file, e.g. in
         * JSON format -- but I don't know how to do that yet ;-)
         */
        countries.add(new Country(R.drawable.australia, "Australia"));
        countries.add(new Country(R.drawable.canada, "Canada"));
        countries.add(new Country(R.drawable.denmark, "Denmark"));
        countries.add(new Country(R.drawable.finland, "Finland"));
        countries.add(new Country(R.drawable.iceland, "Iceland"));
        countries.add(new Country(R.drawable.ireland, "Ireland"));
        countries.add(new Country(R.drawable.jamaica, "Jamaica"));
        countries.add(new Country(R.drawable.lithuania, "Lithuania"));
        countries.add(new Country(R.drawable.sweden, "Sweden"));
        countries.add(new Country(R.drawable.switzerland, "Switzerland"));

        return countries;
    }

    /**
     * represents a country with information
     */
    private class Country {
        // the country's flag image
        private int flagImage;

        // the country's name
        private String name;

        // of course, further information about the country is possible

        /**
         * create a country
         *
         * @param flagImage resource name of the flag image
         * @param name      country's name
         */
        Country(int flagImage, String name) {
            this.flagImage = flagImage;
            this.name = name;
        }

        /**
         * get the country's resource name of the flag image
         *
         * @return country's resource name of the flag image
         */
        int getFlagImage() {
            return this.flagImage;
        }

        /**
         * get the country's name
         *
         * @return country's name
         */
        String getName() {
            return this.name;
        }
    }
}
