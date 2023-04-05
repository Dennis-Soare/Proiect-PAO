package service;

import exeptions.InvalidDataExc;
import models.Client;
import models.Order;
import repositories.ClientRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientService {

    private ClientRepo clientRepo = new ClientRepo();

    public void registerNewClient(String username, String address, int age, boolean over18, List<Order> pastOrders, List<Float> pastPayments, String email)
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

        Client entity = new Client(username, address, age, over18, pastOrders, pastPayments, email);
        clientRepo.add(entity);
    }

    public Client[] getAllClients() {
        List<Client> result = new ArrayList<>();
        for (int i = 0; i < clientRepo.getSize(); i++) {
            if (clientRepo.get(i) != null) {
                result.add(clientRepo.get(i));
            }
        }
        return result.toArray(new Client[0]);
    }

    public void removeACLient(String email) throws InvalidDataExc {
        boolean ok = true;
        int i;

        for (i = 0; i < clientRepo.getNumberOf() && ok; i++) {
            if (Objects.equals(clientRepo.get(i).getEmail(), email))
                ok = false;

        }
        if (ok)
            throw new InvalidDataExc("Invalid Client");

        else
            clientRepo.delete(clientRepo.get(i - 1));
    }

    public boolean validateEmail(String emailRegister) {
        for (int i = 0; i < clientRepo.getNumberOf(); i++)
            if (Objects.equals(clientRepo.get(i).getEmail(), emailRegister))
                return true;
        return false;
    }

}
