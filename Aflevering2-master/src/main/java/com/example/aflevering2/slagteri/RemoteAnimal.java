package com.example.aflevering2.slagteri;

import client.ShClient;

import java.util.List;

public class RemoteAnimal implements IAnimal{

private final ShClient shClient;

    public RemoteAnimal(ShClient shClient) {
        this.shClient = shClient;
    }

    public Gris createGris(int weight, String origin, String date) {
        return null;
    }

    public Gris getGris(long ID) {
        return null;
    }

    @Override
    public List<Gris> getAllGrise() {
        return null;
    }
}
