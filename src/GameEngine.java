import javax.swing.*;
import java.awt.*;

public class GameEngine extends JPanel implements  Runnable{
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            update();
            repaint();
            try{
                Thread.sleep(16);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void update(){

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}