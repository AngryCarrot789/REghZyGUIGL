package reghzy.guigl.core.event;

import reghzy.guigl.core.controls.UIElement;

/**
 * An event is called whenever "something" happens, in respect to a specific UIElement, e.g. MouseOver events
 */
public class Event {
    private final UIElement element;

    public Event(UIElement element) {
        this.element = element;
    }

    public UIElement getElement() {
        return element;
    }
}
