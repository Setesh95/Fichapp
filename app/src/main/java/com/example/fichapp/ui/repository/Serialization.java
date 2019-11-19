package com.example.fichapp.ui.repository;

import com.example.fichapp.ui.login.UserModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class Serialization {
    private File users = new File(Constants.FILE_NAME);
    private ArrayList<UserModel> userArray = new ArrayList<>();

    public boolean addUser(UserModel userModel){
        if(fetchUsers()) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(users));
                userArray.add(userModel);
                oos.writeObject(userArray);
                oos.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean fetchUsers(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(users));
            if(ois.readObject() != null) {
                userArray.addAll((ArrayList<UserModel>) ois.readObject());
            }
            ois.close();
            return true;
        }
        catch (IOException | ClassNotFoundException e){
            return false;
        }
    }
}
