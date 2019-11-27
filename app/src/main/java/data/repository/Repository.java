package data.repository;

import android.content.Context;

import com.example.fichapp.ui.model.UserModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Repository {
    private static Repository repository = null;
    private Context context;
    private ArrayList<UserModel> userList = new ArrayList<>();
    private String fileName = Constants.FILE_NAME;

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
                writeFile(user);
            }
        } else {
            writeFile(user);
        }
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

    private void writeFile(UserModel user) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            userList.add(user);
            os.writeObject(userList);
            os.close();
            fos.close();
            System.out.println(userList.size());
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
}
