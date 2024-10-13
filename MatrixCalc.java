import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MatrixCalc extends JFrame implements ActionListener 
{
    private JTextField[][] matrixA, matrixB;
    private JTextField rowsFieldA, colsFieldA, rowsFieldB, colsFieldB;
    private JTextArea resultArea;
    private JButton addButton, subButton, mulButton, detButton;
    private JPanel matrixPanelA, matrixPanelB;

    private int rowsA = 0, colsA = 0, rowsB = 0, colsB = 0;

    public MatrixCalc() 
    {
        setTitle("Matrices");
        setLayout(new BorderLayout());

        JPanel dimensionPanel = new JPanel(new GridLayout(2, 1));

        JPanel matrixADimensions = new JPanel();
        matrixADimensions.add(new JLabel("Matrix A - Rows:"));
        rowsFieldA = new JTextField(3);
        matrixADimensions.add(rowsFieldA);
        matrixADimensions.add(new JLabel("Columns:"));
        colsFieldA = new JTextField(3);
        matrixADimensions.add(colsFieldA);
        JButton setDimensionsButtonA = new JButton("Set Dimension for A");
        setDimensionsButtonA.addActionListener(e -> setMatrixDimensionsA());
        matrixADimensions.add(setDimensionsButtonA);

        JPanel matrixBDimensions = new JPanel();
        matrixBDimensions.add(new JLabel("Matrix B - Rows:"));
        rowsFieldB = new JTextField(3);
        matrixBDimensions.add(rowsFieldB);
        matrixBDimensions.add(new JLabel("Columns:"));
        colsFieldB = new JTextField(3);
        matrixBDimensions.add(colsFieldB);
        JButton setDimensionsButtonB = new JButton("Set Dimension for B");
        setDimensionsButtonB.addActionListener(e -> setMatrixDimensionsB());
        matrixBDimensions.add(setDimensionsButtonB);

        dimensionPanel.add(matrixADimensions);
        dimensionPanel.add(matrixBDimensions);

        add(dimensionPanel, BorderLayout.NORTH);

        JPanel matricesPanel = new JPanel(new GridLayout(1, 2));
        matrixPanelA = new JPanel();
        matrixPanelB = new JPanel();
        matricesPanel.add(matrixPanelA);
        matricesPanel.add(matrixPanelB);
        add(matricesPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        subButton = new JButton("Subtract");
        mulButton = new JButton("Multiply");
        detButton = new JButton("Determinant (Matrix A)");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        detButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(detButton);
        add(buttonPanel, BorderLayout.SOUTH);

        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.EAST);

        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMatrixDimensionsA() 
    {
        try 
        {
            rowsA = Integer.parseInt(rowsFieldA.getText());
            colsA = Integer.parseInt(colsFieldA.getText());

            matrixA = new JTextField[rowsA][colsA];
            matrixPanelA.removeAll();

            matrixPanelA.setLayout(new GridLayout(rowsA, colsA));

            for (int i = 0; i < rowsA; i++) 
            {
                for (int j = 0; j < colsA; j++) 
                {
                    matrixA[i][j] = new JTextField(3);
                    matrixPanelA.add(matrixA[i][j]);
                }
            }

            matrixPanelA.setBorder(BorderFactory.createTitledBorder("Matrix A"));

            revalidate();
            repaint();
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "valid dimensions for matrix a", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setMatrixDimensionsB() 
    {
        try 
        {
            rowsB = Integer.parseInt(rowsFieldB.getText());
            colsB = Integer.parseInt(colsFieldB.getText());

            matrixB = new JTextField[rowsB][colsB];
            matrixPanelB.removeAll();

            matrixPanelB.setLayout(new GridLayout(rowsB, colsB));

            for (int i = 0; i < rowsB; i++) 
            {
                for (int j = 0; j < colsB; j++) 
                {
                    matrixB[i][j] = new JTextField(3);
                    matrixPanelB.add(matrixB[i][j]);
                }
            }

            matrixPanelB.setBorder(BorderFactory.createTitledBorder("Matrix B"));

            revalidate();
            repaint();
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "valid dimensions for matrix b", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            double[][] matA = readMatrix(matrixA, rowsA, colsA);
            double[][] matB = readMatrix(matrixB, rowsB, colsB);
            double[][] result = null;

            if (e.getSource() == addButton) 
            {
                if (rowsA != rowsB || colsA != colsB) 
                {
                    throw new IllegalArgumentException("Ensure similar matrix dimensions for addition.");
                }
                result = addMatrices(matA, matB, rowsA, colsA);
            } 
            else if (e.getSource() == subButton) 
            {
                if (rowsA != rowsB || colsA != colsB) 
                {
                    throw new IllegalArgumentException("Ensure similar matrix dimensions for subtraction.");
                }
                result = subtractMatrices(matA, matB, rowsA, colsA);
            } 
            else if (e.getSource() == mulButton) 
            {
                if (colsA != rowsB)
                {
                    throw new IllegalArgumentException("To multiply matrices, rows in A must be equal to B.");
                }
                result = multiplyMatrices(matA, matB, rowsA, colsB, colsA);
            } 
            else if (e.getSource() == detButton) 
            {
                double determinant = calculateDeterminant(matA);
                resultArea.setText("Determinant of Matrix A  is " + determinant);
                return;
            }

            displayResult(result, rowsA, colsB);
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Error, check your inputs. Otherwise, call luy.ronnie@gordoncollege.edu.ph.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double[][] readMatrix(JTextField[][] matrixFields, int rows, int cols) 
    {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                matrix[i][j] = Double.parseDouble(matrixFields[i][j].getText());
            }
        }
        return matrix;
    }

    private double[][] addMatrices(double[][] A, double[][] B, int rows, int cols) 
    {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private double[][] subtractMatrices(double[][] A, double[][] B, int rows, int cols) 
    {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    private double[][] multiplyMatrices(double[][] A, double[][] B, int rowsA, int colsB, int commonDim) 
    {
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) 
        {
            for (int j = 0; j < colsB; j++) 
            {
                result[i][j] = 0;
                for (int k = 0; k < commonDim; k++) 
                {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    private double calculateDeterminant(double[][] matrix) 
    {
        if (matrix.length == 2) 
        {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } 
        else if (matrix.length == 3) 
        {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                   matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                   matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        } 
        else 
        {
            throw new IllegalArgumentException("Unsupported size!");
        }
    }

    private void displayResult(double[][] matrix, int rows, int cols) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) 
        {
            sb.append(Arrays.toString(matrix[i])).append("\n");
        }
        resultArea.setText(sb.toString());
    }

    public static void main(String[] args) 
    {
        new MatrixCalc();
    }
}
