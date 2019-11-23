package com.example.fichapp.ui.repository;

import android.content.Context;
import android.util.Log;

import com.example.fichapp.ui.login.UserModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public class Repository {
    private static Repository repository = null;
    private Context context;
    private ArrayList<UserModel> userList = new ArrayList<>();

    private Repository() {

    }

    public static Repository get() {
        if (repository == null) {
            return repository = getSync();
        } else {
            return repository;
        }
    }

    private static synchronized Repository getSync() {
        if (repository == null) repository = new Repository();
        return repository;
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addUser(UserModel userModel) {
        if(fileExist()) {
            if (fetchUsers()) {
                try {
                    FileOutputStream fos = context.openFileOutput("users", Context.MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    userList.add(userModel);
                    os.writeObject(userList);
                    os.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean fileExist(){
        try{
            FileInputStream fis = context.openFileInput("users");
            ObjectInputStream ois = new ObjectInputStream(fis);
            fis.close();
            ois.close();
            return true;
        } catch (IOException e) {
            try {
                FileOutputStream fos = context.openFileOutput("users", Context.MODE_PRIVATE);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                fos.close();
                os.close();
                return true;
            } catch (IOException er) {
                return false;
            }
        }
    }

    private boolean fetchUsers(){
        try{
            FileInputStream fis = context.openFileInput("users");
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(ois.available() != 0) {
                for (UserModel user : (ArrayList<UserModel>) ois.readObject()) {
                    if (user != null) {
                        userList.add(user);
                    }
                }
            }
            ois.close();
            fis.close();
            return true;
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}
