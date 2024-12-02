import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class RegisterPane extends JPanel {
    private RegisterPage registerPage;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton cancelButton;

    public RegisterPane(RegisterPage regPage) {
        initialize();
        this.registerPage = regPage;
    }

    private void initialize() {
        this.usernameField = new JTextField(20);
        this.passwordField = new JPasswordField(20);
        this.confirmPasswordField = new JPasswordField(20);
        this.registerButton = new JButton("Register");
        this.cancelButton = new JButton("Cancel");

        usernameField.setText("Enter your username");
        usernameField.setForeground(Color.GRAY);
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Enter your username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Enter your username");
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });

        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("Enter your password");
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Enter your password")) {
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).isEmpty()) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText("Enter your password");
                }
            }
        });

        confirmPasswordField.setEchoChar((char) 0);
        confirmPasswordField.setForeground(Color.GRAY);
        confirmPasswordField.setText("Confirm your password");
        confirmPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(confirmPasswordField.getPassword()).equals("Confirm your password")) {
                    confirmPasswordField.setForeground(Color.BLACK);
                    confirmPasswordField.setText("");
                    confirmPasswordField.setEchoChar('*');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (new String(confirmPasswordField.getPassword()).isEmpty()) {
                    confirmPasswordField.setForeground(Color.GRAY);
                    confirmPasswordField.setEchoChar((char) 0);
                    confirmPasswordField.setText("Confirm your password");
                }
            }
        });

        registerButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerButtonClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
        });

        cancelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelButtonClicked();
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
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

        add(usernameField, gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.NONE;

        add(new JLabel("Password"), gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(passwordField, gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.NONE;

        add(new JLabel("Confirm password"), gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(confirmPasswordField, gBagConstraints);
        gBagConstraints.gridy++;
        gBagConstraints.fill = GridBagConstraints.NONE;

        add(registerButton, gBagConstraints);
        gBagConstraints.anchor = GridBagConstraints.EAST;
        add(cancelButton, gBagConstraints);
    }

    private void registerButtonClicked() {

    }

    private void cancelButtonClicked() {
        registerPage.setVisible(false);
        new LoginPage().setVisible(true);
        registerPage.dispose();
    }
}

public class RegisterPage extends JFrame {
    public RegisterPage() {
        initialize();
    }

    private void initialize() {
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        add(new RegisterPane(this));
        pack();
    }
}
