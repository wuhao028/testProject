package com.wuhao.test.presentation.commentlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wuhao.test.common.Constants
import com.wuhao.test.common.Resource
import com.wuhao.test.domain.usecase.GetCommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CommentListViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CommentListState())
    val state: State<CommentListState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_POST_ID)?.let { postId ->
            getComments(postId)
        }
    }

    private fun getComments(postId: String) {
        getCommentsUseCase(postId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CommentListState(comments = result.data)
                }
                is Resource.Error -> {
                    _state.value = CommentListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CommentListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}