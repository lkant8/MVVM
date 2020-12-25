package com.darktheft.mvvm.di;

import android.app.Application;

import com.darktheft.mvvm.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuliderModule.class,
                AppModule.class,
                ViewModelFactoryModel.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {


    @Component.Builder
    interface Bulider{

        @BindsInstance
        Bulider application(Application application);

        AppComponent build();
    }
}
