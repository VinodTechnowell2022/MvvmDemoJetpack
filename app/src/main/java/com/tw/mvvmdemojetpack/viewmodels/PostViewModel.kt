package com.tw.mvvmdemojetpack.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tw.mvvmdemojetpack.repos.PostRepository
import com.tw.mvvmdemojetpack.responses.PostItem
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private val repository = PostRepository()

    val _posts = MutableLiveData<List<PostItem>>()

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = repository.getAllPosts()
                _posts.value = posts
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}