package reghzy.guigl.core.render.controls;

import reghzy.guigl.core.controls.primitive.Border;
import reghzy.guigl.core.render.ElementRenderer;
import reghzy.guigl.core.render.Tesselator;
import reghzy.guigl.maths.Vector2;

public class BorderRenderer extends ElementRenderer<Border> {
    @Override
    public void render(Border border, Tesselator tesselator) {
        float absoluteX = border.getAbsoluteX();
        float absoluteY = border.getAbsoluteY();
        Vector2 size = border.getActualSize();
        tesselator.setActiveColour(border.getActiveBorder());
        tesselator.drawRectangleFill(absoluteX, absoluteY, absoluteX + size.x, absoluteY + size.y);
        tesselator.setActiveColour(border.getActiveBackground());
        tesselator.drawRectangleFill(absoluteX + border.getMargin().left,
                                     absoluteY + border.getMargin().top,
                                     absoluteX + size.x - border.getMargin().right,
                                     absoluteY + size.y - border.getMargin().bottom);
    }

    @Override
    public void init() { }

    @Override
    public void destroy() { }
}
