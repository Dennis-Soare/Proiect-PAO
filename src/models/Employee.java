package models;

import java.util.concurrent.TransferQueue;

public class Employee {
    private String first_name;
    private String second_name;
    private int age;

    public Employee() {
        this.first_name = null;
        this.second_name = null;
        this.age = 0;
    }

    // overloaded constructor
    public Employee(String first_name, String second_name, int age) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return this.second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
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
         return this.getFirst_name() == e.getFirst_name() && this.getSecond_name().equals(e.getSecond_name());
    }

    @Override
    public String toString() {
        return "Employee name is " + this.getFirst_name() + ' ' + this.getSecond_name() +
                " and he/she is " + this.getAge() + " years old.";
    }
}
