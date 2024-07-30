package proxypattern;

import java.util.Scanner;

public class ProxyPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the filename of the first image: ");
        String filename1 = scanner.nextLine();

        System.out.print("Enter the filename of the second image: ");
        String filename2 = scanner.nextLine();

        
        Image image1 = new ProxyImage(filename1);
        Image image2 = new ProxyImage(filename2);

    
        System.out.println("Displaying the first image:");
        image1.display();  

        System.out.println("\nDisplaying the second image:");
        image2.display();  

        System.out.println("\nDisplaying the first image again:");
        image1.display(); 
    }
}
