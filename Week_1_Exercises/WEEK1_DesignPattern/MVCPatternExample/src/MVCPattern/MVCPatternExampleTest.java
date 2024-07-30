package MVCPattern;
import java.util.Scanner;

public class MVCPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student model = new Student();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        controller.setStudentName(name);

        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();
        controller.setStudentId(id);

        System.out.println("Enter student grade: ");
        String grade = scanner.nextLine();
        controller.setStudentGrade(grade);

        controller.updateView();

        System.out.println("Do you want to update student details? (yes/no)");
        String update = scanner.nextLine();

        if (update.equalsIgnoreCase("yes")) {
            System.out.println("Enter new student name: ");
            name = scanner.nextLine();
            controller.setStudentName(name);

            System.out.println("Enter new student ID: ");
            id = scanner.nextLine();
            controller.setStudentId(id);

            System.out.println("Enter new student grade: ");
            grade = scanner.nextLine();
            controller.setStudentGrade(grade);

       
            controller.updateView();
        }

        scanner.close();
    }
}
