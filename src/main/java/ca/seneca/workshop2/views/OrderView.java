/**********************************************
 Workshop #2
 Course:APD 545 - Semester 5
 Last Name: Mullagaliev
 First Name: Amir
 ID: 128102225
 Section:ZAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature AM
 Date:10.07.2024
 **********************************************/

package ca.seneca.workshop2.views;

import ca.seneca.workshop2.models.Order;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

public class OrderView extends Pane {

    private Order model = new Order();

    private TextField nameTf;

    private TextField cellTf;

    private TextField qtyTf;

    private Button pOrder;

    private Button cOrder;

    private String[] nmToppings = {"Pineapple", "Extra Cheese", "Dried Shrimps", "Mushrooms", "Anchovies", "Sun Dried Tomatoes", "Dacon", "Spinach", "Roasted Garlic", "Jalapeno"};

    private String[] mToppings = {"Ground Beef", "Shredded Chicken", "Grilled Chicken", "Pepperoni", "Ham", "Bacon"};

    private List<CheckBox> toppingsCbNm = new ArrayList<CheckBox>();

    private List<CheckBox> toppingsCbM = new ArrayList<CheckBox>();

    public ToggleGroup getTgSize() {
        return tgSize;
    }

    public ToggleGroup getTgCrust() {
        return tgCrust;
    }

    private ToggleGroup tgSize = new ToggleGroup();

    private ToggleGroup tgCrust = new ToggleGroup();



    // Public methods
    public Button getPOrder() { return this.pOrder; }

    public Button getCOrder() { return cOrder; }

    public OrderView(Order model) {

        Image img = new Image("https://img.icons8.com/doodle/96/pizza.png");

        Label header = new Label("Pizza Bakery Online ");

        Label customerInfo = new Label("Customer's information");

        Label pizzaBuilder = new Label("Build Your Custom Pizza");

        Label name = new Label("Enter Name:");

        Label cell = new Label("Enter Cell:");

        Label size = new Label("Choose Pizza Size:");

        Label crust = new Label("Choose Pizza Crust:");

        Label top = new Label("Toppings");

        Label qty = new Label("Enter Quantity:");

        // Logo
        ImageView iView = new ImageView(img);

        this.model = model;

        // Add image to the label
        header.setGraphic(iView);
        // Display image to the left of text
        header.setContentDisplay(ContentDisplay.LEFT);
        // Adjust font and location
        header.setFont(new Font("Arial", 32));
        header.relocate(0, 0);
        header.setPrefSize(800, 50);
        header.setTextAlignment(TextAlignment.RIGHT);

        header.setStyle("-fx-background-color: #0D3B66; -fx-text-fill: #FAF0CA");

        pizzaBuilder.setFont(new Font("Arial", 18));
        pizzaBuilder.relocate(35, 150);

        size.setFont(new Font("Arial", 14));
        size.relocate(55, 175);

        // Radiobuttons to choose pizza size
        RadioButton small = new RadioButton("Small - 7.00$");
        RadioButton medium = new RadioButton("Medium - 10.00$");
        RadioButton large = new RadioButton("Large - 13.00$");
        RadioButton xLarge = new RadioButton("Extra Large - 15.00$");

        // Join radiobuttons together
        small.setToggleGroup(tgSize);
        medium.setToggleGroup(tgSize);
        large.setToggleGroup(tgSize);
        xLarge.setToggleGroup(tgSize);

        // Adjust radiobuttons' position
        small.relocate(55, 200);
        medium.relocate(55, 220);
        large.relocate(55, 240);
        xLarge.relocate(55, 260);

        // Set crust label
        crust.setFont(new Font("Arial", 14));
        crust.relocate(250, 175);

        // Create Radiobuttons for crust type
        RadioButton normal = new RadioButton("Normal");
        RadioButton thin = new RadioButton("Thin");
        RadioButton dDish = new RadioButton("Deep Dish");

        // Adjust radiobuttons positions
        normal.relocate(250, 195);
        thin.relocate(250, 215);
        dDish.relocate(250, 235);

        // Join radiobuttons together
        normal.setToggleGroup(tgCrust);
        thin.setToggleGroup(tgCrust);
        dDish.setToggleGroup(tgCrust);

        // Set qty Label
        qty.setFont(new Font("Arial", 14));
        qty.relocate(55, 285);

        this.qtyTf = new TextField();
        this.qtyTf.setTextFormatter(new TextFormatter<>(change -> {
            // Check if the new text matches the pattern for digits only
            if (change.getControlNewText().matches("\\d*")) {
                return change; // Accept the change if it is a digit
            }
            return null; // Reject the change
        }));
        this.qtyTf.relocate(55, 305);
        this.qtyTf.setPrefSize(50, 25);

        // Toppings Label
        top.setFont(new Font("Arial", 18));
        top.relocate(35, 345);

        // Price for non-meat toppings label
        Label priceNM = new Label("$1.10");
        priceNM.setFont(new Font("Arial", 14));
        priceNM.relocate(50, 370);

        // Create checkboxes , using nmToppings String array and pass it
        // to toppingsCbNm
        for (int i = 0; i < nmToppings.length; i++) {
            CheckBox checkbox = new CheckBox(nmToppings[i]);
            toppingsCbNm.add(checkbox);
        }

        // Set up location of each checkbox and pass it to the pane
        int posX = 50;
        for (int i = 0; i < toppingsCbNm.size(); i++) {
            posX = (i != 0)? (i % 4) == 0 ? posX + 150 : posX : posX;
            int posY = 395 + (20 * (i % 4));

            toppingsCbNm.get(i).relocate(posX, posY);
            this.getChildren().add(toppingsCbNm.get(i));
        }

        // Set up new price label, for meet toppings
        Label priceMT = new Label("$2.15");
        priceMT.setFont(new Font("Arial", 14));
        priceMT.relocate(50, 480);

        // Pass all value from meet toppings
        // String array to create checkboxes
        for (int i = 0; i < mToppings.length; i++) {
            CheckBox checkBox = new CheckBox(mToppings[i]);
            toppingsCbM.add(checkBox);
        }

        // Set up location of each checkbox for meet toppings
        posX = 50;
        for (int i = 0; i < toppingsCbM.size(); i++) {
            posX = (i != 0)? (i % 4) == 0 ? posX + 150 : posX : posX;
            int posY = 505 + (20 * (i % 4));

            toppingsCbM.get(i).relocate(posX, posY);
            this.getChildren().add(toppingsCbM.get(i));

        }

        // Customer information

        customerInfo.setFont(new Font("Arial", 18));
        customerInfo.relocate(575, 150);


        name.setFont(new Font("Arial", 14));
        name.relocate(575, 185);

        this.nameTf = new TextField();
        this.nameTf.relocate(660, 180);
        this.nameTf.setPrefSize(100, 15);

        cell.setFont(new Font("Arial", 14));
        cell.relocate(575, 215);

        this.cellTf = new TextField();
        this.cellTf.setTextFormatter(new TextFormatter<>(change -> {
            // Check if the new text matches the pattern for digits only
            if (change.getControlNewText().matches("\\d*")) {
                return change; // Accept the change if it is a digit
            }
            return null; // Reject the change
        }));
        this.cellTf.relocate(645, 210);
        this.cellTf.setPrefSize(115, 15);


        // Set "Place Order" button
        this.pOrder = new Button("Place Order");
        this.pOrder.relocate(700, 555);

        // Set "Clear" Button
        this.cOrder = new Button("Clear");
        this.cOrder.relocate( 645, 555);


        // Pass all the nodes to the pane
        this.getChildren().addAll(new Node[]{
                header,
                customerInfo,
                pizzaBuilder,
                size,
                small,
                medium,
                large,
                xLarge,
                crust,
                normal,
                thin,
                dDish,
                qty,
                this.qtyTf,
                top,
                priceNM,
                priceMT,
                name,
                this.nameTf,
                cell,
                this.cellTf,
                this.pOrder,
                this.cOrder
        });



    }

    // clear all fields, radiobuttons and checkboxes
    // used in controller class
    public void clear() {
        // Cancel selection from all toggle groups
        tgSize.selectToggle(null);
        tgCrust.selectToggle(null);
        // Clear all text fields
        qtyTf.clear();
        nameTf.clear();
        cellTf.clear();

        for (CheckBox cb : toppingsCbNm) {
            cb.setSelected(false);
        }
        for (CheckBox cb: toppingsCbM) {
            cb.setSelected(false);
        }
    }

    // Getters
    public TextField getCellTf() {
        return cellTf;
    }

    public TextField getNameTf() {
        return nameTf;
    }

    public TextField getQtyTf() {
        return qtyTf;
    }

    public Button getpOrder() {
        return pOrder;
    }

    public Button getcOrder() {
        return cOrder;
    }

    public List<CheckBox> getToppingsCbNm() {
        return toppingsCbNm;
    }

    public List<CheckBox> getToppingsCbM() {
        return toppingsCbM;
    }

}
