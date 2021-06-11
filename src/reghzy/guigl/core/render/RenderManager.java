package reghzy.guigl.core.render;

import reghzy.guigl.core.controls.FrameworkElement;
import reghzy.guigl.core.controls.primitive.Rectangle;
import reghzy.guigl.core.render.controls.RectangleRenderer;

import java.util.HashMap;
import java.util.Map;

public class RenderManager {
    private final Map<Class<? extends FrameworkElement>, IElementRenderer<? extends FrameworkElement>> elementRenderers;

    private boolean isRegistered;

    public RenderManager() {
        this.elementRenderers = new HashMap<>();
    }

    public void registerPrimitiveRenderers() {
        if (isRegistered) {
            throw new RuntimeException("Cannot re-register primitive element renderers!");
        }

        registerRenderer(Rectangle.class, new RectangleRenderer());

        this.isRegistered = true;
    }

    public <E extends FrameworkElement> void renderElement(E element) {
        IElementRenderer<E> renderer;
        try {
            renderer = (IElementRenderer<E>) getRenderer(element.getClass());
        }
        catch (ClassCastException e) {
            throw new UnsupportedOperationException("The renderer for the class " + element.getClass().getName() + " was very wrong! " + e.getMessage());
        }

        if (renderer == null) {
            throw new UnsupportedOperationException("The renderer for the class " + element.getClass().getName() + " does not exist!");
        }

        renderer.startRender(element, Tesselator.instance);
    }

    /**
     * Registers an element renderer
     * @param elementClass The class of the element to be rendered
     * @param renderer The renderer itself
     * @param <E> The type of the element (generic)
     */
    public <E extends FrameworkElement> void registerRenderer(Class<E> elementClass, IElementRenderer<E> renderer) {
        this.elementRenderers.put(elementClass, renderer);
    }

    /**
     * Unregisters an element renderer (this is usually a bad thing to do...)
     * @param elementClass The class of the element to be rendered
     * @param <E> The type of the element (generic)
     */
    public <E extends FrameworkElement> void unregisterRenderer(Class<E> elementClass) {
        this.elementRenderers.remove(elementClass);
    }

    /**
     * Gets the element renderer for an element. returns null if one doesn't exist
     * @param elementClass The class of the element to be rendered
     * @param <E> The type of the element (generic)
     */
    public <E extends FrameworkElement> IElementRenderer<E> getRenderer(Class<E> elementClass) {
        return (IElementRenderer<E>) this.elementRenderers.get(elementClass);
    }
}
