package org.electromob.jobapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_job extends AppCompatActivity {

    private EditText job_tittle, last_date, numberof_vacancies;
    private Button update,display;
    private String job, vacancy, last;
    private DatabaseReference reference,reference1;
    private job_update_class job_update_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);


        update = findViewById(R.id.update);
        job_tittle = findViewById(R.id.job_tittle);
        last_date = findViewById(R.id.last_date_apply);
        numberof_vacancies = findViewById(R.id.number_vacancies);

        display = findViewById(R.id.display);

        reference1 = FirebaseDatabase.getInstance().getReference().child("hello");
        reference1.setValue("welcome");

        reference = FirebaseDatabase.getInstance().getReference().child("Jobs").push();

        job = job_tittle.getText().toString().trim();
        vacancy = numberof_vacancies.getText().toString().trim();
        last = last_date.getText().toString().trim();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                job_update_class = new job_update_class(job,last,vacancy);
                reference.setValue(job_update_class);

                Toast.makeText(getApplicationContext(),"Task sucessfull",Toast.LENGTH_SHORT).show();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


    }
}