package com.mbn.cabme.di.component;


import android.app.Application;


import com.mbn.cabme.base.BaseApplication;
import com.mbn.cabme.di.module.ActivityBindingModule;
import com.mbn.cabme.di.module.ContextModule;
import com.mbn.cabme.di.module.NetworkModule;
import com.mbn.cabme.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by Rajat Mittal on 23,March,2021
 */

@Singleton
@Component(modules = {
        ContextModule.class,
        NetworkModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class
})

public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

}