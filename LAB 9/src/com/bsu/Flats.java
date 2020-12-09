package com.bsu;

public class Flats {
    String nameOfFlat;
    double numOfSqM;
    String nearestMetro;
    int pricePerMonth;

    public Flats(String nameOfFlat, double numOfSqM, String nearestMetro, int pricePerMonth) {
        this.nameOfFlat = nameOfFlat;
        this.nearestMetro = nearestMetro;
        this.numOfSqM = numOfSqM;
        this.pricePerMonth = pricePerMonth;
    }

    public String getNameOfFlat(){
     return nameOfFlat;
    }
    public String getNearestMetro(){
        return nearestMetro;
    }
    public double getNumOfSqM(){
        return numOfSqM;
    }
    public int getPricePerMonth(){
        return pricePerMonth;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "Owner ='" + nameOfFlat + '\'' +
                ", price=" + pricePerMonth +
                ", SqM =" + numOfSqM+
                ", nearest metro ='" + nearestMetro + '\'' +
                '}';
    }
}
