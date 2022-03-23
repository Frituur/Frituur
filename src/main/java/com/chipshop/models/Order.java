package com.chipshop.models;
import java.time.LocalDate;

public class Order {
    private int id;
    private int numberOfProducts;
    private double totalPrice;
    private LocalDate timeOfOrder;
    private LocalDate arrivalTime;
    private Status orderStatus;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(LocalDate timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
