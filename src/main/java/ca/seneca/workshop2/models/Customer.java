package ca.seneca.workshop2.models;

public class Customer {

    private String name;
    private String cell;

    public Customer(String name, String cell) {
        this.name = name;
        this.cell = cell;
    }

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
