package dev.lpa;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions){
    public Customer(String name, double initialTransaction){
        this(name, new ArrayList<Double>(500));
        transactions.add(initialTransaction);
    }
}

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Bob", 1000.0);
        System.out.println(customer);

        Bank bank = new Bank("Banca Transilvania");
        bank.addNewCustomer("Josh", 500.0);
        System.out.println(bank);

        bank.addTransaction("Josh", 431.56);
        bank.addTransaction("Josh", -342.11);
        bank.printCustomerTransactions("Josh");
    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer getCustomer(String customerName){
        for (var customer : customers){
            if (customer.name().equalsIgnoreCase(customerName)){  //we can access the field name using name() thanks to customer being declared as record, otherwise we would have had to use a getter
                return customer;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    public void addNewCustomer(String customerName, double initialDeposit){
        if (getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New customer added, hello " + customer.name());
        }
    }

    public void addTransaction(String customerName, double transaction){
        Customer customer = getCustomer(customerName);
        if (customer != null){
            customer.transactions().add(transaction);
        }
    }

    public void printCustomerTransactions(String customerName){
        Customer customer = getCustomer(customerName);
        if (customer == null) return;

        System.out.println("Name: " + customer.name());
        System.out.println("Transactions: ");
        for (var transaction : customer.transactions()){
            System.out.printf("--> $%.2f (%s)%n",transaction, transaction < 0 ? "debit" : "credit");
        }
    }
}
