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
import com.example.personal_note.db.Priority;

import java.util.ArrayList;
import java.util.List;

public class PriorityAdapter extends ArrayAdapter<Priority> {

    public PriorityAdapter(@NonNull Context context, ArrayList<Priority> priorities) {
        super(context, 0, priorities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Priority priority = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.priotity_layout, parent, false);
            TextView tvName = convertView.findViewById(R.id.tvNamePriority);
            TextView tvDate = convertView.findViewById(R.id.tvDataPriotity);

            tvName.setText(priority.getNamePriority());
            tvDate.setText(priority.getDate());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Priority priority = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.priotity_layout, parent, false);
            TextView tvName = convertView.findViewById(R.id.tvNamePriority);
            TextView tvDate = convertView.findViewById(R.id.tvDataPriotity);

            tvName.setText(priority.getNamePriority());
            tvDate.setText(priority.getDate());
        }
        return convertView;
    }
}
