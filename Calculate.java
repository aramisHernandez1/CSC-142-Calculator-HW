import java.util.*;

public class Calculate {
    
    public double evaluteExpression(String[] terms){
        //Create list of opperators and normal numeric values
        ArrayList<String> opperator = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
        double output = 0;

        //Itterate through all terms
        for(String term: terms){
            
            //Check if it is an opperator add it to the list
            if("+-*/^!".contains(term)){
                opperator.add(term);
            }
            else if("sqrtlog".contains(term)){
                opperator.add(term);
            }
            else if("sincostan".contains(term)){
                opperator.add(term);
            }
            //If it is parathesis we completly ignore
            else if("()".contains(term)){
            }
            //Anything else will be a numeric value and will be added to values
            else{
                values.add(term);
            }
        }
        //Itterate through opperators to get each sign
        //This is because some calculations take less arguments then others and do not require 2 numbers
        for(String sign: opperator){

            //All of this opperations take 2 numbers as arguments 
            if("+-*/".contains(sign)){
                double num1 = Double.parseDouble(values.get(0));
                double num2 = Double.parseDouble(values.get(1));
                output = calc(num1, num2, sign);
            }
            //Takes only one number as an arugment
            else if("sqrtlog".contains(sign)){
                double num1 = Double.parseDouble(values.get(0));
                output = calc(num1, 0, sign);
            }
            //Only takes one number
            else if("sincostan".contains(sign)){
                double num1 = Double.parseDouble(values.get(0));
                output = calc(num1, 0, sign);
            }
            //Only takes a number really
            else if("^!".contains(sign)){
                double num1 = Double.parseDouble(values.get(0));
                output = calc(num1, 0, sign);
            }
        }

        return output;
    }


    //Switch statment which does the actual individual calculations for all signs
    public double calc(double num1, double num2, String operator){
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1/num2;
            case "sqrt":
                //No negative square roots
                if(num1 > 0) return Math.sqrt(num1);
            case "^":
                return num1 * num1;
            case "1/":
                return 1/num1;
            //For trig functions convert degress to radians
            //Was unsure if you wanted user number in radians or degrees.
            case "sin":
                return Math.sin(Math.toRadians(num1));
            case "cos":
                return Math.cos(Math.toRadians(num1));
            case "tan":
                return Math.tan(Math.toRadians(num1));
            //Logs cannot be negative
            case  "log":
                if(num1 > 0)return Math.log10(num1);
            case "!":
                return factorial(num1);
            default:
                System.out.println("ERROR: INVAILD OPPERATOR: " + "'" + operator + "'");
                System.out.printf("%f %f %f set to 0", num1, operator, num2);
                return 0.0;
        }

    }

    //Factorial calculation using recursion
    //Factorial are usually calculated in integer form
    //So we convert it into an integer then return a double.
    private double factorial(double num){
        int output = (int)num;

        if(num >= 1){
            return num * factorial(num-1);
        }
        else return 1.0;

    }
}
