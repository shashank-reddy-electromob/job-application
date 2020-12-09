package org.electromob.jobapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference,reference1,reference2;
    FirebaseRecyclerOptions<job_update_class> options ;
    FirebaseRecyclerAdapter<job_update_class,jobsviewholder> adapter;

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        add = findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),add_job.class));
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("Jobs");
        reference.keepSynced(true);

        options = new FirebaseRecyclerOptions.Builder<job_update_class>()
                .setQuery(reference, job_update_class.class).build();

        adapter = new FirebaseRecyclerAdapter<job_update_class, jobsviewholder>(options) {
            @Override
            protected void onBindViewHolder(jobsviewholder incomeViewHolder, int i, job_update_class incomeinfo) {

                incomeViewHolder.jo.setText(incomeinfo.getJobstring());
                incomeViewHolder.va.setText(incomeinfo.getVacancystringl());
                incomeViewHolder.la.setText(incomeinfo.getLaststring());

            }

            @NonNull
            @Override
            public jobsviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_view, parent, false);

                return new jobsviewholder(view);
            }
        };

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}