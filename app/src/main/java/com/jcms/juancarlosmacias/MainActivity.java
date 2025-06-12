package com.jcms.juancarlosmacias;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.jcms.juancarlosmacias.app.AppConfig;

public class MainActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configurar Toolbar como ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        web = findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        //web.loadUrl("file:///android_asset/principal.md");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuinicio){
            web.loadUrl(AppConfig.INICIO);
        }else if(item.getItemId() == R.id.menupolitica) {
            web.loadUrl(AppConfig.POLICITA);
        }else if(item.getItemId() == R.id.list){
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        String url = AppConfig.INICIO;
        // Aquí vuelves a cargar los datos
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("url")) {
            url = intent.getStringExtra("url");
        }
        cargarDatosActualizados(url);
    }

    private void cargarDatosActualizados(String url) {
        Log.e("url", url);
        web.loadUrl(url);

    }
}