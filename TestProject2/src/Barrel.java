import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Barrel extends GameObject implements Movable {

    private static final int BARREL_R = 20;
    private Ellipse barrel;

    public Barrel(){
        this.barrel = new Ellipse(Math.random()*500, Math.random()*500, BARREL_R, BARREL_R);
        this.barrel.draw();
    }

    public void move(){

        int x = Math.random() > 0.5 ? -1 : 1;
        int y = Math.random() > 0.5 ? -1 : 1;

        this.barrel.translate(Math.random() * x, Math.random() * y);

    }

}
