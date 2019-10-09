package com.example.androidpassdatafromasync.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.androidpassdatafromasync.R;
import com.example.androidpassdatafromasync.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class ImageItemAdapter extends RecyclerView.Adapter {

    List<ImageModel> imageModels=new ArrayList<>();
    Context context;

    public ImageItemAdapter(Context context,List<ImageModel> imageModels){
        this.context=context;
        this.imageModels=imageModels;
    }

    public class ImageItemHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView thumb;

        private ImageItemHolder(View view){
            super(view);
            title=view.findViewById(R.id.title);
            thumb=view.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row,parent,false);
        return new ImageItemHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageModel imageModel=imageModels.get(position);
        ImageItemHolder imageItemHolder=(ImageItemHolder)holder;
        imageItemHolder.title.setText(imageModel.getAuthor());
        //now loading image we need to add external library which is glide i used here

        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(R.drawable.bg_grey);
        requestOptions.error(R.drawable.bg_grey);

        Glide.with(context)
                .load(imageModel.getImage())
                .apply(requestOptions)
                .into(imageItemHolder.thumb);


    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }
}
