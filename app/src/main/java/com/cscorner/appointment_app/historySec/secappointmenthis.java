package com.cscorner.appointment_app.historySec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.cscorner.appointment_app.R;

import java.util.ArrayList;

public class secappointmenthis extends AppCompatActivity {
    private RecyclerView recyclerView;
    SecHelper secHelper;
    ArrayList<String> _id, _Name, _Age;
    SecAdapter secAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secappointmenthis);

        recyclerView = findViewById(R.id.recyclerView);
        secHelper = new SecHelper(secappointmenthis.this);
        _id = new ArrayList<>();
        _Name = new ArrayList<>();
        _Age = new ArrayList<>();


        storeDataInArrays();
        secAdapter = new SecAdapter(secappointmenthis.this, this, _id, _Name, _Age);
        recyclerView.setAdapter(secAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(secappointmenthis.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = secHelper.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                _id.add(cursor.getString(0));
                _Name.add(cursor.getString(1));
                _Age.add(cursor.getString(2));
            }
        }
    }
}