import java.awt.*;

public class Personagem {
    private int vida;
    private String nome;
    private int mana;
    private int forca;
    private int x, y;

    private static final int TAMANHO = 32;

    public void atacar(Inimigo alvo){
        if(this.estaNoAlcance(alvo)){
            int dano = forca;
            alvo.receberDano(dano);
            System.out.println("Inimigo atacado! Dano: " + dano);
        }else{
            System.out.println("Inimigo fora de alcace");
        }
    }

    public void receberDano(int dano){
        this.vida -= dano;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void moverPara(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moverCima(){
        if(y > 1) {
            this.y--;
        }
    }
    public void moverBaixo(){
        if (y < Mapa.ALTURA - 2) {
            this.y++;
        }
    }
    public void moverEsquerda(){
        if(x > 1) {
            this.x--;
        }
    }
    public void moverDireita(){
        if(x < Mapa.LARGURA -2) {
            this.x++;
        }
    }
    public void desenhar(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x * TAMANHO, y * TAMANHO,TAMANHO, TAMANHO);
    }

    public boolean estaNoAlcance(Personagem alvo){
        int alcanceAtaque = 2;
        double distancia = Math.sqrt(Math.pow(this.x - alvo.getX(), 2) + Math.pow(this.y - alvo.getY(), 2));
        return distancia <= alcanceAtaque;
    }

}
