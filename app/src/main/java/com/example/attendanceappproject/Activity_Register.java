package com.example.attendanceappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Activity_Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private EditText signupEmail, signupPassword, signupUser;
    private Button signupButton;
    private TextView loginRedirectText;
    private Switch switchView;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        signupEmail = findViewById(R.id.new_mail);
        signupPassword = findViewById(R.id.new_password);
        signupUser = findViewById(R.id.new_username);
        signupButton = findViewById(R.id.register_button);
        loginRedirectText = findViewById(R.id.logInRedirect);
        switchView = findViewById(R.id.switch_view);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();
                String username = signupUser.getText().toString().trim();
                Boolean type = switchView.isChecked();

                if (email.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                }
                if (username.isEmpty()){
                    signupUser.setError("User cannot be empty");
                }
                else{
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Activity_Register.this, "SignUp Successful", Toast.LENGTH_SHORT).show();



                                userID = auth.getCurrentUser().getUid();
                                DocumentReference documentReference = firestore.collection("users").document(userID);

                                Map<String, Object> user = new HashMap<>();
                                user.put("email",email);
                                user.put("password",pass);
                                user.put("uname",username);
                                user.put("type",type);

                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        Log.d(TAG, "onSuccess: user profile is created for " + userID);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });

                                startActivity(new Intent(Activity_Register.this, Activity_Login.class));
                            } else {
                                Toast.makeText(Activity_Register.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Register.this, Activity_Login.class));
            }
        });
    }
}