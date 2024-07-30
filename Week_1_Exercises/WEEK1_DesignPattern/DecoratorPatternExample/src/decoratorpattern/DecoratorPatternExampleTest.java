package decoratorpattern;

import java.util.Scanner;

public class DecoratorPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notifier notifier = new EmailNotifier();
        System.out.println("Choose additional notification channels : SMS, Slack");
        String[] channels = scanner.nextLine().split(",");
        for (String channel : channels) {
            switch (channel.trim().toLowerCase()) {
                case "sms":
                    notifier = new SMSNotifierDecorator(notifier);
                    break;
                case "slack":
                    notifier = new SlackNotifierDecorator(notifier);
                    break;
                default:
                    System.out.println("Unknown channel: " + channel);
                    break;
            }
        }

        System.out.print("Enter the notification message: ");
        String message = scanner.nextLine();
        notifier.send(message);
    }
}
