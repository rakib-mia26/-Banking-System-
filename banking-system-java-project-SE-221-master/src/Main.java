import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a new Login object
        Login login = new Login();

        // Create a new JFrame
        JFrame frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a new JPanel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.add(panel);

        // Create a Register button
        JButton registerButton = new JButton("Register") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.decode("#1B9C85"));
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));
                super.paintComponent(g2d);
            }
        };
        registerButton.setForeground(Color.WHITE);
        registerButton.setOpaque(false);
        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setMargin(new Insets(10, 20, 10, 20));
    // Add an ActionListener to the registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter their information
                String name = JOptionPane.showInputDialog(frame, "Enter your name:");
                String user = JOptionPane.showInputDialog(frame, "Enter Username:");
                String pass = JOptionPane.showInputDialog(frame, "Enter Password:");
                // Register the user
                login.register(frame, name, user, pass);
            }
        });
    // Set the layout constraints for the registerButton
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
    // Add the registerButton to the panel with the specified layout constraints
        panel.add(registerButton, c);

    // Create a Login button
        JButton loginButton = new JButton("Login") {
            // Override the paintComponent method to customize the appearance of the button
            @Override
            protected void paintComponent(Graphics g) {
                // Create a Graphics2D object from the Graphics object
                Graphics2D g2d = (Graphics2D) g.create();
                // Set the rendering hint for anti-aliasing
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Set the color of the button to a custom color
                g2d.setColor(Color.decode("#1B9C85"));
                // Fill the button with a rounded rectangle shape
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));
                // Call the superclass's paintComponent method
                super.paintComponent(g2d);
            }
        };
    // Set various properties of the loginButton
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setMargin(new Insets(10, 20, 10, 20));
    // Add an ActionListener to the loginButton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter their username and password
                String user = JOptionPane.showInputDialog(frame, "Enter username:");
                String pass = JOptionPane.showInputDialog(frame, "Enter Password:");
                // Login the user
                login.login(frame, user, pass);
            }
        });
    // Set the layout constraints for the loginButton
        c.gridx = 1;
        c.gridy = 0;
    // Add the loginButton to the panel with the specified layout constraints
        panel.add(loginButton, c);

        // Create an Exit button
        JButton exitButton = new JButton("Exit") {
            // Override the paintComponent method to customize the appearance of the button
            @Override
            protected void paintComponent(Graphics g) {
                // Create a Graphics2D object from the Graphics object
                Graphics2D g2d = (Graphics2D) g.create();
                // Set the rendering hint for anti-aliasing
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Set the color of the button to a custom color
                g2d.setColor(Color.decode("#FF6347"));
                // Fill the button with a rounded rectangle shape
                g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));
                // Call the superclass's paintComponent method
                super.paintComponent(g2d);
            }
        };
    // Set various properties of the exitButton
        exitButton.setForeground(Color.WHITE);
        exitButton.setOpaque(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setMargin(new Insets(10, 20, 10, 20));
    // Add an ActionListener to the exitButton
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the program when the exitButton is clicked
                System.exit(0);
            }
        });
    // Set the layout constraints for the exitButton
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
    // Add the exitButton to the panel with the specified layout constraints
        panel.add(exitButton, c);

    // Make the frame visible
        frame.setVisible(true);
    }
}
