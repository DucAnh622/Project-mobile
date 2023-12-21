package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_10.R;
import com.example.doan_10.viewmodels.LoginViewModel;
import com.example.doan_10.viewmodels.RegisterViewModel;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private  Button registerButton, cancelButton;
    private TextView loginButton;
    private  EditText firstnameText,lastnameText, usernameText,emailText,passText;

    private RegisterViewModel registerViewModel;
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

        firstnameText = findViewById(R.id.firstname);
        lastnameText = findViewById(R.id.lastname);
        usernameText = findViewById(R.id.username);
        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        cancelButton = findViewById(R.id.CancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
//                startActivity(intent);
//                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Firstname = firstnameText.getText().toString();
                String Lastname = lastnameText.getText().toString();
                String Username = usernameText.getText().toString();
                String Email = emailText.getText().toString();
                String Password = passText.getText().toString();
                if(Validate(Firstname,Lastname,Email,Username,Password) == true) {
                    registerViewModel = new ViewModelProvider(RegisterActivity.this).get(RegisterViewModel.class);
                    registerViewModel.registerAccount(Firstname,Lastname,Email,Username,Password);
                    Toast.makeText(RegisterActivity.this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                firstnameText.setText("");
                lastnameText.setText("");
                usernameText.setText("");
                emailText.setText("");
                passText.setText("");
            }
        });
    }

    public boolean Validate(String firstname ,String lastname, String username,String email,String pass) {
        if(firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Invalid input!", Toast.LENGTH_SHORT).show();
            return false;
        }
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (Pattern.matches(emailRegex, email)) {
            Toast.makeText(RegisterActivity.this, "Wrong email format", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass.length() < 5) {
            Toast.makeText(RegisterActivity.this, "Password must be longer than 5", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("selected_fragment", "menu");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}