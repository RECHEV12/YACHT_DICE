package com.example.yacht_dice;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.yacht_dice.useMethod;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.yacht_dice.useMethod.randNumSix;

public class HelloController {

    @FXML
    private ToggleButton toggleFirst;
    @FXML
    private ToggleButton toggleSecond;
    @FXML
    private ToggleButton toggleThird;
    @FXML
    private ToggleButton toggleFourth;
    @FXML
    private ToggleButton toggleFifth;

    @FXML
    private ImageView firstImage;
    @FXML
    private ImageView secondImage;
    @FXML
    private ImageView thirdImage;
    @FXML
    private ImageView forthImage;
    @FXML
    private ImageView fifthImage;

    @FXML
    private ImageView diceOne;
    @FXML
    private ImageView diceTwo;
    @FXML
    private ImageView diceThree;
    @FXML
    private ImageView diceFour;
    @FXML
    private ImageView diceFive;
    @FXML
    private ImageView diceSix;


    @FXML
    protected void randDice() {

        ArrayList<Dice> diceList = new ArrayList<>(Arrays.asList(
                new Dice(toggleFirst, firstImage),
                new Dice(toggleSecond, secondImage),
                new Dice(toggleThird, thirdImage),
                new Dice(toggleFourth, forthImage),
                new Dice(toggleFifth, fifthImage)
        ));

        ArrayList<ImageView> diceNumList = new ArrayList<>(Arrays.asList(
                diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix));


        int cnt = diceList.size();

        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getButton().isSelected()) {
                cnt--;
            }
        }

        ArrayList<Integer> randList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            randList.add(randNumSix());
        }



        for (int i = 0; i < randList.size(); i++) {
            int temp = randList.get(i);

            int randDiceNum = temp-1;
            ImageView tempImgView = diceNumList.get(randDiceNum);


            for (int t = 0; t < diceList.size(); t++) {
                Dice tempDice = diceList.get(t);

                if (!tempDice.getButton().isSelected()) {

                    tempDice.getImage().setImage(tempImgView.getImage());

                    tempDice.getButton().setSelected(true);

                    break;
                }
            }
        }

        for (int i = 0 ; i <diceList.size(); i ++){
            diceList.get(i).getButton().setSelected(false);
        }

        cnt = diceList.size();
        randList.clear();




    }

}