package com.example.a.t05_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        int imgId;
        String title;
        String desc;

        public MyData(int imgId, String title, String desc) {
            this.imgId = imgId;
            this.title = title;
            this.desc = desc;
        }
    }

    ArrayList<MyData> list = new ArrayList<MyData>();
    private void initData(){
        int iconId = 0;
        for (int i = 0; i<30; i++){
            switch(i%4){
                case 0:
                    iconId = android.R.drawable.ic_btn_speak_now;
                break;
                case 1:
                    iconId = android.R.drawable.ic_delete;
                    break;
                case 2:
                    iconId = android.R.drawable.ic_input_add;
                    break;
                case 3:
                    iconId = android.R.drawable.ic_input_get;
                    break;


            }
            list.add(new MyData(iconId, "title : " +iconId, "desc : " +iconId));
        }
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inf.inflate(R.layout.item_view, null);
            }

            MyData data = list.get(position);

            TextView textTile = (TextView)convertView.findViewById(R.id.textTitle);
            TextView textDesc = (TextView)convertView.findViewById(R.id.textDesc);
            ImageView item_icon = (ImageView)convertView.findViewById(R.id.item_icon);

            textTile.setText(data.title);
            textDesc.setText(data.desc);
            item_icon.setImageResource(data.imgId);
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        MyAdapter adapter = new MyAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
