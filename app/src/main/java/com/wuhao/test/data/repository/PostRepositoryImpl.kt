package com.wuhao.test.data.repository

import com.wuhao.test.data.model.CommentItem
import com.wuhao.test.data.model.PostItem
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: RetrofitService
) : RetrofitService {

    override suspend fun getPosts(): List<PostItem> {
        return api.getPosts()
    }

    override suspend fun getCommentsById(postId: String): List<CommentItem> {
        return api.getCommentsById(postId)
    }
}