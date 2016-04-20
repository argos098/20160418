package com.example.a.t11_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document>{

        private String getElementText(Element dataElement, String tag){
            NodeList dayNodeList = dataElement.getElementsByTagName(tag);
            Element dayElement = (Element) dayNodeList.item(0);

            NodeList textNodeList = dayElement.getChildNodes();
            String val = textNodeList.item(0).getNodeValue();

            return val;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String str = "";
            NodeList nodeList = document.getElementsByTagName("data");

            for(int i=0; i<nodeList.getLength(); i++) {
                Element dataElement = (Element) nodeList.item(i);

                String day = getElementText(dataElement, "day");
                String hour = getElementText(dataElement, "hour");
                String temp = getElementText(dataElement, "temp");
                String wfKor = getElementText(dataElement, "wfKor");

                str += "day : " + day + "hour : " + hour + "temp : " + temp + "wfKor : " + wfKor +"\n";
            }
        }

        @Override
        protected Document doInBackground(String... params) {
            URL url = null;
            Document doc = null;

            try {
                url = new URL(params[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                doc = db.parse(url.openStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return doc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDomParser task = new MyDomParser();
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1138060000");
    }
}
