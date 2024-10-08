package ca.seneca.workshop2.controllers;

import ca.seneca.workshop2.models.Customer;
import ca.seneca.workshop2.models.Order;
import ca.seneca.workshop2.views.OrderView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class OrderController extends Application {
    // Create model
    private Order model = new Order();
    // Declare view
    private OrderView view;

    // Single argument constructor
    public OrderController() { this.view = new OrderView(model); }

    @Override
    public void start(Stage pm) {

        // Two ArrayLists to manage checkbox choices
        ArrayList<String> nMToppings = new ArrayList<String>();
        ArrayList<String> mToppings = new ArrayList<String>();


        // Clear button action
        view.getCOrder().setOnAction(actionEvent -> {

            view.clear();

        });

        // Place Order button action
        view.getPOrder().setOnAction(_ -> {

            // String to track all errors occured due to lack of information
            StringBuilder errorMessage = new StringBuilder();

            // Check if nameField is empty
            if (view.getQtyTf().getText().trim().isEmpty()) {
                errorMessage.append("Quantity is required.\n");
            }

            // Check if emailField is empty
            if (view.getNameTf().getText().trim().isEmpty()) {
                errorMessage.append("Name is required.\n");
            }

            // Check if each ToggleGroup has a selection
            if (view.getTgSize().getSelectedToggle() == null) {
                errorMessage.append("Size is required.\n");
            }

            if (view.getTgCrust().getSelectedToggle() == null) {
                errorMessage.append("Crust is required.\n");
            }

            // Warning alert pops up if at least one error occurs
            if (errorMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validation Error");
                alert.setHeaderText("Please fill out all required fields");
                alert.setContentText(errorMessage.toString());
                alert.showAndWait();
            }
            else {
                // Parse data from toggleGroups
                RadioButton selectedSize = (RadioButton) view.getTgSize().getSelectedToggle();
                RadioButton selectedCrust = (RadioButton) view.getTgCrust().getSelectedToggle();

                // Split the string from size radioButton
                String[] parts = selectedSize.getText().split("-");

                // First part is size and the second is dollar
                String size = parts[0];
                String priceString = parts[1].replace("$", "");
                double price = Double.parseDouble(priceString);

                // crust value assigned to string
                String crust = selectedCrust.getText();

                // Add all selected non-meat toppings to the arrayList
                // increase value by 1.1$ for every non-meat topping
                for (CheckBox cb : view.getToppingsCbNm()) {
                    if (cb.isSelected()) {
                        nMToppings.add(cb.getText());
                        price += 1.1;
                    }
                }

                // Increase value by 2.15$ for each meat topping
                for (CheckBox cb : view.getToppingsCbM()) {
                    if (cb.isSelected()) {
                        mToppings.add(cb.getText());
                        price += 2.15;
                    }
                }

                // add qty amount of pizzas
                for (int i = 0; i < Integer.valueOf(view.getQtyTf().getText()); i++) {

                    model.addPizza(size, price, crust, nMToppings.toArray(new String[0]), mToppings.toArray(new String[0]));

                }

                // Create a customer based on entered data
                model.customer = new Customer(view.getNameTf().getText(), view.getCellTf().getText());

                // Multiply price by quantity
                price *= Integer.valueOf(view.getQtyTf().getText());

                // Confirmation pop-up with data
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                confirmation.setTitle("Confirmation");
                confirmation.setHeaderText("Order Summary");
                Label result = new Label("Your name: " + model.customer.getName() + "\n" +
                        "Phone number: " + model.customer.getCell() + "\n" +
                        "Pizza type: " + crust + "\n" +
                        "Size: " + size + "\n" +
                        "Quantity: " + view.getQtyTf().getText() + "\n" +
                        "Total before tax: $" + String.format("%.2f",price) + "\n" +
                        "Total to be paid: $" + String.format("%.2f", price * 1.13));
                result.setStyle("-fx-font-size: 24px;");

                confirmation.getDialogPane().setContent(result);
                // Adjust size of pop-up according to content's size
                confirmation.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                confirmation.show();

            }





        });



        Scene sc = new Scene(view, 800 , 600);

        // Check if css file exists
        URL cssFile = getClass().getResource("/style.css");
        if (cssFile != null) {
            sc.getStylesheets().add(cssFile.toExternalForm());
        } else {
            System.out.println("CSS file not found: /css/style.css");
        }

        pm.setScene(sc);
        pm.setResizable(false);
        pm.setTitle("Pizza Order Application");
        pm.show();

    }

    public static void main(String[] args) {
        launch(args);
    }



}
