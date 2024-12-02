import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorPane extends JPanel {
    private CalculatorFrame calcFrame;
    private JButton[] buttons;
    private JButton clearButton;
    private JTextField displayField;

    private boolean equalsPressed = false;
    private boolean operationPressed = false;
    private char operation = '\0';
    private String operand = "";

    public CalculatorPane(CalculatorFrame calc) {
        calcFrame = calc;
        initialize();
    }

    private void initialize() {
        String[] buttonSymbols = {"7", "8", "9", "/",
                                  "4", "5", "6", "*",
                                  "1", "2", "3", "-",
                                  ".", "0", "=", "+"
                                };
        displayField = new JTextField();
        setLayout(new GridBagLayout());
        GridBagConstraints gBagConstraints = new GridBagConstraints();

        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        gBagConstraints.gridx = 0;
        gBagConstraints.gridy = 0;
        gBagConstraints.insets = new Insets(5, 5, 5, 5);
        gBagConstraints.gridwidth = 3;
        gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(displayField, gBagConstraints);

        gBagConstraints.gridwidth = 1;
        gBagConstraints.gridx = 3;
        gBagConstraints.fill = GridBagConstraints.NONE;

        clearButton = new JButton("C");
        add(clearButton, gBagConstraints);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAction(e.getActionCommand());
            }
        });
        gBagConstraints.gridy++;

        buttons = new JButton[buttonSymbols.length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonSymbols[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAction(e.getActionCommand());
                }
            });

            if (i % 4 == 0) {
                gBagConstraints.gridx = 0;
                gBagConstraints.gridy++;
            }
            add(buttons[i], gBagConstraints);
            gBagConstraints.gridx++;
        }
    }

    private void handleAction(String str) {
        char action = str.charAt(0);

        switch (action) {
            case 'C':
                if (!displayField.getText().isEmpty()) {
                    displayField.setText("");
                }

                operationPressed = false;
                operand = "";
                operation = '\0';
                break;
            case '.':
                if (displayField.getText().isEmpty()) {
                    displayField.setText("0.");
                } else {
                    if (!displayField.getText().contains(".")) {
                        displayField.setText(displayField.getText().concat("."));
                    }
                }
                break;
            case '+':
            case '-':
            case '/':
            case '*':
                if (!operationPressed && !displayField.getText().isEmpty() && operation == '\0') {
                    operationPressed = true;
                    operand = displayField.getText();
                } else {
                    if (!operationPressed && operation != '\0' && !displayField.getText().isEmpty()) {
                        displayField.setText(operand = String.valueOf(eval(operation, operand, displayField.getText())));
                        operationPressed = true;
                    }
                }

                operation = action;
                break;
            case '=':
                if (!operationPressed && operation != '\0' && !displayField.getText().isEmpty()) {
                    displayField.setText(String.valueOf(eval(operation, operand, displayField.getText())));
                    operation = '\0';
                    equalsPressed = true;
                }
                break;
            default:
                if (operationPressed) {
                    displayField.setText(Character.toString(action));
                    operationPressed = false;
                } else if (equalsPressed) {
                    displayField.setText(Character.toString(action));
                    equalsPressed = false;
                } else {
                    displayField.setText(displayField.getText().concat(Character.toString(action)));
                }
                break;
        }
    }

    private double eval(char operation, String str1, String str2) {
        double num1, num2;

        num1 = Double.parseDouble(str1);
        num2 = Double.parseDouble(str2);

        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num1 == 0.0 || num2 == 0.0) {
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        initialize();
    }

    private void initialize() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new CalculatorPane(this));
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {
        new CalculatorFrame().setVisible(true);
    }
}
