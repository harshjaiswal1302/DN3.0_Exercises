package singleton;

public class Logger {
    private Logger() {
    }

    private static class LoggerHolder {
        private static Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}


