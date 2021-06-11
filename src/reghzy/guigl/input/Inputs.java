package reghzy.guigl.input;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import reghzy.guigl.core.controls.Window;
import reghzy.guigl.input.listener.KeyListener;
import reghzy.guigl.input.listener.MouseListener;
import reghzy.guigl.maths.Vector2;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class Inputs {
    private static Inputs instance;
    
    public final Window window;
    public final Mouse mouse;
    public final Keyboard keyboard;

    private Inputs(Window window) {
        this.window = window;
        this.mouse = new Mouse();
        this.keyboard = new Keyboard();
    }

    public void registerEvents() {
        GLFW.glfwSetKeyCallback(this.window.getHandle(), this.keyboard.keyCallback);
        GLFW.glfwSetMouseButtonCallback(this.window.getHandle(), this.mouse.mouseButtonCallback);
    }

    public void update() {
        this.mouse.update();
    }

    public void destroyCallbacks() {
        this.mouse.destroyCallbacks();
        this.keyboard.destroyCallbacks();
    }

    public static Inputs create(Window window) {
        if (instance == null) {
            instance = new Inputs(window);
            return instance;
        }

        throw new UnsupportedOperationException("Cannot recreate inputs instance");
    }

    public static Inputs getInstance() {
        return instance;
    }

    public class Mouse {
        private final GLFWMouseButtonCallback mouseButtonCallback;
        private final ArrayList<MouseListener> listeners;
        private final boolean[] mouseButtonsDown;

        public final Vector2 cursorCurrent;
        public final Vector2 cursorPrevious;
        public final Vector2 cursorChange;
        private final DoubleBuffer mouseBufferX;
        private final DoubleBuffer mouseBufferY;

        private Mouse() {
            this.cursorCurrent = new Vector2();
            this.cursorPrevious = new Vector2();
            this.cursorChange = new Vector2();
            this.mouseBufferX = BufferUtils.createDoubleBuffer(1);
            this.mouseBufferY = BufferUtils.createDoubleBuffer(1);
            this.listeners = new ArrayList<>(256);
            this.mouseButtonsDown = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
            this.mouseButtonCallback = new GLFWMouseButtonCallback() {
                @Override
                public void invoke(long window, int button, int action, int mods) {
                    mouseButtonsDown[button] = (action != GLFW.GLFW_RELEASE);
                    MouseButton mouseButton = MouseButton.fromCode(button);
                    for(MouseListener listener : Mouse.this.listeners) {
                        if (action == GLFW.GLFW_RELEASE) {
                            listener.onButtonUp(mouseButton);
                        }
                        else {
                            listener.onButtonDown(mouseButton);
                        }
                    }
                }
            };
        }

        public boolean isButtonDown(MouseButton button) {
            return isButtonDown(button.code);
        }

        public boolean isButtonUp(MouseButton button) {
            return isButtonUp(button.code);
        }

        public boolean isButtonDown(int button) {
            return this.mouseButtonsDown[button];
        }

        public boolean isButtonUp(int button) {
            return !this.mouseButtonsDown[button];
        }

        public void registerListener(MouseListener listener) {
            this.listeners.add(listener);
        }

        public void unregisterListener(MouseListener listener) {
            this.listeners.remove(listener);
        }

        private void update() {
            GLFW.glfwGetCursorPos(Inputs.this.window.getHandle(), this.mouseBufferX, this.mouseBufferY);
            this.cursorPrevious.set(this.cursorCurrent);
            this.cursorCurrent.set((float) this.mouseBufferX.get(0), (float) this.mouseBufferY.get(0));
            this.cursorChange.set(this.cursorCurrent.x - this.cursorChange.x, this.cursorCurrent.y - this.cursorChange.y);
        }


        private void destroyCallbacks() {
            this.mouseButtonCallback.free();
        }
    }

    public class Keyboard {
        private final GLFWKeyCallback keyCallback;
        private final ArrayList<KeyListener> listeners;
        private final boolean[] keysDown;

        private Keyboard() {
            this.listeners = new ArrayList<>(256);
            this.keysDown = new boolean[GLFW.GLFW_KEY_LAST];
            this.keyCallback = new GLFWKeyCallback() {
                @Override
                public void invoke(long window, int key, int scancode, int action, int mods) {
                    if (key < keysDown.length && key >= 0) {
                        keysDown[key] = (action != GLFW.GLFW_RELEASE);
                        KeyboardKey keyboardKey = KeyboardKey.fromCode(key);
                        for (KeyListener listener : Keyboard.this.listeners) {
                            if (action == GLFW.GLFW_RELEASE) {
                                listener.onKeyUp(keyboardKey, scancode);
                            }
                            else {
                                listener.onKeyDown(keyboardKey, scancode);
                            }
                        }
                    }
                }
            };
        }

        public boolean isKeyDown(KeyboardKey key) {
            return isKeyDown(key.code);
        }

        public boolean isKeyUp(KeyboardKey key) {
            return isKeyUp(key.code);
        }

        public boolean isKeyDown(int key) {
            return this.keysDown[key];
        }

        public boolean isKeyUp(int key) {
            return !this.keysDown[key];
        }

        public void registerListener(KeyListener listener) {
            listeners.add(listener);
        }

        public void unregisterListener(KeyListener listener) {
            listeners.remove(listener);
        }

        private void destroyCallbacks() {
            this.keyCallback.free();
        }
    }
}
