package com.example.postsview.Data;

import com.example.postsview.POJO.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
  private static final String baseURL="https://jsonplaceholder.typicode.com/";
  private   static Client client_instance;
    PostInterface postInterface;
     public  Client(){
         Retrofit retrofit=new  Retrofit.Builder()
                 .baseUrl(baseURL)
                // .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .build();
          postInterface = retrofit.create(PostInterface.class);
       //  Call<List<PostModel>> call=postInterface.getPosts();

    }

    public static Client getClient_instance() {
         if (client_instance==null)
         { return new Client();}

        return client_instance;
    }

    public Observable<List<PostModel>> getposts(){
         return postInterface.getPosts();
    }


}
