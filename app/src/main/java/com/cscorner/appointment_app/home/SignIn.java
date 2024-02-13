package com.cscorner.appointment_app.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cscorner.appointment_app.R;

public class SignIn extends AppCompatActivity {
    DBHelper DB;
    TextView sign;
    EditText login_name,login_pass, login_pass2;
    private Button btn;
    ImageView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        login_name = (EditText) findViewById(R.id.name);
        sign = (TextView) findViewById(R.id.sign);
        btn = (Button) findViewById(R.id.btn);
        login_pass = (EditText) findViewById(R.id.password);
        login_pass2 = (EditText) findViewById(R.id.repassword);
        click = (ImageView) findViewById(R.id.click);
        DB = new DBHelper(this);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = login_name.getText().toString();
                String password = login_pass.getText().toString();
                String repassword = login_pass2.getText().toString();

                if (name.equals("") || password.equals("") || repassword.equals("")){
                    Toast.makeText(SignIn.this, "please enter Empty places", Toast.LENGTH_SHORT).show();
                }else{
                    if (password.equals(repassword)){
                        Boolean checkname = DB.checkname(name);
                        if (checkname == false){
                            Boolean insert = DB.insertData(name, password);
                            if (insert == true){
                                Toast.makeText(SignIn.this, "Register SuccessFully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignIn.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignIn.this, "already exists", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(SignIn.this, "password not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}