package com.paulpayelcompose.lastestmovieapp.network

import com.paulpayelcompose.lastestmovieapp.model.TvShowList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

   /*companion object{

       fun getInstance(): Retrofit {
           return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
       }
   }*/





    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        var apiService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(RetrofitService::class.java)
            }
            return apiService!!
        }
    }

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey:String): Response<TvShowList>

}