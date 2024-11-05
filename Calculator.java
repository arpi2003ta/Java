import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField input1, input2, result;
    private JButton addButton, subButton, mulButton, divButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Creating components
        input1 = new JTextField();
        input2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        // Adding components to the frame
        add(new JLabel("Enter Number 1:"));
        add(input1);
        add(new JLabel("Enter Number 2:"));
        add(input2);
        add(new JLabel("Result:"));
        add(result);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        // Adding action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            if (e.getSource() == addButton) {
                res = num1 + num2;
            } else if (e.getSource() == subButton) {
                res = num1 - num2;
            } else if (e.getSource() == mulButton) {
                res = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                res = num1 / num2;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
