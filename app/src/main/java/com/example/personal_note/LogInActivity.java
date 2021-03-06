
package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.User;

public class LogInActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView textView,tv1;
    Button b1,b2;
    DatabaseHelper db;
    SharePreferences p;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        db = new DatabaseHelper(this);
        p = new SharePreferences(this);
        e1 =(EditText)findViewById(R.id.txtemail);
        e2 = (EditText)findViewById(R.id.txtpassword);
        tv1 = (TextView)findViewById(R.id.textView2) ;
        b1 = (Button)findViewById(R.id.btnLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u=new User();
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpassword = db.emailpassword(email,password);
                if(email.trim().equals("")&&password.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Email và Password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                        { if(email.trim().equals("")){
                            Toast.makeText(getApplicationContext(),"Chưa Nhập Email",Toast.LENGTH_SHORT).show();
                        }
                        else
                            { if(password.trim().equals(""))
                            {
                                Toast.makeText(getApplicationContext(),"Chưa Nhập Password",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                if (Chkemailpassword==true)
                                {
                                    Intent i = new Intent(LogInActivity.this,NavigationActivity.class);
                                    i.putExtra("email",e1.getText().toString());
                                    user = db.getUsers(email);
                                    p.savePreferences("firstname", user.getFirstnameUser());
                                    p.savePreferences("lastname", user.getLastnameUser());
                                    p.savePreferences("email", user.getEmailUser());
                                    p.savePreferences("pass", password);
                                    p.savePreferences("id", String.valueOf(user.getIdUser()));
                                    startActivity(i);
                                    Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),"Xin chào " + email ,Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(getApplicationContext(),"Đăng Nhập Thất Bại, Kiểm Tra Lại Thông Tin",Toast.LENGTH_SHORT).show();
                                e2.setText("");
                                e1.setText("");
                            }
                            }
                        }
                        }
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
        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s .length() <8){
                    e2.setError("Nhập  trên 8 ký tự");
                }else {
                    e2.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}