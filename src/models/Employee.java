package models;

import java.util.Objects;

public class Employee {
    private String first_name;
    private String last_name;
    private int age;

    public Employee() {
        this.first_name = null;
        this.last_name = null;
        this.age = 0;
    }

    // overloaded constructor
    public Employee(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        Employee e = (Employee) o;
         return this.getFirst_name() == e.getFirst_name() && this.getLast_name().equals(e.getLast_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, age);
    }

    @Override
    public String toString() {
        return "Employee name is " + this.getFirst_name() + ' ' + this.getLast_name() +
                " and he/she is " + this.getAge() + " years old.";
    }
}
