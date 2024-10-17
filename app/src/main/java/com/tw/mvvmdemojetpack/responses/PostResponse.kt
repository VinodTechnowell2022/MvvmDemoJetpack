package com.tw.mvvmdemojetpack.responses

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("PostResponse")
	val postResponse: List<PostItem>
)

data class PostItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("body")
	val body: String,

	@field:SerializedName("userId")
	val userId: Int
)
