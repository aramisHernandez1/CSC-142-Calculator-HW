import javax.swing.*;
import java.awt.*;
import java.net.URL;

//I decide not to inherit JFRAME because I dont want this class to have access to all the JFrame Methods and fields.
public class Calculator {
    
    //Init basic sizes widnow, panel, etc
    private JFrame mainWind = new JFrame("Calculator");
    private JPanel panel = new JPanel();
    private int borderHeight = 400;
    private int borderWidth = 275;

    private JTextField textField = new JTextField(20);
    private ImageIcon image;
    private JLabel imageLabel = new JLabel();

    //Create an array of all button values on the calculator to itterate through and create buttons with
    private String[] buttonValues = {"Clear", ".", "+", "-", "*", "/", "=", "sqrt",     
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "sin", "cos", "tan",
        "!", "1/x", "x^2", "log"
    };

    public Calculator(){
        initalize();
    }

    //Set up calculator
    private void initalize(){
        //Init the JFrame
        this.mainWind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWind.setSize(borderWidth, borderHeight);
        this.mainWind.setLocationRelativeTo(null);
        this.mainWind.setVisible(true);


        //Set up panel and textfiled and add both
        this.panel.setBackground(Color.DARK_GRAY);
        this.textField.setFocusable(false);
        this.mainWind.add(panel);
        this.panel.add(textField);

        //Get Image path and set image
        URL url = getClass().getResource("/calculatorImage.png");
        if(url != null){
            image = new ImageIcon(url);
        }
        imageLabel.setIcon(image);

        createButtons();
        panel.add(imageLabel);
    }

    //Set up individual button and add it to panel
    private void initButton(JButton button){
        button.setFocusable(false);
        this.panel.add(button);
    }

    //Loop through buttons and create each individual button for each symbol
    private void createButtons(){
        for(String buttonSymbol: buttonValues){
            JButton button = new JButton(buttonSymbol);
            button.addActionListener(new ButtonHandler(textField));
            initButton(button);
        }
    }
}
