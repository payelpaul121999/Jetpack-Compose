package com.paulpayelcompose.lastestmovieapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulpayelcompose.lastestmovieapp.model.TvShow
import com.paulpayelcompose.lastestmovieapp.network.RetrofitService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {



    var movieListResponse:List<TvShow> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = RetrofitService.getInstance()
            try {
                val movieList = apiService.getPopularTvShow("df57ebe7d0723991d4ab8564e57256dc")
                movieListResponse = movieList.body()!!.tvShows
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }




   /* init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPopularDetails("df57ebe7d0723991d4ab8564e57256dc")
        }
    }

    val liveDataPopular : LiveData<TvShowList> = repository.liveData*/

}