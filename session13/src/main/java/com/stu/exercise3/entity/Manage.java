package com.stu.exercise3.entity;

public interface Manage<T> {

    void add(T item);

    void update(int id, T item);

    void delete(int id);

    void display();
}
