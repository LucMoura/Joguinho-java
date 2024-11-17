public class Batalha {
    private Personagem jogador;
    private Personagem inimigo;

    public void iniciar(){
        while (jogador.getVida() > 0 && inimigo.getVida() > 0){
            jogador.atacar(inimigo);
            if(inimigo.getVida() > 0){
                inimigo.atacar(jogador);
            }
        }
        System.out.println(jogador.getVida() > 0 ? "Vitória!" : "Derrota");
    }
}
