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
import com.example.personal_note.db.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends ArrayAdapter<Status> {

    public StatusAdapter(@NonNull Context context, ArrayList<Status> statuses) {
        super(context, 0, statuses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Status status = getItem(position);
        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.status_layout,parent,false);
            TextView tvName = convertView.findViewById(R.id.tvNameStatus);
            TextView tvDate = convertView.findViewById(R.id.tvDateStatus);

            tvName.setText(status.getNameStatus());
            tvDate.setText(status.getDate());
        }
        return convertView;
    }
}
