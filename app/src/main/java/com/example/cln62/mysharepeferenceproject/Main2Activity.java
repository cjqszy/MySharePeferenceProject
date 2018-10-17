package com.example.cln62.mysharepeferenceproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editTextInput);
        button = findViewById(R.id.buttonBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                MyEventClass myEventClass = new MyEventClass();
                myEventClass.setMessage(data);
                EventBus.getDefault().post(myEventClass);
                finish();
            }
        });
    }
}
