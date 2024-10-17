package com.tw.mvvmdemojetpack.api

import com.tw.mvvmdemojetpack.responses.PostItem
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getAllPosts(): List<PostItem>

}