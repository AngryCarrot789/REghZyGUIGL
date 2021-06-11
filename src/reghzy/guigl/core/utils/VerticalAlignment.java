package reghzy.guigl.core.utils;

public enum VerticalAlignment {
    /**
     * The element's position will stick to the top, and will be offset (moved down) by the margin's top value
     */
    top,
    /**
     * The element will try to stay vertically in the middle of its parent (based on the parent size and element's size). Margin will not affect this
     */
    center,
    /**
     * The element's position will stick to the bottom, and will be offset (moved up) by the margin's bottom value
     */
    bottom,
    /**
     * The element's will take up the entire parent's vertical space, offset (moved down/up respectfully) by the margin's top and bottom value
     */
    stretch,
    /**
     * Vertical alignment does not affect the element at all (only used for windows... probably)
     */
    NONE;
}
