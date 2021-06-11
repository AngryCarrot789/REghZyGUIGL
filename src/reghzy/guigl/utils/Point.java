package reghzy.guigl.utils;

public class Point {
    private float x;
    private float y;

    public Point() { }

    public Point(float a) {
        this.x = a;
        this.y = a;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void set(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void set(float a) {
        this.x = a;
        this.y = a;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
