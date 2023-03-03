package com.Methods;

import com.Models.Bank;
import com.Models.Customer;
import com.Interfaces.BankInterface;

import java.util.ArrayList;

public class Methods implements BankInterface {
    Bank bank = new Bank("Bank Al Habib");

    public void addCustomer(String name,String idNum){
        if(findCustomer(idNum)==null){
            bank.getCustomers().add(new Customer(name,idNum));
            System.out.println("Account created Successfully");
            return;
        }
        System.out.println("Customer has already an account");
    }
    public void credit(String idNum,double amount){
        Customer tempCustomer = findCustomer(idNum);
        if(tempCustomer!=null){
            tempCustomer.addBalance(amount);
            System.out.println("Amount added successfully");
            return;
        }
        System.out.println("Customer does not have account");
    }
    public void debit(String idNum,double amount){
        Customer tempCustomer = findCustomer(idNum);
        if(tempCustomer!=null){
            if(amount<=tempCustomer.getBalance()){
                tempCustomer.withDrawBalance(amount);
                System.out.println("Amount withDrawn successfully");
            }
            else {
                System.out.println("You have not sufficient balance\nYour balance is: "+tempCustomer.getBalance());
            }

            return;
        }
        System.out.println("Customer does not have account");
    }
    public void showBalance(String idNum){
        Customer tempCustomer = findCustomer(idNum);
        if(tempCustomer!=null){
            System.out.println("Your balance is: "+tempCustomer.getBalance());
            return;
        }
        System.out.println("Customer does not have account");
    }
    public boolean signUp(String idNum,String password){
        Customer tempCustomer = findCustomer(idNum);
        if(tempCustomer!=null){
            if(tempCustomer.getPassword()==null){
                tempCustomer.setPassword(password);
                System.out.println("You have set your password, Now login");
            }
            else {
                System.out.println("Your password is already set\nPlease login");
            }

            return true;
        }
        System.out.println("Customer does not have account");
        return false;
    }
    public boolean login(String idNum,String password){
        Customer tempCustomer = findCustomer(idNum);
        if(tempCustomer!=null) {
            if (tempCustomer.getPassword() != null) {
                if(tempCustomer.getPassword().equals(password)){
                    return true;
                }
                else{
                    System.out.println("Wrong password");
                }
            }
            else {
                System.out.println("Please sign up first");
            }
        }
        else {
        System.out.println("Account does not exist");}
        return false;
    }
    private Customer findCustomer(String idNum){
        for(Customer customer: bank.getCustomers()){
            if(customer.getIdNum().equals(idNum)){
                return customer;
            }
        }
        return null;
    }
    public String getName() {
        return bank.getName();
    }

    public ArrayList<Customer> getCustomers() {
        return bank.getCustomers();
    }

}
