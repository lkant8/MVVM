package com.darktheft.mvvm.di.auth;

import androidx.lifecycle.ViewModel;

import com.darktheft.mvvm.di.ViewModelKey;
import com.darktheft.mvvm.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
