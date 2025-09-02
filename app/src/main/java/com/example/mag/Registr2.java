package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registr2 extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText et_username, et_password;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr2);

        databaseHelper = new DatabaseHelper(this);
        et_username = (EditText)findViewById(R.id.login);
        et_password = (EditText)findViewById(R.id.password);

        btn_register= (Button)findViewById(R.id.button_zareg);
    }

    public void next(View view) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        if(username.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "Заполните поля!", Toast.LENGTH_SHORT).show();
        }else{
            if(password.equals(password)){
                Boolean checkusername = databaseHelper.CheckUsername(username);
                if(checkusername == true){
                    Boolean insert = databaseHelper.Insert(username, password);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(), "Регистрация пройдена!", Toast.LENGTH_SHORT).show();
                        et_username.setText("");
                        et_password.setText("");
                        Intent intent = new Intent(this, Katalog.class);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Имя пользователя занято", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Некорректный пароль", Toast.LENGTH_SHORT).show();
            }
    }
}
}
