package reghzy.guigl.core.event.input;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;
import reghzy.guigl.maths.Vector2;

public class MouseMoveEvent extends Event {
    public MouseMoveEvent(UIElement element) {
        super(element);
    }
}
