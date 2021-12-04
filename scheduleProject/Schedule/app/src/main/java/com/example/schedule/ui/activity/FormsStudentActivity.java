package com.example.schedule.ui.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_student);

        StudentDAO dao = new StudentDAO();

        final EditText nameField = findViewById(R.id.activity_forms_student_name);
        final EditText telephoneField = findViewById(R.id.activity_forms_student_telephone);
        final EditText emailField = findViewById(R.id.activity_forms_student_email);

        Button saveButton = findViewById(R.id.activity_forms_student_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                String telephone = telephoneField.getText().toString();
                String email = telephoneField.getText().toString();

                StudentClass createdStudent = new StudentClass(name, telephone, email);

                dao.save(createdStudent);

                finish();
                //start a new activity
                startActivity(new Intent(FormsStudentActivity.this,
                        StudentListActivity.class));
            }
        });
    }
}