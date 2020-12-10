package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final String savedUser = prefs.getString("user", "");
        final String savedPassword = prefs.getString("pass", "");
        final SharedPreferences.Editor editor = prefs.edit();

        final EditText username = findViewById(R.id.textUser);
        final EditText password = findViewById(R.id.textPassword);

        final Button dewit = findViewById(R.id.dew);

        if (savedUser.equals("admin") && savedPassword.equals("admin")){
            Success();
        }

        dewit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                    if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                        editor.putString("user", "admin");
                        editor.putString("pass", "admin");
                        editor.commit();
                        Success();
                    } else  {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }

    public void Success() {
        Intent goMain = new Intent(this, MainActivity.class);
        startActivity(goMain);
    }
}
