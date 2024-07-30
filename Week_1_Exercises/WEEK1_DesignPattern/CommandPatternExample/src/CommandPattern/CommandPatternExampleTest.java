package CommandPattern;

import java.util.Scanner;

public class CommandPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("Select command (1: Turn On Light, 2: Turn Off Light, 0: Exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            remote.pressButton();
        }

        scanner.close();
    }
}
