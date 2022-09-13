package com.example.lginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {
    static int PERMISSION_CODE = 100;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

                EditText phone_no = findViewById(R.id.text);
                ImageButton callButton = findViewById(R.id.imageButton);
                btn = (Button)findViewById(R.id.buttonBook);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity3.this,Bookreading.class);
                        startActivity(intent);
                    }
                });
                callButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String phone = phone_no.getText().toString();
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel: "+phone_no.toString()));
                        startActivity(i);
                    }
                });

                if (ContextCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ;
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
                }

            }
        }
