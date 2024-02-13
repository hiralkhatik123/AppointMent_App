package com.cscorner.appointment_app.forms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cscorner.appointment_app.R;
import com.cscorner.appointment_app.databinding.ActivityFromSecBinding;
import com.cscorner.appointment_app.historySec.SecHelper;

import java.util.Calendar;

public class FromSec extends AppCompatActivity {
    public ActivityFromSecBinding binding;
    int cyear, cmonth, cday;
    Button btn;
    EditText nameAge, Age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFromSecBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn = (Button) findViewById(R.id.btn);
        nameAge = (EditText) findViewById(R.id.name);
        Age = (EditText) findViewById(R.id.age);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameAge.getText().toString();
                String age = Age.getText().toString();

                if (name.equals("") || age.equals("")){
                    Toast.makeText(FromSec.this, "please enterempty spaces", Toast.LENGTH_SHORT).show();
                }else{
                    SecHelper secHelper = new SecHelper(FromSec.this);
                    secHelper.addApp(name.trim(), age.trim());
                    }
            }
        });
    }
}