package com.aarav.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<ShapeModel> shapeModelArrayList;
    MyAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);

        shapeModelArrayList = new ArrayList<>();

        ShapeModel sphere = new ShapeModel(R.drawable.sphere, "Sphere");
        ShapeModel cylinder = new ShapeModel(R.drawable.cylinder, "Cylinder");
        ShapeModel cube = new ShapeModel(R.drawable.cube, "Cube");
        ShapeModel prism = new ShapeModel(R.drawable.prism, "Prism");

        shapeModelArrayList.add(sphere);
        shapeModelArrayList.add(cylinder);
        shapeModelArrayList.add(cube);
        shapeModelArrayList.add(prism);

        adapter = new MyAdpater(shapeModelArrayList, getApplicationContext());

        gridView.setAdapter(adapter);

        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), Sphere.class);
//                startActivity(intent);

                if (adapter.getItem(i).getShapeName().equals("Sphere")) {
                    Intent intent = new Intent(getApplicationContext(), Sphere.class);
                    startActivity(intent);
                } else if (adapter.getItem(i).getShapeName().equals("Cube")) {
                    Intent intent = new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent);
                } else if (adapter.getItem(i).getShapeName().equals("Cylinder")) {
                    Intent intent = new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(intent);
                } else if (adapter.getItem(i).getShapeName().equals("Prism")) {
                    Intent intent = new Intent(getApplicationContext(), Prism.class);
                    startActivity(intent);
                }
            }
        });


    }
}