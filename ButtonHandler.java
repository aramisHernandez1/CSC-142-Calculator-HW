import java.awt.event.*;
import javax.swing.JTextField;

public class ButtonHandler implements ActionListener{
    JTextField textField;
    Calculate calculate;

    //init textfield and the main calculate class which will do the acutal calculations
    ButtonHandler(JTextField text){
        this.textField = text;
        calculate = new Calculate();
    }

    //Handle each statement one expression at a time.
    //As this simplifyies the process greatly 
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand(); //Gets the buttons value when clicked
        String input = textField.getText();
        String[] terms = input.split(" ");
        boolean opperation = containOpperation(terms);


        //Check if numeric number or decimal point
        if("0123456789.".contains(command)){
            if(!input.endsWith(")")){
                input += command;
            }  
        }
        //Empty text field if we hit clear
        else if("Clear".contains(command)){
            input = "";
        }
        else if("+-*/".contains(command)){

            //Makes sure there is no opperation if we are adding an opperation
            //Becasue we want to handle one expression at a time
            if(opperation == false){
                input += " " + command + " ";
            }
        }

        //Sqrt and logs cannot really handle negative numbers so we make sure we have
        //No negative signs
        else if("sqrtlog".contains(command)){
            if(opperation == false && input.contains("-") == false){
                input = command + " ( " + input + " )";
            }
        }
        //Same as above but does not care for negative
        //This takes a degrees then coverts them into radians
        else if("sincostan".contains(command)){
            if(opperation == false){
                input = command + " ( " + input + " )";
            }
        }
        //Make sure there is extra space so we can split it
        else if("x^2".contains(command)){
            if(opperation == false){
                input += " ^ 2";
            }
        }
        else if("!".contains(command)){
            if(opperation == false){
                input = command + " " + input;
            }
        }
        //Will just be handled like our normal divison statement
        else if("1/x".contains(command)){
            if(opperation == false){
                input = "1 / " + input;
                System.out.println(input);
            }
        }
        else if("=".contains(command)){
            if(opperation == true){
                double newTerm = calculate.evaluteExpression(terms);
                input = Double.toString(newTerm);
                
            }
        }

        textField.setText(input);
    }

    private boolean containOpperation(String[] terms){
        for(String term : terms){
            if("+-*/sqrtsincostanlog!".contains(term) || term.contains("^")){
                return true;
            }
        }
        return false;
    }
}
