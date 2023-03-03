package com.Interfaces;

import com.Models.Customer;

import java.util.ArrayList;

public interface BankInterface {
    void addCustomer(String name,String idNum);
    void credit(String idNum,double amount);
    void debit(String idNum,double amount);
    void showBalance(String idNum);
    ArrayList<Customer> getCustomers();
    String getName();
    boolean signUp(String idNum,String password);
    boolean login(String idNum,String password);
}
