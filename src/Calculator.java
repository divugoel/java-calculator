import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cerebro on 22/06/15.
 */
public class Calculator extends JFrame implements ActionListener {
    private double firstNumber;
    private String operand = "";
    private boolean isInNumberEntringMode = false;

    private JPanel panel;
    private JTextField resultField;

    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonAdd;
    private JButton buttonFour;
    private JButton buttonSix;
    private JButton buttonSeven;
    private JButton buttonEight;
    private JButton buttonNine;
    private JButton buttonDivide;
    private JButton buttonZero;
    private JButton buttonEqual;
    private JButton buttonFive;
    private JButton buttonSubtract;
    private JButton buttonMultiply;

    public Calculator(){

        super();

        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.buttonOne.addActionListener(this);
        this.buttonTwo.addActionListener(this);
        this.buttonThree.addActionListener(this);
        this.buttonFour.addActionListener(this);
        this.buttonFive.addActionListener(this);
        this.buttonSix.addActionListener(this);
        this.buttonSeven.addActionListener(this);
        this.buttonEight.addActionListener(this);
        this.buttonNine.addActionListener(this);
        this.buttonZero.addActionListener(this);
        this.buttonAdd.addActionListener(this);
        this.buttonSubtract.addActionListener(this);
        this.buttonDivide.addActionListener(this);
        this.buttonMultiply.addActionListener(this);
        this.buttonEqual.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttonPressed = (JButton)e.getSource();

        if(buttonPressed == this.buttonZero
                || buttonPressed == this.buttonOne
                || buttonPressed == this.buttonTwo
                || buttonPressed == this.buttonThree
                || buttonPressed == this.buttonFour
                || buttonPressed == this.buttonFive
                || buttonPressed == this.buttonSix
                || buttonPressed == this.buttonSeven
                || buttonPressed == this.buttonEight
                || buttonPressed == this.buttonNine
                ) {

            this.digitPressed(buttonPressed.getText());
        } else if (buttonPressed == this.buttonEqual) {
            this.calculate();
        } else {
            this.operationPressed(buttonPressed.getText());
        }

    }


    private void digitPressed(String digit) {
        if(this.isInNumberEntringMode) {
            this.resultField.setText(this.resultField.getText() + digit);
        } else {
            this.resultField.setText(digit);
            this.isInNumberEntringMode = true;
        }
    }

    private void operationPressed(String operand) {
        this.calculate();
        this.firstNumber = Double.parseDouble(this.resultField.getText());
        this.operand = operand;

        this.isInNumberEntringMode = false;


    }

    private void calculate() {
        if(this.operand.length() > 0) {
            double secondNumber = Double.parseDouble(this.resultField.getText());
            double result;
            if (this.operand.equals("+")) {
                result = this.firstNumber + secondNumber;
            } else if (this.operand.equals("-")) {
                result = this.firstNumber - secondNumber;
            } else if (this.operand.equals("/")) {
                result = this.firstNumber / secondNumber;
            } else if (this.operand.equals("*")) {
                result = this.firstNumber * secondNumber;
            } else {
                result = 0;
            }

            this.resultField.setText(Double.toString(result));

            this.isInNumberEntringMode = false;
            this.operand = "";
        }
    }
}

