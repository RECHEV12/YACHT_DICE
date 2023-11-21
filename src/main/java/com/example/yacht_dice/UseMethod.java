package com.example.yacht_dice;

import java.util.*;

public class UseMethod {
    public static int randNumSix() {
        int rand = ((int) (Math.random() * 6)) + 1;
        return rand;
    }

    public static int checkAces(ArrayList<Integer> diceList) {
        int result = 0;

        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 1) {
                result += diceList.get(i);
            }
        }
        return result;
    }

    public static int checkTwos(ArrayList<Integer> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 2) {
                result += diceList.get(i);
            }
        }
        return result;
    }

    public static int checkThrees(ArrayList<Integer> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 3) {
                result += diceList.get(i);
            }
        }
        return result;
    }

    public static int checkFours(ArrayList<Integer> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 4) {
                result += diceList.get(i);
            }
        }
        return result;
    }

    public static int checkFives(ArrayList<Integer> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 5) {
                result += diceList.get(i);
            }
        }
        return result;
    }

    public static int checkSixes(ArrayList<Integer> diceList) {
        int result = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i) == 6) {
                result += diceList.get(i);
            }
        }
        return result;
    }


    public static int checkChoices(ArrayList<Integer> diceList) {

        int firstNum = diceList.get(0);
        int secondNum = diceList.get(1);
        int thirdNum = diceList.get(2);
        int fourNum = diceList.get(3);
        int fiveNum = diceList.get(4);

        return (firstNum + secondNum + thirdNum + fourNum + fiveNum);
    }

    public static int checkFourOfAKind(ArrayList<Integer> diceList) {
        int result = 0;

        int firstNum = diceList.get(0);
        int secondNum = diceList.get(1);
        int thirdNum = diceList.get(2);
        int fourNum = diceList.get(3);
        int fiveNum = diceList.get(4);

        if (
                firstNum == secondNum && thirdNum == fourNum && firstNum == thirdNum ||
                        secondNum == thirdNum && fourNum == fiveNum && secondNum == fourNum
        ) {
            result = (firstNum + secondNum + thirdNum + fourNum + fiveNum);
        }

        return result;
    }

    public static int checkFullHouse(ArrayList<Integer> diceList) {

        Collections.sort(diceList);

        int result = 0;
        int firstNum = diceList.get(0);
        int secondNum = diceList.get(1);
        int thirdNum = diceList.get(2);
        int fourNum = diceList.get(3);
        int fiveNum = diceList.get(4);

        if (
                firstNum == secondNum && (thirdNum == fourNum && fourNum == fiveNum) ||
                        (firstNum == secondNum && secondNum == thirdNum) && fourNum == fiveNum) {
            result = (firstNum + secondNum + thirdNum + fourNum + fiveNum);
        }
        return result;
    }

    public static int checkSmallStraight(ArrayList<Integer> diceList) {
        int result = 0;
        int cnt = 0;
        int a = 0;
        int b = 0;

        ArrayList<Integer> straightInt = new ArrayList<>();

        straightInt.add(diceList.get(diceList.size() - 1));

        for (int i = 0; i < diceList.size() - 1; i++) {
            if (!(diceList.get(i) == diceList.get(i + 1))) {
                straightInt.add(diceList.get(i));
            }
        }

        Collections.sort(straightInt);

        if (straightInt.size() == 4) {
            for (int i = 0; i < straightInt.size() - 1; i++) {
                if (straightInt.get(i) + 1 == straightInt.get(i + 1)) {
                    cnt++;
                }
            }
        } else if (straightInt.size() == 5) {

            for (int i = 0; i < 3; i++) {
                if (straightInt.get(i) + 1 == straightInt.get(i + 1)) {
                    a++;
                }
            }
            for (int i = 4; i > 1; i--) {
                if (straightInt.get(i) - 1 == straightInt.get(i - 1)) {
                    b++;
                }
            }
        }

        if (a >= 3 || b >= 3) {
            cnt = 3;
        }

        if (cnt >= 3) {
            result = 15;
        }

        return result;
    }

    public static int checkLargeStraight(ArrayList<Integer> diceList) {
        int result = 0;
        int cnt = 0;

        Collections.sort(diceList);


        for (int i = 0; i < diceList.size() - 1; i++) {
            if (diceList.get(i) + 1 == diceList.get(i + 1)) {
                cnt++;
            }
        }

        if (cnt >= 4) {
            result = 30;
        }

        return result;
    }

    public static int checkYacht(ArrayList<Integer> diceList) {
        int result = 0;

        int firstNum = diceList.get(0);
        int secondNum = diceList.get(1);
        int thirdNum = diceList.get(2);
        int fourNum = diceList.get(3);
        int fiveNum = diceList.get(4);

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


}
