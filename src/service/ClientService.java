package service;

import exeptions.InvalidDataExc;
import models.Client;
import models.Order;
import repositories.ClientRepo;

import java.util.List;

public class ClientService {
    private ClientRepo clientRepo = new ClientRepo();

    public void registerNewClient(String username, String address, int age, boolean over18, List<Order> pastOrders, List<Float> pastPayments)
            throws InvalidDataExc {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidDataExc("Invalid name");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new InvalidDataExc("Invalid address");
        }
        if (age < 0) {
            throw new InvalidDataExc("Invalid age");
        }

        Client entity = new Client(username, address, age, over18, pastOrders, pastPayments);
        clientRepo.add(entity);
    }
}
