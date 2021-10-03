package com.wuhao.test.presentation.postlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wuhao.test.data.model.PostItem
import com.wuhao.test.presentation.Screen


@Composable
fun PostListScreen(
    navController: NavController,
    qury: MutableState<TextFieldValue>,
    viewModel: PostListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            val searchedText = qury.value.text
            val filteredPosts = if (searchedText.isEmpty()) {
                state.posts
            } else {
                state.posts.filter {
                    it.body.contains(searchedText, true)
                            || it.title.contains(searchedText, true)
                }
            }
            items(filteredPosts) { post ->
                PostItemScreen(
                    postItem = post,
                    onItemClick = {
                        navController.navigate(Screen.CommentListScreen.route + "/${post.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}