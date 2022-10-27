package com.example.aflevering2.slagteri;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity


public class Gris {
    @Id
    @GeneratedValue
    private static long ID;
    public int weight;
    public String origin;
    public String date;

    public Gris(int weight, String origin, String date) {
        this.weight = weight;
        this.origin = origin;
        this.date = date;
    }

    public Gris() {}

    public static long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
