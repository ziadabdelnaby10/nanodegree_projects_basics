package com.example.nanodegree_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String nameFirstTeam = "mmm" , nameSecondTeam = "kkk";
    TextView firstOutScore , firstGoalScore , firstFoulScore , secondOutScore , secondGoalScore , secondFoulScore , FirstName , SecondName;
    int firstOut = 0 , firstGoal = 0 , firstFoul = 0 , secondOut = 0 , secondGoal = 0 , secondFoul = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle x = getIntent().getExtras();
        nameFirstTeam = x.getString("First");
        nameSecondTeam = x.getString("Second");

        firstFoulScore = findViewById(R.id.txtFirstFoul);
        firstOutScore = findViewById(R.id.txtFirstOut);
        firstGoalScore = findViewById(R.id.txtFirstGoal);
        secondFoulScore = findViewById(R.id.txtSecondFoul);
        secondOutScore = findViewById(R.id.txtSecondOut);
        secondGoalScore = findViewById(R.id.txtSecondGoal);

        FirstName = findViewById(R.id.firstName);
        SecondName = findViewById(R.id.secondName);

        FirstName.setText(nameFirstTeam);
        SecondName.setText(nameSecondTeam);

        firstGoalScore.setText(firstGoal+"");
        firstOutScore.setText(firstOut+"");
        firstFoulScore.setText(firstFoul+"");
        secondGoalScore.setText(secondGoal+"");
        secondOutScore.setText(secondOut+"");
        secondFoulScore.setText(secondFoul+"");
    }

    public void resetTheScore(View view) {
        firstFoul = 0;
        firstOut = 0;
        firstGoal = 0;
        secondFoul = 0;
        secondGoal = 0;
        secondOut = 0;

        firstGoalScore.setText(firstGoal+"");
        firstOutScore.setText(firstOut+"");
        firstFoulScore.setText(firstFoul+"");
        secondGoalScore.setText(secondGoal+"");
        secondOutScore.setText(secondOut+"");
        secondFoulScore.setText(secondFoul+"");
    }

    public void incSecondFoul(View view) {
        secondFoul++;
        secondFoulScore.setText(secondFoul+"");
    }

    public void incSecondGoal(View view) {
        secondGoal++;
        secondGoalScore.setText(secondGoal+"");
    }

    public void incFirstFoul(View view) {
        firstFoul++;
        firstFoulScore.setText(firstFoul+"");
    }

    public void incFirstGoal(View view) {
        firstGoal++;
        firstGoalScore.setText(firstGoal+"");
    }

    public void incFirstOut(View view) {
        firstOut++;
        firstOutScore.setText(firstOut+"");
    }

    public void incSecondOut(View view) {
        secondOut++;
        secondOutScore.setText(secondOut+"");
    }
}
