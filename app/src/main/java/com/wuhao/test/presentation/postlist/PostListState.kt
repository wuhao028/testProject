package com.wuhao.test.presentation.postlist

import com.wuhao.test.data.model.PostItem

data class PostListState(
    val isLoading: Boolean = false,
    val posts: List<PostItem> = emptyList(),
    val error: String = ""
)
