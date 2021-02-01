package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1;
    EditText editTextNum2;

    Button addButton;
    Button subButton;
    Button multButton;
    Button divButton;

    String oper;
    private final String KEY1 = "key";
    private final String KEY2 = "key";
    String textView;
    float num1;
    float num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNumber);
        editTextNum2 = findViewById(R.id.editTextNumber2);

        addButton = findViewById(R.id.button_add);
        subButton = findViewById(R.id.button_subtract);
        multButton = findViewById(R.id.button_multiply);
        divButton = findViewById(R.id.button_divine);
    }

    public void onClick(View view) {
        float answer = 0;

        if(TextUtils.isEmpty(editTextNum1.getText().toString()) || TextUtils.isEmpty(editTextNum2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(editTextNum1.getText().toString());
        num2 = Float.parseFloat(editTextNum2.getText().toString());

        switch (view.getId()) {
            case R.id.button_add:
                oper = "+";
                answer = num1 + num2;
                break;
            case R.id.button_subtract:
                oper = "-";
                answer = num1 - num2;
                break;
            case R.id.button_multiply:
                oper = "*";
                answer = num1 * num2;
                break;
            case R.id.button_divine:
                oper = "/";
                answer = num1 / num2;
                break;
            default:
                break;
        }

        textView = String.format("%.2f %s %.2f = %.2f", num1, oper, num2, answer);

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("output", textView);
        startActivity(intent);
    }
}