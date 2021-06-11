package reghzy.guigl.core.style.utils;

import reghzy.guigl.core.style.builtin.DarkTheme;

/**
 * Contains a few builtin resource dictionaries
 */
public class ResourceManager {
    private static final ResourceDictionary primitiveDark;

    /**
     * Returns a copy of the builtin dark theme resource dictionary
     */
    public static ResourceDictionary getDark() {
        return primitiveDark.copy();
    }

    static {
        primitiveDark = new ResourceDictionary();
        primitiveDark.putResource(DarkTheme.WindowBackground.getStyle(), DarkTheme.WindowBackground.getColour());
        primitiveDark.putResource(DarkTheme.WindowBorder.getStyle(), DarkTheme.WindowBorder.getColour());
        primitiveDark.putResource(DarkTheme.ContainerBackground.getStyle(), DarkTheme.ContainerBackground.getColour());
        primitiveDark.putResource(DarkTheme.ContainerBorder.getStyle(), DarkTheme.ContainerBorder.getColour());
        primitiveDark.putResource(DarkTheme.DarkBackground.getStyle(), DarkTheme.DarkBackground.getColour());
        primitiveDark.putResource(DarkTheme.DarkBorder.getStyle(), DarkTheme.DarkBorder.getColour());
        primitiveDark.putResource(DarkTheme.DefaultBackground.getStyle(), DarkTheme.DefaultBackground.getColour());
        primitiveDark.putResource(DarkTheme.DefaultBorder.getStyle(), DarkTheme.DefaultBorder.getColour());
        primitiveDark.putResource(DarkTheme.BrightBackground.getStyle(), DarkTheme.BrightBackground.getColour());
        primitiveDark.putResource(DarkTheme.BrightBorder.getStyle(), DarkTheme.BrightBorder.getColour());
        primitiveDark.putResource(DarkTheme.MouseDownBackground.getStyle(), DarkTheme.MouseDownBackground.getColour());
        primitiveDark.putResource(DarkTheme.MouseDownBorder.getStyle(), DarkTheme.MouseDownBorder.getColour());
        primitiveDark.putResource(DarkTheme.MouseOverBackground.getStyle(), DarkTheme.MouseOverBackground.getColour());
        primitiveDark.putResource(DarkTheme.MouseOverBorder.getStyle(), DarkTheme.MouseOverBorder.getColour());
        primitiveDark.putResource(DarkTheme.DefaultForeground.getStyle(), DarkTheme.DefaultForeground.getColour());
        primitiveDark.putResource(DarkTheme.DisabledForeground.getStyle(), DarkTheme.DisabledForeground.getColour());
    }
}
