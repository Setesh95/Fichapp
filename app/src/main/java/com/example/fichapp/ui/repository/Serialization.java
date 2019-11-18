package com.example.fichapp.ui.repository;

import com.example.fichapp.ui.login.UserModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.security.auth.callback.Callback;

public class Serialization {
    private File users = new File(Constants.FILE_NAME);

    public boolean writeUser(UserModel userModel){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(users));
            oos.writeObject(userModel);
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
