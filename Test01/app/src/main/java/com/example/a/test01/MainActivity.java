package com.example.a.test01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory()+"/Download";
        File dir = new File(path);
        final File[] files = dir.listFiles();

        final ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i < files.length; i++){
            String name = files[i].getName();
            if(name.lastIndexOf(".mp3") > 0){
                strList.add(files[i].getName());
            }
        }

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, strList.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra("fName", strList.get(position));
                startActivity(intent);

            }
        });
    }
}
