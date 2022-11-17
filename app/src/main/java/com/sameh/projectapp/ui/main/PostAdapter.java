package com.sameh.projectapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sameh.projectapp.R;
import com.sameh.projectapp.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList = new ArrayList<>();

    public void setPostList(List<Post> postsList) {
        this.postList = postsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        PostViewHolder viewHolder = new PostViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.tv_body.setText(postList.get(position).getBody());
        holder.tv_user_id.setText(postList.get(position).getUserId()+"");
        holder.tv_title.setText(postList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_user_id, tv_body;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_user_id = itemView.findViewById(R.id.tv_user_id);
            tv_body = itemView.findViewById(R.id.tv_body);

        }
    }

}
