package com.example.sharedpreferenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    EditText editText;
    TextView textView;

    String mytext="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        editText=findViewById(R.id.edittext1);
        textView=findViewById(R.id.textview1);

        button1.setOnClickListener(view -> {
            save(editText.getText().toString());
            editText.setText("");
        });

        button2.setOnClickListener(view -> {
            load();
        });
    }

    public void save(String text){
        SharedPreferences.Editor editor=(SharedPreferences.Editor) getSharedPreferences("Pr",MODE_PRIVATE).edit();
        editor.putString("pr",text);
        editor.commit();
    }

    public void load(){
            SharedPreferences sharedPreferences=getSharedPreferences("Pr",MODE_PRIVATE);
            String savedtext=sharedPreferences.getString("pr","");
            textView.setText(savedtext);
    }
}