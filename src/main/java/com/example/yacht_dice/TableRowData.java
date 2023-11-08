package com.example.yacht_dice;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TableRowData {
    IntegerProperty Aces;    IntegerProperty Twos;    IntegerProperty Threes;    IntegerProperty Fours;    IntegerProperty Fives;
    IntegerProperty Sixes;    IntegerProperty total;    StringProperty bonus;    IntegerProperty choices;
    IntegerProperty FourOfAKind;    IntegerProperty FullHouse;    IntegerProperty smaillStraiht;
    IntegerProperty largeStraiht;    IntegerProperty yacht;

    public TableRowData(IntegerProperty aces, IntegerProperty twos, IntegerProperty threes, IntegerProperty fours, IntegerProperty fives, IntegerProperty sixes, IntegerProperty total, StringProperty bonus, IntegerProperty choices, IntegerProperty fourOfAKind, IntegerProperty fullHouse, IntegerProperty smaillStraiht, IntegerProperty largeStraiht, IntegerProperty yacht) {
        Aces = aces;
        Twos = twos;
        Threes = threes;
        Fours = fours;
        Fives = fives;
        Sixes = sixes;
        this.total = total;
        this.bonus = bonus;
        this.choices = choices;
        FourOfAKind = fourOfAKind;
        FullHouse = fullHouse;
        this.smaillStraiht = smaillStraiht;
        this.largeStraiht = largeStraiht;
        this.yacht = yacht;
    }

    public int getAces() {
        return Aces.get();
    }

    public IntegerProperty acesProperty() {
        return Aces;
    }

    public void setAces(int aces) {
        this.Aces.set(aces);
    }

    public int getTwos() {
        return Twos.get();
    }

    public IntegerProperty twosProperty() {
        return Twos;
    }

    public void setTwos(int twos) {
        this.Twos.set(twos);
    }

    public int getThrees() {
        return Threes.get();
    }

    public IntegerProperty threesProperty() {
        return Threes;
    }

    public void setThrees(int threes) {
        this.Threes.set(threes);
    }

    public int getFours() {
        return Fours.get();
    }

    public IntegerProperty foursProperty() {
        return Fours;
    }

    public void setFours(int fours) {
        this.Fours.set(fours);
    }

    public int getFives() {
        return Fives.get();
    }

    public IntegerProperty fivesProperty() {
        return Fives;
    }

    public void setFives(int fives) {
        this.Fives.set(fives);
    }

    public int getSixes() {
        return Sixes.get();
    }

    public IntegerProperty sixesProperty() {
        return Sixes;
    }

    public void setSixes(int sixes) {
        this.Sixes.set(sixes);
    }

    public int getTotal() {
        return total.get();
    }

    public IntegerProperty totalProperty() {
        return total;
    }

    public void setTotal(int total) {
        this.total.set(total);
    }

    public String getBonus() {
        return bonus.get();
    }

    public StringProperty bonusProperty() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus.set(bonus);
    }

    public int getChoices() {
        return choices.get();
    }

    public IntegerProperty choicesProperty() {
        return choices;
    }

    public void setChoices(int choices) {
        this.choices.set(choices);
    }

    public int getFourOfAKind() {
        return FourOfAKind.get();
    }

    public IntegerProperty fourOfAKindProperty() {
        return FourOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        this.FourOfAKind.set(fourOfAKind);
    }

    public int getFullHouse() {
        return FullHouse.get();
    }

    public IntegerProperty fullHouseProperty() {
        return FullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.FullHouse.set(fullHouse);
    }

    public int getSmaillStraiht() {
        return smaillStraiht.get();
    }

    public IntegerProperty smaillStraihtProperty() {
        return smaillStraiht;
    }

    public void setSmaillStraiht(int smaillStraiht) {
        this.smaillStraiht.set(smaillStraiht);
    }

    public int getLargeStraiht() {
        return largeStraiht.get();
    }

    public IntegerProperty largeStraihtProperty() {
        return largeStraiht;
    }

    public void setLargeStraiht(int largeStraiht) {
        this.largeStraiht.set(largeStraiht);
    }

    public int getYacht() {
        return yacht.get();
    }

    public IntegerProperty yachtProperty() {
        return yacht;
    }

    public void setYacht(int yacht) {
        this.yacht.set(yacht);
    }
}
