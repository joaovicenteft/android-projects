package com.example.schedule.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.R;
import com.example.schedule.model.Student;
import com.example.schedule.ui.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // studentDAO class, returning the list of students objects

        setContentView(R.layout.activity_student_list);
        setTitle("Student List");

        FloatingActionButton floatButtonStudent = findViewById(R.id.button_student_add);

        floatButtonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentListActivity.this,
                        FormsStudentActivity.class));
            }
        });
    }
    // ends the cycle of activity in android
    // this avoids the interface of having backwards motion
    // ends the old activitys
    @Override
    protected void onResume() {
        StudentDAO dao = new StudentDAO();

        super.onResume();
        ListView listaDeAlunos = findViewById(R.id.studentList);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
