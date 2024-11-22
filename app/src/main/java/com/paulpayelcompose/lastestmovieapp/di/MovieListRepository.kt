package com.paulpayelcompose.lastestmovieapp.di

import android.net.http.HttpException
import com.paulpayelcompose.lastestmovieapp.data.MovieDatabase
import com.paulpayelcompose.lastestmovieapp.model.Movie
import com.paulpayelcompose.lastestmovieapp.repository.MovieListRepository
import com.paulpayelcompose.lastestmovieapp.repository.Resource
import com.paulpayelcompose.lastestmovieapp.repository.Resource.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieListRepositoryImpl
@Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase):MovieListRepository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)
           if (localMovieList.isNotEmpty() && !forceFetchFromRemote){
               emit(
                   Success(data = localMovieList.map { movieEntity ->
                       movieEntity.toMovie(category)
                   }))
               emit(Resource.Loading(false))
               return@flow
           }
            val movieListFromApi = try {
                movieApi.getMoviesList(category,page)
            }catch (e:IOException){
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            }catch (e:HttpException){
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            }catch (e:Exception){
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            }
            val movieEntities =movieListFromApi.results.let {
                it.map { movieDao->
                    movieDao.toMovieEntity(category)
                }
            }
            movieDatabase.movieDao.upsertMovieList(movieEntities)
            emit(Resource.Success(movieEntities.map { it.toMovie(category) }))
            emit(Resource.Loading(false))

        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
         emit(Resource.Loading(true))
         val movieEntity=movieDatabase.movieDao.getMovieById(id)
            if (movieEntity !=null){
                emit(Resource.Success(movieEntity.toMovie(movieEntity.category)))
                emit(Resource.Loading(false))
                return@flow
            }
            emit(Resource.Error(message = "Error loading movies"))
            emit(Resource.Loading(false))
        }
    }

}