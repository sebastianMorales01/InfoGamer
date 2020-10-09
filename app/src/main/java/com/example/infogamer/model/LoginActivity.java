package com.example.infogamer.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infogamer.MainActivity;
import com.example.infogamer.R;

public class LoginActivity extends AppCompatActivity {

    EditText login_user,login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_user = findViewById(R.id.login_user);
        login_pass = findViewById(R.id.login_pass);
    }

    public void bt_login(View view) {
        String user = login_user.getText().toString();
        String pass = login_pass.getText().toString();
        if (!user.isEmpty() && !pass.isEmpty()){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            login_pass.setText("");
        }else{
            Toast.makeText(this,"complete los campos",Toast.LENGTH_SHORT).show();
        }

    }

    public void bt_aboutUs(View view) {
        Intent i = new Intent(this,AboutUsActivity.class);
        startActivity(i);
    }
}