package com.strobertchs.cs.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends Activity implements View.OnClickListener{

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;

    Game mathGame = new Game();
    Question currQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The next line loads our UI design to the screen
        setContentView(R.layout.activity_game);


        /*Here we get a working object based on either the button
          or TextView class and base as well as link our new objects
          directly to the appropriate UI elements that we created previously*/
        textObjectPartA = (TextView)findViewById(R.id.textPartA);
        textObjectPartB = (TextView)findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);
        buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        setQuestion();

    }//onCreate ends here

    @Override
    public void onClick(View view) {
        //declare a new int to be used in all the cases
        int answerGiven=0;
        switch (view.getId()) {

            case R.id.buttonChoice1:
                //initialize a new int with the value contained in buttonObjectChoice1
                //Remember we put it there ourselves previously
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());

                break;

            case R.id.buttonChoice2:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());

                break;

            case R.id.buttonChoice3:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());

                break;

        }

        updateScoreAndLevel(answerGiven);
        setQuestion();

    }

    void setQuestion(){

        currQuestion = new Question(mathGame.getCurrentLevel());

        textObjectPartA.setText(""+currQuestion.getPartA());
        textObjectPartB.setText(""+currQuestion.getPartB());

        //set the multi choice buttons
        //A number between 0 and 2
        Random randInt = new Random();
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout){
            case 0:

                buttonObjectChoice1.setText(""+currQuestion.getCorrectAnswer());
                buttonObjectChoice2.setText(""+currQuestion.getWrongAnswer1());
                buttonObjectChoice3.setText(""+currQuestion.getWrongAnswer2());

                break;

            case 1:
                buttonObjectChoice2.setText(""+currQuestion.getCorrectAnswer());
                buttonObjectChoice3.setText(""+currQuestion.getWrongAnswer1());
                buttonObjectChoice1.setText(""+currQuestion.getWrongAnswer2());
                break;

            case 2:
                buttonObjectChoice3.setText(""+currQuestion.getCorrectAnswer());
                buttonObjectChoice1.setText(""+currQuestion.getWrongAnswer1());
                buttonObjectChoice2.setText(""+currQuestion.getWrongAnswer2());
                break;
        }
    }


    void updateScoreAndLevel(int answerGiven){

        if (currQuestion.guessIsCorrect(answerGiven)){
            Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
            mathGame.updateScore();
            mathGame.incrementLevel();
        }else{
            Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
            mathGame.resetScore();
        }

        //Actually update the two TextViews
        textObjectScore.setText("Score: " + mathGame.getCurrentScore());
        textObjectLevel.setText("Level: " + mathGame.getCurrentLevel());
    }

}