package service;

import exeptions.InvalidDataExc;
import models.Employee;
import repositories.EmployeeRepo;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Objects;

public class EmployeeService {
    private EmployeeRepo employeeRepo  = new EmployeeRepo();

    public void registerNewEmployee(String first_name, String last_name, int age) {
        Employee employee = new Employee(first_name, last_name, age);
        employeeRepo.add(employee);
    }

    public Employee[] getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < employeeRepo.getSize(); i++) {
            if (employeeRepo.get(i) != null) {
                result.add(employeeRepo.get(i));
            }
        }
        return result.toArray(new Employee[0]);
    }

    public void removeEmployee(String first_name) throws InvalidDataExc {
        boolean ok = true;
        int i;

        for (i = 0; i < employeeRepo.getNumberOf() && ok; i++) {
            if (Objects.equals(employeeRepo.get(i).getFirst_name(), first_name))
                ok = false;
        }
        if (ok)
            throw new InvalidDataExc("Invalid Employee");
        else
            employeeRepo.delete(employeeRepo.get(i - 1));
    }
}
