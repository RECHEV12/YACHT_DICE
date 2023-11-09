package com.example.yacht_dice;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.yacht_dice.UseMethod.randNumSix;

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

    private UserData userA = UserData.getUserA();
    private UserData userB = UserData.getUserB();


    @FXML
    protected void randDice() {


        // 다이스 객체를 만들어서 toggle 버튼과 이미지 연동
        ArrayList<Dice> diceList = new ArrayList<>(Arrays.asList(
                new Dice(toggleFirst, firstImage, 2),
                new Dice(toggleSecond, secondImage, 2),
                new Dice(toggleThird, thirdImage, 3),
                new Dice(toggleFourth, forthImage, 4),
                new Dice(toggleFifth, fifthImage, 5)
        ));

        // 눌려져 있는 다이스의 인덱스 얻기
        ArrayList<Integer> falseDice = new ArrayList<>();

        // 주사위 그림이 그려져 있는 주사위(실행 단에선 보이지 않음)
        ArrayList<ImageView> diceNumList = new ArrayList<>(Arrays.asList(
                diceOne, diceTwo, diceThree, diceFour, diceFive, diceSix));

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

        int falseDiceIndex = 0;
        // 전부 true로 바꿔 둔 주사위 중 원래 안눌려져 있던 주사위 되돌리기
        for (int i = 0; i < falseDice.size(); i++) {
            falseDiceIndex = falseDice.get(i);
            diceList.get(falseDiceIndex).getButton().setSelected(false);
        }


        // dice객체에 현재 무슨 숫자의 주사위인지 diceNum 표시
        // getImage().getUrl().substring(62,63) = 그림 숫자 번호
        for (int i = 0; i < diceList.size(); i++) {
            int nowDiceNum = Integer.parseInt(diceList.get(i).getImage().getImage().getUrl().substring(62, 63));

            diceList.get(i).setDiceNum(nowDiceNum);
        }


        //족보 표시
        if (userTurn.getText().equals("userA")) {
            userAcalDiceNum(userA, diceList);
        }
        if (userTurn.getText().equals("userB")) {
            userBcalDiceNum(userB, diceList);
        }


        // 횟수 차감
        decChance();
        // 횟수 0이면 유저 변경
        changeUser(diceList);


        // 랜덤숫자 및 false 주사위 지우기
        randList.clear();
        falseDice.clear();


    }

    /**
     * 족보 점수 확인
     *
     * @param diceList
     */
    protected void userAcalDiceNum(UserData user, ArrayList<Dice> diceList) {
        //숫자를 담기
        ArrayList<Integer> nowDiceNum = new ArrayList<>();

        for (int i = 0; i < diceList.size(); i++) {
            nowDiceNum.add(diceList.get(i).getDiceNum());
        }
        // 번호 정렬
        Collections.sort(nowDiceNum);

        // 각 열에 해당하는 숫자 리턴
        int ace = UseMethod.checkAces(diceList);
        int two = UseMethod.checkTwos(diceList);
        int three = UseMethod.checkThrees(diceList);
        int four = UseMethod.checkFours(diceList);
        int five = UseMethod.checkFives(diceList);
        int six = UseMethod.checkSixes(diceList);

        ArrayList<Integer> aceToSix = new ArrayList<>();
        aceToSix.add(ace);
        aceToSix.add(two);
        aceToSix.add(three);
        aceToSix.add(four);
        aceToSix.add(five);
        aceToSix.add(six);
        int subTotalNum = UseMethod.checkSubTotal(aceToSix);

        String subTotal = subTotalNum + "/63";

        int bonus = UseMethod.checkBonus(subTotalNum);

        int choices = UseMethod.checkChoices(diceList);
        int fourOfAKind = UseMethod.checkFourOfAKind(diceList);
        int fullHouse = UseMethod.checkFullHouse(diceList);
        int smallStraight = UseMethod.checkSmallStraight(diceList);
        int largeStraight = UseMethod.checkLargeStraight(diceList);
        int yacht = UseMethod.checkYacht(diceList);


        ArrayList<Integer> allNumber = new ArrayList<>();
        allNumber.add(subTotalNum);
        allNumber.add(bonus);
        allNumber.add(choices);
        allNumber.add(fourOfAKind);
        allNumber.add(fullHouse);
        allNumber.add(smallStraight);
        allNumber.add(largeStraight);
        allNumber.add(yacht);


        int total = UseMethod.checkTotal(allNumber);

        System.out.println("1 : " + ace);
        System.out.println("2 : " + two);
        System.out.println("3 : " + three);
        System.out.println("4 : " + four);
        System.out.println("5 : " + five);
        System.out.println("6 : " + six);
        System.out.println("1~6 : " + subTotal);
        System.out.println("bonus  : " + bonus);
        System.out.println("cho  : " + choices);
        System.out.println("kin  : " + fourOfAKind);
        System.out.println("hous  : " + fullHouse);
        System.out.println("ss : " + smallStraight);
        System.out.println("ls : " + largeStraight);
        System.out.println("ya  : " + yacht);
        System.out.println("total  : " + total);

        System.out.println("\n=======================\n");

//        user.setAce(ace);
//        user.setTwo(two);
//        user.setThree(three);
//        user.setFour(four);
//        user.setFive(five);
//        user.setSix(six);
//        user.setSubTotal(subTotal);
//        user.setBonus(bonus);
//        user.setChoices(choices);
//        user.setFoakind(fourOfAKind);
//        user.setFullHouse(fullHouse);
//        user.setSmallStraight(smallStraight);
//        user.setLargeStraight(largeStraight);
//        user.setYacht(yacht);
//        user.setTotal(total);

        userA_Aces.setText(Integer.toString(ace));
        userA_Twos.setText(Integer.toString(two));
        userA_Threes.setText(Integer.toString(three));
        userA_Fours.setText(Integer.toString(four));
        userA_Fives.setText(Integer.toString(five));
        userA_Sixes.setText(Integer.toString(six));
        userA_SubTotal.setText(subTotal);
        userA_Bonus.setText(Integer.toString(bonus));
        userA_Choices.setText(Integer.toString(choices));
        userA_FoaKind.setText(Integer.toString(fourOfAKind));
        userA_FullHouse.setText(Integer.toString(fullHouse));
        userA_SmallStr.setText(Integer.toString(smallStraight));
        userA_LargeStr.setText(Integer.toString(largeStraight));
        userA_Yacht.setText(Integer.toString(yacht));


    }


    protected void userBcalDiceNum(UserData user, ArrayList<Dice> diceList) {
        //숫자를 담기
        ArrayList<Integer> nowDiceNum = new ArrayList<>();

        for (int i = 0; i < diceList.size(); i++) {
            nowDiceNum.add(diceList.get(i).getDiceNum());
        }
        // 번호 정렬
        Collections.sort(nowDiceNum);

        // 각 열에 해당하는 숫자 리턴
        int ace = UseMethod.checkAces(diceList);
        int two = UseMethod.checkTwos(diceList);
        int three = UseMethod.checkThrees(diceList);
        int four = UseMethod.checkFours(diceList);
        int five = UseMethod.checkFives(diceList);
        int six = UseMethod.checkSixes(diceList);

        ArrayList<Integer> aceToSix = new ArrayList<>();
        aceToSix.add(ace);
        aceToSix.add(two);
        aceToSix.add(three);
        aceToSix.add(four);
        aceToSix.add(five);
        aceToSix.add(six);
        int subTotalNum = UseMethod.checkSubTotal(aceToSix);

        String subTotal = subTotalNum + "/63";

        int bonus = UseMethod.checkBonus(subTotalNum);

        int choices = UseMethod.checkChoices(diceList);
        int fourOfAKind = UseMethod.checkFourOfAKind(diceList);
        int fullHouse = UseMethod.checkFullHouse(diceList);
        int smallStraight = UseMethod.checkSmallStraight(diceList);
        int largeStraight = UseMethod.checkLargeStraight(diceList);
        int yacht = UseMethod.checkYacht(diceList);


        ArrayList<Integer> allNumber = new ArrayList<>();
        allNumber.add(subTotalNum);
        allNumber.add(bonus);
        allNumber.add(choices);
        allNumber.add(fourOfAKind);
        allNumber.add(fullHouse);
        allNumber.add(smallStraight);
        allNumber.add(largeStraight);
        allNumber.add(yacht);


        int total = UseMethod.checkTotal(allNumber);

        System.out.println("1 : " + ace);
        System.out.println("2 : " + two);
        System.out.println("3 : " + three);
        System.out.println("4 : " + four);
        System.out.println("5 : " + five);
        System.out.println("6 : " + six);
        System.out.println("1~6 : " + subTotal);
        System.out.println("bonus  : " + bonus);
        System.out.println("cho  : " + choices);
        System.out.println("kin  : " + fourOfAKind);
        System.out.println("hous  : " + fullHouse);
        System.out.println("ss : " + smallStraight);
        System.out.println("ls : " + largeStraight);
        System.out.println("ya  : " + yacht);
        System.out.println("total  : " + total);

        System.out.println("\n=======================\n");

//        user.setAce(ace);
//        user.setTwo(two);
//        user.setThree(three);
//        user.setFour(four);
//        user.setFive(five);
//        user.setSix(six);
//        user.setSubTotal(subTotal);
//        user.setBonus(bonus);
//        user.setChoices(choices);
//        user.setFoakind(fourOfAKind);
//        user.setFullHouse(fullHouse);
//        user.setSmallStraight(smallStraight);
//        user.setLargeStraight(largeStraight);
//        user.setYacht(yacht);
//        user.setTotal(total);



    }

    /**
     * 찬스 소진
     */
    protected void decChance() {
        int nowNum = Integer.parseInt(leftChace.getText());
        System.out.println(nowNum);
        switch (nowNum) {

            case 0:
                nowNum = 3;
                break;
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
    protected void changeUser(ArrayList<Dice> diceList) {

        if (userTurn.getText().equals("userA")) {
            if (leftChace.getText().equals("0")) {
                leftChace.setText("3");
                userTurn.setText("userB");

                for (int i = 0; i < diceList.size(); i++) {
                    diceList.get(i).getButton().setSelected(false);
                }
            }


        }

        if (userTurn.getText().equals("userB")) {
            if (leftChace.getText().equals("0")) {
                leftChace.setText("3");
                userTurn.setText("userA");
                for (int i = 0; i < diceList.size(); i++) {
                    diceList.get(i).getButton().setSelected(false);
                }
            }

        }
    }


}