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

public class ChangePassword extends Fragment {
    EditText txtcurrentPass, txtnewPass, txtagainPass;
    DatabaseHelper db;
    SharePreferences p;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_changepassword, container, false);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DatabaseHelper(getContext());
        txtcurrentPass = view.findViewById(R.id.edittextcurrentpass);
        txtnewPass = view.findViewById(R.id.edittextnewpassword);
        txtagainPass = view.findViewById(R.id.edittextagainpass);
        Button btnHome =view.findViewById(R.id.btnHome);
        p = new SharePreferences(getContext());
        Button btnChange = view.findViewById(R.id.btnChange);

        String firstname = p.loadPreferences("firstname");
        String lastname = p.loadPreferences("lastname");
        String email = p.loadPreferences("email");
        String password = p.loadPreferences("pass");
        int id = Integer.parseInt(p.loadPreferences("id"));
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = txtcurrentPass.getText().toString();
                String newPass = txtnewPass.getText().toString();
                String againPass = txtagainPass.getText().toString();
                if(!pass.equals(password)) {
                    Toast.makeText(getContext(), "Mat khau khong dung", Toast.LENGTH_SHORT).show();
                } else if(!newPass.equals(againPass)) {
                    Toast.makeText(getContext(), "Nhap lai mat khau khong dung", Toast.LENGTH_SHORT).show();
                } else {
                    if(newPass.length()>=8)
                    {
                        if(newPass.equals(password))
                        {
                            Toast.makeText(getContext(), "Mat khau moi trung mat khau cu,vui long chon mat khau khac ", Toast.LENGTH_SHORT).show();
                            txtnewPass.setText("");
                            txtagainPass.setText("");
                        }
                        else{
                            User user = new User(email, newPass, firstname, lastname);
                            long i = db.updatePass(id, user);
                            Toast.makeText(getContext(), "Thay doi mat khau thanh cong", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), NavigationActivity.class);
                            startActivity(intent);
                        }
                    }
                    else
                        Toast.makeText(getContext(), "Mat Khau moi phai du 8 ky tu ", Toast.LENGTH_SHORT).show();
                        txtnewPass.setText("");
                        txtagainPass.setText("");
                }

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