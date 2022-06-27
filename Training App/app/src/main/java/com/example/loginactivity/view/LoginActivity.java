package com.example.loginactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.loginactivity.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    Button login, toSignup;
    EditText loginEmail, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btn_login);
        LinearLayout linearLayout = findViewById(R.id.layout_linear);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                Snackbar.make(linearLayout, "Thank you for logging in", Snackbar.LENGTH_SHORT)
                        .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                        .show();
            }
        });

        login = findViewById(R.id.btn_login);
        toSignup = findViewById(R.id.btn_toSignup);
        loginEmail = findViewById(R.id.et_loginEmail);
        loginPassword = findViewById(R.id.et_LoginPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);
        
        login.setOnClickListener(v -> {
            if (loginEmail.getText().toString().equals(sharedPref.getString("account_username", ""))) {
                Toast.makeText(LoginActivity.this, "Email invalid", Toast.LENGTH_SHORT).show();
            } else if (loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))) {
                Toast.makeText(LoginActivity.this, "Password invalid", Toast.LENGTH_SHORT).show();
            } else if (loginEmail.getText().toString().equals(sharedPref.getString("account_username", ""))
                    && loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))) {
                Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
                loginIntent.putExtra("account_email", sharedPref.getString("account_email", ""));
                startActivity(loginIntent);
            }
        });

        toSignup.setOnClickListener(v -> {
            Intent toSignupIntent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(toSignupIntent);
        });
        
    }
}