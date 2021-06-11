package reghzy.guigl.window.input;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import reghzy.guigl.window.Window;

import java.nio.DoubleBuffer;

public class Input {
    private final Window window;
    private final GLFWKeyCallback keyActionCallback;
    private final GLFWMouseButtonCallback mouseButtonCallback;

    public final boolean[] keysDown = new boolean[GLFW.GLFW_KEY_LAST];
    public final boolean[] mouseButtonsDown = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    public final CoordsPair mousePosPrevious;
    public final CoordsPair mousePosCurrent;
    public final CoordsPair mousePosChange;

    private final DoubleBuffer mouseBufferX;
    private final DoubleBuffer mouseBufferY;

    public Input(Window window) {
        mousePosCurrent = new CoordsPair(0, 0);
        mousePosPrevious = new CoordsPair(0, 0);
        mousePosChange = new CoordsPair(0, 0);
        mouseBufferX = BufferUtils.createDoubleBuffer(1);
        mouseBufferY = BufferUtils.createDoubleBuffer(1);

        this.window = window;

        keyActionCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key < keysDown.length && key >= 0) {
                    keysDown[key] = (action != GLFW.GLFW_RELEASE);
                }
            }
        };

        mouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                mouseButtonsDown[button] = (action != GLFW.GLFW_RELEASE);
            }
        };
    }

    public void initCallbacks() {
        GLFW.glfwSetKeyCallback(this.window.getWindowId(), this.keyActionCallback);
        GLFW.glfwSetMouseButtonCallback(this.window.getWindowId(), this.mouseButtonCallback);
    }

    public void destroyCallbacks() {
        keyActionCallback.free();
        mouseButtonCallback.free();
    }

    public void updateMouse() {
        GLFW.glfwGetCursorPos(this.window.getWindowId(), this.mouseBufferX, this.mouseBufferY);
        this.mousePosPrevious.set(this.mousePosCurrent);
        this.mousePosCurrent.x = this.mouseBufferX.get(0);
        this.mousePosCurrent.y = this.mouseBufferY.get(0);
        this.mousePosChange.x = this.mousePosCurrent.x - this.mousePosPrevious.x;
        this.mousePosChange.y = this.mousePosCurrent.y - this.mousePosPrevious.y;
    }
}
