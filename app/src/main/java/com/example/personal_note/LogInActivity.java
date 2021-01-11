package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personal_note.db.DatabaseHelper;

public class LogInActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
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
                    Intent i = new Intent(LogInActivity.this,NavigationActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Đã đăng nhập " + email ,Toast.LENGTH_LONG).show();
                }else Toast.makeText(getApplicationContext(),"Đăng nhập thất bại, kiểm tra lại thông tin",Toast.LENGTH_SHORT).show();
            }
        });
        b2 = (Button)findViewById(R.id.btnExit);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}