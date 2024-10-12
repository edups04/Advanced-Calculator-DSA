import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinMaxIO extends JFrame {
    //Add ng textfield at label
    private JTextField input1;
    private JTextField input2;
    private JLabel output;

    public MinMaxIO() {
        setTitle("MinMax Calculator");//pangalan ng JFrame
        setSize(300, 200);//Size ng JFrame
        setLayout(null);
        setLocationRelativeTo(null);//Para mapunta sa center ang JFrame
        
        //Label para sa first number along with its properties.
        JLabel firstLabel = new JLabel("First Number:");
        firstLabel.setBounds(10, 10, 100, 25);
        add(firstLabel);
        
        //Textfield para sa min na i-input ng user
        input1 = new JTextField(); 
        input1.setBounds(120, 10, 150, 25);
        add(input1);
        
        //Label para sa first number along with its properties.
        JLabel secondLabel = new JLabel("Second Number:");
        secondLabel.setBounds(10, 40, 100, 25);
        add(secondLabel);
        
        //Textfield para sa max na i-input ng user
        input2 = new JTextField();
        input2.setBounds(120, 40, 150, 25);
        add(input2);
        
        //Label ng result. Dito lalabas yung output
        output = new JLabel("Result: ");
        output.setBounds(10, 100, 250, 25);
        add(output);

        //Button para sa Min and its properties
        JButton minButton = new JButton("Find Min");
        minButton.setBounds(10, 70, 125, 25);
        add(minButton);

        //Button para sa Max and its properties
        JButton maxButton = new JButton("Find Max");
        maxButton.setBounds(145, 70, 125, 25);
        add(maxButton);

        //Para sa first input ng user
        minButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(input1.getText());
                    int num2 = Integer.parseInt(input2.getText());
                    int min = Math.min(num1, num2);
                    output.setText("Result: Min is " + min); //Ieedit yung text ng label ng result at i-add yung min
                } catch (NumberFormatException ex) {
                    output.setText("Please enter whole numbers for Min.");//Para pag nag-input ng decimal
                }
            }
        });

        //Para sa second input ng user
        maxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(input1.getText());
                    int num2 = Integer.parseInt(input2.getText());
                    int max = Math.max(num1, num2);
                    output.setText("Result: Max is " + max); //Ieedit yung text ng label ng result at i-add yung max
                } catch (NumberFormatException ex) {
                    output.setText("Please enter whole numbers for Max.");//Para pag nag-input ng decimal
                }
            }
        });

        setVisible(true);//para maging visilble yung JFrame ng MinMax
    }

    public static void main(String[] args) {
        new MinMaxIO();
    }
}
