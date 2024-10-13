import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.Stack;


public class Calculator implements ActionListener
{                                           
    double base = 0; 
    double exponent = 0; 
    boolean isExponentMode = false;
    
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

    
    Font largeFont = new Font("SansSerif", Font.PLAIN, 40);
    Font myFont = new Font("SansSerif", Font.PLAIN, 20);
    double num1=0, num2=0, result=0;
    char operator;
    boolean squareRootFlag = false;
  
    Calculator() 
    {
        
        frame = new JFrame("Advanced/Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 999);
        frame.getContentPane().setBackground(Color.decode("#1c1c1c"));
        frame.setLayout(null);
        frame.setVisible(true);
        
        textfield = new JTextField();
        textfield.setBounds(50, 30, 590, 89);
        textfield.setFont(largeFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.decode("#1c1c1c"));
        textfield.setForeground(Color.WHITE);
        textfield.setBorder(BorderFactory.createEmptyBorder());
                            
        addButton = new Design("+", 30);
        subButton = new Design("-", 30);
        multiButton = new Design("×", 30);
        divButton = new Design("÷", 30);
        decimalButton = new Design(".", 30);
        equalButton = new Design("=", 30);
        openparenthesisButton = new Design("(", 30);
        closeparenthesisButton = new Design(")", 30);
        percentageButton = new Design("%", 30); // modulus
        positivenegativeButton = new Design("±", 30);
        shiftButton = new Design ("SHIFT", 15);
        minmaxButton = new Design("MinMax", 15);
        absoluteButton = new Design("ABS", 15);
        roundButton = new Design("ROUND", 15);
        delButton = new Design("DEL", 15);
        clearButton = new Design("AC/ON", 15);
        yButton = new Design("y", 15);
        xButton = new Design("x", 15);
        summationButton = new Design("∑", 15);
        capitalpiButton = new Design("Π", 15);
        integralButton = new Design("∫", 15);
        modulusButton = new Design("|x|", 15);
        ceilButton = new Design("⌈CEIL⌉", 15);
        floorButton = new Design("⌊ FLR ⌋", 15);
        lowercasepiButton = new Design("π", 15);
        sinButton = new Design("sin", 15);
        cosButton = new Design("cos", 15);
        tanButton = new Design("tan", 15);
        squarerootButton = new Design("√", 15);
        permutationButton = new Design("nPr", 15);
        combinationButton = new Design("nCr", 15);
        factorialButton = new Design("!", 15);
        customexponentButton = new Design("xʸ", 15);
        logarithmButton = new Design("logₙy", 15);
        
        addButton.setBackground(Color.decode("#ff9500"));
        subButton.setBackground(Color.decode("#ff9500"));
        multiButton.setBackground(Color.decode("#ff9500"));
        divButton.setBackground(Color.decode("#ff9500"));
        percentageButton.setBackground(Color.decode("#ff9500"));
        equalButton.setBackground(Color.decode("#ff9500"));
        decimalButton.setBackground(Color.decode("#ff9500"));
        positivenegativeButton.setBackground(Color.decode("#ff9500"));
        closeparenthesisButton.setBackground(Color.decode("#ff9500"));
        openparenthesisButton.setBackground(Color.decode("#ff9500"));
        shiftButton.setBackground(Color.decode("#ff9500"));
        minmaxButton.setBackground(Color.decode("#505050"));
        absoluteButton.setBackground(Color.decode("#505050"));
        roundButton.setBackground(Color.decode("#505050"));
        delButton.setBackground(Color.decode("#ff9500"));
        clearButton.setBackground(Color.decode("#ff9500"));
        yButton.setBackground(Color.decode("#505050"));
        xButton.setBackground(Color.decode("#505050"));
        summationButton.setBackground(Color.decode("#505050"));
        capitalpiButton.setBackground(Color.decode("#505050"));
        integralButton.setBackground(Color.decode("#505050"));
        modulusButton.setBackground(Color.decode("#505050"));
        ceilButton.setBackground(Color.decode("#505050"));
        floorButton.setBackground(Color.decode("#505050"));
        lowercasepiButton.setBackground(Color.decode("#505050"));
        sinButton.setBackground(Color.decode("#505050"));
        cosButton.setBackground(Color.decode("#505050"));
        tanButton.setBackground(Color.decode("#505050"));
        squarerootButton.setBackground(Color.decode("#505050"));
        permutationButton.setBackground(Color.decode("#505050"));
        combinationButton.setBackground(Color.decode("#505050"));
        factorialButton.setBackground(Color.decode("#505050"));
        customexponentButton.setBackground(Color.decode("#505050"));
        logarithmButton.setBackground(Color.decode("#505050"));
        
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
        
        
    for(int i=0; i<34; i++)
    {
        functionButtons[i].addActionListener(this);
        functionButtons[i].setForeground(Color.WHITE);
        functionButtons[i].setFont(myFont);
        functionButtons[i].setFocusable(false);
    }
            
        openparenthesisButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        closeparenthesisButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        multiButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        subButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        divButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        addButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        equalButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        positivenegativeButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        percentageButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        decimalButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        
    for(int i=0; i<10; i++)
    {
        numberButtons[i] = new Design(String.valueOf(i), 30);
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(largeFont);
        numberButtons[i].setBackground(Color.decode("#d4d4d2"));
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
        panel.setBackground(Color.decode("#1c1c1c"));
         
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
        frame.setBackground(Color.decode("#1c1c1c"));
        frame.setVisible(true);    
    }
 
    public static void main(String[]args) 
    {
        Calculator calc = new Calculator();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    for (int i = 0; i < 10; i++) 
    {
        if (e.getSource() == numberButtons[i]) 
        {
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
    }

    if (e.getSource() == decimalButton) 
    { //Decimal Button
        textfield.setText(textfield.getText().concat("."));
    }
    
    if (e.getSource() == addButton) 
    { //Addition Button
        textfield.setText(textfield.getText().concat(" + "));
        operator = '+';
    }
    
    if (e.getSource() == subButton) 
    { //Substraction Button
        textfield.setText(textfield.getText().concat(" - "));
        operator = '-';
    }
    
    if (e.getSource() == multiButton) 
    { //Multiplication Button
        textfield.setText(textfield.getText().concat(" × "));
        operator = '*';
    }
    
    if (e.getSource() == divButton) 
    { //Division Button
        textfield.setText(textfield.getText().concat(" ÷ "));
        operator = '/';
    }
    
    if (e.getSource() == equalButton) 
    { //Equal Button
        String expression = textfield.getText();
        
        if (expression.startsWith("√")) 
        { 
            num1 = Double.parseDouble(expression.substring(1));
            result = Math.sqrt(num1);
            textfield.setText(String.valueOf(result)); 
        } 
        else if (isExponentMode) 
        {
            // Handle exponent mode
            double exponent = Double.parseDouble(textfield.getText());
            result = Math.pow(base, exponent);
            textfield.setText(base + " ^ " + exponent + " = " + result); 
            isExponentMode = false; 
        } 
        else 
        {
            try 
            {
                result = evaluateExpression(expression);
                textfield.setText(String.valueOf(result)); 
            } 
            catch (Exception ex) 
            {
                textfield.setText("Error");
            }
        }
    }
    
    if (e.getSource() == clearButton) 
    { //Clear Button
        textfield.setText("");
    }
    
    if (e.getSource() == delButton) 
    { //Delete Button
        String string = textfield.getText();
        textfield.setText("");
        for (int i = 0; i < string.length() - 1; i++) 
        {
            textfield.setText(textfield.getText() + string.charAt(i));
        }
    }
    
    if (e.getSource() == absoluteButton) 
    { //Abosulute Button
        double absolute = Double.parseDouble(textfield.getText());
        absolute = Math.abs(absolute);
        textfield.setText(String.valueOf(absolute));
    }
    
    if (e.getSource() == floorButton) 
    { //Floor Button
        double floor = Double.parseDouble(textfield.getText());
        floor = Math.floor(floor);
        textfield.setText(String.valueOf(floor));
    }
    
    if (e.getSource() == ceilButton) 
    { //Ceiling Button
        double ceil = Double.parseDouble(textfield.getText());
        ceil = Math.ceil(ceil);
        textfield.setText(String.valueOf(ceil));
    }
     
    if (e.getSource() == roundButton) 
    { //Round off Button
        double roundOff = Double.parseDouble(textfield.getText());
        roundOff = Math.round(roundOff);
        textfield.setText(String.valueOf(roundOff));
    }
    
    if (e.getSource() == percentageButton) 
    { // Modulus Button
        textfield.setText(textfield.getText().concat(" % "));
        operator = '%';
    }
 
    if (e.getSource() == positivenegativeButton) 
    { //Positive Negative Button
        double temp = Double.parseDouble(textfield.getText());
        temp *= -1;
        textfield.setText(String.valueOf(temp));
    }
        
    if (e.getSource() == minmaxButton) 
    { //Min Max Button
        new MinMaxIO();
    }

    if (e.getSource() == integralButton) 
    { //Calculus Functions
        new PolynomialCalc();
    }
    
    if (e.getSource() == factorialButton) 
    { //Factorial Button
        String input = textfield.getText();
        try 
        {
            double num = Double.parseDouble(input);
            result = factorial(num);
            textfield.setText(String.valueOf(result));
        } 
        catch (NumberFormatException ex) 
        {
            textfield.setText("Invalid input");
        }
    }
    
    if (e.getSource() == sinButton) 
    { // Sine Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.sin(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }

    if (e.getSource() == cosButton) 
    { // Cosine Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.cos(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }

    if (e.getSource() == tanButton) 
    { // Tangent Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.tan(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }
    
    if (e.getSource() == squarerootButton) 
    { //Square Root Button
        textfield.setText(textfield.getText().concat("√"));
    }
    
    if (e.getSource() == customexponentButton) 
    { //Custom Exponent Button
        isExponentMode = true; 
        base = Double.parseDouble(textfield.getText()); 
        textfield.setText(""); 
    }
}
    
    public double evaluateExpression(String expression) 
    {
        String[] tokens = expression.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

    for (String token : tokens) 
    {
        if (token.matches("\\d+(\\.\\d+)?")) 
        {
            values.push(Double.parseDouble(token));
        } 
        else if (token.length() == 1 && "+-×÷%".contains(token)) 
        {
            while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token.charAt(0))) 
            {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }
            operators.push(token.charAt(0));
        }
    }
    
    while (!operators.isEmpty()) 
    {
        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
    }
    return values.pop();
}

    private int precedence(char operator) 
    {
        switch (operator) 
        {
            case '+':
            case '-':
                return 1;
            case '×':
            case '÷':
            case '%':
                return 2;
            default:
                return 0;
        }
    }
    
    private double applyOperator(char operator, double b, double a) 
    {
        switch (operator) 
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '×':
                return a * b;
            case '÷':
                if (b == 0) 
                {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
            case '%':
                return a % b;
            default:
                return 0;
        }
    }
        
    private static double factorial(double num) 
    {
        if (num < 0) 
        {
            return 0; 
        }
        double result = 1;
        for (int i = 2; i <= num; i++) 
        {
            result *= i;
        }
        return result;
    }

}

