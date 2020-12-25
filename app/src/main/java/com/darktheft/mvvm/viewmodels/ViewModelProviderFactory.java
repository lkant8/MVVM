package com.darktheft.mvvm.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelProviderFactory  implements ViewModelProvider.Factory {
    private static final String TAG = ViewModelProviderFactory.class.getName();

//    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    private final  Map<Class<? extends ViewModel>, Provider<ViewModel>> creaters;

    @Inject
    public ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creaters) {
        this.creaters = creaters;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return null;


        Provider<? extends ViewModel> creater = creaters.get(modelClass);
        if (creater == null){// if the viewmodels has not been created
            // loop throught the allowable keys (allowd classes with the @viewmodelsKey)

            for (Map.Entry<Class <? extends ViewModel>, Provider<ViewModel>> entry :creaters.entrySet()){
                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(entry.getKey())){
                    creater = entry.getValue();
                    break;
                }
            }

        }

        if (creater == null){
            throw new IllegalArgumentException("unlnown model class "+modelClass );
        }
        try {
            return (T) creater.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


//    @Inject
//    public ViewModelProviderFactory(Map<Class<? extends ViewModel>, javax.inject.Provider>)

//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return null;
//    }
//



}
