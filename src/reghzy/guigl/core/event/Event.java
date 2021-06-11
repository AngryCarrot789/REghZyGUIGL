package reghzy.guigl.core.event;

import reghzy.guigl.core.controls.UIElement;

public class Event {
    private final UIElement element;

    public Event(UIElement element) {
        this.element = element;
    }

    public UIElement getElement() {
        return element;
    }
}
