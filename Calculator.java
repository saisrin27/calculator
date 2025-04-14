import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // components
    JTextField textField;
    double num1, num2, result;
    char operator;

    Calculator() {
        setTitle("Calculator");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // input field
        textField = new JTextField();
        textField.setBounds(30, 40, 280, 40);
        textField.setEditable(false);
        add(textField);

        // buttons
        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+",
            "C"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, y, 60, 40);
            button.addActionListener(this);
            add(button);
            x += 70;

            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 50;
            }
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if ((input.charAt(0) >= '0' && input.charAt(0) <= '9') || input.equals(".")) {
            textField.setText(textField.getText() + input);
        } else if (input.equals("C")) {
            textField.setText("");
            num1 = num2 = result = 0;
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num2 != 0 ? num1 / num2 : 0; break;
            }

            textField.setText("" + result);
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
