package reghzy.guigl.core.controls;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import reghzy.guigl.core.event.control.PositionChangedEvent;
import reghzy.guigl.core.event.control.SizeChangedEvent;
import reghzy.guigl.core.event.window.TitleChangedEvent;
import reghzy.guigl.core.utils.HorizontalAlignment;
import reghzy.guigl.core.utils.VerticalAlignment;
import reghzy.guigl.input.Inputs;
import reghzy.guigl.maths.Vector2;

public class Window extends ContentControl {
    private String title;
    private Vector2 viewportOffset;
    private Vector2 desktopPosition;
    private final long hWnd;

    public final GLFWVidMode videoMode;
    public final Inputs inputs;

    public Window(String title, int width, int height, int x, int y) {
        this.title = title;
        this.viewportOffset = new Vector2(0, 0);
        this.desktopPosition = new Vector2(x, y);
        this.position.set(0, 0);
        this.actualSize.set(width, height);
        super.horizontalAlignment = HorizontalAlignment.NONE;
        super.verticalAlignment = VerticalAlignment.NONE;

        this.hWnd = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (this.hWnd == 0) {
            throw new RuntimeException("Failed to create a window! Title: '" + title + '\'');
        }

        this.inputs = Inputs.create(this);
        this.inputs.registerEvents();

        GLFWWindowSizeCallback sizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                Vector2 before = Window.this.actualSize.copy();
                Window.this.actualSize.set(width, height);
                if (Window.this.eventMap.hasListeners(SizeChangedEvent.class)) {
                    Window.this.eventMap.sendEvent(new SizeChangedEvent(Window.this, before));
                }
            }
        };

        GLFWWindowPosCallback posCallback = new GLFWWindowPosCallback() {
            @Override
            public void invoke(long window, int posX, int posY) {
                Vector2 before = Window.this.desktopPosition.copy();
                Window.this.desktopPosition.set(posX, posY);
                if (Window.this.eventMap.hasListeners(PositionChangedEvent.class)) {
                    Window.this.eventMap.sendEvent(new PositionChangedEvent(Window.this, before));
                }
            }
        };

        GLFW.glfwSetWindowSizeCallback(this.hWnd, sizeCallback);
        GLFW.glfwSetWindowPosCallback(this.hWnd, posCallback);
        GLFW.glfwMakeContextCurrent(this.hWnd);
        GL.createCapabilities();
        this.videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String before = this.title;
        this.title = title;
        if (this.eventMap.hasListeners(TitleChangedEvent.class)) {
            this.eventMap.sendEvent(new TitleChangedEvent(this, this, before));
        }
    }

    public Vector2 getViewportOffset() {
        return viewportOffset;
    }

    public void setViewportOffset(Vector2 viewportOffset) {
        this.viewportOffset = viewportOffset;
    }

    public Vector2 getDesktopPosition() {
        return desktopPosition;
    }

    public void setDesktopPosition(Vector2 desktopPosition) {
        this.desktopPosition = desktopPosition;
    }

    public long getHandle() {
        return this.hWnd;
    }

    public float getWidth() {
        return this.actualSize.x;
    }

    public float getHeight() {
        return this.actualSize.y;
    }

    public int getGlWidth() {
        return (int) this.actualSize.x;
    }

    public int getGlHeight() {
        return (int) this.actualSize.y;
    }

    public float getDesktopX() {
        return this.desktopPosition.x;
    }

    public float getDesktopY() {
        return this.desktopPosition.y;
    }

    public void glUseViewport() {
        GL11.glViewport((int) this.viewportOffset.x, (int) this.viewportOffset.y, getGlWidth(), getGlHeight());
    }

    public void glfwSwapBuffers() {
        GLFW.glfwSwapBuffers(this.hWnd);
    }

    public boolean glfwShouldClose() {
        return GLFW.glfwWindowShouldClose(this.hWnd);
    }

    public void glfwClose() {
        GLFW.glfwSetWindowShouldClose(this.hWnd, true);
    }

    public void glfwShow() {
        GLFW.glfwSetWindowShouldClose(this.hWnd, false);
        GLFW.glfwShowWindow(this.hWnd);
    }

    public void glfwDestroy() {
        this.inputs.destroyCallbacks();
        GLFW.glfwDestroyWindow(this.hWnd);
    }

    @Override
    public void update() {
        updateMouse();
    }
}
