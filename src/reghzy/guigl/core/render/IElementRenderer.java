package reghzy.guigl.core.render;

import reghzy.guigl.core.controls.FrameworkElement;

public interface IElementRenderer<E extends FrameworkElement> {
    void init();
    void destroy();

    void startRender(E element, Tesselator tesselator);
}
