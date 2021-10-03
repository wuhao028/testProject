package com.wuhao.test.data.usecase

import com.wuhao.test.common.Resource
import com.wuhao.test.data.model.PostItem
import com.wuhao.test.data.repository.PostRepository
import com.wuhao.test.data.repository.PostRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<Resource<List<PostItem>>> = flow {
        try {
            emit(Resource.Loading<List<PostItem>>())
            val posts = repository.getPosts()
            emit(Resource.Success<List<PostItem>>(posts))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<PostItem>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<PostItem>>("Couldn't reach server. Check your internet connection."))
        }
    }
}