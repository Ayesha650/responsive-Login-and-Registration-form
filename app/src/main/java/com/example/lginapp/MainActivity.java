package com.example.lginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, confirmPassword;
    Button Register,btngotologin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.eduname);
        password = (EditText) findViewById(R.id.edpassword);
        confirmPassword = (EditText) findViewById(R.id.edconfirmpass);
        Register = (Button) findViewById(R.id.buttonReg);
        btngotologin = (Button)findViewById(R.id.button2);

        DB = new DBHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String Confpass = confirmPassword.getText().toString();

                if (user.equals("") || pass.equals("") || Confpass.equals(""))
                    Toast.makeText(MainActivity.this, "Please Enter all the fields ", Toast.LENGTH_SHORT).show();
                else if (pass.equals(Confpass)) {
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser == false) {
                        Boolean inserts = DB.insertData(user, pass);
                        if (inserts == true) {
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "User already exists! ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Passwords not Matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btngotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
    }

}
