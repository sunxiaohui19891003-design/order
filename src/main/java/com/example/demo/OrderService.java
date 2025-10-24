package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // 菜单（固定写在这里，后面可以改成数据库）
    private final String[] dishes = {"红烧肉", "宫保鸡丁", "米饭"};
    private final int[] prices = {20, 18, 2};
    // 订单列表
    private final ArrayList<Order> orders = new ArrayList<>();

    // 返回菜单
    public String[] getDishes() {
        return dishes;
    }

    // 返回当前订单（Controller 调用）
    public ArrayList<Order> getOrders() {
        return orders;
    }

    // 添加菜
    public void addDish(int choice, int quantity) {
        String dishName = dishes[choice - 1];
        int price = prices[choice - 1];
        int cost = price * quantity;
        boolean found = false;
        // 先检查是否已经点过这个菜
        for (Order o : orders) {
            if (o.dishName.equals(dishName)) {
                // 找到了相同的菜，数量加上
                o.quantity += quantity;
                o.cost = o.quantity * price;
                found = true;
                break;
            }
        }
        // 没有点过，新增订单
        if (!found) {
            orders.add(new Order(dishName, quantity, cost));
        }
    }

    // 删除菜
    public void deleteDish(int index) {
        if (index < 0 || index >= orders.size()) return;
        Order o = orders.get(index);
        o.quantity--;
        o.cost = o.quantity * prices[getDishIndex(o.dishName)];
        if (o.quantity <= 0) {
            orders.remove(index);
            System.out.println("已删除一份：" + o.dishName + "，剩余 " + o.quantity + " 份。");
        }
    }

    public int getDishIndex(String dish) {
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].equals(dish)) {
                return i;
            }
        }
        return -1;
    }
}

