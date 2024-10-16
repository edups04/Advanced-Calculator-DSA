import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class PermutationCalc extends JFrame implements ActionListener {
    private JTextField wordField;
    private JTextField nField; // For total elements (n)
    private JTextField rField; // For selection size (r)
    private JTextField calculatorDisplay;
    private JButton calculateButton;
    private JComboBox<String> optionComboBox;

    public PermutationCalc(JTextField calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay;
        setTitle("Permutation Calculator");

        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Word input
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Enter a word:"), gbc);

        gbc.gridx = 1;
        wordField = new JTextField(10);
        inputPanel.add(wordField, gbc);

        // Total elements input
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Enter n (total elements):"), gbc);

        gbc.gridx = 1;
        nField = new JTextField(10);
        inputPanel.add(nField, gbc);

        // Selection size input
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Enter r (selection size):"), gbc);

        gbc.gridx = 1;
        rField = new JTextField(10);
        inputPanel.add(rField, gbc);

        // Combo box for selection of calculation type
        String[] options = {
            "Word Permutations",
            "nPr (Permutations without repetition)",
            "n^r (Permutations with repetition)",
            "Circular Permutations"
        };
        optionComboBox = new JComboBox<>(options);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        inputPanel.add(optionComboBox, gbc);

        JPanel buttonPanel = new JPanel();
        calculateButton = new JButton("Calculate Permutation");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String option = (String) optionComboBox.getSelectedItem();
        String word = wordField.getText().trim();
        String nText = nField.getText().trim();
        String rText = rField.getText().trim();
        long result = 0;

        try {
            int n = word.isEmpty() ? Integer.parseInt(nText) : word.length();
            int r = rText.isEmpty() ? 0 : Integer.parseInt(rText);

            switch (option) {
                case "Word Permutations":
                    result = computePermutationWithoutRepetition(word);
                    break;
                case "nPr (Permutations without repetition)":
                    result = computeNPr(n, r);
                    break;
                case "n^r (Permutations with repetition)":
                    result = computePermutationWithRepetition(n, r);
                    break;
                case "Circular Permutations":
                    result = computeCircularPermutations(n);
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid integers or a valid word.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        calculatorDisplay.setText("Permutation: " + result);
    }

    private long computePermutationWithRepetition(int n, int r) {
        // Calculate permutations with repetition: n^r
        return (long) Math.pow(n, r);
    }

    private long computePermutationWithoutRepetition(String word) {
        // Count occurrences of each character
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        long totalPermutations = factorial(word.length());

        // Divide by the factorial of the counts of each character
        for (int count : charCountMap.values()) {
            totalPermutations /= factorial(count);
        }

        return totalPermutations;
    }

    private long computeNPr(int n, int r) {
        // nPr = n! / (n - r)!
        return factorial(n) / factorial(n - r);
    }

    private long computeCircularPermutations(int n) {
        // Circular permutations = (n - 1)!
        return factorial(n - 1);
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
