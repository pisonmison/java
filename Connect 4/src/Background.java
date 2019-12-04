import javax.swing.*;

public class Background extends JFrame {
    public Background(){
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Demo");
        frame.setLayout(null);

        JLabel background;
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("Background.jpg");

        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,700);
        frame.add(background);
    }

    public static void main(String[] args){
        new Background();
    }
}