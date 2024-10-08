package ca.seneca.workshop2.models;

public class Order {
    // Public attributes
    public Customer customer;
    public int MAX_SIZE = 100;
    public Pizza[] pizzas = new Pizza[MAX_SIZE];
    public int qty;




    // Default Constructor
    public Order(){

    }

    // addPizza method, creates pizza based on arguments
    public void addPizza(String sz, double price, String crust, String[] nm, String[] m){
        qty++;
        pizzas[qty] = new Pizza(sz, price, crust, nm, m);

    }


}
