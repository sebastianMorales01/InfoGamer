package com.example.infogamer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.infogamer.adapter.AdapterNotice;
import com.example.infogamer.model.Notice;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    public static final String URL="https://newsapi.org/v2/everything?q=games&language=es&apiKey=623a0b688ae046e8b0b307cb6a70d075";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processHttp();
    }

    private void processHttp() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                processUsers(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void processUsers(String data) {


        try {
            JSONObject root = new JSONObject(data);
            JSONArray articlesArray = root.getJSONArray("articles");

            List<Notice> list = new ArrayList<>();

            for (int i=0; i<articlesArray.length();i++) {
                JSONObject info = articlesArray.getJSONObject(i);

                String author = info.getString("author");
                String title = info.getString("title");
                String description = info.getString("description");
                String photo = info.getString("urlToImage");
                String fecha = info.getString("publishedAt");
                String url = info.getString("url");
                String content = info.getString("content");


                //Log.d("INFO", "---------------");
                //Log.d("info", name + "," + species);

                //formato de fecha
                String dateStr = fecha;
                SimpleDateFormat dfr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                Date dfrec = dfr.parse(dateStr);
                SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a", Locale.ENGLISH);
                df.setTimeZone(TimeZone.getTimeZone("GMT-4"));

                String date = df.format(dfrec);



                Notice notice1 = new Notice(author,title,description,photo,date,url,content);
                list.add(notice1);
            }

            RecyclerView rc = findViewById(R.id.rc_notice);
            AdapterNotice ad = new AdapterNotice(this,list,R.layout.item_notice);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);
            rc.setLayoutManager(lm);
            rc.setAdapter(ad);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }





}