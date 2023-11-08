package com.example.yacht_dice;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<RoundRowData> roundTable;
    @FXML
    private TableColumn<RoundRowData, String> round;

    ObservableList<RoundRowData> roundList = FXCollections.observableArrayList(
                      new RoundRowData(new SimpleStringProperty("categories"))
                    , new RoundRowData(new SimpleStringProperty("Aces"))
                    , new RoundRowData(new SimpleStringProperty("Twos"))
                    , new RoundRowData(new SimpleStringProperty("Threes"))
                    , new RoundRowData(new SimpleStringProperty("Fours"))
                    , new RoundRowData(new SimpleStringProperty("Fives"))
                    , new RoundRowData(new SimpleStringProperty("Sixes"))
                    , new RoundRowData(new SimpleStringProperty("total"))
                    , new RoundRowData(new SimpleStringProperty("bonus"))
                    , new RoundRowData(new SimpleStringProperty("choices"))
                    , new RoundRowData(new SimpleStringProperty("FourOfAKind"))
                    , new RoundRowData(new SimpleStringProperty("FullHouse"))
                    , new RoundRowData(new SimpleStringProperty("smaillStraiht"))
                    , new RoundRowData(new SimpleStringProperty("largeStraiht"))
                    , new RoundRowData(new SimpleStringProperty("yacht"))
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        round.setCellValueFactory(cellData -> cellData.getValue().categoriesProperty());
        roundTable.setItems(roundList);
    }

    @FXML
    private TableView<TableRowData> yachtTable;
    @FXML
    private TableColumn<TableRowData, Integer> userA;
    private TableColumn<TableRowData, Integer> userB;


}
