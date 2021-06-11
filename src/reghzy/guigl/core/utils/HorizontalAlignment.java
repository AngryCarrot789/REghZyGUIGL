package reghzy.guigl.core.utils;

public enum HorizontalAlignment {
    /**
     * The element's position will stick to the left side, and will be offset (moved right) by the margin's left value
     */
    left,
    /**
     * The element will try to stay horizontally in the middle of its parent (based on the parent size and element's size). Margin will not affect this
     */
    center,
    /**
     * The element's position will stick to the right side, and will be offset (moved left) by the margin's right value
     */
    right,
    /**
     * The element's will take up the entire parent's horizontal space, offset (moved right/left respectfully) by the margin's left and right value
     */
    stretch,
    /**
     * Horizontal alignment does not affect the element at all (only used for windows... probably)
     */
    NONE;
}
