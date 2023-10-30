package org.rental.account;

public class Cars {
    private String carName;
    private String carType;
    private int price;
    private int number;
    public Cars(String carName, String carType, int price, int number) {
        this.carName = carName;
        this.carType = carType;
        this.price = price;
        this.number = number;
    }

    public Cars() {
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cars [carName=" + carName + ", carType=" + carType + ", price=" + price + ", number=" + number + "]";
    }
    
}
