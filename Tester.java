import javax.swing.*;

public class Tester {
    public static void main(String[] args){
        JFrame window = new JFrame("Graphing Calculator");
        window.setSize(1001, 1026);
        window.add(new Window());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
