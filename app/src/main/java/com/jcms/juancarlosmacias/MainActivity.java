package com.jcms.juancarlosmacias;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar toolbar;
    private WebView web;
    private String url = "http://www.juancarlosmacias.es/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configurar Toolbar como ActionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        web = findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/principal.md");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuinicio){
            web.loadUrl("file:///android_asset/principal.md");
        }else if(item.getItemId() == R.id.menupolitica){
            web.loadUrl("file:///android_asset/politica.md");
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}