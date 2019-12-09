package com.example.fichapp.repository;

import android.content.Context;

import com.example.fichapp.ui.history.RegisterHistoryModel;
import com.example.fichapp.utils.DateUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Repository {
    private static Repository repository = null;
    private UserModel userLogged = null;
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
            if (!findUser(user)) {
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

    private int generateId() {
        for (UserModel user : userList) {
            if (idGenerated <= user.getId()) {
                idGenerated = user.getId() + 1;
            }
        }
        return idGenerated;
    }

    public boolean findUser(UserModel user) {
        fetchUsers();
        for (UserModel userOfList : userList) {
            if (userOfList.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(UserModel user) {
        fetchUsers();
        for (UserModel usersOfList : userList) {
            if (user.getEmail().equals(usersOfList.getEmail())) {
                if (user.getPassword().equals(usersOfList.getPassword())) {
                    this.userLogged = usersOfList;
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

    public void registerAction(Date date) {

        ArrayList<RegisterHistoryModel> registerList;
        registerList = userLogged.getCheckInOutList();
        if (!userLogged.getCheckInOutList().isEmpty()) {
            RegisterHistoryModel lastRegister = registerList.get(registerList.size() - 1);
            if (lastRegister.getTimeCheckOut() == null) {
                lastRegister.setTimeCheckOut(DateUtils.toTimeString(date));
            } else {
                registerList.add(newRegister(date));
            }
        } else {
            registerList.add(newRegister(date));
        }
        userLogged.setCheckInOutList(registerList);
        updateUserHistoryList();
    }

    private RegisterHistoryModel newRegister(Date date) {
        return new RegisterHistoryModel(DateUtils.toDateString(date), DateUtils.toTimeString(date), null);
    }

    private void updateUserHistoryList() {
        ArrayList<UserModel> updatedList = new ArrayList<>();
        for (UserModel user : userList) {
            if (user.getEmail().equals(userLogged.getEmail())) {
                updatedList.add(userLogged);
            } else {
                updatedList.add(user);
            }
        }
        this.userList = updatedList;
        writeFile();
    }

    public ArrayList<RegisterHistoryModel> getDateList() {
        return userLogged.getCheckInOutList();
    }
}
