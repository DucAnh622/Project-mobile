package com.example.doan_10.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.doan_10.repositories.RegisterRepository;

public class RegisterViewModel extends AndroidViewModel  {
    private RegisterRepository registerRepository;
    public RegisterViewModel(@NonNull Application application) {
        super(application);
        registerRepository = new RegisterRepository(application);
    }
    public void registerAccount(String firstname, String lastname, String email, String username, String password){
        registerRepository.Register(firstname,lastname,email,username,password);
    }
}
