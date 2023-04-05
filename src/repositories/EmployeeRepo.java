package repositories;

import models.Client;
import models.Employee;

import java.util.Arrays;

public class EmployeeRepo implements GenericRepo<Employee, String> {

    private Employee[] storage = new Employee[11];

    @Override
    public void add(Employee entity) {
        for(int i=0; i<storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = entity;
                return;
            }
        }
        Employee[] newStorage = Arrays.<Employee, Employee>copyOf(storage, 2 * storage.length, Employee[].class);

        newStorage[storage.length] = entity;
        storage = newStorage;
    }

    @Override
    public Employee get(int id) {
        return storage[id];
    }

    @Override
    public void update(Employee entity, String first_name) {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] != null && storage[i].hashCode() == entity.hashCode())
                storage[i].setFirst_name(first_name);
    }


    @Override
    public void delete(Employee entity) {
        Employee[] newStorage = new Employee[storage.length - 1];
        int j = 0;
        for (Employee Employee : storage) {
            if (Employee != null && Employee.hashCode() != entity.hashCode()) {
                newStorage[j++] = Employee;
            }
        }
        storage = newStorage;
    }

    @Override
    public int getSize() {
        return storage.length;
    }

    @Override
    public int getNumberOf() {
        int nr = 0;
        for (int i = 0; i < storage.length && storage[i] != null; i++)
            nr++;

        return nr;

    }
}

