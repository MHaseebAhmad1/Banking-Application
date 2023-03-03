package com.UserInterface;

import com.Interfaces.BankInterface;
import com.Methods.Methods;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    BankInterface bank = new Methods();
        public void userInterface(){

            System.out.println(bank.getName());
            System.out.println("=====================");
            bank.addCustomer("Haseeb","43203-2962164-9");
            bank.addCustomer("Muneeb","43203-2867069-9");
            boolean condition1 = true;
            while(condition1){
                boolean condition2 = true;
                System.out.println("Enter your identity(Admin,User)\nTo quit write Quit");
                String person = scanner.nextLine();
                switch (person) {
                    case ("Quit"):
                        System.out.println("You have Quit");
                        condition1 = false;
                        break;
                    case ("Admin"):
                            System.out.println("Enter password");
                            String password = scanner.nextLine();
                            if (password.equals("Haseeb")) {
                                while (condition2) {

                                    System.out.println("Press -1 to change the user\nPress 0 to open a new account\nPress 1 to get Customers details");
                                    int num = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (num) {
                                        case -1:
                                            System.out.println("Choose the user again");
                                            condition2 = false;
                                            break;
                                        case 0:
                                            System.out.println("Enter name of the Customer");
                                            String name = scanner.nextLine();
                                            System.out.println("Enter CNIC of the Customer");
                                            String idNum = scanner.nextLine();
                                            bank.addCustomer(name, idNum);
                                            break;
                                        case 1:
                                            System.out.println(bank.getCustomers());
                                            System.out.println("=======================================================");
                                            break;

                                        default:
                                            System.out.println("You have pressed a wrong option");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Wrong password");
                            }
                        break;
                    case ("User"):
                        System.out.println("Press 0 to signUp\nPress 1 to login");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        switch (n){
                            case 0:
                                System.out.println("Enter your identification");
                                String idNum = scanner.nextLine();
                                System.out.println("Set password");
                                password = scanner.nextLine();
                                boolean signUp = bank.signUp(idNum,password);
                                if(!signUp){
                                    break;
                                }

                            case 1:
                                System.out.println("Enter your identification");
                                idNum = scanner.nextLine();
                                System.out.println("Enter password");
                                password = scanner.nextLine();
                               boolean condition = bank.login(idNum,password);
                                while (condition) {
                                    System.out.println("Press -1 to change the user\nPress 0 to check balance\nPress 1 to credit\nPress 2 to debit");
                                    int num = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (num) {
                                        case -1:
                                            System.out.println("Choose the user again");
                                            condition = false;
                                            break;
                                        case 0:
                                            bank.showBalance(idNum);
                                            System.out.println("============================");
                                            break;
                                        case 1:
                                            System.out.println("Enter amount to credit");
                                            double amount = scanner.nextDouble();
                                            bank.credit(idNum,amount);
                                            break;
                                        case 2:
                                            System.out.println("Enter amount to debit");
                                            amount = scanner.nextDouble();
                                            bank.debit(idNum,amount);
                                            break;

                                        default:
                                            System.out.println("You have entered a wrong option");
                                            break;
                                    }
                                }
                                break;

                            default:
                                System.out.println("You have entered a wrong option");
                                break;
                        }

                        break;
                    default:
                        System.out.println("Enter correct identity");
                        break;
                }
            }
        }
}
