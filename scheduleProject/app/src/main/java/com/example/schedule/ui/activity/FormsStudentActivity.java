package com.example.schedule.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schedule.R;
import com.example.schedule.StudentDAO2;
import com.example.schedule.model.Student;
import com.example.schedule.ui.dao.StudentDAO;

public class FormsStudentActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "New student" ;
    // fields
    private EditText nameField;
    private EditText telephoneField;
    private EditText emailField;

    // constant variable
    final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(APPBAR_TITLE);
        setContentView(R.layout.activity_forms_student);

        extracted();
        extractedButton();
    }

    private void extractedButton() {
        Button saveButton = findViewById(R.id.activity_forms_student_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentClass createdStudent = getStudentClass();
                FormsStudentActivity.this.extracted(createdStudent);
                //start a new activity
                startActivity(new Intent(FormsStudentActivity.this,
                        StudentListActivity.class));
            }
        });
    }

    private void extracted(StudentClass createdStudent) {
        dao.save(createdStudent);
        finish();
    }

    private void extracted() {
        nameField = findViewById(R.id.activity_forms_student_name);
        telephoneField = findViewById(R.id.activity_forms_student_telephone);
        emailField = findViewById(R.id.activity_forms_student_email);
    }

    @NonNull
    private StudentClass getStudentClass() {
        String name = nameField.getText().toString();
        String telephone = telephoneField.getText().toString();
        String email = emailField.getText().toString();

        StudentClass createdStudent = new StudentClass(name, telephone, email);
        return createdStudent;
    }
}