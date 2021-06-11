package reghzy.guigl.core.event;

public interface EventHandler<E extends Event> {
    void process(E event);
}
