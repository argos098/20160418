package com.example.a.t11_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        MyDomParser task = new MyDomParser(textView);
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1138060000");


    }
}
