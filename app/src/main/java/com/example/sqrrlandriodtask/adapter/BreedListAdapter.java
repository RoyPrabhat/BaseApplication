package com.example.sqrrlandriodtask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sqrrlandriodtask.R;

import java.util.ArrayList;

public class BreedListAdapter extends RecyclerView.Adapter<BreedListAdapter.MyViewHolder> {

    public interface ItemClickListener {
        void onClick(String dogName);
    }

    private ArrayList<String> mBreedList;
    private final ItemClickListener mListener;


    public BreedListAdapter(ArrayList<String> breedList, ItemClickListener listener) {
        this.mBreedList = breedList;
        this.mListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_breed_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mBreedName.setText(mBreedList.get(position));
        holder.bind(mBreedList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        if (mBreedList == null) {
            return 0;
        } else {
            return mBreedList.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mBreedName;

        public MyViewHolder(View itemView) {
            super(itemView);
            mBreedName = itemView.findViewById(R.id.breed_mame);
        }


        public void bind(final String dogName, final ItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(mBreedName.getText().toString());
                }
            });
        }
    }
}