package com.example.yacht_dice;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

public class Dice {
    ToggleButton button;
    ImageView image;

    public Dice() {
    }

    public Dice(ToggleButton button, ImageView image) {
        this.button = button;
        this.image = image;
    }

    public ToggleButton getButton() {
        return button;
    }

    public void setButton(ToggleButton button) {
        this.button = button;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
