package com.example.insert_data;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText name,age;
  Button button;
  db_handler db_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextTextPersonName);
        age=findViewById(R.id.editTextNumber);
        button=findViewById(R.id.button);
        db_class =new db_handler(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name_input=name.getText().toString();
                String age_input=age.getText().toString();
                db_class.add_data(name_input,age_input);
                Toast.makeText(MainActivity.this,"data is successfully inserted",Toast.LENGTH_SHORT).show();
              name.setText("");
              age.setText("");
            }
        });

    }

}