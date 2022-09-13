package com.example.lginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText username,password;
    Button Login;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.btnLog);
        DB = new DBHelper(this);


       Login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           String user = username.getText().toString();
           String pass = password.getText().toString();

           if(user.equals("")|| pass.equals(""))
               Toast.makeText(MainActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
           else {
               Boolean checkuserpass = DB.checkusernamepassword(user,pass);{
                   if(checkuserpass == true){
                       Toast.makeText(MainActivity2.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);
                   }else {
                       Toast.makeText(MainActivity2.this, "Invailed Credentials", Toast.LENGTH_SHORT).show();
                   }
               }
           }
           }
       });

    }
}