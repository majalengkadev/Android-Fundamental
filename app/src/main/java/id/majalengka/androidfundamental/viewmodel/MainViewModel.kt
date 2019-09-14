package id.majalengka.androidfundamental.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.majalengka.androidfundamental.model.ResultResponse
import id.majalengka.androidfundamental.utils.Result

class MainViewModel: ViewModel() {

    private val _data = MutableLiveData<Result<ResultResponse>>()
    val data: LiveData<Result<ResultResponse>> get() = _data
}