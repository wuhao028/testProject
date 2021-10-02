package com.wuhao.test.data.repository

import com.wuhao.test.data.model.CommentItem
import com.wuhao.test.data.model.PostItem
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("/posts")
    suspend fun getPosts(): List<PostItem>

    @GET("/posts/{postId}/comments")
    suspend fun getCommentsById(@Path("postId") postId: String): List<CommentItem>

}