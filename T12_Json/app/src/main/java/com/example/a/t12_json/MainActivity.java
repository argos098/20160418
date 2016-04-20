package com.example.a.t12_json;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String str = "[{'name':'kim', 'tel':'010-44444-1212', 'age':20}," +
            "{'name':'park', 'tel':'010-44444-1212', 'age':30}," +
            "{'name':'lee', 'tel':'010-44444-2424', 'age':40}]";

    class GetContacts extends AsyncTask<String, Void, String>{

        private String getResponseString(String strUrl){
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = null;
            HttpEntity httpEntity = null;
            String responseStr = "";

            HttpGet httpGet = new HttpGet(strUrl);
            try {
                httpResponse = httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
                responseStr = EntityUtils.toString(httpEntity);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return responseStr;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... params) {
            String strJson = getResponseString(params[0]);
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONArray array = new JSONArray(str);
            for(int i = 0; i < array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel = obj.getString("tel");
                int age = obj.getInt("age");

                Log.d("json", "name : " + name + " tel : " + tel + " age : " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
