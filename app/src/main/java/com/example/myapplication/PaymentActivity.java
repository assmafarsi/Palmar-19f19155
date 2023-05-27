package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends BaseActivity {

    private TextView selectedButtonTextView;
    private Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable the home button
        getSupportActionBar().setDisplayShowHomeEnabled(true); // Provide an up button

        selectedButtonTextView = findViewById(R.id.selectedButtonTextView);
        payButton = findViewById(R.id.Paybtn);

        String selectedButtonText = getIntent().getStringExtra("SELECTED_BUTTON_TEXT");
        if (selectedButtonText != null) {
            selectedButtonTextView.setText(selectedButtonText);
        }

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform payment logic here
                Toast.makeText(PaymentActivity.this, "Payment successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button click here
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}