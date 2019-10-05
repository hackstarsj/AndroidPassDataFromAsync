package com.example.androidpassdatafromasync.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidpassdatafromasync.R;
import com.example.androidpassdatafromasync.interfaces.NetworkResponseListener;
import com.example.androidpassdatafromasync.task.LoadDataTask;


public class Fragment2 extends Fragment implements NetworkResponseListener {


    private TextView textView;
    private ProgressBar progressBar;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.text1);
        //Now Lets Show a Progressbar
        progressBar=view.findViewById(R.id.progress);
        LoadDataTask loadDataTask=new LoadDataTask(Fragment2.this);
        loadDataTask.execute();
    }

    @Override
    public void SuccessData(String data) {
        progressBar.setVisibility(View.GONE);
        textView.setText("Added From Fragment 2 : "+data);
    }

    @Override
    public void FailedData() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Failed to Load Data on Fragment 2", Toast.LENGTH_SHORT).show();

    }
}
