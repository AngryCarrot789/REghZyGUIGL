package reghzy.guigl.core.controls;

import reghzy.guigl.core.event.control.ChildChangedEvent;

/**
 * A ContentControl is simply a framework element that contains a child control, and nothing else
 */
public class ContentControl extends FrameworkElement {
    private FrameworkElement child;

    public ContentControl() {

    }

    public FrameworkElement getChild() {
        return child;
    }

    public void setChild(FrameworkElement child) {
        FrameworkElement before = this.child;
        this.child = child;
        if (this.eventMap.hasListeners(ChildChangedEvent.class)) {
            this.eventMap.sendEvent(new ChildChangedEvent(before, this));
        }
    }
}
