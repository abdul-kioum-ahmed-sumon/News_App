package com.example.news_app.api

import com.example.news_app.models.NewsResponse
import com.example.news_app.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode: String,
        @Query("page") pageNumber: Int,
        @Query("apiKey") api: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>
}
//package com.example.news_app.api
//import androidx.room.Query
//import androidx.room.RawQuery
//import com.example.news_app.models.NewsResponse
//import com.example.news_app.ui.fragments.SearchFragment
//import com.example.news_app.util.Constants.Companion.API_KEY
//import okhttp3.Response
//import retrofit2.http.GET
//import java.util.Locale
//
//interface NewsAPI {
//    @GET("v2/top-headlines")
//    suspend fun getHeadlines(
//        @Query("country")
//        countryCode: String = "us",
//        @Query("page")
//        pageNumber: Int = 1,
//        @Query("apikey")
//        api: String = API_KEY
//
//    ): Response<NewsResponse>
//    @GET("v2/everything")
//    suspend fun  searchForNews(
//
//        @Query("q")
//        searchQuery: String,
//        @Query("page")
//        pageNumber: Int =1,
//        @Query("apiKey")
//        apiKey:
//    )
//
//}