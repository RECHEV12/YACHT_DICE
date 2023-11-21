package com.example.yacht_dice;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

public class Dice {
    ToggleButton button;
    ImageView image;
    int diceNum;

    public int getDiceNum() {
        return diceNum;
    }

    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }

    public Dice() {
    }

    public Dice(ToggleButton button, ImageView image, int diceNum) {
        this.button = button;
        this.image = image;
        this.diceNum = diceNum;
    }

    public ToggleButton getButton() {
        return button;
    }


    public ImageView getImage() {
        return image;
    }
}
