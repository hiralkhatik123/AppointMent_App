package com.cscorner.appointment_app.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cscorner.appointment_app.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    TextView sign1;
    EditText name1, password1;
    Button btn1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name1 = (EditText) findViewById(R.id.name1);
        password1 = (EditText) findViewById(R.id.password1);
        btn1 = (Button) findViewById(R.id.btn1);
        sign1 = (TextView) findViewById(R.id.sign1);
        DB = new DBHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = name1.getText().toString();
            String password = password1.getText().toString();

                if (name1.equals("") || password1.equals("")){
                    Toast.makeText(login.this, "please enterempty spaces", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkpass = DB.checknamePass(name, password);
                    if (checkpass == true){
                        Toast.makeText(login.this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Invalid credential", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });
     }
}