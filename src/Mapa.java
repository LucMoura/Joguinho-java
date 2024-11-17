import java.awt.*;

public class Mapa {
    private  int [][] tiles;
    private static final int TILE_SIZE = 32;

    private static final int CHAO = 0;
    private static final int GRAMA = 1;
    private static final int AGUA = 2;
    private static final int PAREDE = 3;

    public Mapa(int largura, int altura){
        tiles = new int[largura][altura];
        gerarMapa();
    }

    public void gerarMapa(){
        for(int x = 0; x < tiles.length;x++){
            for(int y = 0; y < tiles[x].length; y++){
                if(x == 0 || y == 0 || x == tiles.length -1 || y == tiles[0].length - 1){
                    tiles[x][y] = PAREDE;
                }else{
                    tiles[x][y] = CHAO;
                }
            }
        }
    }
    public void desenhar(Graphics g){
        for(int x = 0;x < tiles.length;x++){
            for(int y = 0;y < tiles[x].length;y++){
                desenharTile(g, x, y, tiles[x][y]);
            }
        }
    }

    public void desenharTile(Graphics g, int x, int y, int tipo){
        switch (tipo){
            case GRAMA:
                g.setColor(Color.green);
                break;
            case AGUA:
                g.setColor(Color.blue);
                break;
            case PAREDE:
                g.setColor(Color.darkGray);
                break;
            case CHAO:
                g.setColor(Color.GRAY);
        }
        g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

    }
}
