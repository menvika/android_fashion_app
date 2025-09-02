package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login2 extends AppCompatActivity {

    Button btn_llogin;
    EditText et_lusername, et_lpassword;

    DatabaseHelper databaseHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        databaseHelper = new DatabaseHelper(this);

        et_lusername = (EditText)findViewById(R.id.login);
        et_lpassword = (EditText)findViewById(R.id.password);

        btn_llogin = (Button)findViewById(R.id.button_voity);
        };

    public void next(View view) {
        String username = et_lusername.getText().toString();
        String password = et_lpassword.getText().toString();

        Boolean checklogin = databaseHelper.CheckLogin(username, password);
        if(checklogin == true){
            Toast.makeText(getApplicationContext(), "Данные введены корректно\nДобро пожаловать!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Katalog.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Данные введены некорректно\nПовторите попытку!", Toast.LENGTH_SHORT).show();
        }
    }
}
