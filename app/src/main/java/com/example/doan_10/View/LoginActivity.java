package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.doan_10.R;
import com.example.doan_10.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton, cancelButton;
    private TextView registerButton;
    private  EditText nameText,passText;
    private LoginViewModel loginViewModel;
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
                onBackPressed();
//                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
//                startActivity(intent);
//                finish();
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
                    loginViewModel = new ViewModelProvider(LoginActivity.this).get(LoginViewModel.class);
                    loginViewModel.loginAccount(Username,Password);
                    SharedPreferences sharedPreferences = getSharedPreferences("IdUser", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("id_user", 2);
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, "Sign In successfully!", Toast.LENGTH_SHORT).show();
                }
                nameText.setText("");
                passText.setText("");
            }
        });
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