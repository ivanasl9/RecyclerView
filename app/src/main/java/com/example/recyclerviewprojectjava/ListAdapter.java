package com.example.recyclerviewprojectjava;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder>  {

    private ArrayList<String> mNames;
    private ArrayList<String> mImages;
    private ArrayList<String> descL;



    private Context context;

    public ListAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mImages, ArrayList<String> descL) {
        this.mNames = mNames;
        this.mImages = mImages;
        this.descL = descL;
        this.context = context;


    }

    private static final String TAG = "ListAdapter";


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rec, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(MainActivity.context)
                .asBitmap()
                .load(mImages.get(position))
                .circleCrop()
                .into(holder.ci);


        holder.tvName.setText(mNames.get(position));
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));
                Toast.makeText(context, mNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mNames.get(position));
                intent.putExtra("desc", descL.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }




    public class MyHolder extends RecyclerView.ViewHolder {

        CircleImageView ci;
        RelativeLayout parent_layout;
        TextView tvName;


        public MyHolder(View itemView) {
            super(itemView);
            ci = itemView.findViewById(R.id.circleImage);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            tvName = itemView.findViewById(R.id.tvName);


        }
    }

}
