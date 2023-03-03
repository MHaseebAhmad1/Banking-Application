package com.Models;

public class Customer extends Person{
    private String password;
    private double balance;

    public Customer(String name, String idNum) {
        super(name, idNum);
        this.balance=0;
    }


    public void addBalance(double amount){
        this.balance+=amount;
    }
    public void withDrawBalance(double amount){
        this.balance-=amount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "\nName: "+ super.getName() +", ID: "+ super.getIdNum() +", Balance: "+this.balance;
    }
}
