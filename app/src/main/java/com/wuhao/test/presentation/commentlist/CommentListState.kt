package com.wuhao.test.presentation.commentlist

import com.wuhao.test.data.model.CommentItem

data class CommentListState(
    val isLoading: Boolean = false,
    val comments: List<CommentItem>? = null,
    val error: String = ""
)