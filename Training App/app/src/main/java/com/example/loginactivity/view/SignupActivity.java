package com.example.loginactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginactivity.R;

public class SignupActivity extends AppCompatActivity {

    Button signup, toLogin;
    EditText signupUsername, signupEmail, signupPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.btn_signup);
        toLogin = findViewById(R.id.btn_toLogin);
        signupUsername = findViewById(R.id.et_signupUsername);
        signupEmail = findViewById(R.id.et_signupEmail);
        signupPassword = findViewById(R.id.et_signupPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        signup.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("account_username", signupUsername.getText().toString());
            editor.putString("account_email", signupEmail.getText().toString());
            editor.putString("account_password", signupPassword.getText().toString());
            editor.apply();

            Toast.makeText(SignupActivity.this, "Sign Up successful, return to Log In Page!", Toast.LENGTH_SHORT).show();

            Intent signupIntent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(signupIntent);
        });

        toLogin.setOnClickListener(v -> {
            Intent toLoginIntent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(toLoginIntent);
        });
    }
}