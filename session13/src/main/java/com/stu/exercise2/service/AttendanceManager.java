package com.stu.exercise2.service;

import com.stu.exercise2.entity.Manage;
import com.stu.exercise2.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student> {
    private final List<Student> students = new ArrayList<>();
    private int currentId = 1;

    // Thêm sinh viên
    public void addStudent(String name) {

        Student student = new Student(currentId++, name);

        students.add(student);

        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void add(Student item) {
        students.add(item);
    }

    // Sửa sinh viên
    @Override
    public void update(int id, String newName) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(newName);

                System.out.println("Sửa thành công.");

                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên.");
    }

    // Xóa sinh viên
    @Override
    public void delete(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                System.out.println("Xóa thành công.");

                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên.");
    }

    // Hiển thị danh sách
    @Override
    public void display() {

        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
        } else {

            System.out.println("===== DANH SÁCH SINH VIÊN =====");

            students.forEach(System.out::println);
        }
    }
}
