package com.paulpayelcompose.lastestmovieapp.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paulpayelcompose.lastestmovieapp.model.TvShow
import com.paulpayelcompose.lastestmovieapp.model.TvShowList

class Repository(private val retrofitService: RetrofitService) {

    private val popularLiveData = MutableLiveData<TvShowList>()
    val liveData : LiveData<TvShowList> get() = popularLiveData

   /* private val popularLiveData = MutableLiveData<TvShow>()
    val liveData : LiveData<TvShow> get() = popularLiveData*/

    suspend fun getPopularDetails(apiKey:String){
            val result = retrofitService.getPopularTvShow(apiKey)
            if (result.body() !=null){
                Log.d("japan",result.body().toString())
                popularLiveData.postValue(result.body())

            }
    }
}