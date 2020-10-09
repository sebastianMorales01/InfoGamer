package com.example.infogamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    String title,picture;

    //extra
    String date,author,desc,url;
    //
    private ImageView detail_photo;
    private TextView detail_title,detail_desc,detail_date,detail_author,detail_url;
    //extra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = getIntent().getStringExtra("TITLE");
        picture = getIntent().getStringExtra("PICTURE");

        //extra
        date = getIntent().getStringExtra("DATE");
        author = getIntent().getStringExtra("AUTHOR");
        desc = getIntent().getStringExtra("DESC");
        url = getIntent().getStringExtra("URL");
        //

        detail_photo = findViewById(R.id.detail_photo);
        detail_title = findViewById(R.id.detail_title);

        //extra
        detail_date = findViewById(R.id.detail_date);
        detail_author = findViewById(R.id.detail_author);
        detail_desc = findViewById(R.id.detail_desc);
        detail_url = findViewById(R.id.detail_url);
        //

        detail_title.setText(title);
        Glide.with(this).load(picture).into(detail_photo);

        //extra
        detail_date.setText(date);
        detail_author.setText(author);
        detail_desc.setText(desc);
        detail_url.setText(url);
        //

    }
}