public class Personagem {
    private int vida;
    private String nome;
    private int mana;
    private int forca;

    public void atacar(Personagem alvo){
        int dano = forca;
        alvo.receberDano(dano);
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

}
