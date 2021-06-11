package reghzy.guigl.core.event.control;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;
import reghzy.guigl.core.utils.Thickness;

public class MarginChangedEvent extends Event {
    private final Thickness before;

    public MarginChangedEvent(UIElement element, Thickness before) {
        super(element);
        this.before = before;
    }

    public Thickness getBefore() {
        return before;
    }
}
