import javax.swing.*;
import java.awt.*;
import java.net.URL;

//I decide not to inherit JFRAME because I dont want this class to have access to all the JFrame Methods and fields.
public class Calculator {
    
    private JFrame mainWind = new JFrame("Calculator");
    private JPanel panel = new JPanel();
    private int borderHeight = 400;
    private int borderWidth = 275;

    private JTextField textField = new JTextField(20);
    private ImageIcon image;
    private JLabel imageLabel = new JLabel();

    //Contains all but clear as clear does no calculation
    private String[] buttonValues = {"Clear", ".", "+", "-", "*", "/", "=", "sqrt",     
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "sin", "cos", "tan",
        "!", "1/x", "x^2", "log"
    };



    public Calculator(){
        initalize();
    }

    private void initalize(){
        this.mainWind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWind.setSize(borderWidth, borderHeight);
        this.mainWind.setLocationRelativeTo(null);
        this.mainWind.setVisible(true);



        this.panel.setBackground(Color.DARK_GRAY);
        this.textField.setFocusable(false);

        this.mainWind.add(panel);
        this.panel.add(textField);
        URL url = getClass().getResource("/calculatorImage.png");
        if(url != null){
            image = new ImageIcon(url);
        }
        imageLabel.setIcon(image);

        

        createButtons();
        panel.add(imageLabel);
    }

    public JPanel getPanel(){
        return this.panel;
    }

    public void addText(String text){
        this.textField.setText(text);
    }

    private void initButton(JButton button){
        button.setFocusable(false);
        this.panel.add(button);
    }


    private void createButtons(){
        for(String buttonSymbol: buttonValues){
            JButton button = new JButton(buttonSymbol);
            button.addActionListener(new ButtonHandler(textField));
            initButton(button);

        }
    }
}
