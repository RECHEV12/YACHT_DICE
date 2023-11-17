package com.example.yacht_dice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
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

    protected UserData userA = new UserData();
    protected UserData userB = new UserData();

    ArrayList<Dice> diceList = new ArrayList<>();
    // 눌려져 있는 다이스의 인덱스 얻기
    ArrayList<Integer> falseDice = new ArrayList<>();
    // 주사위 그림이 그려져 있는 주사위(실행 단에선 보이지 않음)
    ArrayList<ImageView> diceNumList = new ArrayList<>();

    ArrayList<Label> userA_List = new ArrayList<>();
    ArrayList<Label> userB_List = new ArrayList<>();

    ArrayList<Integer> nowDiceNum = new ArrayList<>();
    ArrayList<Integer> userNumList = new ArrayList<>();
    ArrayList<Integer> showBlueTextNum = new ArrayList<>();

    ArrayList<ToggleButton> toggle = new ArrayList<>();

    @FXML
    protected void randDice() {
        // 돌릴 수 있는 횟수가 0이거나 라운드가 넘어가면 더이상 못 누르기
        if (nowNum == 0) {
            return;
        }

        // 횟수 차감
        decChance();


        addLIst();
        // 다이스 객체를 만들어서 toggle 버튼과 이미지 연동

        // 잠금 해제
        for (ToggleButton tg : toggle) {
            tg.setDisable(false);
        }

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

        // 전부 true로 바꿔 둔 주사위 중 원래 안눌려져 있던 주사위 되돌리기
        for (int i = 0; i < falseDice.size(); i++) {
            diceList.get(falseDice.get(i)).getButton().setSelected(false);
        }


        // dice객체에 현재 무슨 숫자의 주사위인지 diceNum 표시
        // getImage().getUrl().substring(62,63) = 그림 숫자 번호
        int indexImg = diceNumList.get(1).getImage().getUrl().indexOf("ges/") + 4;

        for (int i = 0; i < diceList.size(); i++) {
            int nowDiceNum = Integer.parseInt(diceList.get(i).getImage().
                    getImage().getUrl().substring(indexImg, indexImg + 1));

            diceList.get(i).setDiceNum(nowDiceNum);
        }

        //족보 표시
        usercalDiceNum();

        // 랜덤숫자 및 false 주사위 지우기
        randList.clear();
        falseDice.clear();

    }


    public ArrayList<UserData> dfe() {
        ArrayList<UserData> ee = new ArrayList<>();
        ee.add(userA);
        ee.add(userB);

        return ee;
    }


    /**
     * 굴릴 때마다 보여주는 가상 점수(파란색 글자)
     *
     * @param labelList   띄워줄 각각의 파란 글자 라벨
     * @param numList     각각의 점수
     * @param userNumList 현재 굴리는 유저
     */
    protected void setBlueText(ArrayList<Label> labelList, ArrayList<Integer> numList, ArrayList<Integer> userNumList) {


        for (int i = 0; i < labelList.size(); i++) {
            Label lab = labelList.get(i);

            if (!(lab.getTextFill() == Paint.valueOf("black"))) {
                lab.setText(Integer.toString(numList.get(i)));

            } else {
                lab.setText(Integer.toString(userNumList.get(i)));
            }

        }
        showBlueTextNum.clear();
        labelList.clear();
    }

    /**
     * 가상의 유저에게 매 턴 나온 점수를 넣고 이를 이용하는 메소드
     */
    protected void setTempUser() {
        for (int i = 0; i < diceList.size(); i++) {
            nowDiceNum.add(diceList.get(i).getDiceNum());
        }

        Collections.sort(nowDiceNum);

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

        showBlueTextNum.add(ace);
        showBlueTextNum.add(two);
        showBlueTextNum.add(three);
        showBlueTextNum.add(four);
        showBlueTextNum.add(five);
        showBlueTextNum.add(six);
        showBlueTextNum.add(choices);
        showBlueTextNum.add(fourOfAKind);
        showBlueTextNum.add(fullHouse);
        showBlueTextNum.add(smallStraight);
        showBlueTextNum.add(largeStraight);
        showBlueTextNum.add(yacht);

    }

    /**
     * 족보 점수 확인
     */
    protected void usercalDiceNum() {
        boolean nowUser = userTurn.getText().equals("userA");

        Label subTotal;
        Label Bonus;
        Label Total;
        UserData user;
        ArrayList<Label> list;

        if (nowUser) {
            user = userA;
            list = userA_List;
            subTotal = userA_SubTotal;
            Bonus = userA_Bonus;
            Total = userA_Total;
        } else {
            user = userB;
            list = userB_List;
            subTotal = userB_SubTotal;
            Bonus = userB_Bonus;
            Total = userB_Total;
        }
        setUserNumList(user);
        setTempUser();
        setBlueText(list, showBlueTextNum, userNumList);

        subTotal.setText(user.getSubTotal());
        Bonus.setText(Integer.toString(user.getBonus()));
        Total.setText(Integer.toString(user.getTotal()));

        nowDiceNum.clear();
        diceList.clear();
    }

    /**
     * 유저변경
     */
    @FXML
    protected void changeUser() {

        leftChace.setText("3");
        nowNum = 3;
        ArrayList<Label> list = userA_List;
        addLIst();

        if (userTurn.getText().equals("userA")) {
            userTurn.setText("userB");
            nowA = false;
            nowB = true;

            getTotalNum("A");

        } else if (userTurn.getText().equals("userB")) {
            userTurn.setText("userA");
            nowA = true;
            nowB = false;


            list = userB_List;

            getTotalNum("B");

            roundCheck();
        }


        deleteNum(list);

        cantLock();
        yourTurn();
        addLIstClear();
        moveResult();
    }

    /**
     * 마지막 라운드가 끝난 후 결과창으로 이동
     */
    protected void moveResult() {
        ArrayList<UserData> userList = new ArrayList<>();
        userList.add(userA);
        userList.add(userB);
        if (roundNum == 13) {

            Stage stg = (Stage) userA_Aces.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("result-view.fxml"));

            Scene scene;

            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ResultController rc = fxmlLoader.getController();

            stg.setTitle("Yacht Dice Result");
            stg.setScene(scene);
            stg.show();
            rc.getResult(userList);
        }
    }

    /**
     * 찬스 소진하는 메소드
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
     * 자기 차례가 아니거나 횟수가 0이면 리턴
     *
     * @param a 어느쪽 유저인지 확인
     * @return
     */
    protected boolean myTurnCheck(String a) {
        boolean now;

        if (a.equals("A")) {
            now = nowA;
        } else {
            now = nowB;
        }

        return !now || leftChace.getText().equals("3");
    }

    /**
     * 턴이 넘어갈 때 주사위 잠금을 전부 해제 및 리스트 클리어
     */
    protected void yourTurn() {
        for (int i = 0; i < diceList.size(); i++) {
            diceList.get(i).getButton().setSelected(false);
        }
    }

    /**
     * 현재 몇 라운드인지 확인하기
     */
    protected void roundCheck() {
        if (roundNum <= 12) {
            roundNum++;
            if (roundNum == 13) {
                roundSet.setText("Game Set");
            } else {
                roundSet.setText("Round " + roundNum + "/12");
            }
        }
    }

    /**
     * 보너스 점수를 계산하는 메소드
     *
     * @param a 현재 누가 굴리는 중인지
     */
    protected void getBonusNum(String a) {
        int userSubTotal;

        UserData tempUser;
        Label tempSubTotal;
        Label tempBonus;

        if (a.equals("A")) {
            tempUser = userA;
            tempSubTotal = userA_SubTotal;
            tempBonus = userA_Bonus;
        } else {
            tempUser = userB;
            tempSubTotal = userB_SubTotal;
            tempBonus = userB_Bonus;
        }

        userSubTotal = tempUser.getAce() + tempUser.getTwo() + tempUser.getThree() + tempUser.getFour() + tempUser.getFive() + tempUser.getSix();
        tempUser.setSubTotal(userSubTotal + "/63");
        tempSubTotal.setText(tempUser.getSubTotal());

        if (userSubTotal >= 63) {
            tempUser.setBonus(35);
            tempBonus.setText(tempUser.getBonus() + "");
        }

    }

    /**
     * 최종 점수를 계산하는 메소드
     *
     * @param a 현재 누가 굴리는 중인지
     */
    protected void getTotalNum(String a) {
        int realTotal;
        UserData tempUser;
        Label totalLabel;

        if (a.equals("A")) {
            tempUser = userA;
            totalLabel = userA_Total;

        } else {
            tempUser = userB;
            totalLabel = userB_Total;
        }

        realTotal = tempUser.getAce() + tempUser.getTwo() + tempUser.getThree() + tempUser.getFour() + tempUser.getFive()
                + tempUser.getSix() + tempUser.getBonus() + tempUser.getChoices() + tempUser.getFoakind() + tempUser.getFullHouse()
                + tempUser.getSmallStraight() + tempUser.getLargeStraight() + tempUser.getYacht();

        tempUser.setTotal(realTotal);
        totalLabel.setText(Integer.toString(tempUser.getTotal()));
    }

    /**
     * 점수 입력이 끝난 후, 글씨가 파란 글씨들은 전부 삭제
     *
     * @param list 현재 무슨 리스트인지 받아오는 파라미터
     */
    protected void deleteNum(ArrayList<Label> list) {
        for (Label lab : list) {
            if (!(lab.getTextFill() == Paint.valueOf("black"))) {
                lab.setText("");
            }
        }
    }

    /**
     * 미리 선언된 리스트를 추가하는 메소드
     */
    protected void addLIst() {
        diceList.add(new Dice(toggleFirst, firstImage, 2));
        diceList.add(new Dice(toggleSecond, secondImage, 2));
        diceList.add(new Dice(toggleThird, thirdImage, 3));
        diceList.add(new Dice(toggleFourth, forthImage, 4));
        diceList.add(new Dice(toggleFifth, fifthImage, 5));

        diceNumList.add(diceOne);
        diceNumList.add(diceTwo);
        diceNumList.add(diceThree);
        diceNumList.add(diceFour);
        diceNumList.add(diceFive);
        diceNumList.add(diceSix);

        userA_List.add(userA_Aces);
        userA_List.add(userA_Twos);
        userA_List.add(userA_Threes);
        userA_List.add(userA_Fours);
        userA_List.add(userA_Fives);
        userA_List.add(userA_Sixes);
        userA_List.add(userA_Choices);
        userA_List.add(userA_FoaKind);
        userA_List.add(userA_FullHouse);
        userA_List.add(userA_SmallStr);
        userA_List.add(userA_LargeStr);
        userA_List.add(userA_Yacht);

        userB_List.add(userB_Aces);
        userB_List.add(userB_Twos);
        userB_List.add(userB_Threes);
        userB_List.add(userB_Fours);
        userB_List.add(userB_Fives);
        userB_List.add(userB_Sixes);
        userB_List.add(userB_Choices);
        userB_List.add(userB_FoaKind);
        userB_List.add(userB_FullHouse);
        userB_List.add(userB_SmallStr);
        userB_List.add(userB_LargeStr);
        userB_List.add(userB_Yacht);

        toggle.add(toggleFirst);
        toggle.add(toggleSecond);
        toggle.add(toggleThird);
        toggle.add(toggleFourth);
        toggle.add(toggleFifth);
    }

    /**
     * 추가한 리스트를 리셋시키는 메소드
     */
    protected void addLIstClear() {
        diceList.clear();
        diceNumList.clear();
        userA_List.clear();
        userB_List.clear();
        toggle.clear();
    }


    protected void getUserNumList() {
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
        userNumList.add(0);
    }

    protected void setUserNumList(UserData user) {
        int idx = 0;
        userNumList.set(idx++, user.getAce());
        userNumList.set(idx++, user.getTwo());
        userNumList.set(idx++, user.getThree());
        userNumList.set(idx++, user.getFour());
        userNumList.set(idx++, user.getFive());
        userNumList.set(idx++, user.getSix());
        userNumList.set(idx++, user.getChoices());
        userNumList.set(idx++, user.getFoakind());
        userNumList.set(idx++, user.getFullHouse());
        userNumList.set(idx++, user.getSmallStraight());
        userNumList.set(idx++, user.getLargeStraight());
        userNumList.set(idx++, user.getYacht());


    }


    /**
     * 첫턴에는 주사위를 잠글 수 없음
     */
    protected void cantLock() {
        for (ToggleButton tg : toggle) {
            tg.setDisable(true);
        }
    }

    @FXML
    protected void choiceAceUserA() {
        String me = "A";

        if (myTurnCheck(me)) {
            return;
        }

        userA.setAce(tempUser.getAce());
        userA_Aces.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();

    }

    @FXML
    protected void choiceTwoUserA() {
        String me = "A";

        if (myTurnCheck(me)) {
            return;
        }

        userA.setTwo(tempUser.getTwo());
        userA_Twos.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();
    }

    @FXML
    protected void choiceThreeUserA() {
        String me = "A";

        if (myTurnCheck(me)) {
            return;
        }

        userA.setThree(tempUser.getThree());
        userA_Threes.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();
    }

    @FXML
    protected void choiceFourUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setFour(tempUser.getFour());
        userA_Fours.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();
    }

    @FXML
    protected void choiceFiveUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setFive(tempUser.getFive());
        userA_Fives.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();
    }

    @FXML
    protected void choiceSixUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setSix(tempUser.getSix());
        userA_Sixes.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);

        changeUser();
    }

    @FXML
    protected void choiceChoiceUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setChoices(tempUser.getChoices());
        userA_Choices.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFokaUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setFoakind(tempUser.getFoakind());
        userA_FoaKind.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFullHouseUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setFullHouse(tempUser.getFullHouse());
        userA_FullHouse.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceSSrUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setSmallStraight(tempUser.getSmallStraight());
        userA_SmallStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceLSrUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setLargeStraight(tempUser.getLargeStraight());
        userA_LargeStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceYachtUserA() {
        String me = "A";
        if (myTurnCheck(me)) {
            return;
        }

        userA.setYacht(tempUser.getYacht());
        userA_Yacht.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceAceUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setAce(tempUser.getAce());
        userB_Aces.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceTwoUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setTwo(tempUser.getTwo());
        userB_Twos.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceThreeUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }
        userB.setThree(tempUser.getThree());
        userB_Threes.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceFourUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setFour(tempUser.getFour());
        userB_Fours.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceFiveUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setFive(tempUser.getFive());
        userB_Fives.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceSixUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setSix(tempUser.getSix());
        userB_Sixes.setTextFill(Paint.valueOf("black"));

        getBonusNum(me);
        changeUser();
    }

    @FXML
    protected void choiceChoiceUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setChoices(tempUser.getChoices());
        userB_Choices.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFokaUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setFoakind(tempUser.getFoakind());
        userB_FoaKind.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceFullHouseUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setFullHouse(tempUser.getFullHouse());
        userB_FullHouse.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceSSrUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setSmallStraight(tempUser.getSmallStraight());
        userB_SmallStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceLSrUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setLargeStraight(tempUser.getLargeStraight());
        userB_LargeStr.setTextFill(Paint.valueOf("black"));

        changeUser();
    }

    @FXML
    protected void choiceYachtUserB() {
        String me = "B";
        if (myTurnCheck(me)) {
            return;
        }

        userB.setYacht(tempUser.getYacht());
        userB_Yacht.setTextFill(Paint.valueOf("black"));

        changeUser();
    }
}

