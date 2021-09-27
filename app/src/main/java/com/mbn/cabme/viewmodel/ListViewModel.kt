package com.mbn.cabme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbn.cabme.network.ApiResponse
import com.mbn.cabme.repository.ComingSoonRepository

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject




class ListViewModel @Inject constructor(private val repo: ComingSoonRepository) : ViewModel() {
    private var disposable: CompositeDisposable?
    private val apiResponses = MutableLiveData<ApiResponse>()
    private val apiResponseLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    fun getApiResponses(): LiveData<ApiResponse> {
        return apiResponses
    }

    fun getError(): LiveData<Boolean> {
        return apiResponseLoadError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchApiResponses() {
        loading.value = true
        disposable!!.add(
            repo.executeCheckUSer()?.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    loading.value = false
                    apiResponses.value= it
                },{
                        t: Throwable? ->
                    loading.value = false
                    apiResponseLoadError.value=true
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (disposable != null) {
            disposable!!.clear()
            disposable = null
        }
    }

    init {
        disposable = CompositeDisposable()
        fetchApiResponses()
    }
}