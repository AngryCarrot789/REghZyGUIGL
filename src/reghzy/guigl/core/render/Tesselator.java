package reghzy.guigl.core.render;

import org.lwjgl.opengl.GL11;
import reghzy.guigl.core.style.Colour;
import reghzy.guigl.window.Window;
import sun.plugin.dom.exception.InvalidStateException;

public class Tesselator {
    public static Tesselator instance;

    private final Window window;
    private boolean isTesselating;

    public Tesselator(Window window) {
        instance = this;
        this.window = window;
        init();
    }

    public void init() {
        this.isTesselating = true;
    }

    public void preDraw() {
        checkCanTesselate();
    }

    private void checkCanTesselate() {
        if (!isTesselating) {
            throw new InvalidStateException("Not tesselating!");
        }
    }

    public void postDraw() {

    }

    public void setActiveColour(Colour colour) {
        setActiveColour(colour.getRed() / 255.0f, colour.getGreen() / 255.0f, colour.getBlue() / 255.0f, colour.getAlpha() / 255.0f);
    }


    public void setActiveColour(float r, float g, float b) {
        GL11.glColor4f(r, g, b, 1.0f);
    }


    public void setActiveColour(float r, float g, float b, float a) {
        GL11.glColor4f(r, g, b, a);
    }


    public void clearBackground() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }


    public void clearBackgroundColour(Colour colour) {
        GL11.glClearColor(colour.getRed() / 255.0f, colour.getGreen() / 255.0f, colour.getBlue() / 255.0f, colour.getAlpha() / 255.0f);
    }


    public void clearBackgroundColour(float r, float g, float b) {
        GL11.glClearColor(r, g, b, 1.0f);
    }


    public void clearBackgroundColour(float r, float g, float b, float a) {
        GL11.glClearColor(r, g, b, a);
    }


    public void setLineThickness(float thickness) {
        GL11.glLineWidth(thickness);
    }


    public void drawRectangleOutline(float x1, float y1, float x2, float y2) {
        preDraw();
        float ndcX1 = CoordinateHelper.screenToNdcX(x1, (float) this.window.getWidth());
        float ndcY1 = CoordinateHelper.screenToNdcY(y1, (float) this.window.getHeight());
        float ndcX2 = CoordinateHelper.screenToNdcX(x2, (float) (this.window.getDesktopX() + this.window.getWidth()));
        float ndcY2 = CoordinateHelper.screenToNdcY(y2, (float) (this.window.getDesktopY() + this.window.getHeight()));

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(ndcX1, ndcY1, 0);
        GL11.glVertex3f(ndcX2, ndcY1, 0);
        GL11.glVertex3f(ndcX2, ndcY2, 0);
        GL11.glVertex3f(ndcX1, ndcY2, 0);
        GL11.glEnd();
        postDraw();
    }


    public void drawRectangleFill(float x1, float y1, float x2, float y2) {
        preDraw();
        float ndcX1 = CoordinateHelper.screenToNdcX(x1, (float) this.window.getWidth());
        float ndcY1 = CoordinateHelper.screenToNdcY(y1, (float) this.window.getHeight());
        float ndcX2 = CoordinateHelper.screenToNdcX(x2, (float) this.window.getWidth());
        float ndcY2 = CoordinateHelper.screenToNdcY(y2, (float) this.window.getHeight());

        GL11.glColor3f(0.2f, 0.3f, 0.8f);
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            GL11.glVertex3f(ndcX2, ndcY2, 0);
            GL11.glVertex3f(ndcX2, ndcY1, 0);
            GL11.glVertex3f(ndcX1, ndcY1, 0);
        }
        GL11.glEnd();
         GL11.glBegin(GL11.GL_TRIANGLES);
         {
             GL11.glVertex3f(ndcX1, ndcY1, 0);
             GL11.glVertex3f(ndcX1, ndcY2, 0);
             GL11.glVertex3f(ndcX2, ndcY2, 0);
         }
        GL11.glEnd();
        postDraw();
    }


    public void drawLine(float x1, float y1, float x2, float y2) {
        float ndcX1 = CoordinateHelper.screenToNdcX(x1, (float) this.window.getWidth());
        float ndcY1 = CoordinateHelper.screenToNdcY(y1, (float) this.window.getHeight());
        float ndcX2 = CoordinateHelper.screenToNdcX(x2, (float) (this.window.getDesktopX() + this.window.getWidth()));
        float ndcY2 = CoordinateHelper.screenToNdcY(y2, (float) (this.window.getDesktopY() + this.window.getHeight()));

        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(ndcX1, ndcY1, 0);
        GL11.glVertex3f(ndcX2, ndcY2, 0);
        GL11.glEnd();
    }
}
