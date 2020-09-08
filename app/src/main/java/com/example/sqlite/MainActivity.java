package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        insertUser();
        getAllUser();
        updateUser();
        deleteUser();
    }

    public void insertUser() {
        User user = new User("Nguyen Van A", "Male", 20);
        String message = dbHelper.insertDB(user);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void getAllUser() {
        List<User> userList = dbHelper.getAllUser();
        for (User user : userList) {
            Log.d("USER", "name: " + user.getName() + " id: " + user.getId() + " age: " + user.getAge());
        }
    }

    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("Nguyen Van B Update");
        user.setAge(21);
        String message = dbHelper.updateUser(user);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void deleteUser() {
        dbHelper.deleteUser(1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.close();
    }
}