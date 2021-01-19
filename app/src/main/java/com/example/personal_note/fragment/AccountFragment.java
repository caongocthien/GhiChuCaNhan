package com.example.personal_note.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personal_note.NavigationActivity;
import com.example.personal_note.R;
import com.example.personal_note.SharePreferences;
import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.User;


public class AccountFragment extends Fragment {
    TextView tvEmail,tvFullName;
    DatabaseHelper db;
    SharePreferences p;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_account, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DatabaseHelper(getContext());
        tvEmail =  view.findViewById(R.id.Email);
        tvFullName = view.findViewById(R.id.HoTen);
        Button btnHome =view.findViewById(R.id.btnHome);
        p = new SharePreferences(getContext());
        String firstname = p.loadPreferences("firstname");
        String lastname = p.loadPreferences("lastname");
        String email = p.loadPreferences("email");
        String password = p.loadPreferences("pass");
        int id = Integer.parseInt(p.loadPreferences("id"));
        tvEmail.setText(email);
        tvFullName.setText(firstname+" "+lastname);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NavigationActivity.class);
                startActivity(intent);
            }
        });
    }
}