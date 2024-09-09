package com.paulpayelcompose.lastestmovieapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieEntity WHERE id=:id")
    suspend fun getMovieById(id:Int) :MovieEntity

    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)
    @Query("SELECT * FROM MovieEntity WHERE category=:category")
    suspend fun getMovieListByCategory(category: String):List<MovieEntity>
}