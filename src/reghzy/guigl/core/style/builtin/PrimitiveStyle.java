package reghzy.guigl.core.style.builtin;

import reghzy.guigl.core.style.utils.base.Style;

/**
 * Primitive styles are the fundamental styles this framework uses (background colours, foreground/text colours, etc)
 * <p>
 *     These should always be available to any control (unless youre trying to cut down the memory usage...)
 * </p>
 */
public enum PrimitiveStyle implements Style {
    WindowBackground    ("windowBackground"   ),
    WindowBorder        ("windowBorder"       ),
    ContainerBackground ("containerBackground"),
    ContainerBorder     ("containerBorder"    ),
    DarkBackground      ("darkBackground"     ),
    DarkBorder          ("darkBorder"         ),
    DefaultBackground   ("defaultBackground"  ),
    DefaultBorder       ("defaultBorder"      ),
    BrightBackground    ("brightBackground"   ),
    BrightBorder        ("brightBorder"       ),
    MouseOverBackground ("mouseOverBackground"),
    MouseOverBorder     ("mouseOverBorder"    ),
    MouseDownBackground ("mouseDownBackground"),
    MouseDownBorder     ("mouseDownBorder"    ),
    DefaultForeground   ("defaultForeground"  ),
    DisabledForeground  ("disabledForeground" );

    private final String name;

    PrimitiveStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
