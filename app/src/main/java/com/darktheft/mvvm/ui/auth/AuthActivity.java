package com.darktheft.mvvm.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.darktheft.mvvm.R;
import com.darktheft.mvvm.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = AuthActivity.class.getName();

//    @Inject
//    String string;
//    @Inject
//    boolean isAppNull;

    private AuthViewModel viewModel;
    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        viewModel = ViewModelProviders.of(this,providerFactory).get(AuthViewModel.class);
//        Log.d(TAG, "onCreate: "+string);
//        Log.d(TAG, "onCreate: app is null ?"+isAppNull);


        setLogo();
    }

    private void setLogo(){
        requestManager.load(logo)
                .into((ImageView)findViewById(R.id.imagelogo));
    }

}