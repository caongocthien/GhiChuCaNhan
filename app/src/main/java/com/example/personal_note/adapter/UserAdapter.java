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
import com.example.personal_note.db.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter {
    public UserAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
