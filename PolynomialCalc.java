import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * This section contains the Calculus functions for the calculator application.
 * The only thing that this supports is the basic Power rule for both Differentiation
 * and integration.
 * Please do NOT expect something like a complex triple integral here
 * OR chain rule and definite integrals. That's way out of my league, 
 * we only have Calc 1 under our belt.
 */
public class PolynomialCalc extends JFrame 
{
    private JTextField inputField;
    private JTextArea outputArea;

    public PolynomialCalc() 
    {
        /*
         * Window details. In this section, the specifications of the window is placed.
         */
        setTitle("Differentiation and Integration");
        setSize(600, 100);
        setFont(new Font("Poppins", Font.PLAIN, 30));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        /*
         * This contains the details and contents of the buttons.
         * There are only two buttons here.
         */
        inputField = new JTextField();
        JButton derivativeButton = new JButton("Find d/dx");
        JButton integralButton = new JButton("Find ∫");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Panel arrangement. This section contains the arrangement of the entire window.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(derivativeButton);
        panel.add(integralButton);

        add(inputField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        /*
         * This is the differentiation section. We first capture the input, and then it will solve it later for ParseAndDerive.
         * If it is an error then it will print sir loudel's email and then display a help message.
         */
        derivativeButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String polynomial = inputField.getText();
                try
                {
                    String derivative = parseAndDerive(polynomial);
                    outputArea.setText(derivative);
                } 
                catch (Exception ex) 
                {
                    outputArea.setText("@manaloto.loudel@gordoncollege.edu.ph: " + ex.getMessage());
                }
            }
        });

        /*
         * This is the integration section. Similar to the differentiation sector, we first capture
         * the output and then solve for parseandintegrate.
         * Same thing happens for the error handling for chain rule because it is NOT supported yet.
         */
        integralButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                String polynomial = inputField.getText();
                try 
                {
                    String integral = parseAndIntegrate(polynomial);
                    outputArea.setText(integral + " + C");
                } 
                catch (Exception ex) 
                {
                    outputArea.setText("@manaloto.loudel@gordoncollege.edu.ph: " + ex.getMessage());
                }
            }
        });
    }

    /*
     * This section contains the error messages stating that chain rule is NOT supported yet.
     * It will be implemented in the future.
     * We can probably ask Sir Loudel for a fix.
     */
    private String parseAndDerive(String polynomial) 
    {
        if (polynomial.contains("(")) 
        {
            throw new UnsupportedOperationException("I need sir loudel's help for the Chain rule.");
        }
        return derivative(polynomial);
    }

    private String parseAndIntegrate(String polynomial) 
    {
        if (polynomial.contains("(")) 
        {
            throw new UnsupportedOperationException("I need sir loudel's help for the Chain rule.");
        }
        return integral(polynomial);
    }

    /*
     * This section handles differentiation through the use of d/dx.
     * We first capture  the input, remove spaces, and the  do the power thing.
     * Afterwards, we convert the input to ints and then solve it.
     */
    private int gcd(int a, int b) 
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    private String derivative(String polynomial) 
    {
        polynomial = polynomial.replace("-", "+-");
        String[] terms = polynomial.split("\\+");
        StringBuilder result = new StringBuilder();

        for (String term : terms) 
        {
            term = term.trim();
            if (term.isEmpty()) continue;

            int coefficient = 1;
            int power = 0;

            if (term.contains("x")) 
            {
                int xIndex = term.indexOf("x");
                String coefStr = term.substring(0, xIndex).trim();

                if (!coefStr.isEmpty() && !coefStr.equals("+") && !coefStr.equals("-")) 
                {
                    coefficient = Integer.parseInt(coefStr);
                } 
                else if (coefStr.equals("-")) 
                {
                    coefficient = -1;
                } 
                else if (coefStr.equals("+")) 
                {
                    coefficient = 1;
                }

                if (term.contains("^")) 
                {
                    power = Integer.parseInt(term.substring(term.indexOf("^") + 1).trim());
                } 
                else 
                {
                    power = 1;
                }
            } 
            else 
            {
                coefficient = Integer.parseInt(term);
            }

            if (power == 0) continue; // Constant term derivative is 0 and will always be zero

            coefficient *= power;
            power -= 1;

            StringBuilder termBuilder = new StringBuilder();

            if (result.length() > 0) 
            {
                if (coefficient > 0) 
                {
                    termBuilder.append(" + ");
                } 
                else 
                {
                    termBuilder.append(" - ");
                    coefficient = Math.abs(coefficient);
                }
            } 
            else if (coefficient < 0) 
            {
                termBuilder.append("-");
                coefficient = Math.abs(coefficient);
            }

            if (coefficient != 1 || power == 0) 
            {
                termBuilder.append(coefficient);
            }

            if (power > 0) 
            {
                termBuilder.append("x");
                if (power != 1) 
                {
                    termBuilder.append("^").append(power);
                }
            }
            result.append(termBuilder);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    /*
     * Enplaced here is the integration section of this code. The process
     * works like Differentiation, only that this time, we are integrating. Furthermore,
     * only Power rule is supported here, not Chain rule. Please
     * be advised regarding this.
     */
    public String integral(String polynomial) 
    {
        polynomial = polynomial.replace("-", "+-");
        String[] terms = polynomial.split("\\+");
        StringBuilder result = new StringBuilder();

        for (String term : terms) 
        {
            term = term.trim();
            if (term.isEmpty()) continue;

            int coefficient = 1;
            int power = 0;

            if (term.contains("x")) 
            {
                int xIndex = term.indexOf("x");
                String coefStr = term.substring(0, xIndex).trim();

                if (!coefStr.isEmpty() && !coefStr.equals("+") && !coefStr.equals("-")) 
                {
                    coefficient = Integer.parseInt(coefStr);
                } 
                else if (coefStr.equals("-")) 
                {
                    coefficient = -1;
                } 
                else if (coefStr.equals("+")) 
                {
                    coefficient = 1;
                }

                if (term.contains("^")) 
                {
                    power = Integer.parseInt(term.substring(term.indexOf("^") + 1).trim());
                } 
                else 
                {
                    power = 1;
                }
            } 
            else 
            {
                coefficient = Integer.parseInt(term);
            }

            power += 1;
            int numerator = coefficient;
            int denominator = power;
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;

            StringBuilder termBuilder = new StringBuilder();

            if (numerator == 0) continue;

            if (result.length() > 0) 
            {
                if (coefficient > 0) 
                {
                    termBuilder.append(" + ");
                } 
                else 
                {
                    termBuilder.append(" - ");
                    numerator = Math.abs(numerator);
                }
            } 
            else if (coefficient < 0) 
            {
                termBuilder.append("-");
                numerator = Math.abs(numerator);
            }

            if (!(numerator == 1 && denominator == 1 && power != 0)) 
            {
                if (denominator == 1) 
                {
                    termBuilder.append(numerator);
                } 
                else 
                {
                    termBuilder.append(numerator).append("/").append(denominator);
                }
            }

            if (power != 0) 
            {
                termBuilder.append("x");
                if (power != 1) 
                {
                    termBuilder.append("^").append(power);
                }
            }

            result.append(termBuilder);
        }

        if (result.length() == 0) 
        {
            return "0";
        }

        String finalResult = result.toString().trim();

        if (finalResult.startsWith("+")) 
        {
            finalResult = finalResult.substring(1).trim();
        }

        return finalResult;
    }

    // Main class. We obviously call this one.
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new PolynomialCalc().setVisible(true);
        });
    }
}
