package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.banco.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    // git pull → editar → git add → git commit → git push
    // git push -u origin main

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        try{
            DataBaseHelper data = new DataBaseHelper(this, "TCC", null, 1);
            SQLiteDatabase banco = data.getWritableDatabase();
        }

        catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro ao criar o banco " + e.getMessage());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}