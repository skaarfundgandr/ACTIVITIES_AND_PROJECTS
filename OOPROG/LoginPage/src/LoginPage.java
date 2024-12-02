import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginPane extends JPanel {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginPage loginPage;

    public LoginPane(LoginPage login) {
        initialize();
        loginPage = login;
    }

    private void initialize() {
        this.userField = new JTextField(20);
        this.passwordField = new JPasswordField(20);
        this.loginButton = new JButton("Login");

        userField.setText("Enter your username");
        userField.setForeground(Color.GRAY);
        userField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userField.getText().equals("Enter your username")) {
                    userField.setText("");
                    userField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (userField.getText().isEmpty()) {
                    userField.setText("Enter your username");
                    userField.setForeground(Color.GRAY);
                }
            }
        });

        passwordField.setEchoChar((char) 0);
        passwordField.setText("Enter your password");
        passwordField.setForeground(Color.GRAY);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Enter your password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                    passwordField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).isEmpty()) {
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText("Enter your password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonClicked();
            }
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gBagConstraints = new GridBagConstraints();
        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 0;
        gBagConstraints.insets = new Insets(2, 2, 2, 2);
        gBagConstraints.anchor = GridBagConstraints.WEST;

        add(new JLabel("Username"), gBagConstraints);
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gBagConstraints.gridy++;

        add(userField, gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.NONE;

        add(new JLabel("Password"), gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(passwordField, gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.NONE;

        add(loginButton, gBagConstraints);
    }

    private void loginButtonClicked() {
        if (userField.getText().equals("root") && new String(passwordField.getPassword()).equals("root")) {
            JOptionPane.showMessageDialog(this, "Login successful");
            new CalculatorFrame().setVisible(true);
            loginPage.setVisible(false);
            loginPage.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "User not found");
        }
    }
}

public class LoginPage extends JFrame {
    public LoginPage() {
        initialize();
    }

    private void initialize() {
        setTitle("Login");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LoginPane(this));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
}