package id.majalengka.androidfundamental.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    private val loading = MutableLiveData<Boolean>()

    fun getLoading(): LiveData<Boolean> = loading

    protected fun setLoading() = loading.postValue(true)

    protected fun finishLoading() = loading.postValue(false)
}