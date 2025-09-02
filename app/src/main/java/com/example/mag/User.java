package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void voity(View view) {
        Intent intent = new Intent(this, Login2.class);
        startActivity(intent);
    }
    public void zareg(View view) {
        Intent intent = new Intent(this, Registr2.class);
        startActivity(intent);
        finish();
    }
}