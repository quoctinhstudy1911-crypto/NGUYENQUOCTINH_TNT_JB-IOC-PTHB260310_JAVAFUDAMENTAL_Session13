package com.stu.exercise4.entity;

public interface Manage<T> {

    void add(T item);

    void update(String orderCode, T item);

    void delete(String orderCode);

    void display();
}