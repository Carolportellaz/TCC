package com.example.dados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.mainLayout);
        Button bntAdd = findViewById(R.id.bntAdd);
        Button bntView = findViewById(R.id.bntView);

        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNm = findViewById(R.id.txtNm);
                EditText txtIdade = findViewById(R.id.txtIdade);

                CostumerModel costumerModel;

                try{
                    String nome = txtNm.getText().toString();
                    int idade = Integer.parseInt(txtIdade.getText().toString());

                    // SÓ ADICIONO NO BANCO MAIORES DE 18 ANOS //
                    if(idade < 18){
                        Toast.makeText(MainActivity.this, nome + "você não tem idade", Toast.LENGTH_SHORT).show();
                    }

                     costumerModel = new CostumerModel(-1, nome, idade);
                }

                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Informe valores válidos", Toast.LENGTH_SHORT).show();
                    costumerModel = new CostumerModel(-1, "", -1);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean sucess = dataBaseHelper.addOne(costumerModel);

                Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
            }
        });

        bntView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}