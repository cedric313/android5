package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private static final String MyPREFERENCES = "ced";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText findRememberMe = findViewById(R.id.editTexteRememberMe);
        Button saveRememberMe = findViewById(R.id.buttonSave);
        final TextView backup = findViewById(R.id.textViewBackup);
        final SharedPreferences sharedPref = MainActivity.this.getSharedPreferences("username",Context.MODE_PRIVATE);
        saveRememberMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("remember_me", findRememberMe.getText().toString());
                editor.apply();

                backup.setText(sharedPref.getString("remember_me", ""));
                Toast.makeText(MainActivity.this, "Saved " + findRememberMe.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        backup.setText(sharedPref.getString("remember_me", ""));
    }
}
