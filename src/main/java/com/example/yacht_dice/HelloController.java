package com.example.yacht_dice;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.yacht_dice.UseMethod.randNumSix;

public class HelloController {
    @FXML
    private Label roundSet;
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
    private Label userTurn;
    @FXML
    private Label leftChace;

    @FXML
    private Label userA_Aces;
    @FXML
    private Label userA_Twos;
    @FXML
    private Label userA_Threes;
    @FXML
    private Label userA_Fours;
    @FXML
    private Label userA_Fives;
    @FXML
    private Label userA_Sixes;
    @FXML
    private Label userA_SubTotal;
    @FXML
    private Label userA_Bonus;
    @FXML
    private Label userA_Choices;
    @FXML
    private Label userA_FoaKind;
    @FXML
    private Label userA_FullHouse;
    @FXML
    private Label userA_SmallStr;
    @FXML
    private Label userA_LargeStr;
    @FXML
    private Label userA_Yacht;
    @FXML
    private Label userA_Total;

    @FXML
    private Label userB_Aces;
    @FXML
    private Label userB_Twos;
    @FXML
    private Label userB_Threes;
    @FXML
    private Label userB_Fours;
    @FXML
    private Label userB_Fives;
    @FXML
    private Label userB_Sixes;
    @FXML
    private Label userB_SubTotal;
    @FXML
    private Label userB_Bonus;
    @FXML
    private Label userB_Choices;
    @FXML
    private Label userB_FoaKind;
    @FXML
    private Label userB_FullHouse;
    @FXML
    private Label userB_SmallStr;
    @FXML
    private Label userB_LargeStr;
    @FXML
    private Label userB_Yacht;
    @FXML
    private Label userB_Total;

    int nowNum = 3;

    boolean nowA = true;

    boolean nowB = false;

    int roundNum = 1;

    private UserData tempUser = new UserData();

    private UserData userA = new UserData();
    private UserData userB = new UserData();

    ArrayList<Dice> diceList = new ArrayList<>();


    @FXML
    protected void randDice() {
        if (nowNum == 0 || roundNum == 13) {
            return;
        }

        addLIst();
        // 다이스 객체를 만들어서 toggle 버튼과 이미지 연동


        // 눌려져 있는 다이스의 인덱스 얻기
        ArrayList<Integer> falseDice = new ArrayList<>();

        // 주사위 그림이 그려져 있는 주사위(실행 단에선 보이지 않음)
        ArrayList<ImageView> diceNumList = new ArrayList<>(Arrays.asList(diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix));

        // 랜덤한 숫자를 얻을 횟수
        int cnt = diceList.size();

        // true 값을 확인하여 cnt를 줄이기 + false값인 인덱스  falseDice에 담기
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getButton().isSelected()) {
                cnt--;
            } else {
                falseDice.add(i);
            }
        }


        // 랜덤 숫자 배열 만들기
        ArrayList<Integer> randList = new ArrayList<>();

        // 랜덤 숫자 만들기
        for (int i = 0; i < cnt; i++) {
            randList.add(randNumSix());
        }

        // 랜덤 숫자에 따른 주사위 그림 출력
        for (int i = 0; i < randList.size(); i++) {

            // 랜덤숫자 가져오기
            int temp = randList.get(i);




            // 랜덤숫자에 따른 그림 가져오기
            int randDiceNum = temp - 1;
            ImageView tempImgView = diceNumList.get(randDiceNum);

            // false인 주사위의 그림 교체
            for (int t = 0; t < diceList.size(); t++) {
                Dice tempDice = diceList.get(t);

                if (!tempDice.getButton().isSelected()) {

                    tempDice.getImage().setImage(tempImgView.getImage());

                    // true값으로 교체해야 중첩에 안걸린다.
                    tempDice.getButton().setSelected(true);

                    break;
                }
            }
        }

        int falseDiceIndex;
        // 전부 true로 바꿔 둔 주사위 중 원래 안눌려져 있던 주사위 되돌리기
        for (int i = 0; i < falseDice.size(); i++) {
            falseDiceIndex = falseDice.get(i);
            diceList.get(falseDiceIndex).getButton().setSelected(false);
        }


        // dice객체에 현재 무슨 숫자의 주사위인지 diceNum 표시
        // getImage().getUrl().substring(62,63) = 그림 숫자 번호
        int indexImg = diceNumList.get(1).getImage().getUrl().indexOf("ges/") + 4;

        for (int i = 0; i < diceList.size(); i++) {
            int nowDiceNum = Integer.parseInt(diceList.get(i).getImage().getImage().getUrl().substring(indexImg, indexImg + 1));

            diceList.get(i).setDiceNum(nowDiceNum);
        }


        //족보 표시
        if (userTurn.getText().equals("userA")) {
            userAcalDiceNum(userA);
        } else if (userTurn.getText().equals("userB")) {
            userBcalDiceNum(userB);
        }


        //숫자 클릭하기


        // 횟수 차감
        decChance();


        // 랜덤숫자 및 false 주사위 지우기
        randList.clear();
        falseDice.clear();


    }

    /**
     * 족보 점수 확인
     */
    protected void userAcalDiceNum(UserData user) {
        //숫자를 담기
        ArrayList<Integer> nowDiceNum = new ArrayList<>();


        for (int i = 0; i < diceList.size(); i++) {
            nowDiceNum.add(diceList.get(i).getDiceNum());
        }
        // 번호 정렬
        Collections.sort(nowDiceNum);

        // 각 열에 해당하는 숫자 리턴
        int ace = UseMethod.checkAces(nowDiceNum);
        int two = UseMethod.checkTwos(nowDiceNum);
        int three = UseMethod.checkThrees(nowDiceNum);
        int four = UseMethod.checkFours(nowDiceNum);
        int five = UseMethod.checkFives(nowDiceNum);
        int six = UseMethod.checkSixes(nowDiceNum);

        int choices = UseMethod.checkChoices(nowDiceNum);
        int fourOfAKind = UseMethod.checkFourOfAKind(nowDiceNum);
        int fullHouse = UseMethod.checkFullHouse(nowDiceNum);
        int smallStraight = UseMethod.checkSmallStraight(nowDiceNum);
        int largeStraight = UseMethod.checkLargeStraight(nowDiceNum);
        int yacht = UseMethod.checkYacht(nowDiceNum);

        tempUser.setAce(ace);
        tempUser.setTwo(two);
        tempUser.setThree(three);
        tempUser.setFour(four);
        tempUser.setFive(five);
        tempUser.setSix(six);
        tempUser.setChoices(choices);
        tempUser.setFoakind(fourOfAKind);
        tempUser.setFullHouse(fullHouse);
        tempUser.setSmallStraight(smallStraight);
        tempUser.setLargeStraight(largeStraight);
        tempUser.setYacht(yacht);

        if (!(userA_Aces.getTextFill() == Paint.valueOf("black"))) {
            userA_Aces.setText(Integer.toString(ace));
        } else {
            userA_Aces.setText(Integer.toString(user.getAce()));
        }

        if (!(userA_Twos.getTextFill() == Paint.valueOf("black"))) {
            userA_Twos.setText(Integer.toString(two));
        } else {
            userA_Twos.setText(Integer.toString(user.getTwo()));
        }

        if (!(userA_Threes.getTextFill() == Paint.valueOf("black"))) {
            userA_Threes.setText(Integer.toString(three));
        } else {
            userA_Threes.setText(Integer.toString(user.getThree()));
        }

        if (!(userA_Fours.getTextFill() == Paint.valueOf("black"))) {
            userA_Fours.setText(Integer.toString(four));
        } else {
            userA_Fours.setText(Integer.toString(user.getFour()));
        }

        if (!(userA_Fives.getTextFill() == Paint.valueOf("black"))) {
            userA_Fives.setText(Integer.toString(five));
        } else {
            userA_Fives.setText(Integer.toString(user.getFive()));
        }

        if (!(userA_Sixes.getTextFill() == Paint.valueOf("black"))) {
            userA_Sixes.setText(Integer.toString(six));
        } else {
            userA_Sixes.setText(Integer.toString(user.getSix()));
        }

        int userSubTotal = user.getAce() + user.getTwo() + user.getThree() + user.getFour() + user.getFive() + user.getSix();

        if (userSubTotal >= 63) {
            user.setBonus(35);
        }

        user.setSubTotal(userSubTotal + "/63");

        userA_SubTotal.setText(user.getSubTotal());

        userA_Bonus.setText(Integer.toString(user.getBonus()));

        if (!(userA_Choices.getTextFill() == Paint.valueOf("black"))) {
            userA_Choices.setText(Integer.toString(choices));
        } else {
            userA_Choices.setText(Integer.toString(user.getChoices()));
        }

        if (!(userA_FoaKind.getTextFill() == Paint.valueOf("black"))) {
            userA_FoaKind.setText(Integer.toString(fourOfAKind));
        } else {
            userA_FoaKind.setText(Integer.toString(user.getFoakind()));
        }

        if (!(userA_FullHouse.getTextFill() == Paint.valueOf("black"))) {
            userA_FullHouse.setText(Integer.toString(fullHouse));
        } else {
            userA_FullHouse.setText(Integer.toString((user.getFullHouse())));
        }

        if (!(userA_SmallStr.getTextFill() == Paint.valueOf("black"))) {
            userA_SmallStr.setText(Integer.toString(smallStraight));
        } else {
            userA_SmallStr.setText(Integer.toString(user.getSmallStraight()));
        }

        if (!(userA_LargeStr.getTextFill() == Paint.valueOf("black"))) {
            userA_LargeStr.setText(Integer.toString(largeStraight));
        } else {
            userA_LargeStr.setText(Integer.toString(user.getLargeStraight()));
        }

        if (!(userA_Yacht.getTextFill() == Paint.valueOf("black"))) {
            userA_Yacht.setText(Integer.toString(yacht));
        } else {
            userA_Yacht.setText(Integer.toString(user.getYacht()));
        }

        int realTotal = userSubTotal + user.getBonus() + user.getChoices() + user.getFoakind() + user.getFullHouse() +
                user.getSmallStraight() + user.getLargeStraight() + user.getYacht();

        user.setTotal(realTotal);

        userA_Total.setText(Integer.toString(user.getTotal()));

        nowDiceNum.clear();
        diceList.clear();
    }

    protected void userBcalDiceNum(UserData user) {
        //숫자를 담기
        ArrayList<Integer> nowDiceNum = new ArrayList<>();


        for (int i = 0; i < diceList.size(); i++) {
            nowDiceNum.add(diceList.get(i).getDiceNum());
        }
        // 번호 정렬
        Collections.sort(nowDiceNum);

        // 각 열에 해당하는 숫자 리턴
        int ace = UseMethod.checkAces(nowDiceNum);
        int two = UseMethod.checkTwos(nowDiceNum);
        int three = UseMethod.checkThrees(nowDiceNum);
        int four = UseMethod.checkFours(nowDiceNum);
        int five = UseMethod.checkFives(nowDiceNum);
        int six = UseMethod.checkSixes(nowDiceNum);

        int choices = UseMethod.checkChoices(nowDiceNum);
        int fourOfAKind = UseMethod.checkFourOfAKind(nowDiceNum);
        int fullHouse = UseMethod.checkFullHouse(nowDiceNum);
        int smallStraight = UseMethod.checkSmallStraight(nowDiceNum);
        int largeStraight = UseMethod.checkLargeStraight(nowDiceNum);
        int yacht = UseMethod.checkYacht(nowDiceNum);


        tempUser.setAce(ace);
        tempUser.setTwo(two);
        tempUser.setThree(three);
        tempUser.setFour(four);
        tempUser.setFive(five);
        tempUser.setSix(six);
        tempUser.setChoices(choices);
        tempUser.setFoakind(fourOfAKind);
        tempUser.setFullHouse(fullHouse);
        tempUser.setSmallStraight(smallStraight);
        tempUser.setLargeStraight(largeStraight);
        tempUser.setYacht(yacht);

        if (!(userB_Aces.getTextFill() == Paint.valueOf("black"))) {
            userB_Aces.setText(Integer.toString(ace));
        } else {
            userB_Aces.setText(Integer.toString(user.getAce()));
        }

        if (!(userB_Twos.getTextFill() == Paint.valueOf("black"))) {
            userB_Twos.setText(Integer.toString(two));
        } else {
            userB_Twos.setText(Integer.toString(user.getTwo()));
        }

        if (!(userB_Threes.getTextFill() == Paint.valueOf("black"))) {
            userB_Threes.setText(Integer.toString(three));
        } else {
            userB_Threes.setText(Integer.toString(user.getThree()));
        }

        if (!(userB_Fours.getTextFill() == Paint.valueOf("black"))) {
            userB_Fours.setText(Integer.toString(four));
        } else {
            userB_Fours.setText(Integer.toString(user.getFour()));
        }

        if (!(userB_Fives.getTextFill() == Paint.valueOf("black"))) {
            userB_Fives.setText(Integer.toString(five));
        } else {
            userB_Fives.setText(Integer.toString(user.getFive()));
        }

        if (!(userB_Sixes.getTextFill() == Paint.valueOf("black"))) {
            userB_Sixes.setText(Integer.toString(six));
        } else {
            userB_Sixes.setText(Integer.toString(user.getSix()));
        }

        int userSubTotal = user.getAce() + user.getTwo() + user.getThree() + user.getFour() + user.getFive() + user.getSix();

        if (userSubTotal >= 63) {
            user.setBonus(35);
        }

        user.setSubTotal(userSubTotal + "/63");

        userB_SubTotal.setText(user.getSubTotal());

        userB_Bonus.setText(Integer.toString(user.getBonus()));

        if (!(userB_Choices.getTextFill() == Paint.valueOf("black"))) {
            userB_Choices.setText(Integer.toString(choices));
        } else {
            userB_Choices.setText(Integer.toString(user.getChoices()));
        }

        if (!(userB_FoaKind.getTextFill() == Paint.valueOf("black"))) {
            userB_FoaKind.setText(Integer.toString(fourOfAKind));
        } else {
            userB_FoaKind.setText(Integer.toString(user.getFoakind()));
        }

        if (!(userB_FullHouse.getTextFill() == Paint.valueOf("black"))) {
            userB_FullHouse.setText(Integer.toString(fullHouse));
        } else {
            userB_FullHouse.setText(Integer.toString((user.getFullHouse())));
        }

        if (!(userB_SmallStr.getTextFill() == Paint.valueOf("black"))) {
            userB_SmallStr.setText(Integer.toString(smallStraight));
        } else {
            userB_SmallStr.setText(Integer.toString(user.getSmallStraight()));
        }

        if (!(userB_LargeStr.getTextFill() == Paint.valueOf("black"))) {
            userB_LargeStr.setText(Integer.toString(largeStraight));
        } else {
            userB_LargeStr.setText(Integer.toString(user.getLargeStraight()));
        }

        if (!(userB_Yacht.getTextFill() == Paint.valueOf("black"))) {
            userB_Yacht.setText(Integer.toString(yacht));
        } else {
            userB_Yacht.setText(Integer.toString(user.getYacht()));
        }

        int realTotal = userSubTotal + user.getBonus() + user.getChoices() + user.getFoakind() + user.getFullHouse() +
                user.getSmallStraight() + user.getLargeStraight() + user.getYacht();

        user.setTotal(realTotal);

        userB_Total.setText(Integer.toString(user.getTotal()));


        nowDiceNum.clear();
        diceList.clear();
    }


    /**
     * 찬스 소진
     */
    protected void decChance() {

        switch (nowNum) {

            case 1:
                nowNum = 0;
                break;
            case 2:
                nowNum = 1;
                break;
            case 3:
                nowNum = 2;
                break;
        }

        leftChace.setText(Integer.toString(nowNum));
    }


    /**
     * 유저변경
     */
    @FXML
    protected void changeUser() {

        if (userTurn.getText().equals("userA")) {

            leftChace.setText("3");
            userTurn.setText("userB");
            nowNum = 3;
            nowA = false;
            nowB = true;
            getTotalNumA();
            addLIst();
            delectTempNumA();

            for (int i = 0; i < diceList.size(); i++) {
                diceList.get(i).getButton().setSelected(false);
            }

            tempUser = new UserData();
            diceList.clear();


        } else if (userTurn.getText().equals("userB")) {

            leftChace.setText("3");
            userTurn.setText("userA");

            nowNum = 3;
            nowA = true;
            nowB = false;

            getTotalNumB();
            addLIst();
            delectTempNumB();

            if (roundNum <= 12) {
                roundNum++;
                if (roundNum == 13){
                roundSet.setText("Game Set");
                }else {
                roundSet.setText("Round " + roundNum + "/12");
                }
            }


            for (int i = 0; i < diceList.size(); i++) {
                diceList.get(i).getButton().setSelected(false);
            }
            tempUser = new UserData();
            diceList.clear();

        }
    }


    @FXML
    protected void choiceAceUserA() {

        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }

        userA.setAce(tempUser.getAce());
        userA_Aces.setTextFill(Paint.valueOf("black"));

        getBonusNumA();
        getSubTotalA();
        changeUser();

    }

    @FXML
    protected void choiceTwoUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setTwo(tempUser.getTwo());
        userA_Twos.setTextFill(Paint.valueOf("black"));


        getBonusNumA();
        getSubTotalA();
        changeUser();
    }

    @FXML
    protected void choiceThreeUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setThree(tempUser.getThree());
        userA_Threes.setTextFill(Paint.valueOf("black"));


        getBonusNumA();
        getSubTotalA();
        changeUser();
    }

    @FXML
    protected void choiceFourUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setFour(tempUser.getFour());
        userA_Fours.setTextFill(Paint.valueOf("black"));


        getBonusNumA();
        getSubTotalA();
        changeUser();
    }

    @FXML
    protected void choiceFiveUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setFive(tempUser.getFive());
        userA_Fives.setTextFill(Paint.valueOf("black"));


        getBonusNumA();
        getSubTotalA();
        changeUser();
    }

    @FXML
    protected void choiceSixUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setSix(tempUser.getSix());
        userA_Sixes.setTextFill(Paint.valueOf("black"));


        getBonusNumA();
        getSubTotalA();
        changeUser();
    }


    @FXML
    protected void choiceChoiceUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setChoices(tempUser.getChoices());
        userA_Choices.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceFokaUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setFoakind(tempUser.getFoakind());
        userA_FoaKind.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceFullHouseUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setFullHouse(tempUser.getFullHouse());
        userA_FullHouse.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceSSrUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setSmallStraight(tempUser.getSmallStraight());
        userA_SmallStr.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceLSrUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setLargeStraight(tempUser.getLargeStraight());
        userA_LargeStr.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceYachtUserA() {
        if (!nowA || leftChace.getText().equals("3")) {
            return;
        }
        userA.setYacht(tempUser.getYacht());
        userA_Yacht.setTextFill(Paint.valueOf("black"));


        changeUser();
    }

    @FXML
    protected void choiceAceUserB() {

        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setAce(tempUser.getAce());
        userB_Aces.setTextFill(Paint.valueOf("black"));


        getBonusNumB();
        getSubTotalB();
        changeUser();
    }

    @FXML
    protected void choiceTwoUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setTwo(tempUser.getTwo());
        userB_Twos.setTextFill(Paint.valueOf("black"));

        getBonusNumB();
        getSubTotalB();
        changeUser();
    }

    @FXML
    protected void choiceThreeUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setThree(tempUser.getThree());
        userB_Threes.setTextFill(Paint.valueOf("black"));

        getBonusNumB();
        getSubTotalB();
        changeUser();
    }

    @FXML
    protected void choiceFourUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setFour(tempUser.getFour());
        userB_Fours.setTextFill(Paint.valueOf("black"));

        getBonusNumB();
        getSubTotalB();
        changeUser();
    }

    @FXML
    protected void choiceFiveUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setFive(tempUser.getFive());
        userB_Fives.setTextFill(Paint.valueOf("black"));

        getBonusNumB();
        getSubTotalB();
        changeUser();
    }

    @FXML
    protected void choiceSixUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setSix(tempUser.getSix());
        userB_Sixes.setTextFill(Paint.valueOf("black"));

        getBonusNumB();
        getSubTotalB();
        changeUser();
    }


    @FXML
    protected void choiceChoiceUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setChoices(tempUser.getChoices());
        userB_Choices.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFokaUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setFoakind(tempUser.getFoakind());
        userB_FoaKind.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFullHouseUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setFullHouse(tempUser.getFullHouse());
        userB_FullHouse.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceSSrUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setSmallStraight(tempUser.getSmallStraight());
        userB_SmallStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceLSrUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setLargeStraight(tempUser.getLargeStraight());
        userB_LargeStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceYachtUserB() {
        if (!nowB || leftChace.getText().equals("3")) {
            return;
        }
        userB.setYacht(tempUser.getYacht());
        userB_Yacht.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    protected void addLIst() {
        diceList.add(new Dice(toggleFirst, firstImage, 2));
        diceList.add(new Dice(toggleSecond, secondImage, 2));
        diceList.add(new Dice(toggleThird, thirdImage, 3));
        diceList.add(new Dice(toggleFourth, forthImage, 4));
        diceList.add(new Dice(toggleFifth, fifthImage, 5));
    }

    protected void getSubTotalA() {
        int userSubTotal = userA.getAce() + userA.getTwo() + userA.getThree() + userA.getFour() + userA.getFive() + userA.getSix();

        userA.setSubTotal(userSubTotal + "/63");

        userA_SubTotal.setText(userA.getSubTotal());
    }

    protected void getSubTotalB() {
        int userSubTotal = userB.getAce() + userB.getTwo() + userB.getThree() + userB.getFour() + userB.getFive() + userB.getSix();

        userB.setSubTotal(userSubTotal + "/63");

        userB_SubTotal.setText(userB.getSubTotal());
    }

    protected void getBonusNumA() {
        int userSubTotal = userA.getAce() + userA.getTwo() + userA.getThree() + userA.getFour() + userA.getFive() + userA.getSix();
        if (userSubTotal >= 63) {
            userA.setBonus(35);
            userA_Bonus.setText(userA.getBonus() + "");
        }

    }

    protected void getBonusNumB() {
        int userSubTotal = userB.getAce() + userB.getTwo() + userB.getThree() + userB.getFour() + userB.getFive() + userB.getSix();
        if (userSubTotal >= 63) {
            userB.setBonus(35);
            userB_Bonus.setText(userB.getBonus() + "");
        }

    }

    protected void getTotalNumA() {
        int userSubTotal = userA.getAce() + userA.getTwo() + userA.getThree() + userA.getFour() + userA.getFive() + userA.getSix();
        int realTotal = userSubTotal + userA.getBonus() + userA.getChoices() + userA.getFoakind() + userA.getFullHouse() +
                userA.getSmallStraight() + userA.getLargeStraight() + userA.getYacht();

        userA.setTotal(realTotal);

        userA_Total.setText(Integer.toString(userA.getTotal()));
    }

    protected void getTotalNumB() {
        int userSubTotal = userB.getAce() + userB.getTwo() + userB.getThree() + userB.getFour() + userB.getFive() + userB.getSix();
        int realTotal = userSubTotal + userB.getBonus() + userB.getChoices() + userB.getFoakind() + userB.getFullHouse() +
                userB.getSmallStraight() + userB.getLargeStraight() + userB.getYacht();

        userB.setTotal(realTotal);

        userB_Total.setText(Integer.toString(userB.getTotal()));
    }

    protected void delectTempNumA() {

        if (!(userA_Aces.getTextFill() == Paint.valueOf("black"))) {
            userA_Aces.setText("");
        }
        if (!(userA_Twos.getTextFill() == Paint.valueOf("black"))) {
            userA_Twos.setText("");
        }

        if (!(userA_Threes.getTextFill() == Paint.valueOf("black"))) {
            userA_Threes.setText("");
        }

        if (!(userA_Fours.getTextFill() == Paint.valueOf("black"))) {
            userA_Fours.setText("");
        }

        if (!(userA_Fives.getTextFill() == Paint.valueOf("black"))) {
            userA_Fives.setText("");
        }

        if (!(userA_Sixes.getTextFill() == Paint.valueOf("black"))) {
            userA_Sixes.setText("");
        }


        if (!(userA_Choices.getTextFill() == Paint.valueOf("black"))) {
            userA_Choices.setText("");
        }

        if (!(userA_FoaKind.getTextFill() == Paint.valueOf("black"))) {
            userA_FoaKind.setText("");
        }

        if (!(userA_FullHouse.getTextFill() == Paint.valueOf("black"))) {
            userA_FullHouse.setText("");
        }
        if (!(userA_SmallStr.getTextFill() == Paint.valueOf("black"))) {
            userA_SmallStr.setText("");
        }
        if (!(userA_LargeStr.getTextFill() == Paint.valueOf("black"))) {
            userA_LargeStr.setText("");
        }

        if (!(userA_Yacht.getTextFill() == Paint.valueOf("black"))) {
            userA_Yacht.setText("");
        }

    }

    protected void delectTempNumB() {

        if (!(userB_Aces.getTextFill() == Paint.valueOf("black"))) {
            userB_Aces.setText("");
        }
        if (!(userB_Twos.getTextFill() == Paint.valueOf("black"))) {
            userB_Twos.setText("");
        }

        if (!(userB_Threes.getTextFill() == Paint.valueOf("black"))) {
            userB_Threes.setText("");
        }

        if (!(userB_Fours.getTextFill() == Paint.valueOf("black"))) {
            userB_Fours.setText("");
        }

        if (!(userB_Fives.getTextFill() == Paint.valueOf("black"))) {
            userB_Fives.setText("");
        }

        if (!(userB_Sixes.getTextFill() == Paint.valueOf("black"))) {
            userB_Sixes.setText("");
        }


        if (!(userB_Choices.getTextFill() == Paint.valueOf("black"))) {
            userB_Choices.setText("");
        }

        if (!(userB_FoaKind.getTextFill() == Paint.valueOf("black"))) {
            userB_FoaKind.setText("");
        }

        if (!(userB_FullHouse.getTextFill() == Paint.valueOf("black"))) {
            userB_FullHouse.setText("");
        }
        if (!(userB_SmallStr.getTextFill() == Paint.valueOf("black"))) {
            userB_SmallStr.setText("");
        }
        if (!(userB_LargeStr.getTextFill() == Paint.valueOf("black"))) {
            userB_LargeStr.setText("");
        }

        if (!(userB_Yacht.getTextFill() == Paint.valueOf("black"))) {
            userB_Yacht.setText("");
        }

    }
}

