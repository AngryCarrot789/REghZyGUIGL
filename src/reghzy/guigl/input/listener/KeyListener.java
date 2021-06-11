package reghzy.guigl.input.listener;

import reghzy.guigl.input.KeyboardKey;

public interface KeyListener {
    void onKeyDown(KeyboardKey key, int scanCode);
    void onKeyUp(KeyboardKey key, int scanCode);
}
