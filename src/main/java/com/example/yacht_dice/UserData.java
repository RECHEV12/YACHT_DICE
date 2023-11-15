package com.example.yacht_dice;

public class UserData {
    private String name;
    private int ace;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private String subTotal;
    private int bonus;
    private int choices;
    private int foakind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yacht;
    private int total;

    public UserData() {
    }

    public UserData(String name, int ace, int two, int three, int four, int five, int six, String subTotal, int bonus, int choices, int foakind, int fullHouse, int smallStraight, int largeStraight, int yacht, int total) {
        this.name = name;
        this.ace = ace;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.subTotal = subTotal;
        this.bonus = bonus;
        this.choices = choices;
        this.foakind = foakind;
        this.fullHouse = fullHouse;
        this.smallStraight = smallStraight;
        this.largeStraight = largeStraight;
        this.yacht = yacht;
        this.total = total;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAce() {
        return ace;
    }

    public void setAce(int ace) {
        this.ace = ace;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getChoices() {
        return choices;
    }

    public void setChoices(int choices) {
        this.choices = choices;
    }

    public int getFoakind() {
        return foakind;
    }

    public void setFoakind(int foakind) {
        this.foakind = foakind;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public void setSmallStraight(int smallStraight) {
        this.smallStraight = smallStraight;
    }

    public int getLargeStraight() {
        return largeStraight;
    }

    public void setLargeStraight(int largeStraight) {
        this.largeStraight = largeStraight;
    }

    public int getYacht() {
        return yacht;
    }

    public void setYacht(int yacht) {
        this.yacht = yacht;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}


