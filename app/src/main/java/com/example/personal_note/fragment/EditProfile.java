package com.example.personal_note.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.personal_note.HomeActivity;
import com.example.personal_note.NavigationActivity;
import com.example.personal_note.R;
import com.example.personal_note.SharePreferences;
import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.User;

public class EditProfile extends Fragment {
    EditText txtfirstname,txtlastname ;
    DatabaseHelper db;
    SharePreferences p;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_edit_profile, container, false);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DatabaseHelper(getContext());

        txtfirstname = view.findViewById(R.id.edittextfistname);

        txtlastname = view.findViewById(R.id.edittextlastname);
        Button btnHome =view.findViewById(R.id.btnHome);
        p = new SharePreferences(getContext());
        Button btnChange = view.findViewById(R.id.btnChange);

        String firstname = p.loadPreferences("firstname");
        String lastname = p.loadPreferences("lastname");
        String email = p.loadPreferences("email");
        String password = p.loadPreferences("pass");
        int id = Integer.parseInt(p.loadPreferences("id"));
        txtfirstname.setText(firstname);
        txtlastname.setText(lastname);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = txtfirstname.getText().toString();
                String lastname = txtlastname.getText().toString();

                    User user = new User(email,password,firstname,lastname);
                    long i = db.updatePass(id, user);
                    Toast.makeText(getContext(), "Thay doi thong tin thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), NavigationActivity.class);
                    startActivity(intent);
                }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NavigationActivity.class);
                startActivity(intent);





            }
        });

    }
}