package models;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Client {
    private String username;
    private String address;
    private int age;
    private boolean over18;
    private List<Order> pastOrders = new ArrayList<Order>();
    private List<Float> pastPayments = new ArrayList<Float>();
    private String email;

    public Client(String username, String address, int age, boolean over18, List<Order> pastOrders, List<Float> pastPayments, String email) {
        this.username = username;
        this.address = address;
        this.age = age;
        this.over18 = over18;
        this.pastOrders = pastOrders;
        this.pastPayments = pastPayments;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public List<Order> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    public List<Float> getPastPayments() {
        return pastPayments;
    }

    public void setPastPayments(List<Float> pastPayments) {
        this.pastPayments = pastPayments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && over18 == client.over18 && Objects.equals(username, client.username) && Objects.equals(address, client.address) && Objects.equals(pastOrders, client.pastOrders) && Objects.equals(pastPayments, client.pastPayments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, address, age, over18, pastOrders, pastPayments);
    }

    @Override
    public String toString() {
        return "Client{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", over18=" + over18 +
                ", pastOrders=" + pastOrders +
                ", pastPayments=" + pastPayments +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
