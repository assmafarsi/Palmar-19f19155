package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {

    private Button paymentButton1;
    private Button paymentButton2;
    private ImageView cartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Set up the back button in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        paymentButton1 = findViewById(R.id.btn1);
        paymentButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPayment("A Brief History of Time");
            }
        });

        paymentButton2 = findViewById(R.id.btn2);
        paymentButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPayment("The Silk Roads");
            }
        });

        cartItem = findViewById(R.id.cartItem);
        cartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPaymentActivity();
            }
        });
    }

    private void performPayment(String buttonText) {
        Toast.makeText(this, "Payment successful for " + buttonText + "!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HistoryActivity.this, PaymentActivity.class);
        intent.putExtra("SELECTED_BUTTON_TEXT", buttonText);
        startActivity(intent);
    }

    private void navigateToPaymentActivity() {
        Intent intent = new Intent(HistoryActivity.this, PaymentActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
