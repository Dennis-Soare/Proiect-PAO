package repositories;

import models.Client;

import java.util.Arrays;

public class ClientRepo implements GenericRepo<Client> {

    private Client[] storage = new Client[11];

    @Override
    public void add(Client entity) {
        for(int i=0; i<storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = entity;
                return;
            }
        }
        Client[] newStorage = Arrays.<Client, Client>copyOf(storage, 2 * storage.length, Client[].class);

        newStorage[storage.length] = entity;
        storage = newStorage;
    }

    @Override
    public Client get(int id) {
        return storage[id];
    }

    @Override
    public void update(Client entity, Client newEntity) {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] != null && storage[i].hashCode() == entity.hashCode())
                storage[i] = newEntity;
    }

    @Override
    public void delete(Client entity) {
        Client[] newStorage = new Client[storage.length - 1];
        int j = 0;
        for (Client client : storage) {
            if (client != null && client.hashCode() != entity.hashCode()) {
                newStorage[j++] = client;
            }
        }
        storage = newStorage;
    }

    @Override
    public int getSize() {
        return storage.length;
    }
}
