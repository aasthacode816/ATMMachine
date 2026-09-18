import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUICalculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = '\0';

    public GUICalculator() {
        // Frame setup
        setTitle("Java GUI Calculator");
        setSize(320, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Display field setup
        displayField = new JTextField("0");
        displayField.setFont(new Font("Arial", Font.BOLD, 28));
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setBackground(Color.WHITE);
        displayField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(displayField, BorderLayout.NORTH);

        // Buttons grid setup
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {
            "C", "±", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", ""
        };

        for (String label : buttonLabels) {
            if (label.isEmpty()) {
                panel.add(new JLabel()); // Spacer for empty cell
                continue;
            }
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setFocusable(false);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle numeric inputs and decimal
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (displayField.getText().equals("0") && !command.equals(".")) {
                displayField.setText(command);
            } else {
                // Prevent multiple decimals in a single number
                if (command.equals(".") && displayField.getText().contains(".")) {
                    return;
                }
                displayField.setText(displayField.getText() + command);
            }
        } 
        // Handle Clear button
        else if (command.equals("C")) {
            displayField.setText("0");
            num1 = num2 = result = 0;
            operator = '\0';
        } 
        // Handle Sign toggle (±)
        else if (command.equals("±")) {
            double value = Double.parseDouble(displayField.getText());
            value = value * -1;
            displayField.setText(formatResult(value));
        } 
        // Handle Percentage (%)
        else if (command.equals("%")) {
            double value = Double.parseDouble(displayField.getText());
            value = value / 100;
            displayField.setText(formatResult(value));
        } 
        // Handle equals (=)
        else if (command.equals("=")) {
            if (operator != '\0') {
                num2 = Double.parseDouble(displayField.getText());
                calculate();
                displayField.setText(formatResult(result));
                operator = '\0';
            }
        } 
        // Handle Operators (+, -, *, /)
        else {
            num1 = Double.parseDouble(displayField.getText());
            operator = command.charAt(0);
            displayField.setText("0");
        }
    }

    private void calculate() {
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    result = 0;
                } else {
                    result = num1 / num2;
                }
                break;
        }
    }

    // Strips trailing .0 for whole numbers
    private String formatResult(double val) {
        if (val == (long) val) {
            return String.format("%d", (long) val);
        } else {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUICalculator().setVisible(true);
        });
    }
}