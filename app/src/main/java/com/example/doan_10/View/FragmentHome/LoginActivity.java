package com.example.doan_10.View.FragmentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.doan_10.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton, cancelButton;
    private TextView registerButton;
    private  EditText nameText,passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerButton = findViewById(R.id.toRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        nameText = findViewById(R.id.username);
        passText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        cancelButton = findViewById(R.id.CancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = nameText.getText().toString();
                String Password = passText.getText().toString();
                if(Username.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Sign In successfully!", Toast.LENGTH_SHORT).show();
                }
                nameText.setText("");
                passText.setText("");
            }
        });
    }
}