package com.example.aflevering2.slagteri;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity


public class Gris {
    @Id
    @GeneratedValue
    private long ID;
    public int vægt;
    public String origen;
    public String date;

    public Gris(int vægt, String origen, String date) {
        this.vægt = vægt;
        this.origen = origen;
        this.date = date;
    }

    public Gris() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getVægt() {
        return vægt;
    }

    public void setVægt(int vægt) {
        this.vægt = vægt;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
