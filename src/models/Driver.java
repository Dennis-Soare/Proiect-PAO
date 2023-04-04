package models;

public class Driver extends Employee{
    private String car_model;

    public Driver() {
        super();
    }

    public Driver(String first_name, String second_name, int age, String car_model) {
        super(first_name, second_name, age);
        this.car_model = car_model;
    }

    public String getCar_model() {
        return this.car_model;
    }

    public void  setCar_model(String car_model) {
        this.car_model = car_model;
    }

}
