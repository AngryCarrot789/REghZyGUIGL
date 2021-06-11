package reghzy.guigl.core.controls;

import reghzy.guigl.core.style.utils.ResourceDictionary;
import reghzy.guigl.core.utils.Visibility;

public class FrameworkElement extends UIElement {
    protected Visibility visibility;

    protected final ResourceDictionary resourceDictionary;

    public FrameworkElement() {
        this.visibility = Visibility.visible;
        this.resourceDictionary = new ResourceDictionary();
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public ResourceDictionary getResources() {
        return this.resourceDictionary;
    }
}
