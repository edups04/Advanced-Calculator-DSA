import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MinMaxIO extends JFrame {
    private JTextField inputField;
    private JLabel output;

    public MinMaxIO() {
        setTitle("MinMax Calculator");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        // Label for the input field
        JLabel inputLabel = new JLabel("Enter Numbers (comma separated):");
        inputLabel.setBounds(10, 10, 250, 25);
        add(inputLabel);

        // TextField for user input
        inputField = new JTextField();
        inputField.setBounds(10, 40, 300, 25);
        add(inputField);

        // Label to display De result
        output = new JLabel("Result: ");
        output.setBounds(10, 130, 300, 25);
        add(output);

        // Button to find De Min
        JButton minButton = new JButton("Find Min");
        minButton.setBounds(10, 80, 150, 25);
        add(minButton);

        // Button to find De Max
        JButton maxButton = new JButton("Find Max");
        maxButton.setBounds(170, 80, 150, 25);
        add(maxButton);

        // ActionListener for De Min button
        minButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] numbers = parseInputNumbers();
                    int min = Arrays.stream(numbers).min().getAsInt();
                    output.setText("Result: Min is " + min);
                } catch (NumberFormatException ex) {
                    output.setText("Please enter valid whole numbers.");
                } catch (Exception ex) {
                    output.setText("An error occurred: " + ex.getMessage());
                }
            }
        });

        // ActionListener for De Max button
        maxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] numbers = parseInputNumbers();
                    int max = Arrays.stream(numbers).max().getAsInt();
                    output.setText("Result: Max is " + max);
                } catch (NumberFormatException ex) {
                    output.setText("Please enter valid whole numbers.");
                } catch (Exception ex) {
                    output.setText("An error occurred: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    private int[] parseInputNumbers() throws NumberFormatException {
        String input = inputField.getText();
        String[] numberStrings = input.split(","); // Split input by commasss
        return Arrays.stream(numberStrings)
                     .map(String::trim)             
                     .mapToInt(Integer::parseInt)   
                     .toArray();
    }

    public static void main(String[] args) {
        new MinMaxIO();
    }
}
