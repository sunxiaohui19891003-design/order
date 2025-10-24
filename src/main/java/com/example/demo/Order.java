package com.example.demo;

public class Order {
    String dishName;
    int quantity;
    int cost;

    public Order(String dishName, int quantity, int cost) {
        this.dishName = dishName;
        this.quantity = quantity;
        this.cost = cost;
    }

    // Getter 和 Setter（保证可以序列化为 JSON）
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
