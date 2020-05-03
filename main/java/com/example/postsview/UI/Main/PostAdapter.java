package com.example.postsview.UI.Main;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.postsview.POJO.PostModel;
import com.example.postsview.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewholder> {

 private List<PostModel> m_list_Post;
  private Context mcontext;

    public PostAdapter(List<PostModel> m_list_Post, Context mcontext) {
        this.m_list_Post = m_list_Post;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.post_item,parent,false);
        return new  viewholder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        PostModel post= m_list_Post.get(position);
        holder.title.setText(post.getTitle());
        holder.userid.setText(post.getUserId()+"");
        holder.body.setText(post.getBody());


    }

    @Override
    public int getItemCount() {
        return m_list_Post.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView title,userid,body;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            userid= itemView.findViewById(R.id.useridTv);
            title= itemView.findViewById(R.id.titleTV);
            body= itemView.findViewById(R.id.bodytv);


        }
    }
}
