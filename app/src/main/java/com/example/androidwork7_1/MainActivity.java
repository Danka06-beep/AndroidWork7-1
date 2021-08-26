package com.example.androidwork7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "MyLog";
Button btngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo = findViewById(R.id.btngo);
        Date dt = new Date();
        int hourse = dt.getHours();
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (hourse > 6 && hourse < 14){
                    Log.d(LOG, "Утро");
                    intent.setData(Uri.parse("http://morning"));
                }else if (hourse > 14 && hourse < 15){
                    Log.d(LOG, "Дневная");
                    intent.setData(Uri.parse("http://afternoon "));
                }else if (hourse > 15 && hourse < 6){
                    Log.d(LOG, "Вечерняя");
                    intent.setData(Uri.parse("http://evening "));
                }
                startActivity(intent);
            }
        });
    }
}