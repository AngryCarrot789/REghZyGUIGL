package reghzy.guigl.window;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import reghzy.guigl.window.input.CoordsPair;
import reghzy.guigl.window.input.Input;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

public class Window {
    private String title;
    private int desktopX;
    private int desktopY;
    private double width;
    private double height;
    private final Input input;
    private final long windowId;
    private final GLFWVidMode videoMode;
    private boolean isOpen;
    public final boolean hasInitialised;

    private GLFWWindowSizeCallback resizeCallback;
    private GLFWWindowPosCallback posCallback;

    public Window(String title, int width, int height, int x, int y) {
        this.title = title;
        this.desktopX = x;
        this.desktopY = y;
        this.width = width;
        this.height = height;
        this.windowId = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        setPosition(x, y);

        if (this.windowId == 0) {
            System.err.println("Failed to create window");
            this.resizeCallback = null;
            this.posCallback = null;
            this.videoMode = null;
            this.input = null;
            this.hasInitialised = false;
            return;
        }

        this.input = new Input(this);

        resizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                Window.this.width = width;
                Window.this.height = height;
                useViewport();
            }
        };

        posCallback = new GLFWWindowPosCallback() {
            @Override
            public void invoke(long window, int posX, int posY) {
                Window.this.desktopX = posX;
                Window.this.desktopY = posY;
            }
        };

        GLFW.glfwSetWindowSizeCallback(this.windowId, this.resizeCallback);
        GLFW.glfwSetWindowPosCallback(this.windowId, this.posCallback);

        this.videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

        GLFW.glfwMakeContextCurrent(this.windowId);
        GL.createCapabilities();

        this.hasInitialised = true;
    }

    public void swapBuffers() {
        GLFW.glfwSwapBuffers(this.windowId);
    }

    public void setTitle(String title) {
        GLFW.glfwSetWindowTitle(this.windowId, title);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        GLFW.glfwSetWindowSize(this.windowId, width, height);
    }

    public void setPosition(int x, int y) {
        this.desktopX = x;
        this.desktopY = y;
        GLFW.glfwSetWindowPos(this.windowId, x, y);
    }

    public void useViewport() {
        GL11.glViewport(0, 0, (int) this.width, (int) this.height);
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(this.getWindowId());
    }

    public long getWindowId() {
        return this.windowId;
    }

    public void showWindow() {
        GLFW.glfwShowWindow(this.windowId);
        this.isOpen = true;
    }

    public void closeWindow() {
        GLFW.glfwSetWindowShouldClose(this.windowId, true);
        destroy();
        this.isOpen = false;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public Input getInput() {
        return this.input;
    }

    public GLFWVidMode getVideoMode() {
        return videoMode;
    }

    public void destroy() {
        this.input.destroyCallbacks();
        GLFW.glfwDestroyWindow(this.windowId);
    }

    public int getDesktopX() {
        return desktopX;
    }

    public int getDesktopY() {
        return desktopY;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
