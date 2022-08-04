package com.altaf.fbiwanted

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val wantedResponse = MutableLiveData<List<ItemsItem>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    private fun getFBIWanted(
        responsHandler: (List<ItemsItem>) -> Unit,
        errorHandler: (Throwable) -> Unit
    ){
        ApiClient.getApiService().getWanted()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responsHandler(it.items as List<ItemsItem>)
            }, {
                errorHandler(it)
            })
    }

    fun getWantedData(){
        isLoading.postValue(true)
        getFBIWanted({
            isLoading.postValue(false)
            wantedResponse.postValue(it)
        },{
            isLoading.postValue(true)
            isError.postValue(it)
        })
    }
}