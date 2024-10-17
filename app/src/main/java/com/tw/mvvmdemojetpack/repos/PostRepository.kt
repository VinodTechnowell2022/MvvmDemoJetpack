package com.tw.mvvmdemojetpack.repos

import com.tw.mvvmdemojetpack.api.RetrofitInstance
import com.tw.mvvmdemojetpack.responses.PostItem

class PostRepository {

    private val apiService = RetrofitInstance.apiService

    suspend fun getAllPosts(): List<PostItem> {
        return apiService.getAllPosts()
    }

}