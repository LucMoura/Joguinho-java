import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Janela extends JFrame implements KeyListener {
    private Mapa mapa;
    private Personagem personagem;

    public Janela() {
        super("Teste");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mapa = new Mapa(Mapa.LARGURA, Mapa.ALTURA);
        personagem = new Personagem();
        personagem.setNome("Marcos");
        personagem.setForca(10);
        personagem.setMana(50);
        personagem.moverPara(10, 10);


        addKeyListener(this);
        setFocusable(true);
        mapa.gerarMapa();
        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        mapa.desenhar(g);
        personagem.desenhar(g);
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            personagem.moverCima();
        }else if(keyCode == KeyEvent.VK_S){
            personagem.moverBaixo();
        }else if(keyCode == KeyEvent.VK_A){
            personagem.moverEsquerda();
        }else if(keyCode == KeyEvent.VK_D){
            personagem.moverDireita();
        }

        repaint();
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
}
