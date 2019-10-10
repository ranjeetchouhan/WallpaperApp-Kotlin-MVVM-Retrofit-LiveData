package com.guysapp.wallpapers.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.guysapp.wallpapers.FullScreenActivity;
import com.guysapp.wallpapers.R;
import com.guysapp.wallpapers.model.Hit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflter;

    private Context mContext;
    private List<Hit> dataItems;
    public CustomAdapter(Context context, List<Hit> getList){
        dataItems = getList;
        mContext = context;

        inflter = (LayoutInflater.from(context));

    }


    @Override
    public int getCount() {
        return dataItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.row_item, null); // inflate the layout
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon); // get the reference of ImageView
//        icon.setImageResource(logos[i]); // set logo images

        Picasso.with(mContext).load(dataItems.get(position).getPreviewURL()).placeholder(R.drawable.download).into(icon);


        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, FullScreenActivity.class);
                intent.putExtra("url",dataItems.get(position).getPreviewURL());
                mContext.startActivity(intent);
                //Toast here

            }});

        return convertView;
    }
}
