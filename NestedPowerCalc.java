import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NestedPowerCalc {
    JFrame frame;
    JTextField baseField, exponentField, nestedExponentField;
    JButton calculateButton;
    JLabel resultLabel;

    public NestedPowerCalc() {
        frame = new JFrame("Nested Power Calculator");

        // Input for base (x)
        JLabel baseLabel = new JLabel("Enter base (x):");
        baseLabel.setBounds(20, 20, 150, 30);
        baseField = new JTextField();
        baseField.setBounds(150, 20, 150, 30);

        // Input for exponent (y)
        JLabel exponentLabel = new JLabel("Enter exponent (y):");
        exponentLabel.setBounds(20, 60, 150, 30);
        exponentField = new JTextField();
        exponentField.setBounds(150, 60, 150, 30);

        // Input for nested exponent (z)
        JLabel nestedExponentLabel = new JLabel("Enter nested exponent (z):");
        nestedExponentLabel.setBounds(20, 100, 150, 30);
        nestedExponentField = new JTextField();
        nestedExponentField.setBounds(150, 100, 150, 30);

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 150, 150, 30);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateNestedPower();
            }
        });

        // Result label
        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 200, 300, 30);

        // Adding components to the frame
        frame.add(baseLabel);
        frame.add(baseField);
        frame.add(exponentLabel);
        frame.add(exponentField);
        frame.add(nestedExponentLabel);
        frame.add(nestedExponentField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void calculateNestedPower() {
        try {
            double x = Double.parseDouble(baseField.getText());
            double y = Double.parseDouble(exponentField.getText());
            double z = Double.parseDouble(nestedExponentField.getText());

            // Calculate x^(y^z)
            double result = Math.pow(x, Math.pow(y, z));
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input, please enter numbers.");
        }
    }

    public static void main(String[] args) {
        new NestedPowerCalc();
    }
}
