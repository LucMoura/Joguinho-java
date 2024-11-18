import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Janela extends JFrame implements KeyListener {
    private Mapa mapa;
    private Personagem personagem;
    private Inimigo inimigo;
    private Random random;


    public Janela() {
        super("Teste");


        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        mapa = new Mapa(Mapa.LARGURA, Mapa.ALTURA);
        personagem = new Personagem();
        inimigo = new Inimigo(5, 5, 100, 10, "Gronk");
        random = new Random();


        personagem.setNome("Marcos");
        personagem.setForca(1000);
        personagem.setMana(50);
        personagem.moverPara(10, 10);
        personagem.setVida(100);

        personagem.statusHeroi(personagem);


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
        if(inimigo.getVida() > 0){
            inimigo.desenhar(g);
            inimigo.perseguir(personagem);
        }


        if(inimigo.inimigoIsproximo(personagem)){
            personagem.receberDano(inimigo.getForca());
            personagem.statusHeroi(personagem);
        }

        if(personagem.getVida() <= 0) System.exit(0);

        if(!inimigoIsAlive(inimigo)){
            int randomX, randomY;
            randomX = random.nextInt(25);
            randomY = random.nextInt(19);
            inimigo = new Inimigo(randomX ,randomY,100, 10, "Gronk");

        }
    }

    private boolean inimigoIsAlive(Inimigo inimigo) {
        if(inimigo.getVida() < 0){
            return false;
        }
        return true;
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
        }else if(keyCode == KeyEvent.VK_SPACE){
            personagem.atacar(inimigo);

        }

        repaint();
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
}
