package nl.capgemini.printers.model;

import java.io.Serializable;

public class Printer implements Serializable {

    private long id;

    private String type;
    private double price;

    public Printer() {

    }

    public Printer(long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
