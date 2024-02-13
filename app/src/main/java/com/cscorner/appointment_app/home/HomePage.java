package com.cscorner.appointment_app.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cscorner.appointment_app.R;
import com.cscorner.appointment_app.aboutHospital;
import com.cscorner.appointment_app.contacts;
import com.cscorner.appointment_app.forms.FromSec;
import com.cscorner.appointment_app.historySec.secappointmenthis;
import com.cscorner.appointment_app.imageHos;

public class HomePage extends AppCompatActivity {
    TextView  Sec, Third, forth, map;
    Button history;
    LinearLayout chat_doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Sec = (TextView) findViewById(R.id.Sec);
        history = (Button) findViewById(R.id.history);
        Third = (TextView) findViewById(R.id.Third);
        forth = (TextView) findViewById(R.id.forth);
        map = (TextView) findViewById(R.id.map);
        chat_doc = (LinearLayout) findViewById(R.id.chat_doc);

        chat_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), contacts.class);
                startActivity(intent);
            }
        });

        Sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FromSec.class);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), secappointmenthis.class);
                startActivity(intent);
            }
        });

        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), aboutHospital.class);
                startActivity(intent);
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), imageHos.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Civil Hospital Campus, Ahmedabad");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}