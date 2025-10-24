package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService service;
    // 通过构造函数注入 OrderService
    public OrderController(OrderService service) {
        this.service = service;
    }
    // 获取菜单
    @GetMapping("/menu")
    public String[] getMenu() {
        return service.getDishes();
    }
    // 获取当前账单（返回 JSON）
    @GetMapping("/orders")
    public ArrayList<Order> getOrders() {
        return service.getOrders();
    }
    // 添加菜（POST 请求）
//    @PostMapping("/add")
//    public String addOrder(@RequestParam int dish, @RequestParam int qty) {
//        service.addDish(dish, qty);
//        return "已添加菜品";
//    }
    @PostMapping("/order")
    public String addOrder(@RequestParam int dish, @RequestParam int qty) {
        service.addDish(dish, qty);
        return "已添加菜品";  // 添加后刷新页面
    }
    // 删除菜（DELETE 请求）
    @DeleteMapping("/delete")
    public String deleteOrder(@RequestParam int index) {
        service.deleteDish(index);
        return "已删除一份菜品";
    }

}
