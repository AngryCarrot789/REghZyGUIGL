package reghzy.guigl.core.style.utils;

import reghzy.guigl.core.style.Colour;

/**
 * A resource simply contains a raw object, which could be anything worthy of being held in a resource dictionary
 * <p>
 *     It provides commands for also easily parsing the data
 * </p>
 */
public class Resource {
    private Object data;

    public Resource(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Colour getColour() {
        if (data instanceof Colour) {
            return (Colour) data;
        }

        return null;
    }

    //public Thickness getThickness() {
    //    if (value instanceof Thickness) {
    //        return (Thickness) value;
    //    }
    //    return null;
    //}

    public Object getData() {
        return this.data;
    }

    public Resource copy() {
        return new Resource(this.data);
    }
}
