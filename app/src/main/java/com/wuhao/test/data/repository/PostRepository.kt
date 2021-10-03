package com.wuhao.test.data.repository

import com.wuhao.test.data.model.CommentItem
import com.wuhao.test.data.model.PostItem

interface PostRepository {

    suspend fun getPosts(): List<PostItem>

    suspend fun getCommentsById(postId: String): List<CommentItem>
}