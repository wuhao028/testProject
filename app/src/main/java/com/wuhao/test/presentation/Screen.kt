package com.wuhao.test.presentation

sealed class Screen(val route: String) {
    object PostListScreen : Screen("post_list_screen")
    object CommentListScreen : Screen("comment_list_screen")
}