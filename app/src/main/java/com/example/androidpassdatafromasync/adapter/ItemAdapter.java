package com.example.androidpassdatafromasync.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidpassdatafromasync.R;
import com.example.androidpassdatafromasync.model.ItemModel;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter
{
    private List<ItemModel> itemModels;
    private Context context;
    public ItemAdapter(Context context, List<ItemModel> itemModels){
        this.context=context;
        this.itemModels=itemModels;
    }

    private class ItemHolder extends RecyclerView.ViewHolder{
        private TextView title,description;
        private ItemHolder(View view){
            super(view);
            title=(TextView)view.findViewById(R.id.title);
            description=(TextView)view.findViewById(R.id.description);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ItemHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //now creating model for adapter
        ItemModel itemModel=itemModels.get(position);
        final ItemHolder itemHolder=(ItemHolder)holder;
        itemHolder.title.setText(itemModel.getTitle());
        itemHolder.description.setText(itemModel.getBody());

    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
