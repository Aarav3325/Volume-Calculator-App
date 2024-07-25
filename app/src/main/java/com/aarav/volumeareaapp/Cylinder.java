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

public class Cylinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView result = findViewById(R.id.result);
        Button calculateBtn = findViewById(R.id.calculate);
        EditText etRadius = findViewById(R.id.etRadius);
        EditText etHeight = findViewById(R.id.etHeight);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = etRadius.getText().toString();
                String height = etHeight.getText().toString();

                int r = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                double volume = (3.14) * (r*r) * h;

                result.setText("Volume of cylinder is " + volume);
            }
        });
    }
}