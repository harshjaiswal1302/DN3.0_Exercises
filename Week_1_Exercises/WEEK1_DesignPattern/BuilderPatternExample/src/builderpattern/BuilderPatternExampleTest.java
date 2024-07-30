package builderpattern;

import java.util.Scanner;

public class BuilderPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Build your Computer:");

      
        System.out.print("Enter CPU");
        String cpu = scanner.nextLine();

       
        System.out.print("Enter RAM");
        String ram = scanner.nextLine();

      
        System.out.print("Enter Storage");
        String storage = scanner.nextLine();

     
        System.out.print("Enter GPU");
        String gpu = scanner.nextLine();

       
        System.out.print("Has WiFi (yes/no): ");
        boolean hasWiFi = scanner.nextLine().equalsIgnoreCase("yes");

      
        Computer computer = new Computer.Builder()
            .setCPU(cpu)
            .setRAM(ram)
            .setStorage(storage)
            .setGPU(gpu)
            .setHasWiFi(hasWiFi)
            .build();

      
        System.out.println("Computer Configuration: " + computer);
    }
}

