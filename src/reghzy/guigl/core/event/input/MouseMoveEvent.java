package reghzy.guigl.core.event.input;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;
import reghzy.guigl.maths.Vector2;

public class MouseMoveEvent extends Event {
    private final Vector2 mousePosition;

    public MouseMoveEvent(Vector2 mousePosition, UIElement element) {
        super(element);
        this.mousePosition = mousePosition;
    }

    public Vector2 getMousePosition() {
        return mousePosition;
    }
}
