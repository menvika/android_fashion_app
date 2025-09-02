package com.example.mag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Katalog extends AppCompatActivity {
    public static Integer count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
    }
    public void basket(View view) {
        Intent intent = new Intent(this, Basket.class);
        startActivity(intent);
        finish();
    }
    public void maps(View view) {
        Intent intent = new Intent(this, Maps.class);
        startActivity(intent);
        finish();
    }
    public void katalog(View view) {
        Toast toast = Toast.makeText(this, "Вы находитесь в каталоге:)\uD83C\uDF52",Toast.LENGTH_LONG);
        toast.show();
    }
    public void dress(View view) {
        Intent intent = new Intent(this, Dress.class);
        startActivity(intent);

    }
    public void trousers(View view) {
        Intent intent = new Intent(this, Trousers.class);
        startActivity(intent);

    }

    public void polo(View view) {
        Intent intent = new Intent(this, Polo.class);
        startActivity(intent);

    }

    public void shorts(View view) {
        Intent intent = new Intent(this, Shorts.class);
        startActivity(intent);

    }

    public void body(View view) {
        Intent intent = new Intent(this, Bodysuit.class);
        startActivity(intent);

    }

    public void hoodie(View view) {
        Intent intent = new Intent(this, Hoodie.class);
        startActivity(intent);

    }


}