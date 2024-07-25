package com.aarav.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdpater extends ArrayAdapter<ShapeModel> {

    private ArrayList<ShapeModel> shapeArrayList;
    private Context context;

    public MyAdpater(ArrayList<ShapeModel> shapeArrayList, Context context) {
        super(context, R.layout.grid_item, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ShapeModel shape = getItem(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);

            holder = new ViewHolder();
            holder.shapeName = convertView.findViewById(R.id.textView);
            holder.shapeImage = convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.shapeName.setText(shape.getShapeName());
        holder.shapeImage.setImageResource(shape.getShapeImage());

        return convertView;
    }

    private static class ViewHolder {
        ImageView shapeImage;
        TextView shapeName;
    }
}
