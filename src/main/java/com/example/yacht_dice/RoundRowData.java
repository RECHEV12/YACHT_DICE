package com.example.yacht_dice;

import javafx.beans.property.StringProperty;

public class RoundRowData {
    private StringProperty name;

    public RoundRowData(StringProperty name) {
        this.name = name;
    }

    public String getCategories() {
        return name.get();
    }

    public StringProperty categoriesProperty() {
        return name;
    }

    public void setCategories(String categories) {
        this.name.set(categories);
    }
}
