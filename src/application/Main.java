package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // #1 - QUESTIONS

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        sc.nextLine();
        System.out.print("Initial balance: ");
        Double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();

        // #2 - INSTANTIATION OBJECT

        Account account = new Account(initialBalance, withdrawLimit);

        // #3 - WITHDRAW PROCESS

        System.out.println();
        System.out.print("Enter the amount for withdraw: ");
        Double amount = sc.nextDouble();
        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f", account.getBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }


        sc.close();
    }
}
