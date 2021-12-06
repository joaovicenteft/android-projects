package com.example.schedule.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.R;
import com.example.schedule.ui.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentListActivity extends AppCompatActivity {

    private final StudentDAO dao = new StudentDAO();

    public static final String LIST_APPBAR = "Student List";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // studentDAO class, returning the list of students objects

        setContentView(R.layout.activity_student_list);
        setTitle(LIST_APPBAR);

        buttonFloatAction();
    }

    private void buttonFloatAction() {
        FloatingActionButton floatButtonStudent = findViewById(R.id.button_student_add);

        floatButtonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formsActionCall();
            }
        });
    }

    private void formsActionCall() {
        startActivity(new Intent(this,
                FormsStudentActivity.class));
    }

    // ends the cycle of activity in android
    // this avoids the interface of having backwards motion
    // ends the old activitys
    @Override
    protected void onResume() {

        super.onResume();
        listSetting();
    }

    private void listSetting() {
        ListView listaDeAlunos = findViewById(R.id.studentList);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
