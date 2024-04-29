import java.awt.event.*;
import java.util.Arrays;

import javax.swing.JTextField;

public class ButtonHandler implements ActionListener{
    JTextField textField;
    Calculate calculate;

    ButtonHandler(JTextField text){
        this.textField = text;
        calculate = new Calculate();
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand(); //Gets the buttons value when clicked
        String input = textField.getText();
        String[] terms = input.split(" ");
        boolean opperation = containOpperation(terms);


        //Check if numeric number or decimal point
        if("0123456789.".contains(command)){
            System.out.println("Hi" + command);
            if(!input.endsWith(")")){
                input += command;
            }
                   
        }
        else if("Clear".contains(command)){
            input = "";
            System.out.println(command);
        }
        else if("+-*/".contains(command)){
            System.out.println("Hi" + command);

            if(opperation == false){
                input += " " + command + " ";
            }
        }
        else if("sqrtlog".contains(command)){
            System.out.println("Hi" + command);
            if(opperation == false && input.contains("-") == false){
                input = command + " ( " + input + " )";
            }
        }
        else if("sincostan".contains(command)){
            System.out.println("Hi" + command);
            if(opperation == false){
                input = command + " ( " + input + " )";
            }
        }
        else if("x^2".contains(command)){
            System.out.println("Hi" + command);
            if(opperation == false){
                input += " ^ 2";
            }
        }
        else if("!".contains(command)){
            System.out.println("Hi" + command);
            if(opperation == false){
                input = command + " " + input;
            }
        }
        
        //Come back to this
        else if("1/x".contains(command)){
            System.out.println("Hi");
            if(opperation == false){
                input = "1 / " + input;
                System.out.println(input);
            }
        }
        else if("=".contains(command)){
            if(opperation == true){
                System.out.println(Arrays.toString(terms));
                double newTerm = calculate.evaluteExpression(terms);
                input = Double.toString(newTerm);
                
            }
        }

        System.out.print("Command: " + command);

        textField.setText(input);


    }

    private boolean containOpperation(String[] terms){
        for(String term : terms){
            System.out.println(term);
            if("+-*/sqrtsincostanlog!".contains(term) || term.contains("^")){
                return true;
            }
        }
        return false;
    }
}
