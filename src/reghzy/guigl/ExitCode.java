package reghzy.guigl;

public enum ExitCode {
    InitFailed(1048576, "The application failed to initialise!"),
    NormalWindowClose(0, "The application exited without failure (by the user manually closing the window)"),
    NormalAppActions(1, "The application exited without failure (something in code forced the app to close)"),
    Unexpected(257, "The application exited unexpectedly..."),
    Crash(32768, "The application has crashed due to an unhandled exception!");

    private final int code;
    private final String message;

    ExitCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
