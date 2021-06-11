package reghzy.guigl.core.event.control;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;

public class IsEnabledChangedEvent extends Event {
    private final boolean before;

    public IsEnabledChangedEvent(UIElement element, boolean before) {
        super(element);
        this.before = before;
    }

    public boolean isBefore() {
        return before;
    }
}
