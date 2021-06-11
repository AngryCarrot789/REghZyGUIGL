package reghzy.guigl.core.style;

/**
 * A set of 4 values, red, green, blue and alpha (transparency).
 * <p>
 * Their value should always be between 0 and 255.
 * </p>
 * <p>
 * Also provides function for converting between 0-255 values and 0-1 values (for opengl),
 * and also has a function for instead setting the opengl colour (by calcuating the 0-1 values from 0-255)
 * </p>
 */
public class Colour {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public Colour(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = 255;
    }

    public Colour(int r, int g, int b, int a) {
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;
    }

    public void set(Colour colour) {
        this.red = colour.red;
        this.green = colour.green;
        this.blue = colour.blue;
        this.alpha = colour.alpha;
    }

    public void set(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 255;
    }

    public void set(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
