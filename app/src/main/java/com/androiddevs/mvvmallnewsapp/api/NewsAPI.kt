package com.androiddevs.mvvmallnewsapp.api

import androidx.annotation.NonNull
import com.androiddevs.mvvmallnewsapp.models.NewsResponse
import com.androiddevs.mvvmallnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @NonNull
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(@NonNull
        @Query("country")
        countryCode: String = "us",@NonNull
        @Query("page")
        pageNumber: Int = 1,@NonNull
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}