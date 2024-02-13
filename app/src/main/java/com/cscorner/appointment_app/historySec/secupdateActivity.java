package com.cscorner.appointment_app.historySec;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cscorner.appointment_app.R;

public class secupdateActivity extends AppCompatActivity {
    Button btn;
    EditText add_name, add_age;
    String id,name, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secupdate);
        btn = (Button) findViewById(R.id.btn);
        add_name = (EditText) findViewById(R.id.add_name);
        add_age = (EditText) findViewById(R.id.add_age);

        getIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete" + name + "?");
        builder.setMessage("Are you sure you want to delete." + name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SecHelper secHelper = new SecHelper(secupdateActivity.this);
                secHelper.deleteData(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    void getIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("age")){
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            age = getIntent().getStringExtra("age");

            add_name.setText(name);
            add_age.setText(age);
            Log.d("stev",name + " " + age);
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}