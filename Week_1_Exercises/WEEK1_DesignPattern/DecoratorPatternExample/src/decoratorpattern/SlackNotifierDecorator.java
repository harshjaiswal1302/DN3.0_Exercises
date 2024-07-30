package decoratorpattern;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // Send via the base notifier
        System.out.println("Sending Slack message: " + message);
    }
}
