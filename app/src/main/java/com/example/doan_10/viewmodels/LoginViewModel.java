package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.doan_10.repositories.LoginRepository;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }
    public void loginAccount(String username, String password){
        loginRepository.Login(username,password);
    }
}
