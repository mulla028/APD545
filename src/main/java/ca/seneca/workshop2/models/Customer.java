package ca.seneca.workshop2.models;

public class Customer {

    // private attributes
    private String name;
    private String cell;

    // 2 - argument constructor
    public Customer(String name, String cell) {
        this.name = name;
        this.cell = cell;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
}
