package reghzy.guigl.core.style.utils;

import reghzy.guigl.core.style.utils.base.Style;

import java.util.HashMap;
import java.util.Map;

/**
 * A resource dictionary is simply a map, keying a resource name to a resource. The resources can be anything, such as colours
 */
public class ResourceDictionary {
    private final HashMap<String, Resource> resources;

    public ResourceDictionary() {
        this.resources = new HashMap<>();
    }

    public Resource getResource(String name) {
        return resources.get(name);
    }

    public Resource getResource(Style style) {
        return resources.get(style.getName());
    }

    public void putResource(String name, Resource resource) {
        resources.put(name, resource);
    }

    public void putResource(String name, Object resource) {
        resources.put(name, new Resource(resource));
    }

    public void putResource(Style style, Resource resource) {
        resources.put(style.getName(), resource);
    }

    public void putResource(Style style, Object resource) {
        resources.put(style.getName(), new Resource(resource));
    }

    public ResourceDictionary copy() {
        ResourceDictionary resourceDictionary = new ResourceDictionary();
        for (Map.Entry<String, Resource> pair : this.resources.entrySet()) {
            resourceDictionary.putResource(pair.getKey(), pair.getValue());
        }
        return resourceDictionary;
    }
}
