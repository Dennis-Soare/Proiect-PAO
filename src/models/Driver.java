package models;

import java.util.Objects;

public class Driver extends Employee{
    private String car_model;

    public Driver(String first_name, String second_name, int age, String car_model) {
        super(first_name, second_name, age);
        this.car_model = car_model;
    }

    public String getCar_model() {
        return car_model;
    }

    public void  setCar_model(String car_model) {
        this.car_model = car_model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(car_model, driver.car_model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_model);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car_model='" + car_model + '\'' +
                '}';
    }
}
