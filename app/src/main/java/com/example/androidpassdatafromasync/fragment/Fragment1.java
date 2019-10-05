package com.example.androidpassdatafromasync.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidpassdatafromasync.MainActivity;
import com.example.androidpassdatafromasync.R;
import com.example.androidpassdatafromasync.adapter.ItemAdapter;
import com.example.androidpassdatafromasync.interfaces.NetworkResponseListener;
import com.example.androidpassdatafromasync.model.ItemModel;
import com.example.androidpassdatafromasync.task.LoadDataTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment implements NetworkResponseListener {

    private RecyclerView itemlist;
    private ProgressBar progressBar;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemlist=view.findViewById(R.id.item_list);
        progressBar=view.findViewById(R.id.progress);
         LoadDataTask loadDataTask=new LoadDataTask(Fragment1.this);
        loadDataTask.execute();
    }

    @Override
    public void SuccessData(String data) {
        progressBar.setVisibility(View.GONE);
       // textView.setText("Added From Fragment 1 : "+data);
        List<ItemModel> itemModels=new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                itemModels.add(new ItemModel(jsonArray.getJSONObject(i).getString("title"),jsonArray.getJSONObject(i).getString("body")));
            }

            ItemAdapter itemAdapter=new ItemAdapter(getContext(),itemModels);
            itemlist.setLayoutManager(new LinearLayoutManager(getContext()));
            itemlist.setAdapter(itemAdapter);
        }
        catch (JSONException e){
            e.printStackTrace();
            Toast.makeText(getContext(), "Failed to Parse Data", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void FailedData() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Failed to Load Data on Fragment 1", Toast.LENGTH_SHORT).show();

    }
}
