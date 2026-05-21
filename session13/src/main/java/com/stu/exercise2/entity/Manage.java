package com.stu.exercise2.entity;

public interface Manage<T> {
    void add(T item);
    void update(int index, String newName);
    void delete(int index);
    void display();
}
