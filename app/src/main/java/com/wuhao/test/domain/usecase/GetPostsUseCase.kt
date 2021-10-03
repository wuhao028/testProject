package com.wuhao.test.domain.usecase

import com.wuhao.test.common.Resource
import com.wuhao.test.data.model.PostItem
import com.wuhao.test.data.repository.LocalData
import com.wuhao.test.domain.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository,
    private val localData: LocalData
) {
    operator fun invoke(): Flow<Resource<List<PostItem>>> = flow {
        try {
            emit(Resource.Loading<List<PostItem>>())
            val posts = repository.getPosts()
            localData.savePosts(posts = posts)
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