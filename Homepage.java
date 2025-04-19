import javax.swing.*;

public class Homepage extends javax.swing.JFrame {

    public Homepage() {
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Homepage");

        titleLabel = new JLabel("Welcome to the Homepage", JLabel.CENTER);
        greetingLabel = new JLabel("Hello, User!", JLabel.CENTER);
        viewProfileButton = new JButton("View Profile");
        settingsButton = new JButton("Settings");
        logoutButton = new JButton("Logout");

        logoutButton.addActionListener(evt -> logoutButtonActionPerformed());

        // Layout
        setLayout(null);
        titleLabel.setBounds(50, 20, 300, 30);
        greetingLabel.setBounds(50, 60, 300, 20);
        viewProfileButton.setBounds(125, 100, 150, 30);
        settingsButton.setBounds(125, 140, 150, 30);
        logoutButton.setBounds(125, 180, 150, 30);

        add(titleLabel);
        add(greetingLabel);
        add(viewProfileButton);
        add(settingsButton);
        add(logoutButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void logoutButtonActionPerformed() {
        this.dispose();
        new LoginForm().setVisible(true);
    }

    private JLabel titleLabel;
    private JLabel greetingLabel;
    private JButton viewProfileButton;
    private JButton settingsButton;
    private JButton logoutButton;
}
