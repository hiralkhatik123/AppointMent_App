package com.cscorner.appointment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contacts extends AppCompatActivity {

    ImageView copy, copy1, copy2, copy3;
    TextView firstText, secText, thirdText, forText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        copy = (ImageView) findViewById(R.id.copy);
        copy1 = (ImageView) findViewById(R.id.copy1);
        copy2 = (ImageView) findViewById(R.id.copy2);
        copy3 = (ImageView) findViewById(R.id.copy3);
        firstText = (TextView) findViewById(R.id.firstText);
        secText = (TextView) findViewById(R.id.secText);
        thirdText = (TextView) findViewById(R.id.thirdText);
        forText = (TextView) findViewById(R.id.forText);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy", firstText.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(contacts.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        copy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy", secText.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(contacts.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        copy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy", thirdText.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(contacts.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        copy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy", forText.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(contacts.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

    }
}