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

public class FactsActivity extends AppCompatActivity {

    private Button paymentButton1;
    private Button paymentButton2;
    private ImageView cartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        // Set up the back button in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        paymentButton1 = findViewById(R.id.btn1);
        paymentButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPayment("Silent Spring");
            }
        });

        paymentButton2 = findViewById(R.id.btn2);
        paymentButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPayment("The Diary of a Young Girl");
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
        Intent intent = new Intent(FactsActivity.this, PaymentActivity.class);
        intent.putExtra("SELECTED_BUTTON_TEXT", buttonText);
        startActivity(intent);
    }

    private void navigateToPaymentActivity() {
        Intent intent = new Intent(FactsActivity.this, PaymentActivity.class);
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
