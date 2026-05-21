package com.stu.exercise4.service;

import com.stu.exercise4.entity.Manage;
import com.stu.exercise4.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Manage<Order> {

    private final List<Order> orders = new ArrayList<>();

    // Add
    @Override
    public void add(Order item) {
        orders.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    // Update
    @Override
    public void update(String orderCode, Order item) {
        for (Order order : orders) {
            if (order.getOrderCode().equalsIgnoreCase(orderCode)) {
                order.setOrderCode(item.getOrderCode());
                order.setCustomerName(item.getCustomerName());
                System.out.println("Đơn hàng đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng.");
    }

    // Delete
    @Override
    public void delete(String orderCode) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderCode().equalsIgnoreCase(orderCode)) {
                orders.remove(i);
                System.out.println("Đơn hàng đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng.");
    }

    // Display
    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng đang trống.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println((i + 1) + ". " + orders.get(i)
                );
            }
        }
    }
}