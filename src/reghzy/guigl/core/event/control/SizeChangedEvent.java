package reghzy.guigl.core.event.control;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;
import reghzy.guigl.maths.Vector2;

public class SizeChangedEvent extends Event {
    private final Vector2 previousSize;

    public SizeChangedEvent(UIElement element, Vector2 previousSize) {
        super(element);
        this.previousSize = previousSize;
    }

    public Vector2 getPreviousSize() {
        return previousSize;
    }
}
