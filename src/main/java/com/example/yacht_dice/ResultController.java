package com.example.yacht_dice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ResultController {
    @FXML
    private Label ac_A;
    @FXML
    private Label tw_A;
    @FXML
    private Label thr_A;
    @FXML
    private Label four_A;
    @FXML
    private Label five_A;
    @FXML
    private Label six_A;
    @FXML
    private Label bns_A;
    @FXML
    private Label choice_A;
    @FXML
    private Label foka_A;
    @FXML
    private Label fh_A;
    @FXML
    private Label ss_A;
    @FXML
    private Label ls_A;
    @FXML
    private Label ya_A;
    @FXML
    private Label total_A;

    @FXML
    private Label ac_B;
    @FXML
    private Label tw_B;
    @FXML
    private Label thr_B;
    @FXML
    private Label four_B;
    @FXML
    private Label five_B;
    @FXML
    private Label six_B;
    @FXML
    private Label bns_B;
    @FXML
    private Label choice_B;
    @FXML
    private Label foka_B;
    @FXML
    private Label fh_B;
    @FXML
    private Label ss_B;
    @FXML
    private Label ls_B;
    @FXML
    private Label ya_B;
    @FXML
    private Label total_B;
    @FXML
    private Label whoWinner;


    protected void getResult(ArrayList<UserData> list) {
        UserData userA = list.get(0);
        UserData userB = list.get(1);

        ac_A.setText(userA.getAce() + "");
        tw_A.setText(userA.getTwo() + "");
        thr_A.setText(userA.getThree() + "");
        four_A.setText(userA.getFour() + "");
        five_A.setText(userA.getFive() + "");
        six_A.setText(userA.getSix() + "");
        bns_A.setText(userA.getBonus() + "");
        choice_A.setText(userA.getChoices() + "");
        foka_A.setText(userA.getFoakind() + "");
        fh_A.setText(userA.getFullHouse() + "");
        ss_A.setText(userA.getSmallStraight() + "");
        ls_A.setText(userA.getLargeStraight() + "");
        ya_A.setText(userA.getYacht() + "");
        total_A.setText(userA.getTotal() + "");

        ac_B.setText(userB.getAce() + "");
        tw_B.setText(userB.getTwo() + "");
        thr_B.setText(userB.getThree() + "");
        four_B.setText(userB.getFour() + "");
        five_B.setText(userB.getFive() + "");
        six_B.setText(userB.getSix() + "");
        bns_B.setText(userB.getBonus() + "");
        choice_B.setText(userB.getChoices() + "");
        foka_B.setText(userB.getFoakind() + "");
        fh_B.setText(userB.getFullHouse() + "");
        ss_B.setText(userB.getSmallStraight() + "");
        ls_B.setText(userB.getLargeStraight() + "");
        ya_B.setText(userB.getYacht() + "");
        total_B.setText(userB.getTotal() + "");

        if (userA.getTotal() > userB.getTotal()) {
            whoWinner.setText("USER A");

        } else {
            whoWinner.setText("USER B");
        }

    }

}
