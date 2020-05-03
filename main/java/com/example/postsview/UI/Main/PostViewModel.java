package com.example.postsview.UI.Main;

import android.util.Log;

import com.example.postsview.Data.Client;
import com.example.postsview.POJO.PostModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {


 public static    MutableLiveData<List<PostModel>> post_MutableLiveData=new MutableLiveData<>();



 public static void getposts()
    {
       /* Client.getClient_instance().getposts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                post_MutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
        */

       // single Observable
       Observable observable= Client.getClient_instance().getposts()
               .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread());

        Observer<List<PostModel>> observer=new Observer<List<PostModel>>() {
            private static final String TAG = ".PostViewModel";

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<PostModel> value) {
                post_MutableLiveData.setValue(value);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError"+e);
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);

    }


}
