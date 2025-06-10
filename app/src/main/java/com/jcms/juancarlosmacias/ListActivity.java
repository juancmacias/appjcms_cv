package com.jcms.juancarlosmacias;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister_activity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuinicio || item.getItemId() == R.id.menupolitica){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.list){
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
