import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PermutationCalc extends JFrame implements ActionListener {
    private JTextField entryField, limitField;
    private JTextField calculatorDisplay;  // Reference to the calculator's display
    private JButton calculateButton;

    // Constructor updated to accept a JTextField (main calculator display)
    public PermutationCalc(JTextField calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay; // Store the reference to the calculator's display
        setTitle("Permutation Calculator");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        // Input for entry (total elements)
        inputPanel.add(new JLabel("Enter total elements (n):"));
        entryField = new JTextField(10);
        inputPanel.add(entryField);

        // Input for limit (selection size)
        inputPanel.add(new JLabel("Enter selection size (r):"));
        limitField = new JTextField(10);
        inputPanel.add(limitField);

        // Button for calculating permutation
        calculateButton = new JButton("Calculate Permutation");
        calculateButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // So it closes without exiting the whole program
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(entryField.getText());
            int r = Integer.parseInt(limitField.getText());

            // Set the result directly in the calculator's display
            calculatorDisplay.setText("Permutation: " + computePermutation(n, r));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int computePermutation(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= n - i;
        }
        return result;
    }
}
