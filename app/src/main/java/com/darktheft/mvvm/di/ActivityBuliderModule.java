package com.darktheft.mvvm.di;


import com.darktheft.mvvm.di.auth.AuthModule;
import com.darktheft.mvvm.di.auth.AuthViewModelModule;
import com.darktheft.mvvm.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuliderModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class,
                    AuthModule.class,}
    )
    abstract AuthActivity contrAuthActivity();



//    @Provides
//    static RequestOptions provideRequestOptions(){
//        return RequestOptions
//                .placeholderOf(R.drawable.white_backgraund)
//                .error(R.drawable.white_backgraund);
//    }

}
