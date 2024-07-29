package ProjectI.StructuralPattern;

// Singleton Logger Class
class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Main
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log message.");
        logger2.log("This is another log message.");

        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
    }
}

