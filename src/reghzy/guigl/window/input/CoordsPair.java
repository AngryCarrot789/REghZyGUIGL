package reghzy.guigl.window.input;

/**
 * A pair of coordinates (x and y), mainly used for internal use (like mouse position)
 */
public class CoordsPair {
    public double x;
    public double y;

    public CoordsPair(double x, double y) {
        set(x, y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(CoordsPair coords) {
        this.x = coords.x;
        this.y = coords.y;
    }
}
