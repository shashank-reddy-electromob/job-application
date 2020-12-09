package org.electromob.jobapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreatBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=findViewById(R.id.editTextEmailAddress);
        mPassword=findViewById(R.id.editTextPassword);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();
        mLoginBtn=findViewById(R.id.button2);
        mCreatBtn=findViewById(R.id.createText);

        mCreatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),register.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                //String email=mEmail.getText().toString().trim();
                //String password=mPassword.getText().toString().trim();

                //if(TextUtils.isEmpty(email)){
                //    mEmail.setError("Email is Required.");
                //    return;
                //}
                //if(TextUtils.isEmpty(password)){
                //    mPassword.setError("Password is Required.");
                //    return;
                //}
                //if(password.length() < 6){
                //    mPassword.setError("Password Must be >=6 Characters");
                //    return;
                //}
                //progressBar.setVisibility(View.VISIBLE);

                //fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                //    @Override
                //    public void onComplete(@NonNull Task<AuthResult> task) {
                //        if (task.isSuccessful()) {
                //            Toast.makeText(login.this,
                //                    "logged in successfully.", Toast.LENGTH_SHORT).
                //                    show();
                //             startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
                //         } else {
                //             Toast.makeText(login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT);
                //         }
                //     }
                //});
            }
        });

    }
}