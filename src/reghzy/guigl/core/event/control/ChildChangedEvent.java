package reghzy.guigl.core.event.control;

import reghzy.guigl.core.controls.FrameworkElement;
import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.event.Event;

public class ChildChangedEvent extends Event {
    private final FrameworkElement previousChild;

    public ChildChangedEvent(FrameworkElement previousChild, UIElement element) {
        super(element);
        this.previousChild = previousChild;
    }

    public FrameworkElement getPreviousChild() {
        return previousChild;
    }
}
