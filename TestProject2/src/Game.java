import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Rectangle canvas;
    private Keyboard keyboard;
    private Barrel[] barrels;

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    private static final int MAX_BARRELS = 20;
    private static final int JUMP_HEIGHT = -20;

    public Game() {
        this.canvas = new Rectangle(10, 10, HEIGHT, WIDTH);
        this.player = new Player(10, WIDTH - 10);
        this.barrels = createBarrels();
        this.canvas.draw();
    }

    public void start() throws InterruptedException {

        while (true) {

            checkCollision();

            if (player.getIsJumping()) {

                this.playerJump();

                this.playerFall();

            }

            for (GameObject b : this.barrels) {
                ((Barrel) b).move();

            }

            Thread.sleep(40);

        }


    }

    private void playerJump() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            this.player.jumpUp();
            for (GameObject b : this.barrels) {
                ((Barrel) b).move();

            }
            Thread.sleep(40);
        }
    }

    private void playerFall() throws InterruptedException {
        for (int i = 0; i > JUMP_HEIGHT; i--) {
            this.player.fall();
            for (GameObject b : this.barrels) {
                ((Barrel) b).move();

            }
            Thread.sleep(40);
        }

        this.player.setJumping(false);
    }

    private Barrel[] createBarrels() {

        Barrel[] barrels = new Barrel[MAX_BARRELS];

        for (int i = 0; i < barrels.length; i++) {
            barrels[i] = new Barrel();
        }

        return barrels;
    }

    private void checkCollision(){

        for( Collidable a : barrels){
            if(this.player.hasCollided(a)){
                this.player.setColorRed();
            }
        }
    }
}
