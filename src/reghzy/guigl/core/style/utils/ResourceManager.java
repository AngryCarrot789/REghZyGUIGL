package reghzy.guigl.core.style.utils;

import reghzy.guigl.core.style.builtin.DarkThemeDictionary;

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

    public static ResourceDictionary getDefaultTheme() {
        return getDark();
    }

    static {
        primitiveDark = new DarkThemeDictionary();
    }
}
