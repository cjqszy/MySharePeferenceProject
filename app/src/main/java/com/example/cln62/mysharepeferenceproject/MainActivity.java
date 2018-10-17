package com.example.cln62.mysharepeferenceproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("MyFile", MODE_PRIVATE);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        EventBus.getDefault().register(this);
//        editText.setText(sp.getString("mykey", ""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*String data = editText.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("mykey", data);
                editor.commit();*/
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Toast.makeText(MainActivity.this, "resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void myMethod(MyEventClass myEventClass){
        String message = myEventClass.getMessage();

        Toast.makeText(this, "receive data " + message, Toast.LENGTH_LONG).show();
    }
}
