package com.example.attendanceappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Activity_Login extends AppCompatActivity {
    public static final String TAG = "TAG";
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private EditText signupEmail, signupPassword;
    private Button loginButton;
    private TextView signUpRedirectText;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        signupEmail = findViewById(R.id.login_email);
        signupPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_Button);
        signUpRedirectText = findViewById(R.id.signUpRedirect);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    signupEmail.setError("Please enter your Email");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    signupEmail.setError("Please enter a valid email adress");
                }
                if (pass.isEmpty()) {
                    signupPassword.setError("Please enter your Username");
                } else {
                    auth.signInWithEmailAndPassword(email, pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(Activity_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Activity_Login.this, MainActivity.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Activity_Login.this, "Login Failed, account not found", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
        signUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_Register.class));
            }
        });
    }
}