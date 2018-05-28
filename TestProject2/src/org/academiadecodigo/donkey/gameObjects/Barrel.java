package org.academiadecodigo.donkey.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Barrel extends GameObject implements Movable, Collidable {

    private static final int BARREL_RADIUS = 20;
    private Ellipse barrel;

    public Barrel() {
        this.barrel = new Ellipse(Math.random() * 500, Math.random() * 500, BARREL_RADIUS, BARREL_RADIUS);
        this.barrel.draw();
    }

    public void move() {

        int x = Math.random() > 0.5 ? -1 : 1;
        int y = Math.random() > 0.5 ? -1 : 1;

        this.barrel.translate(Math.random() * x, Math.random() * y);

    }

    public Point[] collisionBox() {

        int x1 = this.barrel.getX();
        int x2 = this.barrel.getX() + BARREL_RADIUS;
        int y1 = this.barrel.getY();
        int y2 = this.barrel.getY() + BARREL_RADIUS;

        Point[] collisionBox = new Point[BARREL_RADIUS * 4];

        for (int i = 0; i < BARREL_RADIUS; i++) {
            collisionBox[i] = new Point(x1 + i, y1);
        }

        for (int i = BARREL_RADIUS; i < (BARREL_RADIUS * 2); i++) {
            collisionBox[i] = new Point(x2 + (i - BARREL_RADIUS), y2);
        }

        for (int i = (BARREL_RADIUS * 2); i < (BARREL_RADIUS * 3); i++) {
            collisionBox[i] = new Point(x1, y1 - (i - (BARREL_RADIUS * 2)));
        }

        for (int i = (BARREL_RADIUS * 3); i < (BARREL_RADIUS * 4); i++) {
            collisionBox[i] = new Point(x2, y2 + (i - (BARREL_RADIUS * 3)));
        }


        return collisionBox;

    }

}
