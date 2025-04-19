import java.sql.*;
import javax.swing.*;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Login");

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(evt -> loginButtonActionPerformed());

        // Layout
        setLayout(null);
        usernameLabel.setBounds(50, 50, 80, 25);
        usernameField.setBounds(150, 50, 200, 25);
        passwordLabel.setBounds(50, 100, 80, 25);
        passwordField.setBounds(150, 100, 200, 25);
        loginButton.setBounds(150, 150, 100, 30);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loginButtonActionPerformed() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new Homepage().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
