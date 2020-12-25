package com.darktheft.mvvm.di;

import androidx.lifecycle.ViewModelProvider;

import com.darktheft.mvvm.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModel {

    private static final String TAG = ViewModelFactoryModel.class.getName();

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    /*@Provides
    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory factory){
        return factory;
    } // same binds or @provide
*/
}
