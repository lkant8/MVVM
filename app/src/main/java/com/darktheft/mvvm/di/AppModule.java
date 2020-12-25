package com.darktheft.mvvm.di;


import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.darktheft.mvvm.R;
import com.darktheft.mvvm.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

   /* @Provides
    static String someString(){
        return "this is a test string Welcome to manali";
    }

    @Provides
    static boolean getApp(Application application){
        return application == null;
    }*/

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions
                .placeholderOf(R.drawable.white_backgraund)
                .error(R.drawable.white_backgraund);
    } // now we are put into ActivityBuilderModule

    @Singleton
    @Provides
    static RequestManager provideGlideInstanceRequestManager(Application application,RequestOptions requestOptions){

        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideAppDrawable(Application application){
        return ContextCompat.getDrawable(application,R.drawable.ic_launcher_foreground);
    }

    @Singleton
    @Provides
    static Retrofit getRetrofitInstance(){
        return new  Retrofit.Builder()
                .baseUrl(Constants.BASE_URLSTRING)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
