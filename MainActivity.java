package com.example.simpleaddition;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2, etResult;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etResult = findViewById(R.id.etResult);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            String num1Str = etNum1.getText().toString().trim();
            String num2Str = etNum2.getText().toString().trim();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                double sum = num1 + num2;
                etResult.setText(String.valueOf(sum));
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
