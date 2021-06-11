package reghzy.guigl.core.controls.primitive;

import reghzy.guigl.core.controls.FrameworkElement;
import reghzy.guigl.core.style.Colour;
import reghzy.guigl.core.style.utils.base.StyleSheet;

public abstract class Shape extends FrameworkElement {
    private Colour activeBackground;
    private Colour activeBorder;

    public Shape() {
        this.activeBackground = getBackgroundColour();
        this.activeBorder = getBorderColour();
    }

    public Colour getBackgroundColour() {
        return this.resourceDictionary.getResource(StyleSheet.defaultBackground).getColour();
    }

    public Colour getBorderColour() {
        return this.resourceDictionary.getResource(StyleSheet.defaultBorder).getColour();
    }

    public Colour getMouseOverBackgroundColour() {
        return this.resourceDictionary.getResource(StyleSheet.mouseOverBackground).getColour();
    }

    public Colour getMouseOverBorderColour() {
        return this.resourceDictionary.getResource(StyleSheet.mouseOverBorder).getColour();
    }

    public Colour getActiveBackground() {
        return activeBackground;
    }

    public void setActiveBackground(Colour activeBackground) {
        this.activeBackground = activeBackground;
    }

    public Colour getActiveBorder() {
        return activeBorder;
    }

    public void setActiveBorder(Colour activeBorder) {
        this.activeBorder = activeBorder;
    }

    @Override
    public void onMouseEnter() {
        super.onMouseEnter();
        setActiveBackground(getMouseOverBackgroundColour());
        setActiveBorder(getMouseOverBorderColour());
    }

    @Override
    public void onMouseLeave() {
        super.onMouseLeave();
        setActiveBackground(getBackgroundColour());
        setActiveBorder(getBorderColour());
    }
}
