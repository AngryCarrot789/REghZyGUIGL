package reghzy.guigl.core.style.utils.base;

/**
 * The stylesheet contains all of the primitive resource names
 */
public enum StyleSheet implements Style {
    windowBackground("windowBackground"),
    windowBorder("windowBorder"),
    containerBackground("containerBackground"),
    containerBorder("containerBorder"),
    darkBackground("darkBackground"),
    darkBorder("darkBorder"),
    defaultBackground("defaultBackground"),
    defaultBorder("defaultBorder"),
    brightBackground("brightBackground"),
    brightBorder("brightBorder"),
    mouseOverBackground("mouseOverBackground"),
    mouseOverBorder("mouseOverBorder"),
    mouseDownBackground("mouseDownBackground"),
    mouseDownBorder("mouseDownBorder"),
    defaultForeground("defaultForeground"),
    disabledForeground("disabledForeground"),
    ;

    private final String name;

    StyleSheet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
