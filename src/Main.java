import models.Driver;
import models.Employee;
import models.Product;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Employee employee = new Employee();

        product.setProduct_name("produs 1");
        System.out.println(product);

        System.out.println("-----------------------------------");

        employee.setFirst_name("Andrei");
        employee.setLast_name("Popescu");
        employee.setAge(20);

        System.out.println(employee.getFirst_name());
        System.out.println(employee.getLast_name());
        System.out.println(employee.getAge());

        System.out.println("-----------------------------------");

        Driver driver = new Driver("John", "Smith", 25, "Dacia");

        System.out.println(driver.getFirst_name());
        System.out.println(driver.getLast_name());
        System.out.println(driver.getAge());
        System.out.println(driver.getCar_model());
        System.out.println(driver);

        System.out.println("-----------------------------------");


        Employee e1 = new Employee("Sarah", "Johnson", 30);
        Employee e2 = new Employee("Sarah", "Johnson", 30);
        Employee e3 = e1;
        Employee[] list = {e1, e2, e3};

        for(int i=0; i<list.length; i++) {
            System.out.println(list[i]);
        }

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
        System.out.println(e1 == e3);
    }
}