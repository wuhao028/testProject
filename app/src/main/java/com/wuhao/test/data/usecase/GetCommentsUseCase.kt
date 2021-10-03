package com.wuhao.test.data.usecase

import com.wuhao.test.common.Resource
import com.wuhao.test.data.model.CommentItem
import com.wuhao.test.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(postId: String): Flow<Resource<List<CommentItem>>> = flow {
        try {
            emit(Resource.Loading<List<CommentItem>>())
            val comments = repository.getCommentsById(postId)
            emit(Resource.Success<List<CommentItem>>(comments))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<CommentItem>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<CommentItem>>("Couldn't reach server. Check your internet connection."))
        }
    }
}