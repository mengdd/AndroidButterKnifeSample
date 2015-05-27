package com.example.mengdd.butterknifesample.data;

import java.util.ArrayList;
import java.util.List;

public class MockDataUtils {

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String name = "Name";
        int age = 20;
        String location = "Location";
        String work = "Work";
        for (int i = 0; i < 10; ++i) {
            Person person = new Person(name + " " + i, 20 + i, location + " " + i, work + " " + i);
            persons.add(person);
        }
        return persons;
    }
}
