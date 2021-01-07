package com.example.personal_note.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.personal_note.R;
import com.example.personal_note.db.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(@NonNull Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Category category = getItem(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_layout,parent,false);
            TextView tvName = convertView.findViewById(R.id.tvNameCategory);
            TextView tvDate = convertView.findViewById(R.id.tvDateCategory);

            tvName.setText(category.getNameCategory());
            tvDate.setText(category.getDate());
        }
        return convertView;
    }
}
