import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Andrei", "Programator");
        Employee employee2 = new Employee("Adelina", "Programator");
        Employee employee3 = new Employee("Madalin", "Inginer");
        Employee employee4 = new Employee("Andreea", "Inginer");
        Employee employee5 = new Employee("Robi", "Asistent");
        Employee employee6 = new Employee("Rita", "Doctor");
        Employee employee7 = new Employee("Evelynn", "Copil");
        Employee employee8 = new Employee("Cosmin", "Asistent");
        Employee employee9 = new Employee("Adrian", "Inginer");

        List<Employee> employeeList = new ArrayList<>() {{
            add(employee1);
            add(employee2);
            add(employee3);
            add(employee4);
            add(employee5);
            add(employee6);
            add(employee7);
            add(employee8);
            add(employee9);
        }};

        Map<String, List<Employee>> employeesSortedByJobTitle = groupEmployeeByJobTitle(employeeList);
        for (String jobTitle : employeesSortedByJobTitle.keySet()) {

            System.out.println(jobTitle);
            System.out.println(employeesSortedByJobTitle.get(jobTitle));
            System.out.println();
            System.out.println();
            System.out.println();

        }

    }

    public static Map<String, List<Employee>> groupEmployeesByJobTitleRaw(List<Employee> employeeList) {

        Map<String, List<Employee>> groupedEmployees = new HashMap<>();
        for (Employee employee : employeeList) {
            if (groupedEmployees.containsKey(employee.jobTitle)) {
                List<Employee> subListOfEmployees = groupedEmployees.get(employee.jobTitle);
                subListOfEmployees.add(employee);
                groupedEmployees.put(employee.jobTitle, subListOfEmployees);
            } else {
                groupedEmployees.put(employee.jobTitle, new ArrayList<>() {{
                    add(employee);
                }});
            }
        }
        return groupedEmployees;
    }

    public static Map<String, List<Employee>> groupEmployeeByJobTitle(List<Employee> givenEmployeeList) {
        Map<String, List<Employee>> groupedEmployees = new HashMap<>();

        for (Employee e : givenEmployeeList) {
            List<Employee> employeeListByJobTitle = groupedEmployees.getOrDefault(e.jobTitle, new ArrayList<>());
            employeeListByJobTitle.add(e);
            groupedEmployees.put(e.jobTitle,employeeListByJobTitle);
        }
        return groupedEmployees;
    }

}
