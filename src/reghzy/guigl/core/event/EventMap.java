package reghzy.guigl.core.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventMap {
    private final Map<Class<? extends Event>, List<? extends EventHandler>> listeners;

    public EventMap() {
        this.listeners = new ConcurrentHashMap<>();
    }

    /**
     * Calls the process() method for all of the EventHandlers that are listening to the given type of event
     * @param event The event (generic)
     * @param <E> The generic event
     */
    public <E extends Event> void sendEvent(E event) {
        List<EventHandler<E>> handlers = (List<EventHandler<E>>) listeners.get(event.getClass());
        if (handlers == null || handlers.isEmpty()) {
            return;
        }

        for(EventHandler<E> handler : handlers) {
            handler.process(event);
        }
    }

    public <E extends Event> boolean hasListeners(Class<E> eventClass) {
        return listeners.get(eventClass) != null;
    }

    public <E extends Event> void addListener(Class<E> eventClass, EventHandler<E> handler) {
        getHandlers(eventClass).add(handler);
    }

    public <E extends Event> void removeListener(Class<E> eventClass, EventHandler<E> handler) {
        List<EventHandler<E>> handlers = (List<EventHandler<E>>) listeners.get(eventClass);
        if (handlers == null) {
            return;
        }

        handlers.remove(handler);
    }

    public <E extends Event> void removeAllListeners(Class<E> eventClass) {
        List<EventHandler<E>> handlers = (List<EventHandler<E>>) listeners.get(eventClass);
        if (handlers != null) {
            handlers.clear();
        }
    }

    public <E extends Event> List<EventHandler<E>> getHandlers(Class<E> eventClass) {
        List<EventHandler<E>> handlers = (List<EventHandler<E>>) listeners.get(eventClass);
        if (handlers == null) {
            handlers = new ArrayList<>(1);
            this.listeners.put(eventClass, handlers);
        }
        return handlers;
    }
}
