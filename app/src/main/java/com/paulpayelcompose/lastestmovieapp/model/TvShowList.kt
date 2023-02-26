package com.paulpayelcompose.lastestmovieapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvShowList(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val tvShows: ArrayList<TvShow>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
):Serializable
