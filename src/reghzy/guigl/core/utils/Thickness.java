package reghzy.guigl.core.utils;

public class Thickness {
    public float left;
    public float top;
    public float right;
    public float bottom;

    public Thickness() {
        this(0.0f);
    }

    public Thickness(float all) {
        this.left = all;
        this.right = all;
        this.top = all;
        this.bottom = all;
    }

    public Thickness(float horizontal, float vertical) {
        this.left = horizontal;
        this.right = horizontal;
        this.top = vertical;
        this.bottom = vertical;
    }

    public Thickness(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void set(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void set(float all) {
        this.left = all;
        this.top = all;
        this.right = all;
        this.bottom = all;
    }

    public void setHorizontal(float left, float right) {
        this.left = left;
        this.right = right;
    }

    public void setVertical(float top, float bottom) {
        this.top = top;
        this.bottom = bottom;
    }
}
