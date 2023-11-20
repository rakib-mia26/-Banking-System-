import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Login class extends UserInfo class
public class Login extends UserInfo {
    // ArrayLists to store user information
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();

    // Method to register a new user
    void register(JFrame frame, String name1, String user, String pass) {
        // Add user information to the ArrayLists
        name.add(name1);
        username.add(user);
        password.add(pass);
        // Display a message indicating successful registration
        JOptionPane.showMessageDialog(frame, "Registration Successful");
    }

    // Method to login an existing user
    void login(JFrame frame, String user, String pass) {
        // Check if the entered username exists
        int ind1 = username.indexOf(user);
        int ind2 = password.indexOf(pass);
        if (ind1 != -1) {
            // Check if the entered password matches the username
            if (ind1 == ind2) {
                new_account(frame, name.get(ind1), ind1);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Password");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Username");
        }
    }
}
