package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Basket extends AppCompatActivity {

    TextView cartContent;

    public void maps(View view) {
        Intent intent = new Intent(this, Maps.class);
        startActivity(intent);
        finish();
    }

    public void katalog(View view) {
        Intent intent = new Intent(this, Katalog.class);
        startActivity(intent);
        finish();
    }

    public void basket(View view) {
        Toast toast = Toast.makeText(this, "Вы находитесь в корзине:)\uD83C\uDF52", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // Получаем SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Получаем значения элементов корзины
        String item1Value = sharedPreferences.getString("item1", "");
        String item2Value = sharedPreferences.getString("item2", "");
        String item3Value = sharedPreferences.getString("item3", "");
        String item4Value = sharedPreferences.getString("item4", "");

        // Находим TextView для отображения элементов
        TextView item1TextView = findViewById(R.id.item1);
        TextView item2TextView = findViewById(R.id.item2);
        TextView item3TextView = findViewById(R.id.item3);
        TextView item4TextView = findViewById(R.id.item4);

        // Устанавливаем значения в TextView
        item1TextView.setText(item1Value);
        item2TextView.setText(item2Value);
        item3TextView.setText(item3Value);
        item4TextView.setText(item4Value);
    }
    }

