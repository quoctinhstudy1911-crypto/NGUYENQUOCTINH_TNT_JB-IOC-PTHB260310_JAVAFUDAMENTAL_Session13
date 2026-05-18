package com.stu.exercise1.presentation;

import com.stu.exercise1.entity.Person;
import com.stu.exercise1.service.PersonService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PersonService personService = new PersonService();

        int choice;

        do {

            System.out.println("\n************** MENU QUẢN LÝ NGƯỜI DÙNG **************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");

            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> {

                    String name;
                    String email;
                    String phone;

                    do {

                        System.out.print("Nhập tên người dùng: ");
                        name = scanner.nextLine();

                        if(name.isBlank()) {
                            System.out.println("\nVui lòng ko để trống !");
                        }

                    } while (name.isBlank());

                    do {

                        System.out.print("Nhập email người dùng: ");
                        email = scanner.nextLine();

                        if(email.isBlank()) {
                            System.out.println("\nVui lòng ko để trống !");
                        }

                    } while (email.isBlank());


                    do {

                        System.out.print("Nhập số điện thoại người dùng: ");
                        phone = scanner.nextLine();

                        if(phone.isBlank()) {
                            System.out.println("\nVui lòng ko để trống !");
                        }

                    } while (phone.isBlank());


                    Person person =
                            new Person(name, email, phone);

                    boolean isSuccess =
                            personService.addPerson(person);

                    if(isSuccess) {
                        System.out.println("\nNgười dùng đã được thêm thành công.");
                    }
                }


                case 2 -> {

                    System.out.print("Nhập email cần xóa: ");

                    String email =
                            scanner.nextLine();

                    boolean isRemoved =
                            personService.removeByEmail(email);

                    if(isRemoved) {
                        System.out.println("\nXóa người dùng thành công.");
                    }
                    else {
                        System.out.println("\nKhông tìm thấy email.");
                    }
                }


                case 3 -> personService.printList();


                case 4 ->
                        System.out.println("\nThoát chương trình...");


                default ->
                        System.out.println("\nLựa chọn không hợp lệ !");
            }

        } while (choice != 4);

        scanner.close();
    }
}