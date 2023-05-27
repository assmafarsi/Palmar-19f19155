package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button fantasyButton, factsButton, historyButton, literatureButton;
    private ImageView loginIcon, socialWhat, socialPin, socialInsta;
    private dbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        fantasyButton = findViewById(R.id.fantasyButton);
        factsButton = findViewById(R.id.factsButton);
        historyButton = findViewById(R.id.historyButton);
        literatureButton = findViewById(R.id.literatureButton);
        loginIcon = findViewById(R.id.loginIcon);
        socialWhat = findViewById(R.id.socialWhat);
        socialPin = findViewById(R.id.socialPin);
        socialInsta = findViewById(R.id.socialInsta);
        DB = new dbHelper(this);

        // Set click listeners
        fantasyButton.setOnClickListener(this);
        factsButton.setOnClickListener(this);
        historyButton.setOnClickListener(this);
        literatureButton.setOnClickListener(this);
        loginIcon.setOnClickListener(this);
        socialWhat.setOnClickListener(this);
        socialPin.setOnClickListener(this);
        socialInsta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fantasyButton:
                showToast("Browse Fantasy Books");
                startActivity(FantasyActivity.class);
                break;
            case R.id.factsButton:
                showToast("Browse Facts Books");
                startActivity(FactsActivity.class);
                break;
            case R.id.historyButton:
                showToast("Browse History Books");
                startActivity(HistoryActivity.class);
                break;
            case R.id.literatureButton:
                showToast("Browse Literature Books");
                startActivity(LiteratureActivity.class);
                break;
            case R.id.loginIcon:
                showToast("Login clicked");

                String username = "admin";
                String password = "admin123";

                // Check if the username and password are correct
                if (DB.checkCredentials(username, password)) {
                    showToast("Login successful");
                    // Start the desired activity after successful login
                    startActivity(LoginActivity.class);
                } else {
                    showToast("Invalid username or password");
                }
                break;
            case R.id.socialWhat:
                showToast("WhatsApp");
                break;
            case R.id.socialPin:
                showToast("Pinterest");
                break;
            case R.id.socialInsta:
                showToast("Instagram");
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
