package com.example.fichapp.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.fichapp.ui.history.RegisterHistoryModel;
import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "user_table")
public class UserModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

//    private ArrayList<RegisterHistoryModel> checkInOutList = new ArrayList<>();
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String company;
    private int age;
    private String role;

    public UserModel(String company, String email, String password) {
        this.email = email;
        this.company = company;
        this.password = password;
        this.role = "admin";
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public ArrayList<RegisterHistoryModel> getCheckInOutList() {
//        return checkInOutList;
//    }

//    public void setCheckInOutList(ArrayList<RegisterHistoryModel> checkInOutList) {
//        this.checkInOutList = checkInOutList;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
