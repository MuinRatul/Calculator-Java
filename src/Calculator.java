import  java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int borderwidth = 390;
    int borderheight = 540;

    Color lightGray = new Color(212,212,212);
    Color darkGray = new Color(80,80,80);
    Color black = new Color(28,28,28);
    Color orange = new Color(255,149,0);

     String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};


    JFrame frame = new JFrame("Calculator");
    JLabel displaylabel = new JLabel();
    JPanel displaypanele = new JPanel();

    JPanel buttoPanel = new JPanel();

    public Calculator() {
        frame.setVisible(true);
        frame.setSize(borderwidth, borderheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displaylabel.setBackground(black);
        displaylabel.setForeground(Color.white);
        displaylabel.setFont(new Font("Arial",Font.PLAIN,70));
        displaylabel.setHorizontalAlignment(JLabel.RIGHT);
        displaylabel.setText("0");
        displaylabel.setOpaque(true);

        displaypanele.setLayout(new BorderLayout());
        displaypanele.add(displaylabel);
        frame.add(displaypanele, BorderLayout.NORTH);

        buttoPanel.setLayout(new GridLayout(5,4));
        buttoPanel.setBackground(black);
        frame.add(buttoPanel);

        for(int i =0;i<buttonValues.length;i++)
        {
            JButton button = new JButton();
            String buttonvalue = buttonValues[i];
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonvalue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(black));
            if(Arrays.asList(rightSymbols).contains(buttonvalue))
            {
                button.setBackground(orange);
                button.setForeground(Color.white);
            }
            else if(Arrays.asList(topSymbols).contains(buttonvalue))
            {
                button.setBackground(lightGray);
                button.setForeground(black);
            }
            else
            {
                button.setBackground(darkGray);
                button.setForeground(Color.white);
            }
            buttoPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    JButton button = (JButton)e.getSource();
                    String buttonvalue = button.getText();
                    if(Arrays.asList(rightSymbols).contains(buttonvalue))
                    {

                    }
                    else if(Arrays.asList(topSymbols).contains(buttonvalue))
                    {

                    }
                    else
                    {
                        if(buttonvalue.equals("."))
                        {
                            if(!displaylabel.getText().contains(buttonvalue))
                            {
                                displaylabel.setText(displaylabel.getText()+buttonvalue);
                            }

                        }
                        else if("0123456789".contains(buttonvalue))
                        {
                            if(displaylabel.getText()=="0")
                            {
                                displaylabel.setText(buttonvalue);
                            }
                            else
                            {
                                displaylabel.setText(displaylabel.getText()+buttonvalue);
                            }
                        }    
                    }
                }
            });
        }

    }



}
