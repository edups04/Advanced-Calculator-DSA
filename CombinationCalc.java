import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinationCalc extends JFrame implements ActionListener {
    private JTextField entryField, limitField;
    private JTextField calculatorDisplay;
    private JButton calculateButton;

    public CombinationCalc(JTextField calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay;
        setTitle("Combination Calculator");

        setLayout(new BorderLayout(10, 10));  

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Enter total elements (n):"), gbc);

        gbc.gridx = 1;
        entryField = new JTextField(10);
        inputPanel.add(entryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Enter selection size (r):"), gbc);

        gbc.gridx = 1;
        limitField = new JTextField(10);
        inputPanel.add(limitField, gbc);

        JPanel buttonPanel = new JPanel();
        calculateButton = new JButton("Calculate Combination");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(300, 150);
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(entryField.getText());
            int r = Integer.parseInt(limitField.getText());

            calculatorDisplay.setText("Combination: " + computeCombination(n, r));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int computeCombination(int n, int r) {
        return computePermutation(n, r) / factorial(r);
    }

    private int computePermutation(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= n - i;
        }
        return result;
    }

    private int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        new CombinationCalc(null);  
    }
}
