package com.sameh.projectapp.api;

import com.sameh.projectapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    // website url
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    // initialization for PostInterface to implement method in it
    private PostInterface postInterface;
    // instance from this class to create it when i need
    private static PostsClient INSTANCE;

    // to create retrofit and connection to website
    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // for fill the interface
        postInterface = retrofit.create(PostInterface.class);
    }

    // create instance from this class or use the old
    public static PostsClient getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    // it call method in postInterface to return Call<List<Post>> to use later
    public Call<List<Post>> getPosts() {
        return postInterface.getPosts();
    }

}
