package com.example.mag;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class Maps extends AppCompatActivity  {

    private WebView webView;

    private class MyWebClient extends WebViewClient { // создаем private класс MyWebClient, наследующийся от WebViewClient
        @Override // переопределение метода из родительского класса
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) { // переопределяем метод shouldOverrideUrlLoading из род. класса
            String url = request.getUrl().toString(); // в переменную url указываем URL из WebResourceRequest
            view.loadUrl(url); // загружаем URL из WebResourceRequest
            return false; // клиент обарабывает загрузку самостоятельно (false для перехода по ссылкам)
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        webView = findViewById(R.id.webView); // поиск webView элемента по id, объявление переменной

        webView.getSettings().setJavaScriptEnabled(true); // включение поддержки js

        webView.loadUrl("https://www.zeemaps.com/view?group=4964464&x=37.549435&y=55.756998&z=9"); // указание страницы загрузки

        webView.setWebViewClient(new MyWebClient()); // определяем экземпляр класса MyWebClient


        OnBackPressedCallback back = new OnBackPressedCallback(true) { // объект класса для создания обратных вызовов при обработке нажатия кнопки назад
            @Override
            public void handleOnBackPressed() {
                if (webView.canGoBack()) { // если переход назад возможен
                    webView.goBack(); // осуществление перехода
                } else {
                    finish(); //иначе вызываем finish(), активити закрывается
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, back); // привязка созданного обратного вызова к диспетчеру нажатия. Добавление обратного вызова каллбек
        // для возвращения на предыдущий элемент

    }
    public void maps(View view) {
        Toast toast = Toast.makeText(this, "Вы уже тут!\uD83C\uDF52", Toast.LENGTH_LONG);
        toast.show();
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
}