package reghzy.guigl;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import reghzy.guigl.core.controls.FrameworkElement;
import reghzy.guigl.core.controls.Window;
import reghzy.guigl.core.controls.primitive.Border;
import reghzy.guigl.core.render.RenderManager;
import reghzy.guigl.core.render.Tesselator;
import reghzy.guigl.core.utils.HorizontalAlignment;
import reghzy.guigl.core.utils.VerticalAlignment;

import java.util.ArrayList;

public class Application {
    private boolean isRunning;
    private final String name;

    public Window window;
    private final ArrayList<FrameworkElement> elements;
    private static Application application;
    private final RenderManager renderManager;
    private Tesselator tesselator;

    public Application(String name) {
        this.name = name;
        Thread.currentThread().setName(name);
        this.elements = new ArrayList<>();
        this.renderManager = new RenderManager();
        this.renderManager.registerPrimitiveRenderers();
        application = this;
    }

    public static Application getApplication() {
        return application;
    }

    private boolean preInit() {
        if (GLFW.glfwInit()) {
            System.out.println("Initialised glfw! Version: " + GLFW.glfwGetVersionString());
            return true;
        }
        else {
            System.err.println("Failed to init glfw!");
            return false;
        }
    }

    private boolean init() {
        window = new Window("Main Window", 1280, 720, 100, 100);
        window.glfwShow();
        this.tesselator = new Tesselator(this.window);
        // GL11.glClearColor(0.2f, 0.8f, 0.6f, 1.0f);
        // GL11.glEnable(GL11.GL_CULL_FACE);
        // GL11.glCullFace(GL11.GL_BACK);
        // GL11.glEnable(GL11.GL_DEPTH_TEST);
        // GL11.glDepthFunc(GL11.GL_LESS);
        // GL11.glDepthMask(true);
        return true;
    }

    /**
     * Starts the main application loop, which deals with updating and rendering
     */
    public void run() {
        this.isRunning = true;
        if (!preInit())
            return;
        if (!init())
            return;

        Border border = new Border();
        border.getActualSize().set(200, 120);
        border.getMargin().set(5);
        border.setVerticalAlignment(VerticalAlignment.bottom);
        border.setHorizontalAlignment(HorizontalAlignment.right);
        this.elements.add(border);

        while(true) {
            GLFW.glfwPollEvents();

            if (window.glfwShouldClose()) {
                window.glfwClose();
                stop();
                break;
            }

            try {
                update();
            }
            catch (Exception e) {
                stop();
                e.printStackTrace();
            }

            try {
                render();
            }
            catch (Exception e) {
                stop();
                e.printStackTrace();
            }

            if (!this.isRunning) {
                break;
            }
        }

        GLFW.glfwTerminate();
    }

    private void update() {
        window.inputs.update();

        ArrayList<FrameworkElement> elements = this.elements;
        for (int i = 0, size = elements.size(); i < size; i++) {
            elements.get(i).update();
        }
    }

    private void render() {
        window.glUseViewport();
        Tesselator.instance.clearBackground();
        Tesselator.instance.clearBackgroundColour(0.1f, 0.1f, 0.1f);

        for (int i = 0, size = elements.size(); i < size; i++) {
            this.renderManager.renderElement(elements.get(i));
        }

        window.glfwSwapBuffers();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void stop() {
        this.isRunning = false;
    }

    public ArrayList<FrameworkElement> getElements() {
        return elements;
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }

    public String getName() {
        return name;
    }
}
