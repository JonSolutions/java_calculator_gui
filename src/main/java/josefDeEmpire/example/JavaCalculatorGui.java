package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;

public  class JavaCalculatorGui  {
    JavaCalculatorGui(){
    }
    int a, b, c;
    int multiply(){
        c = a*b;
        return c;
    }
    int subtract(){
        c = a-b;
        return c;
    }
    int add(){
        c = a+b;
        return c;
    }
    int divide(){
        c = a/b;
        return c;
    }


//    double result = 0;
//    switch (op) {
//        case "+": result = num1 + num2; break;
//        case "-": result = num1 - num2; break;
//        case "*": result = num1 * num2; break;
//        case "/":
//            if (num2 == 0) {
//                resultLabel.setText("Error: Division by zero");
//                return;
//            }
//            result = num1 / num2;
//            break;
//    }


    void Calculate(){
       //main frame
       JFrame frame = new JFrame("Java Calculator");
       frame.setPreferredSize(new Dimension(400,640));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       frame.setLayout(new GridLayout(4,0));
       frame.setLayout(new FlowLayout());
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.getContentPane().setBackground(Color.GRAY);


       //text area for showing input
       JTextField textArea = new JTextField();
       textArea.setColumns(35);
       textArea.setEditable(true);
        textArea.setBackground(Color.CYAN);
       textArea.setPreferredSize(new Dimension(390,50));

       JPanel textAreaPanel = new JPanel();
       textAreaPanel.setPreferredSize(new Dimension(390,50));
//       textAreaPanel.setBackground(Color.green);
       textAreaPanel.setLayout(new FlowLayout());
       textAreaPanel.add(textArea, BorderLayout.EAST);
//        textAreaPanel.add(textArea1, BorderLayout.WEST);

        //display answer label
       JLabel displayAnswerLabel = new JLabel("label");
       //jpanel for displaying answer
       JPanel answerPanel = new JPanel();
       answerPanel.setPreferredSize(new Dimension(390,25));
//       answerPanel.setBackground(Color.yellow);

        //jpanel1 for numbers: 1-0, X & C
        JPanel numbersPanel = new JPanel();
        numbersPanel.setPreferredSize(new Dimension(390,350));
//        numbersPanel.setBackground(Color.red);
        numbersPanel.setLayout(new GridLayout(4,3));


       JButton zeroButton = new JButton("0");
       zeroButton.addActionListener(e->textArea.setText("0"));
       numbersPanel.add(zeroButton);

       JButton oneButton = new JButton("1");
       oneButton.addActionListener(e -> textArea.setText("1"));
       oneButton.addActionListener(e -> displayAnswerLabel.setText("one"));
       numbersPanel.add(oneButton);

       JButton twoButton = new JButton("2");
       twoButton.addActionListener(e -> textArea.setText("2"));
       twoButton.addActionListener(e -> displayAnswerLabel.setText("two"));
       numbersPanel.add(twoButton);

       JButton threeButton = new JButton("3");
       threeButton.addActionListener(e -> textArea.setText("3"));
       threeButton.addActionListener(e -> displayAnswerLabel.setText("three"));
       threeButton.setActionCommand("3");
       numbersPanel.add(threeButton);

       JButton fourButton = new JButton("4");
       fourButton.addActionListener(e -> textArea.setText("4"));
       fourButton.addActionListener(e -> displayAnswerLabel.setText("four"));
       fourButton.setActionCommand("4");
       numbersPanel.add(fourButton);

       JButton fiveButton = new JButton("5");
       fiveButton.addActionListener(e -> textArea.setText("5"));
       fiveButton.addActionListener(e -> displayAnswerLabel.setText("five"));
       fiveButton.setActionCommand("5");
       numbersPanel.add(fiveButton);

       JButton sixButton = new JButton("6");
       sixButton.addActionListener(e -> textArea.setText("6"));
       sixButton.addActionListener(e -> displayAnswerLabel.setText("six"));
       sixButton.setActionCommand("6");
       numbersPanel.add(sixButton);


       JButton sevenButton = new JButton("7");
       sevenButton.addActionListener(e -> textArea.setText("7"));
       sevenButton.addActionListener(e -> displayAnswerLabel.setText("seven"));
       numbersPanel.add(sevenButton);

       JButton eightButton = new JButton("8");
       eightButton.addActionListener(e -> textArea.setText("8"));
       eightButton.addActionListener(e -> displayAnswerLabel.setText("eight"));
       numbersPanel.add(eightButton);

       JButton nineButton = new JButton("9");
       nineButton.addActionListener(e -> textArea.setText("9"));
       nineButton.addActionListener(e -> displayAnswerLabel.setText("nine"));
       numbersPanel.add(nineButton);

       JButton tenButton = new JButton("=");
       tenButton.addActionListener(e -> textArea.setText("="));

       numbersPanel.add(tenButton);

       JButton elevenButton = new JButton("C");
       elevenButton.addActionListener(e -> textArea.setText(""));
       elevenButton.setActionCommand("C");
       numbersPanel.add(elevenButton);

       //Jpanel2 for operators: +, -, *, /
       JPanel operatorsPanel = new JPanel();
       operatorsPanel.setPreferredSize(new Dimension(390,175));
//       operatorsPanel.setBackground(Color.blue);
       operatorsPanel.setLayout(new FlowLayout());
//       operatorsPanel.setLayout(new GridLayout(1,4));

        JButton multiButton = new JButton("*");
        multiButton.addActionListener(e -> textArea.setText("*"));
        multiButton.setActionCommand("*");
        multiButton.setPreferredSize(new Dimension(90,150));
        operatorsPanel.add(multiButton);

        JButton minusButton = new JButton("-");
        minusButton.addActionListener(e -> textArea.setText("-"));
        minusButton.setActionCommand("-");
        minusButton.setPreferredSize(new Dimension(90,150));
        operatorsPanel.add(minusButton);

        JButton addButton = new JButton("+");
        addButton.addActionListener(e -> textArea.setText("+"));
        addButton.setActionCommand("+");
        addButton.setPreferredSize(new Dimension(90,150));
        operatorsPanel.add(addButton);

        JButton divisionButton = new JButton("/");
        divisionButton.addActionListener(e -> textArea.setText("/"));
        divisionButton.setActionCommand("/");
        divisionButton.setPreferredSize(new Dimension(90,150));
        operatorsPanel.add(divisionButton);

       textAreaPanel.add(textArea);
       frame.add(textAreaPanel);
       answerPanel.add(displayAnswerLabel);
       frame.add(answerPanel);
       frame.add(numbersPanel);
       frame.add(operatorsPanel);
       frame.pack();
       frame.setVisible(true);

    }

}
