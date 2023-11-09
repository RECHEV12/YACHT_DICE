package com.example.yacht_dice;

import java.util.ArrayList;
import java.util.Collections;

public class UseMethod {
    public static int randNumSix() {
        int rand = ((int) (Math.random() * 6)) + 1;
        return rand;
    }

    public static int checkAces(ArrayList<Dice> diceList) {
        int result = 0;

        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 1) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkTwos(ArrayList<Dice> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 2) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkThrees(ArrayList<Dice> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 3) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkFours(ArrayList<Dice> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 4) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkFives(ArrayList<Dice> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 5) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkSixes(ArrayList<Dice> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceNum() == 6) {
                result += diceList.get(i).getDiceNum();
            }
        }
        return result;
    }

    public static int checkSubTotal(ArrayList<Integer> aceToSix) {
        int defaultNum = 0;
        for (int i = 0; i < aceToSix.size(); i++) {
            defaultNum += aceToSix.get(i);
        }
        return defaultNum;
    }


    public static int checkBonus(int subTotal) {
        int result = 0;

        if (subTotal >= 63) {
            result = 35;
        }
        return result;
    }

    public static int checkChoices(ArrayList<Dice> diceList) {
        int result = 0;

        int firstNum = diceList.get(0).getDiceNum();
        int secondNum = diceList.get(1).getDiceNum();
        int thirdNum = diceList.get(2).getDiceNum();
        int fourNum = diceList.get(3).getDiceNum();
        int fiveNum = diceList.get(4).getDiceNum();

        result = (firstNum + secondNum + thirdNum + fourNum + fiveNum);

        return result;
    }

    public static int checkFourOfAKind(ArrayList<Dice> diceList) {
        int result = 0;

        int firstNum = diceList.get(0).getDiceNum();
        int secondNum = diceList.get(1).getDiceNum();
        int thirdNum = diceList.get(2).getDiceNum();
        int fourNum = diceList.get(3).getDiceNum();
        int fiveNum = diceList.get(4).getDiceNum();

        if (
                firstNum == secondNum && thirdNum == fourNum && firstNum == thirdNum ||
                        secondNum == thirdNum && fourNum == fiveNum && secondNum == fourNum
        ) {
            result = (firstNum + secondNum + thirdNum + fourNum + fiveNum);
        }

        return result;
    }

    public static int checkFullHouse(ArrayList<Dice> diceList) {
        int result = 0;
        int firstNum = diceList.get(0).getDiceNum();
        int secondNum = diceList.get(1).getDiceNum();
        int thirdNum = diceList.get(2).getDiceNum();
        int fourNum = diceList.get(3).getDiceNum();
        int fiveNum = diceList.get(4).getDiceNum();

        if (
                firstNum == secondNum && (thirdNum == fourNum && fourNum == fiveNum) ||
                        (firstNum == secondNum && secondNum == thirdNum) && fourNum == fiveNum) {
            result = (firstNum + secondNum + thirdNum + fourNum + fiveNum);
        }
        return result;
    }

    public static int checkSmallStraight(ArrayList<Dice> diceList) {
        int result = 0;
        int cnt = 0;

        ArrayList<Integer> straightInt = new ArrayList<>();


        for (Dice dice : diceList) {
            straightInt.add(dice.getDiceNum());
        }
        Collections.sort(straightInt);

        for (int i = 0; i < straightInt.size() - 1; i++) {
            if (straightInt.get(i) == straightInt.get(i + 1)) {
                straightInt.remove(i + 1);
                i--;
            }
        }

        for (int i = 0; i < straightInt.size() - 1; i++) {
            if (straightInt.get(i) + 1 == straightInt.get(i + 1)) {
                cnt++;

            }
        }

        if (cnt >= 3) {
            result = 15;
        }


        return result;
    }

    public static int checkLargeStraight(ArrayList<Dice> diceList) {
        int result = 0;
        int cnt = 0;

        ArrayList<Integer> straightInt = new ArrayList<>();


        for (Dice dice : diceList) {
            straightInt.add(dice.getDiceNum());
        }
        Collections.sort(straightInt);

        for (int i = 0; i < straightInt.size() - 1; i++) {
            if (straightInt.get(i) == straightInt.get(i + 1)) {
                straightInt.remove(i + 1);
                i--;
            }
        }

        for (int i = 0; i < straightInt.size() - 1; i++) {
            if (straightInt.get(i) + 1 == straightInt.get(i + 1)) {
                cnt++;

            }
        }

        if (cnt >= 4) {
            result = 30;
        }


        return result;
    }

    public static int checkYacht(ArrayList<Dice> diceList) {
        int result = 0;

        int firstNum = diceList.get(0).getDiceNum();
        int secondNum = diceList.get(1).getDiceNum();
        int thirdNum = diceList.get(2).getDiceNum();
        int fourNum = diceList.get(3).getDiceNum();
        int fiveNum = diceList.get(4).getDiceNum();

        if (
                firstNum == secondNum &&
                        thirdNum == fourNum &&
                        firstNum == thirdNum &&
                        fourNum == fiveNum
        ) {
            result = 50;
        }
        return result;
    }

    public static int checkTotal(ArrayList<Integer> allNumber) {
        int result = 0;
        for (int i = 0; i < allNumber.size(); i++) {
            result += allNumber.get(i);
        }
        return result;
    }
}
