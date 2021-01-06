package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personal_note.db.DatabaseHelper;

public class LogInActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        db = new DatabaseHelper(this);
        e1 =(EditText)findViewById(R.id.txtemail);
        e2 = (EditText)findViewById(R.id.txtpassword);
        b1 = (Button)findViewById(R.id.btnLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpassword = db.emailpassword(email,password);
                if (Chkemailpassword==true){
                    Toast.makeText(getApplicationContext(),"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getApplicationContext(),"Dang nhap that bai, kiem tra lai",Toast.LENGTH_SHORT).show();
            }
        });
    }
}