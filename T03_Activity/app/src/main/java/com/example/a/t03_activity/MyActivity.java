package com.example.a.t03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {
    final int MY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void onStartButtonClick(Intent view){
        Intent intent = new Intent(MyActivity.this, MainActivity.class);
        intent.putExtra("id","abcd");
        intent.putExtra("pw","efgh");
        startActivityForResult(intent, MY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MY_REQUEST){
            if(resultCode == RESULT_OK){
                String res = data.getStringExtra("myResult");
                Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
