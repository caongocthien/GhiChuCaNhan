package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personal_note.adapter.CategoryAdapter;
import com.example.personal_note.adapter.UserAdapter;
import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;
    DatabaseHelper databaseHelper;
    ArrayList<User> arrayList;
    //ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        databaseHelper =new DatabaseHelper(this);
        databaseHelper.createTable();


        arrayList = databaseHelper.getUser();
//        arrayAdapter = new UserAdapter(getContext(), categoryArrayList);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.edittextuser);
        e2 = (EditText)findViewById(R.id.edittextpassword);
        e3 = (EditText)findViewById(R.id.edittextconfirmpassword);
        b1 = (Button)findViewById(R.id.bntsignup);
        b2 = (Button)findViewById(R.id.bntsignin);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.trim().equals("")||s2.trim().equals("")||s3.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"Thiếu thông tin, hãy kiểm tra lại!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail==true){

                            User user = new User(s1,s2);
                            if (databaseHelper.insertUser(user)>0) {
//                                arrayAdapter.clear();
                                arrayList.addAll(databaseHelper.getUser());
//                                arrayAdapter.notifyDataSetChanged();
                                Intent i = new Intent(SignUpActivity.this,LogInActivity.class);
                                startActivity(i);
                                //Toast.makeText(SignUpActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        }else Toast.makeText(getApplicationContext(),"Tài khoản đã tồn tại",Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(getApplicationContext(),"Mật khẩu không đúng",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}