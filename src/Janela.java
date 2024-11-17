import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    private Mapa mapa;

    public Janela() {
        super("Teste");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mapa = new Mapa(25, 19);
        mapa.gerarMapa();

        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        mapa.desenhar(g);
    }
}
