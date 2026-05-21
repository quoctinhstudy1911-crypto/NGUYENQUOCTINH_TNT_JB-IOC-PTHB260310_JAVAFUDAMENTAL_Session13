package com.stu.exercise2.presentation;

import com.stu.exercise2.entity.Student;
import com.stu.exercise2.service.AttendanceManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AttendanceManager manager = new AttendanceManager();

        int choice;

        do {

            System.out.println("\n************ MENU QUẢN LÝ ĐIỂM DANH ************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    // Thêm sinh viên
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    manager.addStudent(name);
                    break;

                case 2:

                    // Sửa sinh viên
                    manager.display();
                    System.out.print("Nhập id sinh viên cần sửa: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    manager.update(updateId, newName);
                    break;

                case 3:

                    // Xóa sinh viên
                    manager.display();
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int deleteID = Integer.parseInt(scanner.nextLine());
                    manager.delete(deleteID);
                    break;

                case 4:

                    // Hiển thị danh sách
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
