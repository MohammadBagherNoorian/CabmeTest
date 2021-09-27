package com.mbn.cabme.di.module

import com.mbn.cabme.view.ComingSoonActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector



@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindFeedbackList(): ComingSoonActivity?
}