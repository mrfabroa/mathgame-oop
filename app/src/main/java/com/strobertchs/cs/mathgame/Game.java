package com.strobertchs.cs.mathgame;
/**
 * Models a game
 * Created by robuntu on 11/12/17.
 */

public class Game {
    private int currentScore;
    private int currentLevel;

    /**
     * Construct a Game object, default score at 0 and level at 1
     */
    public Game(){
        resetScore();
    }

    /**
     * Reset the score at 0 and level at 1
     */
    public void resetScore() {
        currentScore = 0;
        currentLevel = 1;
    }


    /**
     * Update the currentScore based on the currentLevel
     */
    public void updateScore(){
        for(int i = 1; i <= currentLevel; i++){
            currentScore = currentScore + i;
        }
    }

    /**
     * Increase the level by 1
     */
    public void incrementLevel(){
        currentLevel++;
    }

    /**
     * Getter method for currentScore
     * @return value of currentScore
     */
    public int getCurrentScore() {
        return currentScore;
    }


    /**
     * Getter method for currentLevel
     * @return value of currentLevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }
}
