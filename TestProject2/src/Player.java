import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements Movable, KeyboardHandler {


    private Rectangle rectangle;
    private Keyboard keyboard;
    private static final int PLAYER_BOX = 20;
    private static final int SPEED = 3;
    private boolean isJumping;
    private int m;
    private boolean Collided;

    public Player(int x, int y) {

        this.rectangle = new Rectangle(x, y, PLAYER_BOX, PLAYER_BOX);
        this.rectangle.draw();
        this.setKeyboard();
        this.m = 0;
        this.isJumping = false;
        this.Collided = false;
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

    public void fall() {

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

    public void setJumping(boolean value) {
        this.isJumping = value;
    }

    public boolean getIsJumping() {
        return this.isJumping;
    }

    public boolean hasCollided(Collidable e) {

        Point[] playerBox = this.collisionBox();
        Point[] gameObjectBox = e.collisionBox();

        for (Point playerPoints : playerBox) {
            for (Point gameObjectPoints : gameObjectBox) {
                if (playerPoints.compare(gameObjectPoints)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Point[] collisionBox() {

        int x1 = this.rectangle.getX();
        int x2 = this.rectangle.getX() + PLAYER_BOX;
        int y1 = this.rectangle.getY();
        int y2 = this.rectangle.getY() + PLAYER_BOX;

        Point[] collisionBox = new Point[PLAYER_BOX * 4];

        for (int i = 0; i < PLAYER_BOX; i++) {
            collisionBox[i] = new Point(x1 + i, y1);
        }

        for (int i = PLAYER_BOX; i < (PLAYER_BOX * 2); i++) {
            collisionBox[i] = new Point(x2 + (i - PLAYER_BOX), y2);
        }

        for (int i = (PLAYER_BOX * 2); i < (PLAYER_BOX * 3); i++) {
            collisionBox[i] = new Point(x1, y1 - (i - (PLAYER_BOX * 2)));
        }

        for (int i = (PLAYER_BOX * 3); i < (PLAYER_BOX * 4); i++) {
            collisionBox[i] = new Point(x2, y2 + (i - (PLAYER_BOX * 3)));
        }


        return collisionBox;

    }

    public void setColorRed() {
        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();
    }


}
