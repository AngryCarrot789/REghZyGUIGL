package reghzy.guigl.core.render.controls;

import reghzy.guigl.core.controls.primitive.Rectangle;
import reghzy.guigl.core.render.ElementRenderer;
import reghzy.guigl.core.render.Tesselator;
import reghzy.guigl.maths.Vector2;

public class RectangleRenderer extends ElementRenderer<Rectangle> {
    @Override
    public void render(Rectangle rectangle, Tesselator tesselator) {
        float absoluteX = rectangle.getAbsoluteX();
        float absoluteY = rectangle.getAbsoluteY();
        Vector2 size = rectangle.getActualSize();
        Tesselator.instance.drawRectangleFill(absoluteX, absoluteY, absoluteX + size.x, absoluteY + size.y);
    }

    @Override
    public void init() { }

    @Override
    public void destroy() { }
}
