package com.example.fichapp.repository;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Repository {
    private static Repository repository = null;
    private UserModel userLoged = null;
    private Context context;
    private ArrayList<UserModel> userList = new ArrayList<>();
    private String fileName = Constants.FILE_NAME;
    private int idGenerated = 0;

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

    public void addUser(UserModel user) {
        if (fileExist()) {
            fetchUsers();
            if(!findUser(user)){
                user.setId(generateId());
                user.setRole("admin");
                userList.add(user);
                writeFile();
            }
        } else {
            userList.add(user);
            writeFile();
        }
    }

    private int generateId(){
        for(UserModel userOfList : userList){
            if(idGenerated <= userOfList.getId()){
                idGenerated = userOfList.getId() + 1;
            }
        }
        return idGenerated;
    }

    public boolean findUser(UserModel user){
        fetchUsers();
        for(UserModel userOfList : userList){
            if(userOfList.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(UserModel user){
        fetchUsers();
        for(UserModel usersOfList : userList){
            if(user.getEmail().equals(usersOfList.getEmail())){
                if(user.getPassword().equals(usersOfList.getPassword())){
                    this.userLoged = usersOfList;
                    return true;
                }
            }
        }
        return false;
    }

    private void writeFile() {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(userList);
            os.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fileExist() {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            fis.close();
            ois.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void fetchUsers() {
        if (userList.isEmpty()) {
            try {
                FileInputStream fis = context.openFileInput(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList.addAll((ArrayList<UserModel>) ois.readObject());
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerAction(Date date){
        ArrayList<Date> registerList = new ArrayList<>();
        if(!userLoged.getCheckInOutList().isEmpty()){
            registerList = userLoged.getCheckInOutList();
            registerList.add(date);
            userLoged.setCheckInOutList(registerList);
        }
        else {
            registerList.add(date);
            userLoged.setCheckInOutList(registerList);
        }
        updateUser();
    }

    private void updateUser(){
        ArrayList<UserModel> updatedList = new ArrayList<>();
        for(UserModel userOfList : userList){
            if(userOfList.getEmail().equals(userLoged.getEmail())){
                updatedList.add(userLoged);
            } else {
                updatedList.add(userOfList);
            }
        }
        userList = updatedList;
        writeFile();
    }
}
