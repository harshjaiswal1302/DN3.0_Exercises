package factorypattern;

import java.util.Scanner;

public class FactoryMethodPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter document type (Word/PDF/Excel): ");
        String type = scanner.nextLine();

        DocumentFactory factory = null;

        switch (type.toLowerCase()) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Unknown document type.");
                return;
        }

        Document document = factory.createDocument();
        document.open();
    }
}

