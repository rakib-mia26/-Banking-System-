import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// UserInfo class
public class UserInfo {
    // ArrayList to store user balance information
    ArrayList<Integer> amount1 = new ArrayList<>();

    // Method to create a new account for a user
    void new_account(JFrame frame, String name, int serial) {
        // Display a welcome message
        JOptionPane.showMessageDialog(frame, "Welcome " + name);
        int size = amount1.size();
        // Check if the user has an existing balance
        if (serial >= size) {
            // Offer the user a free deposit
            int choice = JOptionPane.showConfirmDialog(frame, "You have 0 Balance. Would you like to get 100 tk Free deposit?", "Free Deposit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                // Add the free deposit to the user's balance
                amount1.add(100);
                JOptionPane.showMessageDialog(frame, "Your Balance Is 100 tk.");
                menu(frame, serial);
            } else {
                amount1.add(0);
                JOptionPane.showMessageDialog(frame, "You missed the 100 tk. Offer. Your Balance Is 0 tk.");
                menu(frame, serial);
            }
        } else {
            menu(frame, serial);
        }
    }

    // Method to display the menu options to the user
    void menu(JFrame frame, int serial) {
        while (true) {
            Object[] options = {"Deposit", "View Balance", "Withdraw", "Exit"};
            int choice = JOptionPane.showOptionDialog(frame, "Choose an option:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    deposit(frame, serial);
                    break;
                case 1:
                    view_balance(frame, serial);
                    break;
                case 2:
                    withdraw(frame, serial);
                    break;
                case 3:
                    return;
            }
        }
    }

    // Method to deposit money into the user's account
    void deposit(JFrame frame, int serial) {
        // Prompt the user to enter the amount to deposit
        String amountStr = JOptionPane.showInputDialog(frame, "Enter the amount to deposit:");
        int amount = Integer.parseInt(amountStr);
        // Display a message indicating successful deposit
        JOptionPane.showMessageDialog(frame, "Amount added " + amount);
        // Update the user's balance
        amount += amount1.get(serial);
        JOptionPane.showMessageDialog(frame, "Your current amount is " + amount);
        amount1.set(serial, amount);
    }

    // Method to view the user's current balance
    void view_balance(JFrame frame, int serial) {
        JOptionPane.showMessageDialog(frame, "Your Balance Is: " + amount1.get(serial));
    }

    // Method to withdraw money from the user's account
    void withdraw(JFrame frame, int serial) {
        // Display the user's current balance
        JOptionPane.showMessageDialog(frame, "Your Balance Is: " + amount1.get(serial));
        // Prompt the user to enter the amount to withdraw
        String amount2Str = JOptionPane.showInputDialog(frame, "Enter The amount You want to Withdraw:");
        int amount2 = Integer.parseInt(amount2Str);
        // Check if the user has enough money to withdraw

        if (amount1.get(serial) >= amount2) {
            // Display a message indicating successful withdrawal
            JOptionPane.showMessageDialog(frame, "Withdrawn Amount: " + amount2);
            // Update the user's balance
            amount2 = amount1.get(serial) - amount2;
            JOptionPane.showMessageDialog(frame, "Your new amount is " + amount2);
            amount1.set(serial, amount2);
        } else {
            JOptionPane.showMessageDialog(frame, "You Don't Have enough money to withdraw");
        }
    }
}
