import java.awt.*;

public class Inimigo extends  Personagem{
    private int x, y;
    private int forca;

    public Inimigo(int x, int y, int vida, int forca, String nome){
        super();
        this.setVida(vida);
        this.setForca(forca);
        this.setNome(nome);
        this.x = x;
        this.y = y;
    }

    public void perseguir(Personagem jogaodor){
        if(x < jogaodor.getx()){
            x++;
        }else if (x > jogaodor.getx()){
            x--;
        }

        if (y < jogaodor.getY()){
            y++;
        }else if (y > jogaodor.getY()){
            y--;
        }
    }

    public void desenhar(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x * 32, y *32, 32, 32);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}