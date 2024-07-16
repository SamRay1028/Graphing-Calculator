import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.lang.Object;
import java.net.URL;

public class Window extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
    private Equation equation;
    //private ArrayList<CoordinatePoint> points;
    private int[][] equationArr;

    public Window(){
        setBackground(Color.GREEN.darker());
        addMouseListener(this);
        addMouseMotionListener(this);
        equation = new Equation();
        equationArr = equation.breakDownEquation();
        for(int i = 0; i < equationArr.length; i++){
            for(int j = 0; j < equationArr[0].length; j++){
                System.out.print(equationArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < 20; i++){
            if(i == 9){
                g.setColor(new Color(255, 0, 0,255));
            }
            else {
                g.setColor(new Color(0, 0, 0,255));
            }
            g.fillRect(50 + (i * 50), 0, 1, 1001);

            //g.setColor(new Color(255, 255, 255,255));
        }
        for(int i = 0; i < 20; i++){
            if(i == 9){
                g.setColor(new Color(255, 0, 0,255));
            }
            else {
                g.setColor(new Color(0, 0, 0,255));
            }
            g.fillRect(0, 50 + (i * 50), 1001, 1);
        }
        for(double i = -10; i < 10; i += 0.01){
            g.setColor(new Color(255, 255, 255,255));
            //g.fillOval(i + 500, createPoints(i), 1, 1);
            //g.fillOval(i + 1 + 500, createPoints(i + 1), 1, 1);
            g.drawLine((int) (50 * i + 500), 500 - (int) (50 * createPoints(i)), (int) (50 * (i + 0.01)) + 500, 500 - (int) (50 * (createPoints(i + 0.01))));
        }
    }

    public double createPoints(double x){
        double y = 0;
        for(int i = 0; i < equationArr[0].length; i++){
            y += equationArr[0][i] * equationArr[2][i] * (Math.pow(x, equationArr[1][i]));
        }
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
