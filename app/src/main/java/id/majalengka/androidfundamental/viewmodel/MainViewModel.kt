package id.majalengka.androidfundamental.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.majalengka.androidfundamental.model.ResultResponse
import id.majalengka.androidfundamental.network.Webservice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val webservice: Webservice): BaseViewModel() {

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _data = MutableLiveData<ResultResponse>()
    val data: LiveData<ResultResponse> get() = _data

    init {
        getData()
    }
    fun getData() {
        ///launch the coroutine scope
        coroutineScope.launch {
            var result = webservice.getPrayerTime("Jakarta")
            try {
                _data.value = result


            } catch (e: Exception) {

            }
        }
    }
}