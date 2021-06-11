package reghzy.guigl.core.style.builtin;

import reghzy.guigl.core.style.Colour;
import reghzy.guigl.core.style.utils.Resource;
import reghzy.guigl.core.style.utils.ResourceDictionary;

public class ThemeDictionary extends ResourceDictionary {
    public void addColour(String name, int r, int g, int b) {
        this.putResource(name, new Resource(new Colour(r, g, b)));
    }
}
