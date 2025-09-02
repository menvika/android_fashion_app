package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Trousers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trousers);
    }

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
        Intent intent = new Intent(this, Basket.class);
        startActivity(intent);
        finish();
    }
    public void add (View view)
    {
        TextView name = (TextView)findViewById(R.id.name);
        EditText size1 = (EditText)findViewById(R.id.size1);
        EditText size2 = (EditText)findViewById(R.id.size2);
        String staticValue_name = name.getText().toString();
        String dynamicValue_size1 = size1.getText().toString();
        String dynamicValue_size2 = size2.getText().toString();
        // Объединение статического и динамического значений
        String finalString = staticValue_name + " (" + dynamicValue_size1 + " см, " + dynamicValue_size2 + " см).";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String item = "item" + Katalog.count;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(item, finalString);
        Katalog.count++;
        editor.apply();
        Toast toast = Toast.makeText(this, "Добавлено!\uD83C\uDF52", Toast.LENGTH_LONG);
        toast.show();
    }
}