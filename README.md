# Calculator

## Synopsis
This is my final for my Industry Projects Class. It required a GUI and an object class. It is a calculator that allows you to change the side the plus, minus, multiply and divide symbols are on.

## How to Run
You will need all of the files in /CalculatorFinal/src/com/company.

## Code Example
This is how I implemented the equal button to perform the previous action again. Each of the other button are assigned a place in an array.
```
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
```
