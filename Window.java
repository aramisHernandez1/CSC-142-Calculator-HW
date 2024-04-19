import javax.swing.*;

public class Window {
    
    public JFrame mainWind = new JFrame();

    public Window(){
        initalize();
    }

    private void initalize(){
        this.mainWind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mainWind.setLocationRelativeTo(null);
        this.mainWind.setVisible(true);

    }
}
