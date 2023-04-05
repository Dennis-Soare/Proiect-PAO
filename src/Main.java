import exeptions.InvalidDataExc;
import models.*;
import service.ClientService;
import service.EmployeeService;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static private ClientService service = new ClientService();
    static private ProductService productService = new ProductService();
    static private EmployeeService employeeService = new EmployeeService();

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

//        Product product = new Product();
//        Employee employee = new Employee();
//
//        product.setProduct_name("produs 1");
//        System.out.println(product);
//
//        System.out.println("-----------------------------------");
//
//        employee.setFirst_name("Andrei");
//        employee.setLast_name("Popescu");
//        employee.setAge(20);
//
//        System.out.println(employee.getFirst_name());
//        System.out.println(employee.getLast_name());
//        System.out.println(employee.getAge());
//
//        System.out.println("-----------------------------------");
//
//        Driver driver = new Driver("John", "Smith", 25, "Dacia");
//
//        System.out.println(driver.getFirst_name());
//        System.out.println(driver.getLast_name());
//        System.out.println(driver.getAge());
//        System.out.println(driver.getCar_model());
//        System.out.println(driver);
//
//        System.out.println("-----------------------------------");
//
//
//        Employee e1 = new Employee("Sarah", "Johnson", 30);
//        Employee e2 = new Employee("Sarah", "Johnson", 30);
//        Employee e3 = e1;
//        Employee[] list = {e1, e2, e3};
//
//        for(int i=0; i<list.length; i++) {
//            System.out.println(list[i]);
//        }
//
//        System.out.println(e1 == e2);
//        System.out.println(e1.equals(e2));
//        System.out.println(e1 == e3);

        Main app = new Main();

        app.addClient();
        app.listAllClients();
        System.out.print("Email: ");
        String email = s.nextLine();
        app.deleteClient(email);
        app.listAllClients();
        app.addNewProduct();
        app.listAllProducts();
        System.out.println("Product name: ");
        String prodName = s.nextLine();
        app.deleteProduct(prodName);
        app.listAllProducts();
        app.addNewEmployee();
        app.listAllEmployees();
        System.out.println("Employee name: ");
        String first_name = s.nextLine();
        app.deleteEmployee(first_name);
        app.listAllEmployees();
    }


    private void addClient() {
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Address: ");
        String address = s.nextLine();
        System.out.print("Age: ");
        String age = s.nextLine();
        boolean over18;
        if (Integer.parseInt(age) >= 18)
            over18 = true;
        else over18 = false;
        System.out.print("Email: ");
        String email = s.nextLine();

        try {
            service.registerNewClient(username, address, Integer.parseInt(age), over18, null, null, email);
        } catch (InvalidDataExc invalidData) {
            System.out.println(invalidData.getMessage());
        }
    }

    private void listAllClients() {

        System.out.println("Clients:\n---------------------");
        for (Client client : service.getAllClients()) {
            System.out.println(client);
        }

    }

    private void deleteClient(String email) {
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") && service.validateEmail(email))
            try {
                service.removeACLient(email);

            } catch (InvalidDataExc invalidData) {
                System.out.println(invalidData.getMessage());
            }
        else {
            System.out.println("Invalid email!");
        }

    }

    private void addNewProduct() {
        System.out.print("Product name: ");
        String product_name = s.nextLine();
        System.out.print("Price: ");
        String price = s.nextLine();
        System.out.print("Nr of ingredients: ");
        String nr = s.nextLine();
        System.out.print("Ingredients: ");
        List<String> ingredients = new ArrayList<String>();
        for (int i = 1; i <= Integer.parseInt(nr); i++) {
            String ing = s.nextLine();
            ingredients.add(ing);
        }

        productService.registerNewProduct(product_name, Float.parseFloat(price), ingredients);

    }

    private void listAllProducts() {

        System.out.println("Products:\n---------------------");
        for (Product product : productService.getAllProducts()) {
            System.out.println(product);
        }

    }

    private void deleteProduct(String product_name) {

        try {
            productService.removeAProduct(product_name);

        } catch (InvalidDataExc invalidData) {
            System.out.println(invalidData.getMessage());
        }

    }

    private void addNewEmployee() {
        System.out.print("First name: ");
        String first_name = s.nextLine();
        System.out.print("Last name: ");
        String last_name = s.nextLine();
        System.out.print("Age: ");
        String age = s.nextLine();
        employeeService.registerNewEmployee(first_name, last_name, Integer.parseInt(age));
    }

    private void listAllEmployees() {

        System.out.println("Employees:\n---------------------");
        for (Employee employee : employeeService.getAllEmployees()) {
            System.out.println(employee);
        }

    }

    private  void deleteEmployee(String first_name) {
        try {
            employeeService.removeEmployee(first_name);
        }
        catch (InvalidDataExc invalidData) {
            System.out.println(invalidData.getMessage());
        }
    }

}
