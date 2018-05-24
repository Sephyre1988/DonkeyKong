public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public boolean compare(Point a){
        return this.x == a.getX() && this.y == a.getY();
    }

}
