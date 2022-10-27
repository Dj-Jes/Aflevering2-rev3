package com.example.aflevering2.slagteri;

import java.util.List;

public interface IAnimal {

    Gris createGris(int weight, String origin, String date);
    Gris getGris(long ID);
    List<Gris> getAllGrise();
}
