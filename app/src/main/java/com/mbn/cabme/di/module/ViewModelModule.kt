package com.mbn.cabme.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbn.cabme.base.ViewModelFactory
import com.mbn.cabme.di.util.ViewModelKey
import com.mbn.cabme.viewmodel.ListViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel?): ViewModel?

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?

}