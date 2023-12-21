package com.example.doan_10.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.doan_10.R;

public class ManageAccountActivity extends AppCompatActivity {
    private Button editButton, cancelButton;
    private TextView loginButton;
    private EditText nameText,emailText,passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);
        
    }
}