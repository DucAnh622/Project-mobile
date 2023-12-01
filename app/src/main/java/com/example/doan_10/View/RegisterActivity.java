package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_10.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private  Button registerButton, cancelButton;
    private TextView loginButton;
    private  EditText nameText,emailText,passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginButton = findViewById(R.id.toLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        nameText = findViewById(R.id.username);
        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        cancelButton = findViewById(R.id.CancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = nameText.getText().toString();
                String Email = emailText.getText().toString();
                String Password = passText.getText().toString();
                if(Validate(Username,Email,Password) == true) {
                    Toast.makeText(RegisterActivity.this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                nameText.setText("");
                emailText.setText("");
                passText.setText("");
            }
        });
    }

    public boolean Validate(String name,String email,String pass) {
        if(name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
            return false;
        }
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(emailRegex, email)) {
            Toast.makeText(RegisterActivity.this, "Wrong email format", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass.length() <= 5) {
            Toast.makeText(RegisterActivity.this, "Password must be longer than 5", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}