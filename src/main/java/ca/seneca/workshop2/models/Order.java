package ca.seneca.workshop2.models;

public class Order {
    public Customer customer;
    public int MAX_SIZE = 100;
    public Pizza[] pizzas = new Pizza[MAX_SIZE];
    public int qty;




    public Order(){

    }

    public Order(Customer customer, Pizza[] pizzas, int quantity) {
        this.customer = customer;
        this.pizzas = this.pizzas;
        this.qty = quantity;
    }

    public void addPizza(String sz, double price, String crust, String[] nm, String[] m){
        qty++;
        pizzas[qty] = new Pizza(sz, price, crust, nm, m);

    }


}
