package com.mpssdi.test.ui;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityFactory implements ViewModelProvider.Factory {
    private Application mApplication;

    public MainActivityFactory(Application application) {
        mApplication = application;

    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MainActivityViewmodel(mApplication);
    }
}
