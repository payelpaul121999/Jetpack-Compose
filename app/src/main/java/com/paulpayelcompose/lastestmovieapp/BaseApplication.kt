package com.paulpayelcompose.lastestmovieapp

import android.app.Application
import com.paulpayelcompose.lastestmovieapp.network.Repository
import com.paulpayelcompose.lastestmovieapp.network.RetrofitHelper
import com.paulpayelcompose.lastestmovieapp.network.RetrofitService

/*
class BaseApplication():Application() {
    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        val quoteService = RetrofitHelper.getInstance().create(RetrofitService::class.java)
        repository = Repository(quoteService)
    }
}*/
