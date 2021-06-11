package reghzy.guigl.core.controls.primitive;

import reghzy.guigl.core.utils.Thickness;

public class Border extends Shape {
    private Thickness borderThickness;

    public Border() {
        this.borderThickness = new Thickness(10);
    }

    public Thickness getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(Thickness borderThickness) {
        Thickness before = this.borderThickness;
        this.borderThickness = borderThickness;
        //if (this.eventMap.hasListeners(MarginChangedEvent.class)) {
        //    this.eventMap.sendEvent(new MarginChangedEvent(this, before));
        //}
    }
}
