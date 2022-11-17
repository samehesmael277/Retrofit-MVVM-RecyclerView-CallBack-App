package com.sameh.projectapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sameh.projectapp.api.PostsClient;
import com.sameh.projectapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostViewModel extends ViewModel {

    // to save Call<List<Post>> that's come from PostsClient
    MutableLiveData<List<Post>> mutablePostLiveData = new MutableLiveData<>();

    // create method to get data from PostsClient on call PostsClient.getINSTANCE().getPosts()
    // and save the result in mutablePostLiveData to use in MainActivity
    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                mutablePostLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

}
