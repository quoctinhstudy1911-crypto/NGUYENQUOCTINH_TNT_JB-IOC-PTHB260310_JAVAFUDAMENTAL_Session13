package com.stu.exercise1.service;

import com.stu.exercise1.entity.Person;

import java.util.LinkedList;

public class PersonService {
    private final LinkedList<Person> listPerson = new LinkedList<>();

    public boolean addPerson(Person p)
    {
        return listPerson.add(p);

    }

    public  boolean removeByEmail(String email)
    {
       return listPerson.removeIf(person -> email.equalsIgnoreCase(person.getEmail()));
    }

    public  void printList ()
    {
        System.out.println("Danh sách người dùng: ");
        listPerson.forEach(System.out::println);
    }

}
