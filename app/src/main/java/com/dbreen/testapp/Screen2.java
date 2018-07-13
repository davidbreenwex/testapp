package com.dbreen.testapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        textView = findViewById(R.id.textScreen2);
        parse_deeplink();
    }

    public void button2_clicked(View view){
        Log.d("Button1", "Clicked");
        finish();
    }

    private void parse_deeplink(){

        Intent intent = getIntent();
        Uri data = intent.getData();

        if (data != null){
            for (String key: data.getQueryParameterNames()){
                final String value = data.getQueryParameter(key);
                if (key.equals("text")) {
                    textView.setText(value);
                }
            }
        }
    }
}
