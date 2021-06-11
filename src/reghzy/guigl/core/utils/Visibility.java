package reghzy.guigl.core.utils;

/**
 * The renderability of a control, and whether its present (aka whether its
 * treated as existing or not, used for updating positions of other controls)
 */
public enum Visibility {
    /**
     * Renderable and present
     */
    visible,

    /**
     * Not renderable, but present
     */
    hidden,

    /**
     * Not renderable and is not present
     */
    collapsed
}
