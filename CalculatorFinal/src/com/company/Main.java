package com.company;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Function button menu
        Calculator calculator = new Calculator();

        ToggleGroup group = new ToggleGroup();
        RadioButton rbLeft = new RadioButton("Left");
        rbLeft.setToggleGroup(group);
        RadioButton rbBottom = new RadioButton("Bottom");
        rbBottom.setToggleGroup(group);
        RadioButton rbRight = new RadioButton("Right");
        rbRight.setToggleGroup(group);
        HBox radioButtons = new HBox();
        radioButtons.setAlignment(Pos.CENTER);
        radioButtons.getChildren().addAll(rbLeft,rbBottom,rbRight);

        VBox vFunctionButtons = new VBox();
        HBox hFunctionButtons = new HBox();
        Button add = new Button("+");
        add.setMinWidth(30);
        Button minus = new Button("-");
        minus.setMinWidth(30);
        Button divide = new Button("÷");
        divide.setMinWidth(30);
        Button multiply = new Button("×");
        multiply.setMinWidth(30);
        hFunctionButtons.setAlignment(Pos.TOP_CENTER);

        HBox box1 = new HBox();
        TextField textField = new TextField();
        textField.setMaxWidth(89);
        box1.getChildren().add(textField);
        box1.setAlignment(Pos.CENTER);
        Button seven = new Button("7");
        seven.setMinWidth(30);
        seven.setOnAction(e -> {
            textField.appendText("7");
        });
        Button eight = new Button("8");
        eight.setMinWidth(30);
        eight.setOnAction(e -> {
            textField.appendText("8");
        });
        Button nine = new Button("9");
        nine.setMinWidth(30);
        nine.setOnAction(e -> {
            textField.appendText("9");
        });
        Button four = new Button("4");
        four.setMinWidth(30);
        four.setOnAction(e -> {
            textField.appendText("4");
        });
        Button five = new Button("5");
        five.setMinWidth(30);
        five.setOnAction(e -> {
            textField.appendText("5");
        });
        Button six = new Button("6");
        six.setMinWidth(30);
        six.setOnAction(e -> {
            textField.appendText("6");
        });
        Button one = new Button("1");
        one.setMinWidth(30);
        one.setOnAction(e -> {
            textField.appendText("1");
        });
        Button two = new Button("2");
        two.setMinWidth(30);
        two.setOnAction(e -> {
            textField.appendText("2");
        });
        Button three = new Button("3");
        three.setMinWidth(30);
        three.setOnAction(e -> {
            textField.appendText("3");
        });
        Button zero = new Button("0");
        zero.setMinWidth(30);
        zero.setOnAction(e -> {
            textField.appendText("0");
        });
        Button equal = new Button("=");
        equal.setMinWidth(30);
        equal.setOnAction(e -> {
            textField.appendText("");
        });
        Button clear = new Button("C");
        clear.setOnAction(e -> {
            textField.clear();
        });
        equal.setMinWidth(30);

        HBox box789 = new HBox();
        box789.setAlignment(Pos.CENTER);
        HBox box456 = new HBox();
        box456.setAlignment(Pos.CENTER);
        HBox box123 = new HBox();
        box123.setAlignment(Pos.CENTER);
        HBox box0Equals = new HBox();
        box0Equals.setAlignment(Pos.CENTER);
        box789.getChildren().addAll(seven,eight,nine);
        box456.getChildren().addAll(four,five,six);
        box123.getChildren().addAll(one,two,three);
        box0Equals.getChildren().addAll(zero,equal,clear);
        VBox numPad = new VBox();
        numPad.getChildren().addAll(box1,box789, box456, box123, box0Equals);
        BorderPane root = new BorderPane();
        root.setTop(radioButtons);
        root.setCenter(numPad);

        final boolean[] notBottom = {false};
        group.selectedToggleProperty().addListener(((observable, oldValue, newValue) -> {
            if (rbLeft.isSelected()) {
                root.getChildren().remove(root.getBottom());
                root.getChildren().remove(root.getRight());
                if (!notBottom[0]) {
                    hFunctionButtons.getChildren().removeAll();
                    vFunctionButtons.getChildren().removeAll();
                    vFunctionButtons.getChildren().addAll(add, minus, divide, multiply);
                }
                root.setLeft(vFunctionButtons);
                notBottom[0] = true;
            }
            else if (rbBottom.isSelected()) {
                root.getChildren().remove(root.getLeft());
                root.getChildren().remove(root.getRight());
                hFunctionButtons.getChildren().removeAll();
                vFunctionButtons.getChildren().removeAll();
                hFunctionButtons.getChildren().addAll(add,minus,divide,multiply);
                root.setBottom(hFunctionButtons);
                notBottom[0] = false;
            }
            else {
                root.getChildren().remove(root.getLeft());
                root.getChildren().remove(root.getBottom());
                if (!notBottom[0]) {
                    hFunctionButtons.getChildren().removeAll();
                    vFunctionButtons.getChildren().removeAll();
                    vFunctionButtons.getChildren().addAll(add, minus, divide, multiply);
                }
                vFunctionButtons.setAlignment(Pos.BASELINE_LEFT);
                root.setRight(vFunctionButtons);
                notBottom[0] = true;
            }
        }));
        final boolean[] selected =new boolean[4];
        add.setOnAction(e -> {
            calculator.add(Double.parseDouble(textField.getText()));
            textField.setPromptText(String.valueOf(calculator.getStored()));
            textField.setText("");
            for (int i = 0; i < selected.length; i++) {
                selected[i] = false;
            }
            selected[0] = true;
        });
        minus.setOnAction(e -> {
            calculator.minus(Double.parseDouble(textField.getText()));
            textField.setPromptText(String.valueOf(calculator.getStored()));
            textField.setText("");
            for (int i = 0; i < selected.length; i++) {
                selected[i] = false;
            }
            selected[1] = true;
        });
        multiply.setOnAction(e -> {
            if (calculator.getStored() != 0) {
                calculator.times(Double.parseDouble(textField.getText()));
                textField.setPromptText(String.valueOf(calculator.getStored()));
                textField.setText("");
            }
            else {
                calculator.setStored(Double.parseDouble(textField.getText()));
                textField.setPromptText(String.valueOf(calculator.getStored()));
                textField.setText("");
            }
            for (int i = 0; i < selected.length; i++) {
                selected[i] = false;
            }
            selected[2] = true;
        });
        divide.setOnAction(e -> {
            if (calculator.getStored() != 0) {
                calculator.divide(Double.parseDouble(textField.getText()));
                textField.setPromptText(String.valueOf(calculator.getStored()));
                textField.setText("");
            }
            else {
                calculator.setStored(Double.parseDouble(textField.getText()));
                textField.setPromptText(String.valueOf(calculator.getStored()));
                textField.setText("");
            }
            for (int i = 0; i < selected.length; i++) {
                selected[i] = false;
            }
            selected[3] = true;
        });
        equal.setOnAction(e -> {
            if (selected[0])
                calculator.add(Double.parseDouble(textField.getText()));
            if (selected[1])
                calculator.minus(Double.parseDouble(textField.getText()));
            if (selected[2])
                calculator.times(Double.parseDouble(textField.getText()));
            if (selected[3])
                calculator.divide(Double.parseDouble(textField.getText()));
            textField.setPromptText(String.valueOf(calculator.getStored()));
            textField.clear();
        });
        clear.setOnAction(e -> {
            textField.clear();
            textField.setPromptText("");
                });

        Scene scene = new Scene(root, 180,180);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        rbBottom.setSelected(true);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
