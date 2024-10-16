import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoubleSummationCalc extends JFrame {
    private JTextField aField, bField, cField, dField;
    private JTextArea resultArea;

    public DoubleSummationCalc() {
        setTitle("Double Summation Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input fields for a, b, c, and d
        aField = new JTextField(5);
        bField = new JTextField(5);
        cField = new JTextField(5);
        dField = new JTextField(5);

        // Labels
        add(new JLabel("a:"));
        add(aField);
        add(new JLabel("b:"));
        add(bField);
        add(new JLabel("c:"));
        add(cField);
        add(new JLabel("d:"));
        add(dField);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        // Result area
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // Action listener for calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSummation();
            }
        });

        setVisible(true);
    }

    private void calculateSummation() {
        // Get inputs
        int a = Integer.parseInt(aField.getText());
        int b = Integer.parseInt(bField.getText());
        int c = Integer.parseInt(cField.getText());
        int d = Integer.parseInt(dField.getText());

        // Calculate double summations
        int result1 = 0, result2 = 0, result3 = 0;

        // ∑∑ x + y
        for (int i = a; i <= b; i++) {
            for (int j = c; j <= d; j++) {
                result1 += (i + j);
            }
        }

        // ∑∑ x * y
        for (int i = a; i <= b; i++) {
            for (int j = c; j <= d; j++) {
                result2 += (i * j);
            }
        }

        // ∑∑ x * y (a=1, b=2, c=1, d=2)
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                result3 += (i * j);
            }
        }

        // Display results
        resultArea.setText("∑∑ x + y: " + result1 + "\n");
        resultArea.append("∑∑ x * y: " + result2 + "\n");
        resultArea.append("∑∑ x * y (a=1, b=2, c=1, d=2): " + result3);
    }
}
