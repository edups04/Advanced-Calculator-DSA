import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Calculator implements ActionListener
{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // Number Buttons
    JButton[] functionButtons = new JButton[34]; // Function Buttons
    JButton addButton, subButton, multiButton, divButton;
    JButton decimalButton, equalButton, openparenthesisButton, closeparenthesisButton, percentageButton, positivenegativeButton;
    JButton shiftButton, minmaxButton, absoluteButton, roundButton, delButton, clearButton;
    JButton yButton, xButton, summationButton, capitalpiButton, integralButton, modulusButton;
    JButton ceilButton, floorButton, lowercasepiButton, sinButton, cosButton, tanButton;
    JButton squarerootButton, permutationButton, combinationButton, factorialButton, customexponentButton, logarithmButton;
    JPanel panel;
    
    Font largeFont = new Font("Ink Free", Font.BOLD, 40);
    Font myFont = new Font("Ink Free", Font.BOLD, 20);
    double num1=0, num2=0, result=0;
    char operator;

    Calculator() 
    {
        frame = new JFrame("Advanced Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 999);
        frame.setLayout(null);
        frame.setVisible(true);
        
        textfield = new JTextField();
        textfield.setBounds(50, 30, 590, 89);
        textfield.setFont(largeFont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("÷");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        openparenthesisButton = new JButton("(");
        closeparenthesisButton = new JButton(")");
        percentageButton = new JButton("%");
        positivenegativeButton = new JButton("±");
        shiftButton = new JButton("SHIFT");
        minmaxButton = new JButton("MinMax");
        absoluteButton = new JButton("ABS");
        roundButton = new JButton("ROUND");
        delButton = new JButton("DEL");
        clearButton = new JButton("AC/ON");
        yButton = new JButton("y");
        xButton = new JButton("x");
        summationButton = new JButton("∑");
        capitalpiButton = new JButton("Π");
        integralButton = new JButton("∫");
        modulusButton = new JButton("|x|");
        ceilButton = new JButton("⌈ x ⌉");
        floorButton = new JButton("⌊ x ⌋");
        lowercasepiButton = new JButton("π");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        squarerootButton = new JButton("√");
        permutationButton = new JButton("nPr");
        combinationButton = new JButton("nCr");
        factorialButton = new JButton("!");
        customexponentButton = new JButton("xʸ");
        logarithmButton = new JButton("logₙy");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = openparenthesisButton;
        functionButtons[7] = closeparenthesisButton;
        functionButtons[8] = percentageButton;
        functionButtons[9] = positivenegativeButton;
        functionButtons[10] = shiftButton;
        functionButtons[11] = minmaxButton;
        functionButtons[12] = absoluteButton;
        functionButtons[13] = roundButton;
        functionButtons[14] = delButton;
        functionButtons[15] = clearButton;
        functionButtons[16] = yButton;
        functionButtons[17] = xButton;
        functionButtons[18] = summationButton;
        functionButtons[19] = capitalpiButton;
        functionButtons[20] = integralButton;
        functionButtons[21] = modulusButton;
        functionButtons[22] = ceilButton;
        functionButtons[23] = floorButton;
        functionButtons[24] = lowercasepiButton;
        functionButtons[25] = sinButton;
        functionButtons[26] = cosButton;
        functionButtons[27] = tanButton;
        functionButtons[28] = squarerootButton;
        functionButtons[29] = permutationButton;
        functionButtons[30] = combinationButton;
        functionButtons[31] = factorialButton;
        functionButtons[32] = customexponentButton;
        functionButtons[33] = logarithmButton;
        
        
    for(int i=0; i<34; i++){
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFont(myFont);
        functionButtons[i].setFocusable(false);
    }

    for(int i=0; i<10; i++){
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(myFont);
        numberButtons[i].setFocusable(false);
    }

        delButton.setBounds(410, 138, 110, 30);
        clearButton.setBounds(530, 138, 110, 30);
        shiftButton.setBounds(50, 138, 110, 30);
        minmaxButton.setBounds(170, 138, 110, 30);
        absoluteButton.setBounds(290, 138, 110, 30);
        roundButton.setBounds(50, 187, 110, 30);
        yButton.setBounds(170, 187, 110, 30);
        xButton.setBounds(290, 187, 110, 30);
        summationButton.setBounds(410, 187, 110, 30);
        capitalpiButton.setBounds(530, 187, 110, 30);
        integralButton.setBounds(50, 236, 110, 30);
        modulusButton.setBounds(170, 236, 110, 30);
        ceilButton.setBounds(290, 236, 110, 30);
        floorButton.setBounds(410, 236, 110, 30);
        lowercasepiButton.setBounds(530, 236, 110,30);
        sinButton.setBounds(50, 285, 110, 30);
        cosButton.setBounds(170, 285, 110, 30);
        tanButton.setBounds(290, 285, 110, 30);
        squarerootButton.setBounds(410, 285, 110, 30);
        permutationButton.setBounds(530, 285, 110, 30);
        combinationButton.setBounds(50, 334, 110, 30);
        factorialButton.setBounds(170, 334, 110, 30);
        customexponentButton.setBounds(290, 334, 110, 30);
        logarithmButton.setBounds(410, 334, 110, 30);
        

         panel = new JPanel();
         panel.setBounds (50, 395, 590, 550);
         panel.setLayout (new GridLayout(4, 4, 10, 10));
         //panel.setBackground(Color.GRAY);
         
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(openparenthesisButton);
        panel.add(closeparenthesisButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiButton);
        panel.add(divButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(positivenegativeButton);
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(percentageButton);
        panel.add(equalButton);
         
        
        frame.add(panel);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.add(shiftButton);
        frame.add(minmaxButton);
        frame.add(absoluteButton);
        frame.add(roundButton);
        frame.add(yButton);
        frame.add(xButton);
        frame.add(summationButton);
        frame.add(capitalpiButton);
        frame.add(integralButton);
        frame.add(modulusButton);
        frame.add(ceilButton);
        frame.add(floorButton);
        frame.add(lowercasepiButton);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(tanButton);
        frame.add(squarerootButton);
        frame.add(permutationButton);
        frame.add(combinationButton);
        frame.add(factorialButton);
        frame.add(customexponentButton);
        frame.add(logarithmButton);
        frame.setVisible(true);

    }
    public static void main(String[]args) 
    {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 10; i++) {
        if (e.getSource() == numberButtons[i]) {
            // Concatenate the number in the textfield
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
    }

    if (e.getSource() == decimalButton) {
        // Concatenate decimal point
        textfield.setText(textfield.getText().concat("."));
    }
    if (e.getSource() == addButton) {
        textfield.setText(textfield.getText().concat(" + "));
        operator = '+';
    }
    if (e.getSource() == subButton) {
        textfield.setText(textfield.getText().concat(" - "));
        operator = '-';
    }
    if (e.getSource() == multiButton) {
        textfield.setText(textfield.getText().concat(" * "));
        operator = '*';
    }
    if (e.getSource() == divButton) {
        textfield.setText(textfield.getText().concat(" ÷ "));
        operator = '÷';
    }

    // Evaluate expression when equal button is pressed
    if (e.getSource() == equalButton) {
        String expression = textfield.getText();
        try {
            // Split the expression and perform calculation
            result = evaluateExpression(expression);
            textfield.setText(String.valueOf(result));
        } catch (Exception ex) {
            textfield.setText("Error");
        }
    }

    if (e.getSource() == clearButton) {
        textfield.setText("");
    }
    if (e.getSource() == delButton) {
        String string = textfield.getText();
        textfield.setText("");
        for (int i = 0; i < string.length() - 1; i++) {
            textfield.setText(textfield.getText() + string.charAt(i));
        }
    }
    if (e.getSource() == positivenegativeButton) {
        double temp = Double.parseDouble(textfield.getText());
        temp *= -1;
        textfield.setText(String.valueOf(temp));
    }
}
// Function to evaluate the expression (this is a basic example)
    public double evaluateExpression(String expression) {
    // You can implement a more sophisticated expression parser
    String[] tokens = expression.split(" ");
    double num1 = Double.parseDouble(tokens[0]);
    char operator = tokens[1].charAt(0);
    double num2 = Double.parseDouble(tokens[2]);

    switch (operator) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
        case '÷':
            return num1 / num2;
        default:
            return 0;
    }
}
}

