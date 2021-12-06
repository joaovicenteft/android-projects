package com.example.schedule.ui.dao;

import com.example.schedule.model.Student;
import com.example.schedule.ui.activity.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<StudentClass> students = new ArrayList<>();

    public void save(StudentClass createdStudent) {
        students.add(createdStudent);
    }

    public List<StudentClass> all() {
        return new ArrayList<>(students);
    }
}
