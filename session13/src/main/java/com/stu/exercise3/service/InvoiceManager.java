package com.stu.exercise3.service;

import com.stu.exercise3.entity.Invoice;
import com.stu.exercise3.entity.Manage;

import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements Manage<Invoice> {

    private final List<Invoice> invoices = new ArrayList<>();
    private int currentId = 1;

    // Thêm hóa đơn
    public void addInvoice(String invoiceCode, double amount) {
        Invoice invoice = new Invoice(currentId++, invoiceCode, amount);
        invoices.add(invoice);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void add(Invoice item) {

        invoices.add(item);
    }

    // Update
    @Override
    public void update(int id, Invoice item) {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                invoice.setInvoiceCode(item.getInvoiceCode());
                invoice.setAmount(item.getAmount());
                System.out.println("Hóa đơn đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
    }

    // Delete
    @Override
    public void delete(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getId() == id) {
                invoices.remove(i);
                System.out.println("Hóa đơn đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
    }

    // Display
    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn đang trống.");
        } else {
            for (int i = 0; i < invoices.size(); i++) {
                invoices.forEach(System.out::println);
            }
        }
    }

}