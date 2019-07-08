package com.example.android.footballshotscounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.footballshotscounter.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int missTeamA = 0;
    int missTeamB = 0;
    int totalTeamA = 0;
    int totalTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays a value on a given view.
     *
     * @param value  - a value to display
     * @param viewId - an id of the view to update
     */
    public void display(int value, int viewId) {
        TextView viewToUpdate = (TextView) findViewById(viewId);
        viewToUpdate.setText(String.valueOf(value));
    }

    /**
     * Adds score points for team A.
     */
    public void addScoreForTeamA(int score) {
        scoreTeamA += score;
        display(scoreTeamA, R.id.team_a_score);

    }

    /**
     * Adds score points for team B.
     */
    public void addScoreForTeamB(int score) {
        scoreTeamB += score;
        display(scoreTeamB, R.id.team_b_score);
    }

    /**
     * Adds miss points for team B.
     */
    public void addMissForTeamA(int missPoint) {
        missTeamA += missPoint;
        display(missTeamA, R.id.team_a_miss);
    }

    /**
     * Adds miss points for team B.
     */
    public void addMissForTeamB(int missPoint) {
        missTeamB += missPoint;
        display(missTeamB, R.id.team_b_miss);
    }

    /**
     * Reset all values to 0.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        missTeamA = 0;
        missTeamB = 0;
        totalTeamA = 0;
        totalTeamB = 0;
        display(0, R.id.team_a_score);
        display(0, R.id.team_b_score);
        display(0, R.id.team_a_miss);
        display(0, R.id.team_b_miss);
        display(0, R.id.team_a_total);
        display(0, R.id.team_b_total);
    }

    /**
     * Sets scores depending on the button pressed.
     */
    public void scorePoints(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.goal_button_a:
                addScoreForTeamA(1);
                break;
            case R.id.goal_button_b:
                addScoreForTeamB(1);
                break;
            case R.id.miss_button_a:
                addMissForTeamA(1);
                break;
            case R.id.miss_button_b:
                addMissForTeamB(1);
                break;
            default:
                System.out.println("I don't know what to score.");
                break;
        }
        calculateTotals();
    }

    /**
     * Calculates total scores.
     */
    public void calculateTotals() {
        totalTeamA = scoreTeamA + missTeamA;
        totalTeamB = scoreTeamB + missTeamB;
        display(totalTeamA, R.id.team_a_total);
        display(totalTeamB, R.id.team_b_total);
    }
}
