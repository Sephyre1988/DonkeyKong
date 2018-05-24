import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements Movable, KeyboardHandler {


    private Rectangle rectangle;
    private Keyboard keyboard;

    private static final int SPEED = 3;
    private boolean isJumping;
    private int m;

    public Player(int x, int y) {

        this.rectangle = new Rectangle(x, y, 20, 20);
        this.rectangle.draw();
        this.setKeyboard();
        this.m = 0;
        this.isJumping = false;
    }

    public void move(int x, int y) {
        this.rectangle.translate(x, y);
    }

    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_RIGHT: {
                this.move(SPEED, m);
                break;
            }
            case KeyboardEvent.KEY_LEFT: {
                this.move(-SPEED, m);
                break;
            }
            case KeyboardEvent.KEY_SPACE: {
                this.setJumping(true);
            }

        }
    }

    public void jumpUp() throws InterruptedException {

            this.move(0, -1);


    }

    public void fall(){

            this.move(0, 1);

    }

    public void keyReleased(KeyboardEvent ever) {

    }

    public void setKeyboard() {

        this.keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(up);

    }

    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setJumping(boolean value){
        this.isJumping = value;
    }

    public boolean getIsJumping(){
        return this.isJumping;
    }


}
