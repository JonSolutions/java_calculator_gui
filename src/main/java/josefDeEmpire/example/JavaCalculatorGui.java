package josefDeEmpire.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaCalculatorGui {
    JavaCalculatorGui() {
        Calculate();
    }
    void Calculate(){
        //main frame
        JFrame frame = new JFrame("Java Calculator");
        frame.setPreferredSize(new Dimension(400,640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.GRAY);


        //text area for showing input
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setBackground(Color.CYAN);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea.setPreferredSize(new Dimension(380,50));

        //text area panel
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setPreferredSize(new Dimension(390,50));
        textAreaPanel.setLayout(new FlowLayout());



        //display answer label
        JLabel displayAnswerLabel = new JLabel("Answer...");
        JPanel answerPanel = new JPanel();
        answerPanel.setPreferredSize(new Dimension(390,25));

        //jpanel1 for numbers: 1-0, X & C
        JPanel numbersPanel = new JPanel();
        numbersPanel.setPreferredSize(new Dimension(390,350));
        numbersPanel.setLayout(new GridLayout(4,3));

        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String num : numbers) {
            JButton Button = new JButton(num);
            Button.addActionListener(e-> textArea.append(num));
            numbersPanel.add(Button);
        }


        JButton singleCharacterDeleteButton = new JButton("X");
        singleCharacterDeleteButton.addActionListener(e -> {

            String input = textArea.getText();
            int index = input.length();
            input = input.substring(0, index - 1);
            textArea.setText(input);

        });
        numbersPanel.add(singleCharacterDeleteButton);


        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(e -> {
            textArea.append("0");
        });
        zeroButton.addActionListener(e -> displayAnswerLabel.setText("zero"));
        numbersPanel.add(zeroButton);



        JButton elevenButton = new JButton("C");
        elevenButton.addActionListener(e -> textArea.setText(" "));
        elevenButton.setActionCommand("C");
        numbersPanel.add(elevenButton);

        //Jpanel2 for operators: +, -, *, /
        JPanel operatorsPanel = new JPanel();
        operatorsPanel.setPreferredSize(new Dimension(390,175));
        operatorsPanel.setLayout(new FlowLayout());

        String[] operators = {" + ", " - ", " * ", " / ", " % "};
        for (String op : operators) {
            JButton button = new JButton(op);

            button.addActionListener(e -> textArea.append(op));
            button.setActionCommand(op);
            button.setPreferredSize(new Dimension(70, 60));
            button.setFont(new Font("Arial",Font.BOLD,25));
            operatorsPanel.add(button);
        }
        JButton equalsButton = new JButton(" = ");
        equalsButton.addActionListener(e -> calculation_logic(textArea, displayAnswerLabel));
        equalsButton.setPreferredSize(new Dimension(400, 80));
        equalsButton.setFont(new Font("Arial",Font.BOLD,50));
        operatorsPanel.add(equalsButton);

        textAreaPanel.add(textArea);
        frame.add(textAreaPanel);
        answerPanel.add(displayAnswerLabel);
        frame.add(answerPanel);
        frame.add(numbersPanel);
        frame.add(operatorsPanel);
        frame.pack();
        frame.setVisible(true);
    }

    void calculation_logic(JTextArea textArea, JLabel displayAnswerLabel) {
        String[] operators = {"+", "-", "*", "/", "%"};
        String input = textArea.getText();
        for (String op : operators) {
            boolean x = input.contains(op);
            text_area_logic(x, input,textArea,displayAnswerLabel, op);
        }

    }
    void text_area_logic(boolean x, String input, JTextArea textArea, JLabel displayAnswerLabel, String op) {
        if(x){
            long long_first_part1;
            long long_second_part1;
            double result;
            input = input.replace(" ", "");
            String first_part = input.substring(0, input.indexOf(op));
            String second_part = input.substring(input.indexOf(op) + 1);
            if(second_part.isEmpty()||first_part.isEmpty()){
                displayAnswerLabel.setText("Invalid operation!!");
                textArea.setText("");
                return;
            }else if(op.isEmpty()){
                displayAnswerLabel.setText(first_part);
                textArea.setText("");
                return;
            }
            try {
                long_first_part1 = Long.parseLong(first_part);
                long_second_part1 = Long.parseLong(second_part);
            }catch (NumberFormatException e) {
                displayAnswerLabel.setText("Error: '" + first_part + " or " + second_part + "' is not a valid number!");
                textArea.setText("");
                return;
            }

            System.out.println(first_part);
            System.out.println(second_part);
            double long_first_part = long_first_part1;
            double long_second_part = long_second_part1;
            double answer;
            switch (op) {
                case "+":
                    result = long_first_part + long_second_part;
                    answer = result;
                    String.valueOf(answer);
                    textArea.setText("");
                    displayAnswerLabel.setText("ans: " + first_part + op + second_part + " = " + result);
                    break;
                case "-":
                    result = long_first_part - long_second_part;
                    answer = result;
                    String.valueOf(answer);
                    textArea.setText("");
                    displayAnswerLabel.setText("ans: " + first_part + op + second_part + " = " + result);
                    break;
                case "*":
                    result = long_first_part * long_second_part;
                    answer = result;
                    String.valueOf(answer);
                    textArea.setText("");
                    displayAnswerLabel.setText("ans: " + first_part + op + second_part + " = " + result);
                    break;
                case "%":
                    result = long_first_part % long_second_part;
                    answer = result;
                    String.valueOf(answer);
                    textArea.setText("");
                    displayAnswerLabel.setText("ans: " + first_part + op + second_part + " = " + result);
                    break;
                case "/":
                    if (long_second_part == 0){
                        displayAnswerLabel.setText("Division by zero long_second_part");
                    }
                    result = long_first_part / long_second_part;
                    answer = result;
                    String.valueOf(answer);
                    textArea.setText("");
                    displayAnswerLabel.setText("ans: " + first_part + " / " + second_part + " = " + result);
                    break;


            }

        }


    }
}