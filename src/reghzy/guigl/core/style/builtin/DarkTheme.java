package reghzy.guigl.core.style.builtin;

import reghzy.guigl.core.style.Colour;
import reghzy.guigl.core.style.utils.base.Style;
import reghzy.guigl.core.style.utils.base.ThemeStyle;

/**
 * Contains an implementation for ThemeStyles, with dark colours
 */
public enum DarkTheme implements ThemeStyle {
    WindowBackground    (PrimitiveStyle.WindowBackground,    24, 24, 24),
    WindowBorder        (PrimitiveStyle.WindowBorder,        28, 28, 28),
    ContainerBackground (PrimitiveStyle.ContainerBackground, 27, 27, 27),
    ContainerBorder     (PrimitiveStyle.ContainerBorder,     31, 31, 31),
    DarkBackground      (PrimitiveStyle.DarkBackground,      35, 35, 35),
    DarkBorder          (PrimitiveStyle.DarkBorder,          42, 42, 42),
    DefaultBackground   (PrimitiveStyle.DefaultBackground,   38, 38, 38),
    DefaultBorder       (PrimitiveStyle.DefaultBorder,       45, 45, 45),
    BrightBackground    (PrimitiveStyle.BrightBackground,    41, 41, 41),
    BrightBorder        (PrimitiveStyle.BrightBorder,        48, 48, 48),
    MouseOverBackground (PrimitiveStyle.MouseOverBackground, 56, 56, 56),
    MouseOverBorder     (PrimitiveStyle.MouseOverBorder,     63, 63, 63),
    MouseDownBackground (PrimitiveStyle.MouseDownBackground, 50, 50, 50),
    MouseDownBorder     (PrimitiveStyle.MouseDownBorder,     58, 58, 58),
    DefaultForeground   (PrimitiveStyle.DefaultForeground,   240, 240, 240),
    DisabledForeground  (PrimitiveStyle.DisabledForeground,  210, 210, 210);

    private final Style style;
    private final Colour colour;

    DarkTheme(Style style, int r, int g, int b) {
        this.style = style;
        this.colour = new Colour(r, g, b);
    }

    public Style getStyle() {
        return style;
    }

    public Colour getColour() {
        return colour;
    }
}
