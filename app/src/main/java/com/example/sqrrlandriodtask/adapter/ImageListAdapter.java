package com.example.sqrrlandriodtask.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sqrrlandriodtask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {

    private ArrayList<String> mImageList;
    private Context mContext;


    public ImageListAdapter(ArrayList<String> imageList, Context context) {
        this.mImageList = imageList;
        this.mContext = context;
    }

    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_item, parent, false);
        ImageListAdapter.MyViewHolder holder = new ImageListAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageListAdapter.MyViewHolder holder, int position) {
        Picasso.with(mContext).load(mImageList.get(position)).
                placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .fit().into(holder.dogImage);
    }

    @Override
    public int getItemCount() {
        if (mImageList == null) {
            return 0;
        } else {
            return mImageList.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView dogImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            dogImage = itemView.findViewById(R.id.image);
        }

    }
}