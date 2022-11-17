package com.sameh.projectapp.api;

import com.sameh.projectapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    // this is will come all post from website
    @GET("posts")
    public Call<List<Post>> getPosts();

}
