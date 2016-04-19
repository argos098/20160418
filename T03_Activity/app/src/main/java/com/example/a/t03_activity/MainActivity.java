package com.example.a.t03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    public void onFinishButtonClick(View view){
        Intent intent = new Intent();
        intent.putExtra("myResult", "abcdef");
        setResult(RESULT_OK, intent);

        finish();
    }

}
