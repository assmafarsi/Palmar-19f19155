package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;


public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;
    private dbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        DB = new dbHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                // Check if the username and password are correct
                if (DB.checkCredentials(user, pass)) {
                    showToast("Login successful");

                    // Start the desired activity after successful login
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    finish(); // Finish the login activity
                } else {
                    showToast("Invalid username or password");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Example methods for adding, updating, deleting, and viewing data
    private void addData() {
        boolean result = DB.insertData("Book Title", "Book Author");
        showToast(result ? "Data added successfully" : "Failed to add data");
    }

    private void updateData() {
        boolean result = DB.updateData(1, "New Book Title", "New Book Author");
        showToast(result ? "Data updated successfully" : "Failed to update data");
    }

    private void deleteData() {
        boolean result = DB.deleteData(1);
        showToast(result ? "Data deleted successfully" : "Failed to delete data");
    }

    private void viewData() {
        Cursor cursor = DB.getAllData();
        if (cursor.getCount() == 0) {
            showToast("No data found");
            return;
        }

        StringBuilder data = new StringBuilder();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
            @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("author"));
            data.append("Title: ").append(title).append(", Author: ").append(author).append("\n");
        }

        showToast(data.toString());
    }

    private void clearData() {
        // Code to clear data from the table
    }
}
