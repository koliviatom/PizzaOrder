package application;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller{

    String size = "Small";
    String cheese = "Single";
    String ham = "Single";
    String pineapple = "None";
    String pepper = "None";

    Pizza pizza;
    {
        try {
            pizza = new Pizza(size, cheese, pineapple, pepper, ham);
        } catch (IllegalPizza illegalPizza) {
            illegalPizza.printStackTrace();
        }
    }
    LineItem order;

    int quantity = 1;
    double totCost = 0;

    @FXML
    private TextArea outputOrders;

    @FXML
    private TextField inputQuan;

    @FXML
    private Label totalCost;

    @FXML
    private Label orderCost;

    @FXML
    private Label pizzaCost;

    @FXML
    private ToggleGroup hamGroup;
    @FXML
    private RadioButton hamS;

    @FXML
    private ToggleGroup cheeseGroup;
    @FXML
    private RadioButton cheS;

    @FXML
    private ToggleGroup pineGroup;
    @FXML
    private RadioButton pinN;
    @FXML
    private RadioButton pinS;

    @FXML
    private ToggleGroup pepGroup;
    @FXML
    private RadioButton pepN;
    @FXML
    private RadioButton pepS;

    @FXML
    private ToggleGroup sizeGroup;
    @FXML
    private RadioButton siS;


    @FXML
    void addPressed(ActionEvent event) {
        try {
            order = new LineItem(quantity, pizza);
        } catch (IllegalPizza illegalPizza) {
            illegalPizza.printStackTrace();
        }
        outputOrders.appendText(order.toString() + "\n");

        totCost += order.getCost();
        totalCost.setText("$" + totCost + "0");
    }

    @FXML
    void initialize() {
        outputOrders.setEditable(false);
        //Set initial radiobutton values
        sizeGroup.selectToggle(siS);
        cheeseGroup.selectToggle(cheS);
        hamGroup.selectToggle(hamS);
        pineGroup.selectToggle(pinN);
        pepGroup.selectToggle(pepN);
        pizzaCost.setText("$" + pizza.getCost() + "0");
        orderCost.setText("$" + pizza.getCost()*quantity + "0");

        // restrict quantity to integers 1-100
        //Updates order cost
        inputQuan.textProperty().addListener((observableValue, oldText, newText) ->
        {
            if (newText != null && !newText.isEmpty()) {
                try {
                    quantity = Integer.parseInt(newText);
                    if (quantity > 0 && quantity < 101)
                        //Change order cost
                        orderCost.setText("$" + pizza.getCost()*quantity + "0");

                } catch (NumberFormatException e) {
                    ((StringProperty)observableValue).setValue(oldText);
                }
            }
        });

        //Size toggle listener
        sizeGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            size = ((RadioButton) new_toggle).getText();
            try {
                pizza = new Pizza(size, cheese, pineapple, pepper, ham);
            } catch (IllegalPizza illegalPizza) {
                illegalPizza.printStackTrace();
            }
            pizzaCost.setText("$" + pizza.getCost() + "0");
            orderCost.setText("$" + pizza.getCost()*quantity + "0");
        });

        //Cheese toggle listenter
        cheeseGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            cheese = ((RadioButton)new_toggle).getText();
            try {
                pizza = new Pizza(size, cheese, pineapple, pepper, ham);
            } catch (IllegalPizza illegalPizza) {
                illegalPizza.printStackTrace();
            }
            pizzaCost.setText("$" + pizza.getCost() + "0");
            orderCost.setText("$" + pizza.getCost()*quantity + "0");
        });
        //Ham toggle listener
        hamGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            ham = ((RadioButton)new_toggle).getText();
            if (((RadioButton)new_toggle).getId().equals("None")) {
                //Disable other pine/pep options
                pinS.setDisable(true);
                pepS.setDisable(true);
                //Set pineapple and pepper to none
                pineGroup.selectToggle(pinN);
                pepGroup.selectToggle(pepN);
            }
            else {
                //Enable pine/pep options
                pinS.setDisable(false);
                pepS.setDisable(false);
            }
            try {
                pizza = new Pizza(size, cheese, pineapple, pepper, ham);
            } catch (IllegalPizza illegalPizza) {
                illegalPizza.printStackTrace();
            }
            pizzaCost.setText("$" + pizza.getCost() + "0");
            orderCost.setText("$" + pizza.getCost()*quantity + "0");
        });
        //Pepper toggle listener
        pepGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            pepper = ((RadioButton)new_toggle).getText();
            try {
                pizza = new Pizza(size, cheese, pineapple, pepper, ham);
            } catch (IllegalPizza illegalPizza) {
                illegalPizza.printStackTrace();
            }
            pizzaCost.setText("$" + pizza.getCost() + "0");
            orderCost.setText("$" + pizza.getCost()*quantity + "0");
        });
        //Pineapple toggle listener
        pineGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            pineapple = ((RadioButton)new_toggle).getText();
            try {
                pizza = new Pizza(size, cheese, pineapple, pepper, ham);
            } catch (IllegalPizza illegalPizza) {
                illegalPizza.printStackTrace();
            }
            pizzaCost.setText("$" + pizza.getCost() + "0");
            orderCost.setText("$" + pizza.getCost()*quantity + "0");

        });
    }

}
