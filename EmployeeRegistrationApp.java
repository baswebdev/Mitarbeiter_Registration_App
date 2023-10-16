import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;
    private int employeeID;
    private String address;
    private int postalCode;
    private String city;
    private String phoneNumber;
    private String email;
    private String department;

    public Employee(String firstName, String lastName, int employeeID, String address, int postalCode, String city, String phoneNumber, String email, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

public class EmployeeRegistrationApp {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextEmployeeID = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bitte wählen Sie eine Option:");
            System.out.println("1. Mitarbeiter registrieren");
            System.out.println("2. Mitarbeiter ändern");
            System.out.println("3. Mitarbeiter anzeigen");
            System.out.println("4. Mitarbeiter löschen");
            System.out.println("5. Beenden");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Die Anwendung wird beendet.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
            }
        }
    }

    private static void registerEmployee() {
        System.out.println("Geben Sie den Vornamen des Mitarbeiters ein: ");
        String firstName = scanner.next();

        System.out.println("Geben Sie den Nachnamen des Mitarbeiters ein: ");
        String lastName = scanner.next();

        scanner.nextLine(); // Leere Zeile einlesen

        System.out.println("Geben Sie die Adresse des Mitarbeiters ein: ");
        String address = scanner.nextLine().trim();

        System.out.println("Geben Sie die PLZ des Mitarbeiters ein: ");
        int postalCode = scanner.nextInt();

        scanner.nextLine(); // Leere Zeile einlesen

        System.out.println("Geben Sie den Wohnort des Mitarbeiters ein: ");
        String city = scanner.nextLine().trim();

        System.out.println("Geben Sie die Telefonnummer des Mitarbeiters ein: ");
        String phoneNumber = scanner.next();

        System.out.println("Geben Sie die E-Mail-Adresse des Mitarbeiters ein: ");
        String email = scanner.next();

        System.out.println("Geben Sie die Abteilung des Mitarbeiters ein: ");
        String department = scanner.next();

        Employee employee = new Employee(firstName, lastName, nextEmployeeID++, address, postalCode, city, phoneNumber, email, department);
        employees.add(employee);

        System.out.println("Mitarbeiter wurde registriert. Mitarbeiter-ID: " + employee.getEmployeeID());
    }

    private static void displayEmployees() {
        System.out.println("Liste der Mitarbeiter:");
        for (Employee employee : employees) {
            System.out.println("Mitarbeiter-ID: " + employee.getEmployeeID() + ", Vorname: " + employee.getFirstName() +
                    ", Nachname: " + employee.getLastName() + ", Abteilung: " + employee.getDepartment());
        }
    }

    private static void updateEmployee() {
        System.out.println("Geben Sie die Mitarbeiter-ID des zu ändernden Mitarbeiters ein: ");
        int employeeIDToUpdate = scanner.nextInt();

        Employee employeeToUpdate = findEmployeeByID(employeeIDToUpdate);

        if (employeeToUpdate != null) {
            System.out.println("Was möchten Sie ändern?");
            System.out.println("1. Adresse");
            System.out.println("2. PLZ");
            System.out.println("3. Wohnort");
            System.out.println("4. Telefonnummer");
            System.out.println("5. Email-Adresse");
            System.out.println("6. Abteilung");

            int updateChoice = scanner.nextInt();

            switch (updateChoice) {
                case 1:
                System.out.println("Geben Sie die neue Adresse des Mitarbeiters ein: ");
                scanner.nextLine(); // Leere Zeile einlesen
                String newAddress = scanner.nextLine().trim();
                employeeToUpdate.setAddress(newAddress);
                break;
            case 2:
                System.out.println("Geben Sie die neue PLZ des Mitarbeiters ein: ");
                int newPostalCode = scanner.nextInt();
                employeeToUpdate.setPostalCode(newPostalCode);
                break;
            case 3:
                System.out.println("Geben Sie die neue Wohnort des Mitarbeiters ein: ");
                scanner.nextLine(); // Leere Zeile einlesen
                String newCity = scanner.nextLine().trim();
                employeeToUpdate.setCity(newCity);
                break;
            case 4:
                System.out.println("Geben Sie die neue Telefonnummer des Mitarbeiters ein: ");
                String newPhoneNumber = scanner.next();
                employeeToUpdate.setPhoneNumber(newPhoneNumber);
                break;
            case 5:
                System.out.println("Geben Sie die neue Email-Adresse des Mitarbeiters ein: ");
                String newEmail = scanner.next();
                employeeToUpdate.setEmail(newEmail);
                break;
            case 6:
                System.out.println("Geben Sie die neue Abteilung des Mitarbeiters ein: ");
                String newDepartment = scanner.next();
                employeeToUpdate.setDepartment(newDepartment);
                break;
            default:
                System.out.println("Ungültige Auswahl.");
        }

        System.out.println("Mitarbeiter wurde aktualisiert.");
    } else {
        System.out.println("Mitarbeiter mit der angegebenen ID wurde nicht gefunden.");
    }
}

private static void deleteEmployee() {
    System.out.println("Geben Sie die Mitarbeiter-ID des zu löschenden Mitarbeiters ein: ");
    int employeeIDToDelete = scanner.nextInt();

    Employee employeeToDelete = findEmployeeByID(employeeIDToDelete);

    if (employeeToDelete != null) {
        employees.remove(employeeToDelete);
        System.out.println("Mitarbeiter wurde gelöscht.");
    } else {
        System.out.println("Mitarbeiter mit der angegebenen ID wurde nicht gefunden.");
    }
}

private static Employee findEmployeeByID(int employeeID) {
    for (Employee employee : employees) {
        if (employee.getEmployeeID() == employeeID) {
            return employee;
        }
    }
    return null;
}
}
