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
import com.example.personal_note.db.Note;



import java.util.List;


public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, 0, objects);
    }
    @NonNull


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.status_layout,parent,false);
            TextView tvNoteCate = convertView.findViewById(R.id.tvNoteCategory);
            TextView tvNoteDate = convertView.findViewById(R.id.tvNotePlanDate);
            TextView tvNotePri = convertView.findViewById(R.id.tvNotePriority);

            tvNoteCate.setText(note.getIdCategory());
            tvNoteDate.setText(note.getDate());
            tvNotePri.setText(note.getIdPriority());
        }
        return convertView;
    }
}
