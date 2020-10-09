package com.example.infogamer.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infogamer.DetailActivity;

import com.example.infogamer.model.Notice;
import com.example.infogamer.R;

import java.util.List;

public class AdapterNotice extends RecyclerView.Adapter<AdapterNotice.NoticeHolder> {

    public Activity activity;
    public List<Notice> list;
    public int item_notice;

    public AdapterNotice(Activity activity, List<Notice> list, int item_notice) {
        this.activity = activity;
        this.list = list;
        this.item_notice = item_notice;
    }

    @NonNull
    @Override
    public NoticeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_notice,parent,false);
        return new NoticeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeHolder holder, int position) {
        Notice notice = list.get(position);
        holder.item_title.setText(notice.title);
        holder.item_content.setText(notice.content);
        Glide.with(activity).load(notice.photo).into(holder.item_img);
        holder.urlImage = notice.photo;

        //extra
        holder.date = notice.date;
        holder.author = notice.author;
        holder.desc = notice.description;
        holder.url = notice.url;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class NoticeHolder extends RecyclerView.ViewHolder{

        public ImageView item_img;
        public TextView item_title,item_content;
        RelativeLayout item_card;
        String urlImage;

        //extra
        String date,author,desc,url;


        public NoticeHolder(@NonNull View itemView) {
            super(itemView);

            //redondear bordes de la imagen
            itemView.setClipToOutline(true);

            item_img = itemView.findViewById(R.id.item_img);
            item_title = itemView.findViewById(R.id.item_title);
            item_content = itemView.findViewById(R.id.item_content);

            item_card = itemView.findViewById(R.id.item_card);

            item_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra("TITLE",item_title.getText().toString());
                    intent.putExtra("CONTENT",item_content.getText().toString());
                    intent.putExtra("PICTURE",urlImage);

                    //extra
                    intent.putExtra("DATE",date);
                    intent.putExtra("AUTHOR",author);
                    intent.putExtra("DESC",desc);
                    intent.putExtra("URL",url);

                    activity.startActivity(intent);
                }
            });
        }
    }
}