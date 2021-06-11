package reghzy.guigl.core.render;

import reghzy.guigl.core.controls.FrameworkElement;
import reghzy.guigl.core.utils.Visibility;

public abstract class ElementRenderer<E extends FrameworkElement> implements IElementRenderer<E> {
    public boolean canRender(E element) {
        return element.isEnabled() && element.getVisibility().equals(Visibility.visible);
    }

    public abstract void render(E element, Tesselator tesselator);

    @Override
    public void startRender(E element, Tesselator tesselator) {
        if (canRender(element)) {
            render(element, tesselator);
        }
    }
}
