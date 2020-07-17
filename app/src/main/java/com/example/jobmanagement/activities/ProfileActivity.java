package com.example.jobmanagement.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobmanagement.R;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;
import com.example.jobmanagement.db_repositories.job_profile.InsertJobProfileAsync;

public class ProfileActivity extends AppCompatActivity {

    EditText etPassword, etEmail, etConfirmPassword, etFirstName, etLastName, etId, etCellphone;

    Button btnRegister;

    String[] qualification , studyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnRegister = findViewById(R.id.btnRegister);
        etPassword = findViewById(R.id.etPasswordLogin);
        etConfirmPassword= findViewById(R.id.etConfirmPasswordRegister);
        etFirstName = findViewById(R.id.etFirstNameRegister);
        etLastName = findViewById(R.id.etLastNameRegister);
        etId = findViewById(R.id.etIdNumRegister);
        etCellphone = findViewById(R.id.etCellphoneRegister);

        Resources res = getResources();
        qualification = res.getStringArray(R.array.qualification_list);
        studyField = res.getStringArray(R.array.education_list);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JobProfile jobProfile = new JobProfile();
                jobProfile.setId(Long.parseLong(etId.getText().toString().trim()));
                jobProfile.setEmail(etEmail.getText().toString().trim());
                jobProfile.setName(etFirstName.getText().toString().trim());
                jobProfile.setSurname(etLastName.getText().toString().trim());
                jobProfile.setCellphone(etCellphone.getText().toString().trim());
                jobProfile.setPassword(etPassword.getText().toString().trim());

                if(etId.getText().toString().trim().isEmpty() || etEmail.getText().toString().trim().isEmpty() || etFirstName.getText().toString().trim().isEmpty() ||
                        etLastName.getText().toString().trim().isEmpty() || etCellphone.getText().toString().trim().isEmpty() || etPassword.getText().toString().trim().isEmpty()
                )
                {
                    new InsertJobProfileAsync(jobProfile, getApplicationContext(), new AsyncTaskCallback<JobProfile>() {
                        @Override
                        public void onSuccess(JobProfile object) {

                        }

                        @Override
                        public void onException(Exception exception) {

                        }
                    });

                }else{
                    Toast.makeText(ProfileActivity.this,"Please enter all fields",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
