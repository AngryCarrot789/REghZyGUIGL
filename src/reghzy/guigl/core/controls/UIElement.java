package reghzy.guigl.core.controls;

import reghzy.guigl.Application;
import reghzy.guigl.core.event.EventMap;
import reghzy.guigl.core.utils.HorizontalAlignment;
import reghzy.guigl.core.utils.Thickness;
import reghzy.guigl.core.utils.VerticalAlignment;
import reghzy.guigl.maths.Vector2;
import reghzy.guigl.window.Window;

/**
 * A UI Element is the base class for all visual elements. they have a position
 * relative to their parent, based on their margin, and an event map for listening to events
 */
public class UIElement {
    private static int nextId;

    /**
     * The parent of this UIElement
     */
    protected UIElement parent;

    /**
     * The horizontal alignment of this UIElement relative to its parent
     */
    protected HorizontalAlignment horizontalAlignment;

    /**
     * The vertical alignment of this UIElement relative to its parent
     */
    protected VerticalAlignment verticalAlignment;

    /**
     * The margin of this UIElement relative to its parent, aka the offset from each side (margin.left = 5 means its moved 5 pixels right)
     */
    protected final Thickness margin;

    /**
     * The position of this UIElement. this should never really be manually edited, you should instead use the margin
     * <p>
     *     This is used directly when rendering, so
     * </p>
     */
    protected final Vector2 position;

    /**
     * The target size (width, height) of this element
     */
    protected Vector2 targetSize;

    /**
     * The actual size (width, height) of this element
     */
    protected Vector2 actualSize;

    /**
     * The map that contains all event handlers for this UIElement
     */
    protected EventMap eventMap;

    protected boolean isEnabled;

    /**
     * The ID of this element
     */
    protected final int id;

    public UIElement() {
        this.id = nextId++;
        this.margin = new Thickness();
        this.horizontalAlignment = HorizontalAlignment.left;
        this.verticalAlignment = VerticalAlignment.top;
        this.position = new Vector2();
        this.targetSize = new Vector2();
        this.actualSize = new Vector2();
        this.eventMap = new EventMap();
        this.isEnabled = true;
    }

    public Thickness getMargin() {
        return margin;
    }

    public HorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public VerticalAlignment getVerticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    public UIElement getParent() {
        return this.parent;
    }

    public void setParent(UIElement parent) {
        this.parent = parent;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getActualSize() {
        return this.actualSize;
    }

    /**
     * The position of this UIElement, relative to the top left corner of the host window (not the parent UIElements)
     */
    public Vector2 getAbsolutePosition() {
        Vector2 screenPos = new Vector2(this.position.x, this.position.y);
        for(UIElement element = this.parent; element != null; element = element.parent) {
            screenPos.add(element.position);
        }
        return screenPos;
    }

    public float getAbsoluteX() {
        float startX = this.position.x;
        for (UIElement element = this.parent; element != null; element = element.parent) {
            startX += element.position.x;
        }
        return startX;
    }

    public float getAbsoluteY() {
        float startY = this.position.y;
        for (UIElement element = this.parent; element != null; element = element.parent) {
            startY += element.position.y;
        }
        return startY;
    }

    public void update() {
        switch (this.horizontalAlignment) {
            case left: {
                if (this.parent == null) {
                    this.position.x = this.margin.left;
                }
                else {
                    this.position.x = this.parent.position.x + this.margin.left;
                }
            }
            break;
            case center: {
                float startX;
                float endX;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    startX = 0;
                    endX = (float) window.getWidth();
                }
                else {
                    startX = this.parent.getAbsoluteX();
                    endX = (startX + this.parent.actualSize.x);
                }

                this.position.x = ((endX - startX) / 2) - (this.actualSize.x / 2);
            }
            break;
            case right: {
                float endX;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    endX = (float) window.getWidth();
                }
                else {
                    endX = (this.parent.getAbsoluteX() + this.parent.actualSize.x);
                }

                this.position.x = (endX - this.margin.right) - this.actualSize.x;
            }
            break;
            case stretch: {
                this.position.x = this.margin.left;
                float endX;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    endX = (float) window.getWidth();
                }
                else {
                    endX = (this.parent.getAbsoluteX() + this.parent.actualSize.x);
                }

                this.actualSize.x = (endX - this.margin.right) - this.position.x;
            }
            break;
        }

        switch (verticalAlignment) {
            case top: {
                if (this.parent == null) {
                    this.position.y = this.margin.top;
                }
                else {
                    this.position.y = this.parent.position.y + this.margin.top;
                }
            }
            break;
            case center: {
                float startY;
                float endY;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    startY = 0;
                    endY = (float) window.getHeight();
                }
                else {
                    startY = this.parent.getAbsoluteY();
                    endY = (startY + this.parent.actualSize.y);
                }

                this.position.y = ((endY - startY) / 2) - (this.actualSize.y / 2);
            }
            break;
            case bottom: {
                float endY;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    endY = (float) window.getHeight();
                }
                else {
                    endY = (this.parent.getAbsoluteY() + this.parent.actualSize.y);
                }

                this.position.y = (endY - this.margin.bottom) - this.actualSize.y;
            }
            break;
            case stretch: {
                this.position.y = this.margin.top;
                float endY;
                if (this.parent == null) {
                    Window window = Application.getApplication().window;
                    endY = (float) window.getHeight();
                }
                else {
                    endY = (this.parent.getAbsoluteY() + this.parent.actualSize.y);
                }

                this.actualSize.y = (endY - this.margin.bottom) - this.position.y;
            }
            break;
        }
    }

    public int getId() {
        return id;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
