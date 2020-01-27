package nl.capgemini.printers.model;

import java.io.Serializable;

public class Printer implements Serializable {

    private String type;
    private double price;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
