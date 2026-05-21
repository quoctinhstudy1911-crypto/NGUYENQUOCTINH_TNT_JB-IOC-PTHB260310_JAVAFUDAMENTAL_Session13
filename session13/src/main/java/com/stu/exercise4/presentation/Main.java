package com.stu.exercise4.presentation;

import com.stu.exercise4.entity.Order;
import com.stu.exercise4.service.OrderManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        int choice;

        do {

            System.out.println("\n*************** MENU QUẢN LÝ ĐƠN HÀNG ***************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");

            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    String orderCode;
                    do {
                        System.out.print("Nhập mã đơn hàng: ");
                        orderCode = scanner.nextLine();
                        if (orderCode.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }
                    } while (orderCode.trim().isEmpty());

                    String customerName;
                    do {
                        System.out.print("Nhập tên khách hàng: ");
                        customerName = scanner.nextLine();
                        if (customerName.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }
                    } while (customerName.trim().isEmpty());

                    Order order =
                            new Order(orderCode, customerName);
                    manager.add(order);
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần sửa: ");
                    String updateCode = scanner.nextLine();
                    String newCode;

                    do {
                        System.out.print("Nhập mã đơn hàng mới: ");
                        newCode = scanner.nextLine();
                        if (newCode.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }
                    } while (newCode.trim().isEmpty());

                    String newCustomerName;
                    do {
                        System.out.print("Nhập tên khách hàng mới: ");
                        newCustomerName = scanner.nextLine();
                        if (newCustomerName.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }
                    } while (newCustomerName.trim().isEmpty());

                    Order updatedOrder = new Order(newCode, newCustomerName);
                    manager.update(updateCode, updatedOrder);
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần xóa: ");
                    String deleteCode = scanner.nextLine();
                    manager.delete(deleteCode);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 5);
        scanner.close();
    }
}