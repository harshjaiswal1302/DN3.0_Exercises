package singleton;

public class SingletonPatternExampleTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both logger instances equal? " + (logger1 == logger2));
        
        logger1.log("Singleton pattern test message.");
    }
}
