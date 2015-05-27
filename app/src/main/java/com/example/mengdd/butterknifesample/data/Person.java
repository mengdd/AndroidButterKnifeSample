package com.example.mengdd.butterknifesample.data;

public class Person {
    private String name;
    private int age;
    private String location;
    private String work;

    public Person(String name, int age, String location, String work) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
