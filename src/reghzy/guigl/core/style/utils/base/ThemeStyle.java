package reghzy.guigl.core.style.utils.base;

import reghzy.guigl.core.style.Colour;

/**
 * A theme styles is something that links a Style to a Colour
 */
public interface ThemeStyle {
    Style getStyle();
    Colour getColour();
}
