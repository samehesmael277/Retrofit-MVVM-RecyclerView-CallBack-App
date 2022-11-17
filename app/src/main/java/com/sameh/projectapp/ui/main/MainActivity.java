package com.sameh.projectapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sameh.projectapp.R;


public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // for View Model (save date)
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        // for call method to come data
        postViewModel.getPosts();

        // create RecyclerView and adapter
        RecyclerView my_rcv = findViewById(R.id.my_rcv);
        PostAdapter adapter = new PostAdapter();
        my_rcv.setLayoutManager(new LinearLayoutManager(this));
        my_rcv.setAdapter(adapter);

        // to set list from mutablePostLiveData in adapter in RecyclerView
        postViewModel.mutablePostLiveData.observe(this, adapter::setPostList);

    }

}