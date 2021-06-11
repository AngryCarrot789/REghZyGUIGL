package reghzy.guigl.core.controls;

import reghzy.guigl.core.style.utils.ResourceDictionary;
import reghzy.guigl.core.style.utils.ResourceManager;
import reghzy.guigl.core.utils.Visibility;

/**
 * A framework element is an actual visible control. UIElements simply define the
 * element, FrameworkElements define how it looks, allowing it to be rendered
 */
public class FrameworkElement extends UIElement {
    protected Visibility visibility;

    protected final ResourceDictionary resourceDictionary;

    public FrameworkElement() {
        this.visibility = Visibility.visible;
        this.resourceDictionary = ResourceManager.getDark();
        reloadResources();
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

    /**
     * Called when a resource is changed in the resource dictionary. must be called manually!!!
     */
    public void reloadResources() {

    }
}
