import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Test {


    public static void main(String[] args) {


        Game game = new Game();

        try {

            game.start();

        } catch (InterruptedException e) {
            System.out.println("This is an Interrupted Exception");
            e.printStackTrace();
        }
    }


}
