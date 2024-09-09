package com.paulpayelcompose.lastestmovieapp.model

data class ResponseMovieList(
    val page: Int,
    val results: List<ResponseMovieDao>,
    val total_pages: Int,
    val total_results: Int

)
