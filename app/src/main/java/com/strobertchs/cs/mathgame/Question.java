package com.strobertchs.cs.mathgame;
import java.util.Random;

/**
 * Models a question in a math game
 * Created by robuntu on 11/12/17.
 */


public class Question {

    private int partA;  // the first operand
    private int partB;  // second operand
    private int correctAnswer;
    private int wrongAnswer1;
    private int wrongAnswer2;

    /**
     * Construct a multiplication question
     * @param gameLevel used to set the range of values for the question
     */
    public Question(int gameLevel){

        int numberRange = gameLevel * 3;
        Random randInt = new Random();

        partA = randInt.nextInt(numberRange);
        partA++;//not zero

        partB = randInt.nextInt(numberRange);
        partB++;//not zero

        correctAnswer = partA * partB;
        wrongAnswer1 = correctAnswer-2;
        wrongAnswer2 = correctAnswer+2;
    }

    /**
     * Getter method for partA
     * @return value of partA
     */
    public int getPartA() {
        return partA;
    }


    /**
     * Getter method for partB
     * @return value of partB
     */
    public int getPartB() {
        return partB;
    }

    /**
     * Getter method for correctAnswer
     * @return value of correctAnswer
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }


    /**
     * Getter method for wrongAnswer1
     * @return value of wrongAnswer1
     */
    public int getWrongAnswer1() {
        return wrongAnswer1;
    }


    /**
     * Getter method for wrongAnswer2
     * @return value of wrongAnswer2
     */
    public int getWrongAnswer2() {
        return wrongAnswer2;
    }


    /**
     * Check if a given answer is correct
     * @param answerGiven the guessed answer
     * @return true if the answer is correct
     */
    public boolean guessIsCorrect(int answerGiven){
        return answerGiven == correctAnswer;
    }



}
