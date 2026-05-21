package com.stu.exercise3.presentation;

import com.stu.exercise3.entity.Invoice;
import com.stu.exercise3.service.InvoiceManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();
        int choice;
        do {

            System.out.println("\n*************** MENU QUẢN LÝ HÓA ĐƠN ***************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");

            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    String invoiceCode;
                    do {

                        System.out.print("Nhập mã hóa đơn: ");
                        invoiceCode = scanner.nextLine();
                        if (invoiceCode.trim().isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }
                    } while (invoiceCode.trim().isEmpty());

                    double amount;
                    do {
                        System.out.print("Nhập số tiền: ");
                        amount = Double.parseDouble(scanner.nextLine());

                        if (amount < 0) {
                            System.out.println("Vui lòng nhập số thực >= 0 !");
                        }

                    } while (amount < 0);
                    manager.addInvoice(invoiceCode, amount);
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần sửa: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    String newCode;
                    do {
                        System.out.print("Nhập mã hóa đơn mới: ");
                        newCode = scanner.nextLine();
                        if (newCode.isEmpty()) {
                            System.out.println("Vui lòng ko để trống !");
                        }

                    } while (newCode.isEmpty());

                    double newAmount;
                    do {
                        System.out.print("Nhập số tiền mới: ");
                        newAmount = Double.parseDouble(scanner.nextLine());

                        if (newAmount < 0) {
                            System.out.println("Vui lòng nhập số thực >= 0 !");
                        }

                    } while (newAmount < 0);
                    Invoice updatedInvoice = new Invoice(updateId, newCode, newAmount);
                    manager.update(updateId, updatedInvoice);
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    manager.delete(deleteId);
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