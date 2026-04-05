import java.util.*;

public class EmployeeNames {
    public static void main(String[] args) {

        // List of employee names
        String[] employees = {
            "Amit", "Rahul", "Anita", "Suresh", "Akash", "Neha"
        };

        System.out.println("Employees whose name starts with 'A':");

        for (String name : employees) {
            if (name.charAt(0) == 'A') {
                System.out.println(name);
            }
        }
    }
}