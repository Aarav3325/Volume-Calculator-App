package com.aarav.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prism extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView result = findViewById(R.id.result);
        Button calculateBtn = findViewById(R.id.calculate);
        EditText etBase = findViewById(R.id.etBase);
        EditText etHeight = findViewById(R.id.etHeight);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = etBase.getText().toString();
                String height = etHeight.getText().toString();

                int b = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                double volume = (b * h);

                result.setText("Volume of prism is " + volume);
            }
        });
    }
}