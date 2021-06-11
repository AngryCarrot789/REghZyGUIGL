package reghzy.guigl.core.event.window;

import reghzy.guigl.core.controls.UIElement;
import reghzy.guigl.core.controls.Window;
import reghzy.guigl.core.event.Event;

public class TitleChangedEvent extends Event {
    private final Window window;
    private final String titleBefore;

    public TitleChangedEvent(UIElement element, Window window, String titleBefore) {
        super(element);
        this.window = window;
        this.titleBefore = titleBefore;
    }

    public Window getWindow() {
        return window;
    }

    public String getTitleBefore() {
        return titleBefore;
    }
}
