package EmployeeManagementSystem;
import java.util.Scanner;

public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[count - 1];
                employees[count - 1] = null;
                count--;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maximum number of employees:");
        int size = Integer.parseInt(scanner.nextLine());
        EmployeeManagement em = new EmployeeManagement(size);

        while (true) {
            System.out.println("Choose an option: add, search, traverse, delete, exit");
            String option = scanner.nextLine();
            switch (option.toLowerCase()) {
                case "add":
                    System.out.println("Enter employee ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter employee name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter employee position:");
                    String position = scanner.nextLine();
                    System.out.println("Enter employee salary:");
                    double salary = Double.parseDouble(scanner.nextLine());
                    Employee employee = new Employee(id, name, position, salary);
                    em.addEmployee(employee);
                    break;
                case "search":
                    System.out.println("Enter employee ID to search:");
                    String searchId = scanner.nextLine();
                    Employee found = em.searchEmployee(searchId);
                    if (found != null) {
                        System.out.println("Employee found: " + found);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case "traverse":
                    System.out.println("Traversing all employees:");
                    em.traverseEmployees();
                    break;
                case "delete":
                    System.out.println("Enter employee ID to delete:");
                    String deleteId = scanner.nextLine();
                    em.deleteEmployee(deleteId);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
