package com.example.schedule.ui.activity;


public class StudentClass {
    private final String name;
    private final String telephone;
    private final String email;

    public StudentClass(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
       return name;
    }
}
