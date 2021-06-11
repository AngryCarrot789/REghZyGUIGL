package reghzy.guigl.core.event.control;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.controls.Window;
import reghzy.guigl.core.event.Event;
import reghzy.guigl.maths.Vector2;

public class PositionChangedEvent extends Event {
    private final Vector2 previousPosition;

    public PositionChangedEvent(UIElement element, Vector2 previousPosition) {
        super(element);
        this.previousPosition = previousPosition;
    }

    public Vector2 getPreviousPosition() {
        return previousPosition;
    }
}
