package com.example.postsview.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.postsview.POJO.PostModel;
import com.example.postsview.R;
import com.example.postsview.UI.Main.PostAdapter;
import com.example.postsview.UI.Main.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PostModel>mlist_posts;
    PostAdapter postAdapter;

    PostViewModel posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mlist_posts=new ArrayList<>();
        postAdapter=new PostAdapter(mlist_posts,this);
        recyclerView.setAdapter(postAdapter);


        posts= ViewModelProviders.of(this).get(PostViewModel.class);
       // posts.getposts();
        posts.post_MutableLiveData.observe(MainActivity.this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                mlist_posts.clear();
                Log.d("observe","postModels.size  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+postModels.size());
                for (PostModel post :postModels){
                    mlist_posts.add(post);
                }
              //  mlist_posts=postModels;
                postAdapter.notifyDataSetChanged();


            }
        });







    }
}
